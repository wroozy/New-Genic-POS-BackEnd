package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "supply_order_detail")
public class SupplyOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_order_detail_id")
    private long supplyOrderDetailId;
    private double qty;
    private double orderPrice;
    @ManyToOne
    @JoinColumn(name = "fk_product_detail_id")
    private ProductDetailEntity productDetailEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supply_order_id")
    private SupplyOrderEntity supplyOrderEntity;

    public SupplyOrderDetailEntity() {
    }

    public SupplyOrderDetailEntity(long supplyOrderDetailId,
                                   double qty,
                                   double orderPrice,
                                   ProductDetailEntity productDetailEntity,
                                   SupplyOrderEntity supplyOrderEntity) {
        this.supplyOrderDetailId = supplyOrderDetailId;
        this.qty = qty;
        this.orderPrice = orderPrice;
        this.productDetailEntity = productDetailEntity;
        this.supplyOrderEntity = supplyOrderEntity;
    }

    public long getSupplyOrderDetailId() {
        return supplyOrderDetailId;
    }

    public void setSupplyOrderDetailId(long supplyOrderDetailId) {
        this.supplyOrderDetailId = supplyOrderDetailId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public ProductDetailEntity getProductDetailEntity() {
        return productDetailEntity;
    }

    public void setProductDetailEntity(ProductDetailEntity productDetailEntity) {
        this.productDetailEntity = productDetailEntity;
    }

    public SupplyOrderEntity getSupplyOrderEntity() {
        return supplyOrderEntity;
    }

    public void setSupplyOrderEntity(SupplyOrderEntity supplyOrderEntity) {
        this.supplyOrderEntity = supplyOrderEntity;
    }

    public SupplyOrderEntity getSupplierOrderEntity() {
        return supplyOrderEntity;
    }

    public void setSupplierOrderEntity(SupplyOrderEntity supplyOrderEntity) {
        this.supplyOrderEntity = supplyOrderEntity;
    }

    @Override
    public String toString() {
        return "SupplyOrderDetailEntity{" +
                "supplyOrderDetailId=" + supplyOrderDetailId +
                ", qty=" + qty +
                ", orderPrice=" + orderPrice +
                ", productDetailEntity=" + productDetailEntity +
                ", supplyOrderEntity=" + supplyOrderEntity +
                '}';
    }
}
