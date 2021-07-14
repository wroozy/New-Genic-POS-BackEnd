package lk.wroozy.newgeniccomputer.dto.response;

public class ReturnDetailResponseDTO {

    private long returnDetailId;
    private String reason;
    private double qty;
    private String productCode;
    private long productDetailId;
    private String productName;
    private String productDescription;

    public ReturnDetailResponseDTO() {
    }

    public ReturnDetailResponseDTO(long returnDetailId,
                                   String reason,
                                   double qty,
                                   String productCode,
                                   long productDetailId,
                                   String productName,
                                   String productDescription) {
        this.returnDetailId = returnDetailId;
        this.reason = reason;
        this.qty = qty;
        this.productCode = productCode;
        this.productDetailId = productDetailId;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public long getReturnDetailId() {
        return returnDetailId;
    }

    public void setReturnDetailId(long returnDetailId) {
        this.returnDetailId = returnDetailId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "ReturnDetailResponseDTO{" +
                "returnDetailId=" + returnDetailId +
                ", reason='" + reason + '\'' +
                ", qty=" + qty +
                ", productCode='" + productCode + '\'' +
                ", productDetailId='" + productDetailId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
