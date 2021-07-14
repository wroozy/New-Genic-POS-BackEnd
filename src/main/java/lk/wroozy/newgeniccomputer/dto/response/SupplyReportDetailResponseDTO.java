package lk.wroozy.newgeniccomputer.dto.response;

public class SupplyReportDetailResponseDTO {

    private long supplyOrderDetailId;
    private long productId;
    private long productDetailId;
    private String name;
    private String description;
    private String brand;
    private String size;
    private double qty;
    private double buyingPrice;

    public SupplyReportDetailResponseDTO() {
    }

    public SupplyReportDetailResponseDTO(long supplyOrderDetailId,
                                         long productId,
                                         long productDetailId,
                                         String name,
                                         String description,
                                         String brand,
                                         String size,
                                         double qty,
                                         double buyingPrice) {
        this.supplyOrderDetailId = supplyOrderDetailId;
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.size = size;
        this.qty = qty;
        this.buyingPrice = buyingPrice;
    }

    public long getSupplyOrderDetailId() {
        return supplyOrderDetailId;
    }

    public void setSupplyOrderDetailId(long supplyOrderDetailId) {
        this.supplyOrderDetailId = supplyOrderDetailId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Override
    public String toString() {
        return "SupplyReportDetailResponseDTO{" +
                "supplyOrderDetailId=" + supplyOrderDetailId +
                ", productId=" + productId +
                ", productDetailId=" + productDetailId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", qty=" + qty +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
