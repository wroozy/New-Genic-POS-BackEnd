package lk.wroozy.newgeniccomputer.dto.response;

public class OrderDetailResponseDTO {

    private long orderDetailId;
    private long productId;
    private long productDetailId;
    private String productCode;
    private String name;
    private String description;
    private String size;
    private double qty;
    private double salePrice;
    private double productPrice;

    public OrderDetailResponseDTO() {
    }

    public OrderDetailResponseDTO(long orderDetailId,
                                  long productId,
                                  long productDetailId,
                                  String productCode,
                                  String name,
                                  String description,
                                  String size,
                                  double qty,
                                  double salePrice,
                                  double productPrice) {
        this.orderDetailId = orderDetailId;
        this.productId = productId;
        this.productDetailId = productDetailId;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.size = size;
        this.qty = qty;
        this.salePrice = salePrice;
        this.productPrice = productPrice;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
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

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderDetailResponseDTO{" +
                "orderDetailId=" + orderDetailId +
                ", productId=" + productId +
                ", productDetailId=" + productDetailId +
                ", productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                ", qty=" + qty +
                ", salePrice=" + salePrice +
                ", productPrice=" + productPrice +
                '}';
    }
}
