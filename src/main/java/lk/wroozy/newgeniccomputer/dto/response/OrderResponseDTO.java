package lk.wroozy.newgeniccomputer.dto.response;

import java.util.List;

public class OrderResponseDTO {

    private long orderId;
    private String date;
    private String time;
    private double totalPrice;
    private double discount;
    List<OrderDetailResponseDTO> orderDetailList;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(long orderId,
                            String date,
                            String time,
                            double totalPrice,
                            double discount,
                            List<OrderDetailResponseDTO> orderDetailList) {
        this.orderId = orderId;
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.orderDetailList = orderDetailList;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<OrderDetailResponseDTO> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailResponseDTO> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "OrderResponseDTO{" +
                "orderId=" + orderId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
