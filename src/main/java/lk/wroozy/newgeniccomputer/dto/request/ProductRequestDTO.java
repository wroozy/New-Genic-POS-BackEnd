package lk.wroozy.newgeniccomputer.dto.request;

import java.util.List;

public class ProductRequestDTO {

    private String name;
    private String description;
    private String brand;
    private List<ProductVariationDTO> variationList;
    private long categoryId;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String name,
                             String description,
                             String brand,
                             List<ProductVariationDTO> variationList,
                             long categoryId) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.variationList = variationList;
        this.categoryId = categoryId;
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

    public List<ProductVariationDTO> getVariationList() {
        return variationList;
    }

    public void setVariationList(List<ProductVariationDTO> variationList) {
        this.variationList = variationList;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductRequestDTO{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", variationList=" + variationList +
                ", categoryId=" + categoryId +
                '}';
    }
}
