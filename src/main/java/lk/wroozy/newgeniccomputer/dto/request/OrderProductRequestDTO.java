package lk.wroozy.newgeniccomputer.dto.request;

public class OrderProductRequestDTO {

    private long productDetailId;
    private double qty;

    public OrderProductRequestDTO() {
    }

    public OrderProductRequestDTO(long productDetailId, double qty) {
        this.productDetailId = productDetailId;
        this.qty = qty;
    }

    public long getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(long productDetailId) {
        this.productDetailId = productDetailId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderProductRequestDTO{" +
                "productDetailId=" + productDetailId +
                ", qty=" + qty +
                '}';
    }
}
