package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "supply_order")
public class SupplierOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supply_order_id")
    private long supply_order_id;

    private Date date;
    private Time time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supply_paymetn_id")
    private SupplierPaymentEntity supplierPaymentEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supplier_id")
    private SupplierEntity supplierEntity;

    public SupplierOrderEntity() {
    }

    public SupplierOrderEntity(long supply_order_id,
                               Date date,
                               Time time,
                               SupplierPaymentEntity supplierPaymentEntity,
                               SupplierEntity supplierEntity) {
        this.supply_order_id = supply_order_id;
        this.date = date;
        this.time = time;
        this.supplierPaymentEntity = supplierPaymentEntity;
        this.supplierEntity = supplierEntity;
    }

    public long getSupply_order_id() {
        return supply_order_id;
    }

    public void setSupply_order_id(long supply_order_id) {
        this.supply_order_id = supply_order_id;
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

    public SupplierPaymentEntity getSupplierPaymentEntity() {
        return supplierPaymentEntity;
    }

    public void setSupplierPaymentEntity(SupplierPaymentEntity supplierPaymentEntity) {
        this.supplierPaymentEntity = supplierPaymentEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    @Override
    public String toString() {
        return "SupplierOrderEntity{" +
                "supply_order_id=" + supply_order_id +
                ", date=" + date +
                ", time=" + time +
                ", supplierPaymentEntity=" + supplierPaymentEntity +
                ", supplierEntity=" + supplierEntity +
                '}';
    }
}
