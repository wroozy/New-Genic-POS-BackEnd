package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long categoryId;
    private String category;
    private String description;
    @ManyToOne
    @JoinColumn(name = "fk_admin_id")
    private AdminEntity adminEntity;

    public CategoryEntity() {
    }

    public CategoryEntity(long categoryId,
                          String category,
                          String description,
                          AdminEntity adminEntity) {
        this.categoryId = categoryId;
        this.category = category;
        this.description = description;
        this.adminEntity = adminEntity;
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

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", adminEntity=" + adminEntity +
                '}';
    }
}
