package lk.wroozy.newgeniccomputer.dto.request;

public class SupplyProductDetailDTO {

    private long productDetailId;
    private double stock;
    private double buyingPrice;
    private double salePrice;
    private String warranty;

    public SupplyProductDetailDTO() {
    }

    public SupplyProductDetailDTO(long productDetailId,
                                  double stock,
                                  double buyingPrice,
                                  double salePrice,
                                  String warranty) {
        this.productDetailId = productDetailId;
        this.stock = stock;
        this.buyingPrice = buyingPrice;
        this.salePrice = salePrice;
        this.warranty = warranty;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
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

    @Override
    public String toString() {
        return "SupplyProductDetailDTO{" +
                "productDetailId=" + productDetailId +
                ", stock=" + stock +
                ", buyingPrice=" + buyingPrice +
                ", salePrice=" + salePrice +
                ", warranty='" + warranty + '\'' +
                '}';
    }
}
