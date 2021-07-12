package lk.wroozy.newgeniccomputer.dto.response;

public class CategoryResponseDTO {

    private long categoryId;
    private String category;
    private String description;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(long categoryId,
                               String category,
                               String description) {
        this.categoryId = categoryId;
        this.category = category;
        this.description = description;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryResponseDTO{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
