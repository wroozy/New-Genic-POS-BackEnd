package lk.wroozy.newgeniccomputer.dto.response;

import java.util.List;

public class SupplyReportResponseDTO {

    private String supplyOrderId;
    private double totalPrice;
    private double discount;
    private String date;
    private String time;
    private long supplierId;
    private String supplierName;
    private List<SupplyReportDetailResponseDTO> reportDetailList;

    public SupplyReportResponseDTO() {
    }

    public SupplyReportResponseDTO(String supplyOrderId,
                                   double totalPrice,
                                   double discount,
                                   String date,
                                   String time,
                                   long supplierId,
                                   String supplierName,
                                   List<SupplyReportDetailResponseDTO> reportDetailList) {
        this.supplyOrderId = supplyOrderId;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.date = date;
        this.time = time;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.reportDetailList = reportDetailList;
    }

    public String getSupplyOrderId() {
        return supplyOrderId;
    }

    public void setSupplyOrderId(String supplyOrderId) {
        this.supplyOrderId = supplyOrderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<SupplyReportDetailResponseDTO> getReportDetailList() {
        return reportDetailList;
    }

    public void setReportDetailList(List<SupplyReportDetailResponseDTO> reportDetailList) {
        this.reportDetailList = reportDetailList;
    }

    @Override
    public String toString() {
        return "SupplyReportResponseDTO{" +
                "supplyOrderId=" + supplyOrderId +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", reportDetailList=" + reportDetailList +
                '}';
    }
}

