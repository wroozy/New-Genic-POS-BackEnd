package lk.wroozy.newgeniccomputer.dto.request;

public class ProductUpdateVariationDTO {

    private long productDetailId;
    private String productCode;
    private String size;
    private double stock;
    private String warranty;
    private double buyingPrice;
    private double salePrice;
    private boolean updated;

    public ProductUpdateVariationDTO() {
    }

    public ProductUpdateVariationDTO(long productDetailId,
                                     String productCode,
                                     String size,
                                     double stock,
                                     String warranty,
                                     double buyingPrice,
                                     double salePrice,
                                     boolean updated
                               ) {
        this.productDetailId = productDetailId;
        this.productCode = productCode;
        this.size = size;
        this.stock = stock;
        this.warranty = warranty;
        this.buyingPrice = buyingPrice;
        this.salePrice = salePrice;
        this.updated = updated;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public boolean isUpdated() {
        return updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ProductUpdateVariationDTO{" +
                "productDetailId=" + productDetailId +
                ", productCode='" + productCode + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", warranty='" + warranty + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", salePrice=" + salePrice +
                ", updated=" + updated +
                '}';
    }
}
