package lk.wroozy.newgeniccomputer.dto.response;

import javax.persistence.Column;

public class SupplierResponseDTO {

    private String supplierUuid;
    private String name;
    private String address;
    private String regNo;
    private String mobile;
    private String gmail;

    public SupplierResponseDTO() {
    }

    public SupplierResponseDTO(String supplierUuid,
                               String name,
                               String address,
                               String regNo,
                               String mobile,
                               String gmail) {
        this.supplierUuid = supplierUuid;
        this.name = name;
        this.address = address;
        this.regNo = regNo;
        this.mobile = mobile;
        this.gmail = gmail;
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

    @Override
    public String toString() {
        return "SupplierResponseDTO{" +
                "supplierUuid='" + supplierUuid + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", regNo='" + regNo + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }
}
