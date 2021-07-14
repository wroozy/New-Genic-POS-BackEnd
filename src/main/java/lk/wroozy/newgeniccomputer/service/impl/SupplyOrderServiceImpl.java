package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.SupplyOrderRequestDTO;
import lk.wroozy.newgeniccomputer.dto.request.SupplyProductDetailDTO;
import lk.wroozy.newgeniccomputer.dto.response.SupplyReportDetailResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.SupplyReportResponseDTO;
import lk.wroozy.newgeniccomputer.entity.*;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.*;
import lk.wroozy.newgeniccomputer.service.SupplyOrderService;
import lk.wroozy.newgeniccomputer.util.DateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SupplyOrderServiceImpl implements SupplyOrderService {

    private SupplyOrderRepository supplyOrderRepository;
    private SupplyOrderDetailRepository supplyOrderDetailRepository;
    private SupplierRepository supplierRepository;
    private ProductDetailRepository productDetailRepository;
    private ProductRepository productRepository;
    private SupplyPaymentRepository supplyPaymentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public SupplyOrderServiceImpl(SupplyOrderRepository supplyOrderRepository,
                                  SupplyOrderDetailRepository supplyOrderDetailRepository,
                                  SupplierRepository supplierRepository,
                                  ProductDetailRepository productDetailRepository,
                                  ProductRepository productRepository,
                                  SupplyPaymentRepository supplyPaymentRepository,
                                  ModelMapper modelMapper) {
        this.supplyOrderRepository = supplyOrderRepository;
        this.supplyOrderDetailRepository = supplyOrderDetailRepository;
        this.supplierRepository = supplierRepository;
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
        this.supplyPaymentRepository = supplyPaymentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> placeOrder(SupplyOrderRequestDTO supplyOrderRequestDTO) {
        try {
            if (supplyOrderRequestDTO == null)
                return new ResponseEntity<>("Supply order details not found ", HttpStatus.BAD_REQUEST);
            Optional<SupplierEntity> supplierEntity = supplierRepository.findById(supplyOrderRequestDTO.getSupplierId());
            if (supplierEntity.isEmpty())
                return new ResponseEntity<>("Supplier not found", HttpStatus.BAD_REQUEST);

            SupplyOrderEntity supplyOrderEntity = new SupplyOrderEntity();
            supplyOrderEntity.setSupply_order_id(supplyOrderRequestDTO.getSupplyOrderId());
            double totalPrice = 0;

            for (SupplyProductDetailDTO productDetailDTO :
                    supplyOrderRequestDTO.getProductDetailList()) {
                Optional<ProductDetailEntity> productDetail = productDetailRepository.findById(productDetailDTO.getProductDetailId());
                if (productDetail.isPresent()) {
                    ProductDetailEntity detailEntity = modelMapper.map(productDetailDTO, ProductDetailEntity.class);
                    detailEntity.setUpdateDate(DateConverter.localDateToSql(LocalDate.now()));
                    detailEntity.setUpdateTime(DateConverter.localTimeToSql(LocalTime.now()));
                    detailEntity.setProductEntity(productDetail.get().getProductEntity());
                    detailEntity.setSize(productDetail.get().getSize());
                    detailEntity.setStock(detailEntity.getStock() + productDetail.get().getStock());

                    ProductDetailEntity productDetailEntity = productDetailRepository.save(detailEntity);

                    SupplyOrderDetailEntity supplyOrderDetailEntity = new SupplyOrderDetailEntity();
                    supplyOrderDetailEntity.setProductDetailEntity(productDetailEntity);
                    supplyOrderDetailEntity.setOrderPrice(detailEntity.getBuyingPrice() * detailEntity.getStock());
                    supplyOrderDetailEntity.setQty(detailEntity.getStock());
                    supplyOrderDetailEntity.setSupplierOrderEntity(supplyOrderEntity);

                    SupplyOrderDetailEntity orderDetailEntity = supplyOrderDetailRepository.save(supplyOrderDetailEntity);

                    totalPrice += orderDetailEntity.getOrderPrice();
                }
            }
            if (totalPrice == 0)
                return new ResponseEntity<>("Supply order not placed", HttpStatus.BAD_REQUEST);

            SupplyPaymentEntity supplyPaymentEntity = new SupplyPaymentEntity();
            supplyPaymentEntity.setTotal(totalPrice);
            supplyPaymentEntity.setDiscount(supplyOrderRequestDTO.getDiscount());

            supplyOrderEntity.setSupplierEntity(supplierEntity.get());
            supplyOrderEntity.setDate(DateConverter.localDateToSql(LocalDate.now()));
            supplyOrderEntity.setTime(DateConverter.localTimeToSql(LocalTime.now()));
            supplyOrderEntity.setSupplyPaymentEntity(supplyPaymentEntity);

            supplyPaymentRepository.save(supplyPaymentEntity);
            supplyOrderRepository.save(supplyOrderEntity);

            return new ResponseEntity<>("Order placed", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to Place supply order : " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllSupplyReport(int index, int size) {
        try {
            List<SupplyOrderEntity> all = supplyOrderRepository.findAll();
            if (all.isEmpty())
                return new ResponseEntity<>("No Orders found",HttpStatus.CONFLICT);
            List<SupplyReportResponseDTO> supplyReportList = new ArrayList<>();
            for (SupplyOrderEntity supplyOrderEntity :
                    all) {
                supplyReportList.add(setSupplyOrderResponse(supplyOrderEntity));
            }
            return new ResponseEntity<>(supplyReportList, HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to fetch sale report" + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getSupplyOrder(String supplyOrderId) {
        try{
            Optional<SupplyOrderEntity> supplyOrderEntity = supplyOrderRepository.findById(supplyOrderId);
            if (supplyOrderEntity.isEmpty())
                return new ResponseEntity<>("Supply order not found",HttpStatus.BAD_REQUEST);

            SupplyReportResponseDTO supplyReportResponseDTO = setSupplyOrderResponse(supplyOrderEntity.get());

            return new ResponseEntity<>(supplyReportResponseDTO,HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to get supply order : "+e.getMessage());
        }
    }

    private SupplyReportResponseDTO setSupplyOrderResponse(SupplyOrderEntity supplyOrderEntity){
        List<SupplyReportDetailResponseDTO> reportDetailList = new ArrayList<>();
        for (SupplyOrderDetailEntity supplyOrderDetailEntity :
                supplyOrderEntity.getSupplyOrderDetailList()) {
            reportDetailList.add(
                    new SupplyReportDetailResponseDTO(
                            supplyOrderDetailEntity.getSupplyOrderDetailId(),
                            supplyOrderDetailEntity.getProductDetailEntity().getProductEntity().getProductId(),
                            supplyOrderDetailEntity.getProductDetailEntity().getProductDetailId(),
                            supplyOrderDetailEntity.getProductDetailEntity().getProductEntity().getName(),
                            supplyOrderDetailEntity.getProductDetailEntity().getProductEntity().getDescription(),
                            supplyOrderDetailEntity.getProductDetailEntity().getProductEntity().getBrand(),
                            supplyOrderDetailEntity.getProductDetailEntity().getSize(),
                            supplyOrderDetailEntity.getQty(),
                            supplyOrderDetailEntity.getProductDetailEntity().getBuyingPrice()
                    )
            );

        }

        return new SupplyReportResponseDTO(
                supplyOrderEntity.getSupply_order_id(),
                supplyOrderEntity.getSupplyPaymentEntity().getTotal(),
                supplyOrderEntity.getSupplyPaymentEntity().getDiscount(),
                supplyOrderEntity.getDate().toString(),
                supplyOrderEntity.getTime().toString(),
                supplyOrderEntity.getSupplierEntity().getSupplierId(),
                supplyOrderEntity.getSupplierEntity().getName(),
                reportDetailList
        );
    }
}
