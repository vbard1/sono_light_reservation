package sono_light_reservation.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sono_light_reservation.api.dto.CategoryDto;
import sono_light_reservation.api.dto.EquipementDto;
import sono_light_reservation.api.service.CategoryService;
import sono_light_reservation.api.service.EquipementService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EquipementController {
    @Autowired
    private EquipementService equipementService;

    /**
     * Read the details of the equipement get by id
     *
     * @param id
     * @return equipementDto
     */
    @GetMapping("/equipement/{id}")
    public Optional<EquipementDto> getOneEquipement(@PathVariable int id) {
        return equipementService.getEquipement(id);
    }

    /**
     * Update the details of the equipement get by id
     *
     * @param id
     * @param updatedEquipementDto
     * @return equipement with modifications
     */
    @PutMapping("/equipement/{id}")
    public EquipementDto updateEquipement(@PathVariable int id, @RequestBody EquipementDto updatedEquipementDto) {
        return equipementService.updateEquipement(id, updatedEquipementDto);
    }

    /**
     * Delete existant equipement
     *
     * @param id
     * @return String message : confirm of the suppression
     */
    @DeleteMapping("/equipement/{id}")
    public String deleteEquipement(@PathVariable int id) {
        return equipementService.deleteEquipement(id);
    }

    /**
     * List of all the equipements
     *
     * @return the list of the equipements
     */
    @GetMapping("/equipement")
    public List<EquipementDto> getEquipements() {
        return equipementService.getEquipements();
    }

    /**
     * Create a new equipement
     *
     * @param newEquipementDto
     * @return the details of the new equipementDto
     */
    @PostMapping("/equipement")
    public EquipementDto createEquipement(@RequestBody EquipementDto newEquipementDto) {
        return equipementService.saveEquipement(newEquipementDto);
    }

}
