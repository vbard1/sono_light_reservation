package sono_light_reservation.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import sono_light_reservation.api.entity.Section;

@Data
@Getter
@ToString
public class CategoryDto {
    private int categoryId;
    @NotNull
    private String label;
    private String desciption;
    private String picture_link;
    private Section section;

    public CategoryDto(int categoryId, String label, String desciption, String picture_link, Section section) {
        this.categoryId = categoryId;
        this.label = label;
        this.desciption = desciption;
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

    public String getDesciption() {
        return this.desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getPicture_link() {
        return this.picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
