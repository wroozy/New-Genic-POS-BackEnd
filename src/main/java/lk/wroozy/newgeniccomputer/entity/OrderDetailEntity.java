package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id")
    private long orderDetailId;
    private double qty;
    private double price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_id")
    private OrderEntity orderEntity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_return_detail_id")
    private ReturnDetailEntity returnDetailEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_detail_id")
    private ProductDetailEntity productDetailEntity;

    public OrderDetailEntity() {
    }

    public OrderDetailEntity(long orderDetailId,
                             double qty,
                             double price,
                             OrderEntity orderEntity,
                             ReturnDetailEntity returnDetailEntity,
                             ProductDetailEntity productDetailEntity) {
        this.orderDetailId = orderDetailId;
        this.qty = qty;
        this.price = price;
        this.orderEntity = orderEntity;
        this.returnDetailEntity = returnDetailEntity;
        this.productDetailEntity = productDetailEntity;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ReturnDetailEntity getReturnDetailEntity() {
        return returnDetailEntity;
    }

    public void setReturnDetailEntity(ReturnDetailEntity returnDetailEntity) {
        this.returnDetailEntity = returnDetailEntity;
    }

    public ProductDetailEntity getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(ProductDetailEntity productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "orderDetailId=" + orderDetailId +
                ", qty=" + qty +
                ", price=" + price +
                ", orderEntity=" + orderEntity +
                ", returnDetailEntity=" + returnDetailEntity +
                ", productDetailEntity=" + productDetailEntity +
                '}';
    }
}
