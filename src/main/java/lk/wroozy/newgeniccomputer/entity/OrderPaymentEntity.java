package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_payment")
public class OrderPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_payment_id")
    private long orderPaymentId;
    private double totalPrice;
    private double discount;
    private double totalBuyingPrice;

    public OrderPaymentEntity() {
    }

    public OrderPaymentEntity(long orderPaymentId,
                              double totalPrice,
                              double discount,
                              double totalBuyingPrice) {
        this.orderPaymentId = orderPaymentId;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.totalBuyingPrice = totalBuyingPrice;
    }

    public long getOrderPaymentId() {
        return orderPaymentId;
    }

    public void setOrderPaymentId(long orderPaymentId) {
        this.orderPaymentId = orderPaymentId;
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

    public double getTotalBuyingPrice() {
        return totalBuyingPrice;
    }

    public void setTotalBuyingPrice(double totalBuyingPrice) {
        this.totalBuyingPrice = totalBuyingPrice;
    }

    @Override
    public String toString() {
        return "OrderPaymentEntity{" +
                "orderPaymentId=" + orderPaymentId +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", totalBuyingPrice=" + totalBuyingPrice +
                '}';
    }
}
