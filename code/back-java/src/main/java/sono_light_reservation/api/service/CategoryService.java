package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Section;
import sono_light_reservation.api.repository.CategoryRepository;
import sono_light_reservation.api.repository.SectionRepository;
import sono_light_reservation.api.service.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private SectionRepository sectionRepository;

    /**
     * Read the details of the category get by id
     *
     * @param id
     * @return category
     */
    public Optional<CategoryDto> getCategory(final int id) {
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto categoryDto = categoryMapper.convertToDto(category);
        return Optional.ofNullable(categoryDto);
    }

    /**
     * List of all the categories
     *
     * @return the list of the categories
     */
    public List<CategoryDto> getCategories() {
        return ((List<Category>) categoryRepository.findAll()).stream()
                .map(category -> categoryMapper.convertToDto(Optional.ofNullable(category)))
                .collect(Collectors.toList());
    }

    /**
     * Save category
     *
     * @param categoryDto: Save
     */
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Optional<Section> sectionOptional = sectionRepository.findById(categoryDto.getSection());
        Section section = sectionOptional.orElse(null);

        Category category = categoryMapper.convertToEntity(categoryDto, section);
        categoryRepository.save(category);
        return categoryMapper.convertToDto(Optional.of(category));
    }

    /**
     * Delete existant category
     *
     * @param id
     * @return String: confirm of the suppression
     */
    public String deleteCategory(final int id) {
        categoryRepository.deleteById(id);
        if (categoryRepository.findById(id).isEmpty()) {
            return "category deleted";
        } else {
            return "Error in the deletion";
        }
    }

    /**
     * Update the details of the category get by id
     *
     * @param id
     * @param updatedCategory
     * @return category with modifications
     */
    public CategoryDto updateCategory(int id, CategoryDto updatedCategory) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Id category invalide:" + id));
        if (updatedCategory.getLabel() != null) {
            category.setLabel(updatedCategory.getLabel());
        }
        if (updatedCategory.getDescription() != null) {
            category.setDescription(updatedCategory.getDescription());
        }
        if (updatedCategory.getPicture_link() != null) {
            category.setPicture_link(updatedCategory.getPicture_link());
        }

        Optional<Section> sectionOptional = sectionRepository.findById(updatedCategory.getSection());
        Section section = sectionOptional.orElse(null);
        category.setSection(section);

        return categoryMapper.convertToDto(Optional.of(categoryRepository.save(category)));
    }
}
