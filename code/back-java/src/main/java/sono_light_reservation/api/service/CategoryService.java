package sono_light_reservation.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.repository.CategoryRepository;
import sono_light_reservation.api.service.mapper.CategoryMapper;

@Data
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

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
     * @param CategoryDto: Save
     */
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = categoryMapper.convertToEntity(categoryDto);
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
        return categoryMapper.convertToDto(Optional.of(categoryRepository.save(category)));
    }
}
