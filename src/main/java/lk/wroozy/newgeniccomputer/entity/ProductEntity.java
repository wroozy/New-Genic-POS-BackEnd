package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;
    private String name;
    private String description;
    private String brand;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id")
    private CategoryEntity categoryEntity;

    public ProductEntity() {
    }

    public ProductEntity(long productId,
                         String name,
                         String description,
                         String brand,
                         CategoryEntity categoryEntity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.categoryEntity = categoryEntity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", categoryEntity=" + categoryEntity +
                '}';
    }
}
