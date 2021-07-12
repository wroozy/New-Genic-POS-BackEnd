package lk.wroozy.newgeniccomputer.dto.request;

public class CategoryRequestDTO {

    private String category;
    private String description;

    public CategoryRequestDTO() {
    }

    public CategoryRequestDTO(String category, String description) {
        this.category = category;
        this.description = description;
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
        return "CategoryRequestDTO{" +
                "category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
