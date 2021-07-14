package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "supply_payment")
public class SupplyPaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_payment_id")
    private long supplierPaymentId;
    private double total;
    private double discount;

    public SupplyPaymentEntity() {
    }

    public SupplyPaymentEntity(long supplierPaymentId,
                               double total,
                               double discount) {
        this.supplierPaymentId = supplierPaymentId;
        this.total = total;
        this.discount = discount;
    }

    public long getSupplierPaymentId() {
        return supplierPaymentId;
    }

    public void setSupplierPaymentId(long supplierPaymentId) {
        this.supplierPaymentId = supplierPaymentId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "SupplyPaymentEntity{" +
                "supplierPaymentId=" + supplierPaymentId +
                ", total=" + total +
                ", discount=" + discount +
                '}';
    }
}
