package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.response.OrderDetailResponseDTO;
import lk.wroozy.newgeniccomputer.dto.response.OrderResponseDTO;
import lk.wroozy.newgeniccomputer.entity.OrderDetailEntity;
import lk.wroozy.newgeniccomputer.entity.OrderEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.OrderDetailRepository;
import lk.wroozy.newgeniccomputer.repository.OrderRepository;
import lk.wroozy.newgeniccomputer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public ResponseEntity<?> getAllOrders() {
        try {
            List<OrderEntity> all = orderRepository.findAll();
            if (all.isEmpty())
                return new ResponseEntity<>("No orders found", HttpStatus.CONFLICT);

            List<OrderResponseDTO> orderList = new ArrayList<>();
            for (OrderEntity orderEntity :
                    all) {
                orderList.add(setOrder(orderEntity));
            }

            return new ResponseEntity<>(orderList,HttpStatus.OK);

        }catch (Exception e){
            throw new CustomException("Failed to fetch orders : "+e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getOrder(String orderId) {
        try{
            if (orderId.isEmpty())
                return new ResponseEntity<>("Order Id not found",HttpStatus.BAD_REQUEST);

            Optional<OrderEntity> orderEntity = orderRepository.findById(Long.parseLong(orderId));
            if (orderEntity.isEmpty())
                return new ResponseEntity<>("Order not found",HttpStatus.BAD_REQUEST);

            OrderResponseDTO orderResponseDTO = setOrder(orderEntity.get());

            return new ResponseEntity<>(orderResponseDTO,HttpStatus.OK);
        }catch (Exception e) {
            throw new CustomException("Failed to fetch Order : " + e.getMessage());
        }
    }

    private OrderResponseDTO setOrder(OrderEntity orderEntity){
        List<OrderDetailResponseDTO> detailList = new ArrayList<>();

        for (OrderDetailEntity orderDetailEntity :
                orderEntity.getOrderDetailList()) {
            detailList.add(new OrderDetailResponseDTO(
                    orderDetailEntity.getOrderDetailId(),
                    orderDetailEntity.getProductDetailEntity().getProductEntity().getProductId(),
                    orderDetailEntity.getProductDetailEntity().getProductDetailId(),
                    orderDetailEntity.getProductDetailEntity().getProductCode(),
                    orderDetailEntity.getProductDetailEntity().getProductEntity().getName(),
                    orderDetailEntity.getProductDetailEntity().getProductEntity().getDescription(),
                    orderDetailEntity.getProductDetailEntity().getSize(),
                    orderDetailEntity.getQty(),
                    orderDetailEntity.getProductDetailEntity().getSalePrice(),
                    orderDetailEntity.getPrice()
            ));
        }
        return new OrderResponseDTO(
                orderEntity.getOrderId(),
                orderEntity.getDate().toString(),
                orderEntity.getTime().toString(),
                orderEntity.getOrderPaymentEntity().getTotalPrice(),
                orderEntity.getOrderPaymentEntity().getDiscount(),
                detailList
        );
    }
}
