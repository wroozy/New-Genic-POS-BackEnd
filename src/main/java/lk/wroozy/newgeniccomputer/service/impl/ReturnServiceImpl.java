package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.request.ReturnDetailRequestDTO;
import lk.wroozy.newgeniccomputer.dto.request.ReturnRequestDTO;
import lk.wroozy.newgeniccomputer.dto.response.ReturnDetailResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.ReturnResponseDTO;
import lk.wroozy.newgeniccomputer.entity.OrderDetailEntity;
import lk.wroozy.newgeniccomputer.entity.ReturnDetailEntity;
import lk.wroozy.newgeniccomputer.entity.ReturnEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.OrderDetailRepository;
import lk.wroozy.newgeniccomputer.repository.OrderRepository;
import lk.wroozy.newgeniccomputer.repository.ReturnDetailRepository;
import lk.wroozy.newgeniccomputer.repository.ReturnRepository;
import lk.wroozy.newgeniccomputer.service.ReturnService;
import lk.wroozy.newgeniccomputer.util.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReturnServiceImpl implements ReturnService {


    private ReturnRepository returnRepository;
    private ReturnDetailRepository returnDetailRepository;
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public ReturnServiceImpl(ReturnRepository returnRepository,
                             ReturnDetailRepository returnDetailRepository,
                             OrderRepository orderRepository,
                             OrderDetailRepository orderDetailRepository) {
        this.returnRepository = returnRepository;
        this.returnDetailRepository = returnDetailRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public ResponseEntity<?> placeReturn(ReturnRequestDTO returnRequestDTO) {
        try {
            if (returnRequestDTO == null)
                return new ResponseEntity<>("Return request not found", HttpStatus.BAD_REQUEST);

            ReturnEntity returnEntity = new ReturnEntity();
            for (ReturnDetailRequestDTO detailRequestDTO :
                    returnRequestDTO.getDetailList()) {

                ReturnDetailEntity returnDetailEntity = new ReturnDetailEntity();
                returnDetailEntity.setReturnEntity(returnEntity);
                returnDetailEntity.setQty(detailRequestDTO.getQty());
                returnDetailEntity.setReason(detailRequestDTO.getReason());

                ReturnDetailEntity returnDetail = returnDetailRepository.save(returnDetailEntity);

                Optional<OrderDetailEntity> orderDetail = orderDetailRepository.findById(detailRequestDTO.getOrderDetailId());
                if (orderDetail.isPresent()) {
                    orderDetail.get().setReturnDetailEntity(returnDetail);
                    orderDetailRepository.save(orderDetail.get());
                }

            }

            returnEntity.setDate(DateConverter.localDateToSql(LocalDate.now()));
            returnEntity.setTime(DateConverter.localTimeToSql(LocalTime.now()));

            returnRepository.save(returnEntity);

            return new ResponseEntity<>("Return placed", HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to place Return : " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getAllReturns() {
        try {
            List<ReturnEntity> all = returnRepository.findAll();
            if (all.isEmpty())
                return new ResponseEntity<>("No returns ", HttpStatus.BAD_REQUEST);

            List<ReturnResponseDTO> returnList = new ArrayList<>();
            for (ReturnEntity returnEntity :
                    all) {
                returnList.add(setReturn(returnEntity));
            }

            return new ResponseEntity<>(returnList,HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to fetch returns " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getReturn(long returnId) {
        try {
            if (returnId == 0)
                return new ResponseEntity<>("Return id not found",HttpStatus.BAD_REQUEST);

            Optional<ReturnEntity> returnEntity = returnRepository.findById(returnId);
            if (returnEntity.isEmpty())
                return new ResponseEntity<>("No Return found ",HttpStatus.CONFLICT);

            return new ResponseEntity<>(setReturn(returnEntity.get()),HttpStatus.OK);
        } catch (Exception e) {
            throw new CustomException("Failed to get Return : " + e.getMessage());
        }
    }

    private ReturnResponseDTO setReturn(ReturnEntity returnEntity){

        List<ReturnDetailResponseDTO> detailList = new ArrayList<>();
        for (ReturnDetailEntity returnDetailEntity :
                returnEntity.getReturnDetailList()) {
               detailList.add(new ReturnDetailResponseDTO(
                       returnDetailEntity.getReturnDetailId(),
                       returnDetailEntity.getReason(),
                       returnDetailEntity.getQty(),
                       returnDetailEntity.getOrderDetailEntity().getProductDetailEntity().getProductCode(),
                       returnDetailEntity.getOrderDetailEntity().getProductDetailEntity().getProductDetailId(),
                       returnDetailEntity.getOrderDetailEntity().getProductDetailEntity().getProductEntity().getName(),
                       returnDetailEntity.getOrderDetailEntity().getProductDetailEntity().getProductEntity().getDescription()
               ));
        }

        return new ReturnResponseDTO(
                returnEntity.getReturnId(),
                returnEntity.getDate().toString(),
                returnEntity.getTime().toString(),
                detailList
        );
    }
}
