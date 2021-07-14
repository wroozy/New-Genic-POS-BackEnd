package lk.wroozy.newgeniccomputer.dto.response;

import lk.wroozy.newgeniccomputer.entity.CategoryEntity;

import java.util.List;

public class ProductResponseDTO {

    private long productId;
    private String productCode;
    private String name;
    private String description;
    private String brand;
    private CategoryResponseDTO categoryResponseDTO;
    private List<ProductDetailResponseDTO> productDetailList;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(long productId,
                              String productCode,
                              String name,
                              String description,
                              String brand,
                              CategoryResponseDTO categoryResponseDTO,
                              List<ProductDetailResponseDTO> productDetailList) {
        this.productId = productId;
        this.productCode = productCode;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.categoryResponseDTO = categoryResponseDTO;
        this.productDetailList = productDetailList;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CategoryResponseDTO getCategoryResponseDTO() {
        return categoryResponseDTO;
    }

    public void setCategoryResponseDTO(CategoryResponseDTO categoryResponseDTO) {
        this.categoryResponseDTO = categoryResponseDTO;
    }

    public List<ProductDetailResponseDTO> getProductDetailList() {
        return productDetailList;
    }

    public void setProductDetailList(List<ProductDetailResponseDTO> productDetailList) {
        this.productDetailList = productDetailList;
    }

    @Override
    public String toString() {
        return "ProductResponseDTO{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", brand='" + brand + '\'' +
                ", categoryResponseDTO=" + categoryResponseDTO +
                ", productDetailList=" + productDetailList +
                '}';
    }
}
