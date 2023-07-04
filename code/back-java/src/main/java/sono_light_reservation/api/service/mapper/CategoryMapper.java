package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Section;

import java.util.Optional;

@Data
@Service
public class CategoryMapper {
    /**
     * Convert section information to DTO , for categoryController
     *
     * @param category
     * @return categoryDto
     */
    public CategoryDto convertToDto(Optional<Category> category) {
        int category_section_id = -1;
        if (category.get().getSection() != null) {
            category_section_id = category.get().getSection().getSection_id();
        }
        return new CategoryDto(category.get().getCategory_id(), category.get().getLabel(),
                category.get().getDescription(), category.get().getPicture_link(), category_section_id);
    }

    /**
     * Convert category information to entity , for categoryRepository
     *
     * @param categoryDto
     * @return category
     */
    public Category convertToEntity(CategoryDto categoryDto, Section section) {
        Category category = new Category();
        category.setLabel(categoryDto.getLabel());
        category.setDescription(categoryDto.getDescription());
        category.setPicture_link(categoryDto.getPicture_link());
        category.setSection(section);
        return category;
    }
}
