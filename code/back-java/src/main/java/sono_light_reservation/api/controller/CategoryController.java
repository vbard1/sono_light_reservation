package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.service.CategoryService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * Read the details of the category get by id
     *
     * @param id
     * @return categoryDto
     */
    @GetMapping("/category/{id}")
    public Optional<CategoryDto> getOneSection(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    /**
     * Update the details of the category get by id
     *
     * @param id
     * @param updatedCategoryDto
     * @return category with modifications
     */
    @PutMapping("/category/{id}")
    public CategoryDto updateCategory(@PathVariable int id, @RequestBody CategoryDto updatedCategoryDto) {
        return categoryService.updateCategory(id, updatedCategoryDto);
    }

    /**
     * Delete existant category
     *
     * @param id
     * @return String message : confirm of the suppression
     */
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    /**
     * List of all the categories
     *
     * @return the list of the categories
     */
    @GetMapping("/category")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories();
    }

    /**
     * Create a new category
     *
     * @param newCategoryDto
     * @return the details of the new categoryDto
     */
    @PostMapping("/category")
    public CategoryDto createCategory(@RequestBody CategoryDto newCategoryDto) {
        return categoryService.saveCategory(newCategoryDto);
    }
}
