package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "supply_order_detail")
public class SupplierOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_order_detail_id")
    private long supplyOrderDetailId;
    private double qty;
    private double orderPrice;
    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private ProductEntity productEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supply_order_id")
    private SupplierOrderEntity supplierOrderEntity;

    public SupplierOrderDetailEntity() {
    }

    public SupplierOrderDetailEntity(long supplyOrderDetailId,
                                     double qty,
                                     double orderPrice,
                                     ProductEntity productEntity,
                                     SupplierOrderEntity supplierOrderEntity) {
        this.supplyOrderDetailId = supplyOrderDetailId;
        this.qty = qty;
        this.orderPrice = orderPrice;
        this.productEntity = productEntity;
        this.supplierOrderEntity = supplierOrderEntity;
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

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public SupplierOrderEntity getSupplierOrderEntity() {
        return supplierOrderEntity;
    }

    public void setSupplierOrderEntity(SupplierOrderEntity supplierOrderEntity) {
        this.supplierOrderEntity = supplierOrderEntity;
    }

    @Override
    public String toString() {
        return "SupplierOrderDetailEntity{" +
                "supplyOrderDetailId=" + supplyOrderDetailId +
                ", qty=" + qty +
                ", orderPrice=" + orderPrice +
                ", productEntity=" + productEntity +
                ", supplierOrderEntity=" + supplierOrderEntity +
                '}';
    }
}
