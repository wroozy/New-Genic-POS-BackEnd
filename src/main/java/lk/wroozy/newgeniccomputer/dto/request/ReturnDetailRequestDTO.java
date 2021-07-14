package lk.wroozy.newgeniccomputer.dto.request;

public class ReturnDetailRequestDTO {
    private long orderDetailId;
    private double qty;
    private String reason;

    public ReturnDetailRequestDTO() {
    }

    public ReturnDetailRequestDTO(long orderDetailId, double qty, String reason) {
        this.orderDetailId = orderDetailId;
        this.qty = qty;
        this.reason = reason;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ReturnDetailRequestDTO{" +
                "orderDetailId=" + orderDetailId +
                ", qty=" + qty +
                ", reason='" + reason + '\'' +
                '}';
    }
}
