package lk.wroozy.newgeniccomputer.dto;

public class ProductVariationDTO {

    private String size;
    private double stock;
    private String warranty;
    private double buyingPrice;
    private double salePrice;

    public ProductVariationDTO() {
    }

    public ProductVariationDTO(String size,
                               double stock,
                               String warranty,
                               double buyingPrice,
                               double salePrice
                               ) {
        this.size = size;
        this.stock = stock;
        this.warranty = warranty;
        this.buyingPrice = buyingPrice;
        this.salePrice = salePrice;
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

    @Override
    public String toString() {
        return "ProductVariationDTO{" +
                "size='" + size + '\'' +
                ", stock=" + stock +
                ", warranty='" + warranty + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", salePrice=" + salePrice +
                '}';
    }
}
