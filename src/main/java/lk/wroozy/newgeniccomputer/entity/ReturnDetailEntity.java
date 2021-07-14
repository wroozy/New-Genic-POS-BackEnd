package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "return_detail")
public class ReturnDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_detail_id")
    private long returnDetailId;
    private double qty;
    private String reason;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_return_id")
    private ReturnEntity returnEntity;
    @OneToOne(mappedBy = "returnDetailEntity")
    private OrderDetailEntity orderDetailEntity;

    public ReturnDetailEntity() {
    }

    public ReturnDetailEntity(long returnDetailId,
                              double qty,
                              String reason,
                              ReturnEntity returnEntity,
                              OrderDetailEntity orderDetailEntity) {
        this.returnDetailId = returnDetailId;
        this.qty = qty;
        this.reason = reason;
        this.returnEntity = returnEntity;
        this.orderDetailEntity = orderDetailEntity;
    }

    public long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReturnEntity getReturnEntity() {
        return returnEntity;
    }

    public void setReturnEntity(ReturnEntity returnEntity) {
        this.returnEntity = returnEntity;
    }

    public OrderDetailEntity getOrderDetailEntity() {
        return orderDetailEntity;
    }

    public void setOrderDetailEntity(OrderDetailEntity orderDetailEntity) {
        this.orderDetailEntity = orderDetailEntity;
    }

    @Override
    public String toString() {
        return "ReturnDetailEntity{" +
                "returnDetailId=" + returnDetailId +
                ", qty=" + qty +
                ", reason='" + reason + '\'' +
                ", returnEntity=" + returnEntity +
                ", orderDetailEntity=" + orderDetailEntity +
                '}';
    }
}
