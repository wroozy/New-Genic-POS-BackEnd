package lk.wroozy.newgeniccomputer.dto.request;

import javax.validation.constraints.Pattern;
import java.util.List;

public class OrderRequestDTO {

    private String customerName;
    @Pattern(regexp = "[0-9]{9,10}", message = "Please input valid mobile number")
    private String customerMobile;
    private double discount;
    private List<OrderProductRequestDTO> productList;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(String customerName,
                           String customerMobile,
                           double discount,
                           List<OrderProductRequestDTO> productList) {
        this.customerName = customerName;
        this.customerMobile = customerMobile;
        this.discount = discount;
        this.productList = productList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<OrderProductRequestDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<OrderProductRequestDTO> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "OrderRequestDTO{" +
                "customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", discount=" + discount +
                ", productList=" + productList +
                '}';
    }
}
