package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "supply_order")
public class SupplyOrderEntity {

    @Id
    @Column(name = "supply_order_id")
    private String supply_order_id;
    private Date date;
    private Time time;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supply_payment_id")
    private SupplyPaymentEntity supplyPaymentEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_supplier_id")
    private SupplierEntity supplierEntity;
    @OneToMany(mappedBy = "supplyOrderEntity", fetch = FetchType.LAZY)
    private List<SupplyOrderDetailEntity> supplyOrderDetailList;

    public SupplyOrderEntity() {
    }

    public SupplyOrderEntity(String supply_order_id,
                             Date date,
                             Time time,
                             SupplyPaymentEntity supplyPaymentEntity,
                             SupplierEntity supplierEntity,
                             List<SupplyOrderDetailEntity> supplyOrderDetailList) {
        this.supply_order_id = supply_order_id;
        this.date = date;
        this.time = time;
        this.supplyPaymentEntity = supplyPaymentEntity;
        this.supplierEntity = supplierEntity;
        this.supplyOrderDetailList = supplyOrderDetailList;
    }

    public String getSupply_order_id() {
        return supply_order_id;
    }

    public void setSupply_order_id(String supply_order_id) {
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

    public SupplyPaymentEntity getSupplyPaymentEntity() {
        return supplyPaymentEntity;
    }

    public void setSupplyPaymentEntity(SupplyPaymentEntity supplyPaymentEntity) {
        this.supplyPaymentEntity = supplyPaymentEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public List<SupplyOrderDetailEntity> getSupplyOrderDetailList() {
        return supplyOrderDetailList;
    }

    public void setSupplyOrderDetailList(List<SupplyOrderDetailEntity> supplyOrderDetailList) {
        this.supplyOrderDetailList = supplyOrderDetailList;
    }

    @Override
    public String toString() {
        return "SupplyOrderEntity{" +
                "supply_order_id=" + supply_order_id +
                ", date=" + date +
                ", time=" + time +
                ", supplyPaymentEntity=" + supplyPaymentEntity +
                ", supplierEntity=" + supplierEntity +
                ", supplyOrderDetailList=" + supplyOrderDetailList +
                '}';
    }
}
