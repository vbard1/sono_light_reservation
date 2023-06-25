package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.service.SectionService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    /**
     * Read the details of the section get by id
     * @param id
     * @return sectionDto
     */
    @GetMapping("/section/{id}")
    public Optional<SectionDto> getOneSection(@PathVariable int id) {
        return sectionService.getSection(id);
    }

    /**
     * Update the details of the section get by id
     * @param id
     * @param updatedSectionDto
     * @return section with modifications
     */
    @PutMapping("/section/{id}")
    public SectionDto updateSection(@PathVariable int id, @RequestBody SectionDto updatedSectionDto) {
        return sectionService.updateSection(id, updatedSectionDto);
    }

    /**
     * Delete existant section
     * @param id
     * @return String message : confirm of the suppression
     */
    @DeleteMapping("/section/{id}")
    public String deleteSection(@PathVariable int id) {
        return sectionService.deleteSection(id);
    }

    /**
     * List of all the sections
     * @return the list of the sections
     */
    @GetMapping("/section")
    public List<SectionDto> getSections() {
        return sectionService.getSections();
    }

    /**
     * Create a new section
     * @param newSectionDto
     * @return the details of the new sectionDto
     */
    @PostMapping("/section")
    public SectionDto createSection(@RequestBody SectionDto newSectionDto) {
        return sectionService.saveSection(newSectionDto);
    }


}