package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.ToString;
import sono_light_reservation.api.entity.Section;

@Data
@ToString
public class CategoryDto {
    private int categoryId;
    private String label;
    private String description;
    private String picture_link;
    private int section;

    public CategoryDto(int categoryId, String label, String description, String picture_link, int section) {
        this.categoryId = categoryId;
        this.label = label;
        this.description = description;
        this.picture_link = picture_link;
        this.section = section;
    }

    public CategoryDto() {
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture_link() {
        return this.picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    public int getSection() {
        return this.section;
    }

    public void setSection(int section) {
        this.section = section;
    }
}
