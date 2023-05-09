package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.service.SectionService;

import java.util.List;
import java.util.Optional;

@RestController
public class SectionController {

    @Autowired
    private SectionService sectionService;

    /**
     * Read the details of the section get by id
     * @param id
     * @return section
     */
    @GetMapping("/section/{id}")
    public Optional<SectionDto> getOneSection(@PathVariable int id) {
        return sectionService.getSection(id);
    }

    /**
     * Update the details of the section get by id
     * @param id
     * @param updatedSection
     * @return section with modifications
     */
    @PutMapping("/section/{id}")
    public SectionDto updateSection(@PathVariable int id, @RequestBody SectionDto updatedSection) {
        return sectionService.updateSection(id, updatedSection);
    }

    /**
     * Delete existant section
     * @param id
     * @return String: confirm of the suppression
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
     * @return the details of the new sectino
     */
    @PostMapping("/section")
    public SectionDto createSection(@RequestBody SectionDto newSectionDto) {
        return sectionService.saveSection(newSectionDto);
    }


}