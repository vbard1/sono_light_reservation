package sono_light_reservation.api.service.mapper;

import java.util.Optional;
import sono_light_reservation.api.entity.Category;

import org.springframework.stereotype.Service;

import lombok.Data;
import sono_light_reservation.api.dto.CategoryDto;

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
        return new CategoryDto(category.get().getCategory_id(), category.get().getLabel(),
                category.get().getDesciption(), category.get().getPicture_link(), category.get().getSection());
    }

    /**
     * Convert category information to entity , for categoryRepository
     * 
     * @param categoryDto
     * @return category
     */
    public Category convertToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setLabel(categoryDto.getLabel());
        category.setDesciption(categoryDto.getDesciption());
        category.setPicture_link(categoryDto.getPicture_link());
        category.setSection(categoryDto.getSection());
        return category;
    }
}
