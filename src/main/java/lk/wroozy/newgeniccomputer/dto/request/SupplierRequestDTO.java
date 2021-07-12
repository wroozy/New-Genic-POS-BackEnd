package lk.wroozy.newgeniccomputer.dto.request;

public class SupplierRequestDTO {
    private String name;
    private String address;
    private String gmail;
    private String mobile;
    private String regNo;

    public SupplierRequestDTO() {
    }

    public SupplierRequestDTO(String name,
                              String address,
                              String gmail,
                              String mobile,
                              String regNo) {
        this.name = name;
        this.address = address;
        this.gmail = gmail;
        this.mobile = mobile;
        this.regNo = regNo;
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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public String toString() {
        return "SupplierRequestDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gmail='" + gmail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", regNo='" + regNo + '\'' +
                '}';
    }
}
