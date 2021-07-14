package lk.wroozy.newgeniccomputer.service.impl;

import lk.wroozy.newgeniccomputer.dto.response.SaleReportResponseDTO;
import lk.wroozy.newgeniccomputer.entity.OrderDetailEntity;
import lk.wroozy.newgeniccomputer.entity.OrderEntity;
import lk.wroozy.newgeniccomputer.exception.CustomException;
import lk.wroozy.newgeniccomputer.repository.OrderDetailRepository;
import lk.wroozy.newgeniccomputer.repository.OrderPaymentRepository;
import lk.wroozy.newgeniccomputer.repository.OrderRepository;
import lk.wroozy.newgeniccomputer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private OrderRepository orderRepository;
    private OrderPaymentRepository orderPaymentRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public ReportServiceImpl(OrderRepository orderRepository,
                             OrderPaymentRepository orderPaymentRepository) {
        this.orderRepository = orderRepository;
        this.orderPaymentRepository = orderPaymentRepository;
    }

    @Override
    public ResponseEntity<?> getThisMonthSaleReport() {
        try {
            List<OrderEntity> thisMonthOrders = orderRepository.getThisMonthOrders();
            if (thisMonthOrders.isEmpty())
                return new ResponseEntity<>("No orders for this month yet", HttpStatus.OK);

            SaleReportResponseDTO report = createReport(thisMonthOrders);

            return new ResponseEntity<>(report, HttpStatus.OK);

        } catch (Exception e) {
            throw new CustomException("Failed to get this month sale report : " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getSaleReport(int month, int year) {
        try {
            List<OrderEntity> thisMonthOrders = orderRepository.getMonthOrders(month, year);
            if (thisMonthOrders.isEmpty())
                return new ResponseEntity<>("No orders for this month yet", HttpStatus.OK);

            SaleReportResponseDTO report = createReport(thisMonthOrders);

            return new ResponseEntity<>(report, HttpStatus.OK);

        } catch (Exception e) {
            throw new CustomException("Failed to get this month sale report : " + e.getMessage());
        }
    }

    private SaleReportResponseDTO createReport(List<OrderEntity> thisMonthOrders){
        int saleCount = 0;
        double saleAmount = 0;
        double buyingAmount = 0;
        double discount = 0;


        for (OrderEntity orderEntity :
                thisMonthOrders) {
            saleCount += 1;
            saleAmount += orderEntity.getOrderPaymentEntity().getTotalPrice();
            buyingAmount += orderEntity.getOrderPaymentEntity().getTotalBuyingPrice();
            discount += orderEntity.getOrderPaymentEntity().getDiscount();
        }

        OrderDetailEntity mostSellingProduct = orderDetailRepository.getMostSellingProduct();

        return new SaleReportResponseDTO(
                saleCount,
                saleAmount,
                buyingAmount,
                discount,
                saleAmount - buyingAmount,
                mostSellingProduct.getProductDetailEntity().getProductEntity().getName()
        );
    }
}
