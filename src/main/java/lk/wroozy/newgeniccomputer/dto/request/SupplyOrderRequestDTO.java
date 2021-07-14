package lk.wroozy.newgeniccomputer.dto.request;

import java.util.List;

public class SupplyOrderRequestDTO {

    private String supplyOrderId;
    private long supplierId;
    private double discount;
    private List<SupplyProductDetailDTO> productDetailList;

    public SupplyOrderRequestDTO() {
    }

    public SupplyOrderRequestDTO(String supplyOrderId,
                                 long supplierId,
                                 double discount,
                                 List<SupplyProductDetailDTO> productDetailList) {
        this.supplyOrderId = supplyOrderId;
        this.supplierId = supplierId;
        this.discount = discount;
        this.productDetailList = productDetailList;
    }

    public String getSupplyOrderId() {
        return supplyOrderId;
    }

    public void setSupplyOrderId(String supplyOrderId) {
        this.supplyOrderId = supplyOrderId;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public List<SupplyProductDetailDTO> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<SupplyProductDetailDTO> productDetailList) {
        this.productDetailList = productDetailList;
    }

    @Override
    public String toString() {
        return "SupplyOrderRequestDTO{" +
                "supplyOrderId='" + supplyOrderId + '\'' +
                ", supplierId=" + supplierId +
                ", discount=" + discount +
                ", productDetailList=" + productDetailList +
                '}';
    }
}
