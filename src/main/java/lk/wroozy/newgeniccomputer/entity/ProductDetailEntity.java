package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "product_detail")
public class ProductDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private long productDetailId;
    private String size;
    private double stock;
    private String warranty;
    @Column(name = "buying_price")
    private double buyingPrice;
    @Column(name = "sale_price")
    private double salePrice;
    @Column(name = "update_date")
    private Date updateDate;
    @Column(name = "update_time")
    private Time updateTime;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product_id")
    private ProductEntity productEntity;

    public ProductDetailEntity() {
    }

    public ProductDetailEntity(long productDetailId,
                               String size,
                               double stock,
                               String warranty,
                               double buyingPrice,
                               double salePrice,
                               Date updateDate,
                               Time updateTime,
                               ProductEntity productEntity) {
        this.productDetailId = productDetailId;
        this.size = size;
        this.stock = stock;
        this.warranty = warranty;
        this.buyingPrice = buyingPrice;
        this.salePrice = salePrice;
        this.updateDate = updateDate;
        this.updateTime = updateTime;
        this.productEntity = productEntity;
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

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Time getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Time updateTime) {
        this.updateTime = updateTime;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String toString() {
        return "ProductDetailEntity{" +
                "productDetailId=" + productDetailId +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", warranty='" + warranty + '\'' +
                ", buyingPrice=" + buyingPrice +
                ", salePrice=" + salePrice +
                ", updateDate=" + updateDate +
                ", updateTime=" + updateTime +
                ", productEntity=" + productEntity +
                '}';
    }
}
