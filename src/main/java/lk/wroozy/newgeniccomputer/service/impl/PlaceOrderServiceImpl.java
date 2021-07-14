package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.OrderProductRequestDTO;
import lk.wroozy.newgeniccomputer.dto.request.OrderRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.SingleProductResponseDTO;
import lk.wroozy.newgeniccomputer.entity.*;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.*;
import lk.wroozy.newgeniccomputer.service.PlaceOrderService;
import lk.wroozy.newgeniccomputer.util.DateConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    private OrderPaymentRepository orderPaymentRepository;
    private CustomerRepository customerRepository;
    private ProductDetailRepository productDetailRepository;
    private ModelMapper modelMapper;

    @Autowired
    public PlaceOrderServiceImpl(OrderRepository orderRepository,
                                 OrderDetailRepository orderDetailRepository,
                                 OrderPaymentRepository orderPaymentRepository,
                                 CustomerRepository customerRepository,
                                 ProductDetailRepository productDetailRepository,
                                 ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderPaymentRepository = orderPaymentRepository;
        this.customerRepository = customerRepository;
        this.productDetailRepository = productDetailRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<?> placeOrder(OrderRequestDTO orderRequestDTO) {
        try{
            if (orderRequestDTO == null)
                return new ResponseEntity<>("Order Details not found", HttpStatus.BAD_REQUEST);

            OrderEntity orderEntity = new OrderEntity();
            double totalPrice = 0;
            double totalBuyingPrice = 0;

            for (OrderProductRequestDTO orderProductRequestDTO :
                    orderRequestDTO.getProductList()) {
                Optional<ProductDetailEntity> productDetailEntity = productDetailRepository.findById(orderProductRequestDTO.getProductDetailId());
                if (productDetailEntity.isPresent()){
                    OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                    orderDetailEntity.setQty(orderProductRequestDTO.getQty());
                    orderDetailEntity.setPrice(productDetailEntity.get().getSalePrice() * orderProductRequestDTO.getQty());
                    orderDetailEntity.setOrderEntity(orderEntity);
                    orderDetailEntity.setProductDetailEntity(productDetailEntity.get());

                    totalPrice += productDetailEntity.get().getSalePrice();
                    totalBuyingPrice += productDetailEntity.get().getBuyingPrice();

                    orderDetailRepository.save(orderDetailEntity);
                    productDetailEntity.get().setStock(productDetailEntity.get().getStock() - orderProductRequestDTO.getQty());
                    productDetailRepository.save(productDetailEntity.get());

                }
            }

            OrderPaymentEntity orderPaymentEntity = new OrderPaymentEntity();
            orderPaymentEntity.setTotalPrice(totalPrice);
            orderPaymentEntity.setDiscount(orderRequestDTO.getDiscount());

            OrderPaymentEntity orderPayment = orderPaymentRepository.save(orderPaymentEntity);

            orderEntity.setOrderPaymentEntity(orderPayment);
            orderEntity.setDate(DateConverter.localDateToSql(LocalDate.now()));
            orderEntity.setTime(DateConverter.localTimeToSql(LocalTime.now()));

            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setName(orderRequestDTO.getCustomerName());
            customerEntity.setMobile(orderRequestDTO.getCustomerMobile());

            customerRepository.save(customerEntity);
            orderPaymentRepository.save(orderPaymentEntity);
            OrderEntity order = orderRepository.save(orderEntity);

            return new ResponseEntity<>(createOrderId(order.getOrderId()),HttpStatus.OK);
        }catch (Exception e){
            throw new CustomException("Failed to place Order"+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getProduct(String productCode) {
        try{
            if (productCode.isEmpty())
                return new ResponseEntity<>("Product code not found",HttpStatus.BAD_REQUEST);

            ProductDetailEntity productDetail = productDetailRepository.findByProductCode(productCode);
            if (productDetail == null)
                return new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);

            SingleProductResponseDTO singleProductResponseDTO = new SingleProductResponseDTO(
                    productDetail.getProductEntity().getProductId(),
                    productDetail.getProductCode(),
                    productDetail.getProductEntity().getName(),
                    productDetail.getProductEntity().getDescription(),
                    productDetail.getSize(),
                    productDetail.getStock(),
                    productDetail.getSalePrice()
            );

            return new ResponseEntity<>(singleProductResponseDTO,HttpStatus.OK);

        }catch (Exception e){
            throw new CustomException("Failed to get product : "+e.getMessage());
        }
    }

    private String createOrderId(long orderId){
        String newOrderId = String.valueOf(orderId);
        while (newOrderId.length() <= 8){
            newOrderId = 0 + newOrderId;
        }

        return newOrderId;
    }
}
