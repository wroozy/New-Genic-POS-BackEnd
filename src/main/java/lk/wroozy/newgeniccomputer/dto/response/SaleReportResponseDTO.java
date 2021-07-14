package lk.wroozy.newgeniccomputer.dto.response;

public class SaleReportResponseDTO {

    private int orderCount;
    private double totalSaleAmount;
    private double totalBuyingAmount;
    private double totalDiscounts;
    private double profit;
    private String mostSellingProductName;

    public SaleReportResponseDTO() {
    }

    public SaleReportResponseDTO(int orderCount,
                                 double totalSaleAmount,
                                 double totalBuyingAmount,
                                 double totalDiscounts,
                                 double profit,
                                 String mostSellingProductName) {
        this.orderCount = orderCount;
        this.totalSaleAmount = totalSaleAmount;
        this.totalBuyingAmount = totalBuyingAmount;
        this.totalDiscounts = totalDiscounts;
        this.profit = profit;
        this.mostSellingProductName = mostSellingProductName;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public double getTotalSaleAmount() {
        return totalSaleAmount;
    }

    public void setTotalSaleAmount(double totalSaleAmount) {
        this.totalSaleAmount = totalSaleAmount;
    }

    public double getTotalBuyingAmount() {
        return totalBuyingAmount;
    }

    public void setTotalBuyingAmount(double totalBuyingAmount) {
        this.totalBuyingAmount = totalBuyingAmount;
    }

    public double getTotalDiscounts() {
        return totalDiscounts;
    }

    public void setTotalDiscounts(double totalDiscounts) {
        this.totalDiscounts = totalDiscounts;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public String getMostSellingProductName() {
        return mostSellingProductName;
    }

    public void setMostSellingProductName(String mostSellingProductName) {
        this.mostSellingProductName = mostSellingProductName;
    }

    @Override
    public String toString() {
        return "SaleReportResponseDTO{" +
                "orderCount='" + orderCount + '\'' +
                ", totalSaleAmount=" + totalSaleAmount +
                ", totalBuyingAmount=" + totalBuyingAmount +
                ", totalDiscounts=" + totalDiscounts +
                ", profit=" + profit +
                ", mostSellingProductName='" + mostSellingProductName + '\'' +
                '}';
    }
}
