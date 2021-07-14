package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;
    private Date date;
    private Time time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_payment_id")
    private OrderPaymentEntity orderPaymentEntity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_return_id")
    private ReturnEntity returnEntity;
    @OneToMany(mappedBy =  "orderEntity",fetch = FetchType.LAZY)
    private List<OrderDetailEntity> orderDetailList;


    public OrderEntity() {
    }

    public OrderEntity(long orderId,
                       Date date,
                       Time time,
                       OrderPaymentEntity orderPaymentEntity,
                       ReturnEntity returnEntity,
                       List<OrderDetailEntity> orderDetailList) {
        this.orderId = orderId;
        this.date = date;
        this.time = time;
        this.orderPaymentEntity = orderPaymentEntity;
        this.returnEntity = returnEntity;
        this.orderDetailList = orderDetailList;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public OrderPaymentEntity getOrderPaymentEntity() {
        return orderPaymentEntity;
    }

    public void setOrderPaymentEntity(OrderPaymentEntity orderPaymentEntity) {
        this.orderPaymentEntity = orderPaymentEntity;
    }

    public ReturnEntity getReturnEntity() {
        return returnEntity;
    }

    public void setReturnEntity(ReturnEntity returnEntity) {
        this.returnEntity = returnEntity;
    }

    public List<OrderDetailEntity> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetailEntity> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", time=" + time +
                ", orderPaymentEntity=" + orderPaymentEntity +
                ", returnEntity=" + returnEntity +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
