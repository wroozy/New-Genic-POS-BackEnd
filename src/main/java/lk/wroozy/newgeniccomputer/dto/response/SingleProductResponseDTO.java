package lk.wroozy.newgeniccomputer.dto.response;

public class SingleProductResponseDTO {

    private long productId;
    private String productCode;
    private String name;
    private String description;
    private String size;
    private double stock;
    private double salePrice;

    public SingleProductResponseDTO() {
    }

    public SingleProductResponseDTO(long productId,
                                    String productCode,
                                    String name,
                                    String description,
                                    String size,
                                    double stock,
                                    double salePrice) {
        this.productId = productId;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.size = size;
        this.stock = stock;
        this.salePrice = salePrice;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "SingleProductResponseDTO{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", salePrice=" + salePrice +
                '}';
    }
}
