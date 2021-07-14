package lk.wroozy.newgeniccomputer.dto.request;

import java.util.List;

public class ProductUpdateRequestDTO {
    private String productCode;
    private String name;
    private String description;
    private String brand;
    private List<ProductUpdateVariationDTO> variationList;
    private long categoryId;

    public ProductUpdateRequestDTO() {
    }

    public ProductUpdateRequestDTO(String productCode,
                                   String name,
                                   String description,
                                   String brand,
                                   List<ProductUpdateVariationDTO> variationList,
                                   long categoryId) {
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.variationList = variationList;
        this.categoryId = categoryId;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<ProductUpdateVariationDTO> getVariationList() {
        return variationList;
    }

    public void setVariationList(List<ProductUpdateVariationDTO> variationList) {
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
        return "ProductUpdateRequestDTO{" +
                "productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", variationList=" + variationList +
                ", categoryId=" + categoryId +
                '}';
    }
}
