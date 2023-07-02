package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.EquipmentDto;
import sono_light_reservation.api.service.EquipmentService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * Read the details of the equipment get by id
     *
     * @param id
     * @return equipmentDto
     */
    @GetMapping("/equipment/{id}")
    public Optional<EquipmentDto> getOneEquipment(@PathVariable int id) {
        return equipmentService.getEquipment(id);
    }

    /**
     * List of all the equipments by SECTION id
     *
     * @return the list of the equipments
     */
    @GetMapping("/equipment/section/{id}")
    public List<EquipmentDto> getEquipmentsBySection(@PathVariable int id) {
        return equipmentService.getEquipmentsBySection(id);
    }

    /**
     * List of all the equipments by CATEGORY id
     *
     * @return the list of the equipments
     */
    @GetMapping("/equipment/category/{id}")
    public List<EquipmentDto> getEquipmentsByCategory(@PathVariable int id) {
        return equipmentService.getEquipmentsByCategory(id);
    }

    /**
     * Update the details of the equipment get by id
     *
     * @param id
     * @param updatedEquipmentDto
     * @return equipment with modifications
     */
    @PutMapping("/equipment/{id}")
    public EquipmentDto updateEquipment(@PathVariable int id, @RequestBody EquipmentDto updatedEquipmentDto) {
        return equipmentService.updateEquipment(id, updatedEquipmentDto);
    }

    /**
     * Delete existant equipment
     *
     * @param id
     * @return String message : confirm of the suppression
     */
    @DeleteMapping("/equipment/{id}")
    public String deleteEquipment(@PathVariable int id) {
        return equipmentService.deleteEquipment(id);
    }

    /**
     * List of all the equipments
     *
     * @return the list of the equipments
     */
    @GetMapping("/equipment")
    public List<EquipmentDto> getEquipments() {
        return equipmentService.getEquipments();
    }

    /**
     * Create a new equipment
     *
     * @param newEquipmentDto
     * @return the details of the new equipmentDto
     */
    @PostMapping("/equipment")
    public EquipmentDto createEquipment(@RequestBody EquipmentDto newEquipmentDto) {
        return equipmentService.saveEquipment(newEquipmentDto);
    }

}
