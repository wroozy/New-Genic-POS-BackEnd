package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "supplier")
public class SupplierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long supplierId;
    private String supplierUuid;
    private String name;
    private String address;
    @Column(name = "registration_no")
    private String regNo;
    private String mobile;
    private String gmail;
    @ManyToOne
    @JoinColumn(name = "fk_admin_id")
    private AdminEntity adminEntity;

    public SupplierEntity() {
    }

    public SupplierEntity(long supplierId,
                          String supplierUuid,
                          String name,
                          String address,
                          String regNo,
                          String mobile,
                          String gmail,
                          AdminEntity adminEntity) {
        this.supplierId = supplierId;
        this.supplierUuid = supplierUuid;
        this.name = name;
        this.address = address;
        this.regNo = regNo;
        this.mobile = mobile;
        this.gmail = gmail;
        this.adminEntity = adminEntity;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierUuid() {
        return supplierUuid;
    }

    public void setSupplierUuid(String supplierUuid) {
        this.supplierUuid = supplierUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    @Override
    public String toString() {
        return "SupplierEntity{" +
                "supplierId=" + supplierId +
                ", supplierUuid='" + supplierUuid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", regNo='" + regNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gmail='" + gmail + '\'' +
                ", adminEntity=" + adminEntity +
                '}';
    }
}
