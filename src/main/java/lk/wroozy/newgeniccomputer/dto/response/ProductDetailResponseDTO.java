package lk.wroozy.newgeniccomputer.dto.response;

public class ProductDetailResponseDTO {

    private long productDetailId;
    private String size;
    private double stock;
    private String warranty;
    private double buyingPrice;
    private double salePrice;
    private String updateDate;
    private String updateTime;

    public ProductDetailResponseDTO() {
    }

    public ProductDetailResponseDTO(long productDetailId,
                                    String size,
                                    double stock,
                                    String warranty,
                                    double buyingPrice,
                                    double salePrice,
                                    String updateDate,
                                    String updateTime) {
        this.productDetailId = productDetailId;
        this.size = size;
        this.stock = stock;
        this.warranty = warranty;
        this.buyingPrice = buyingPrice;
        this.salePrice = salePrice;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
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

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
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

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ProductDetailResponseDTO{" +
                "productDetailId=" + productDetailId +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", warranty='" + warranty + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", salePrice=" + salePrice +
                ", updateDate='" + updateDate + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
