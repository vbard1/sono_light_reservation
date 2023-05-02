package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.RubriqueDto;
import sono_light_reservation.api.service.RubriqueService;

import java.util.List;
import java.util.Optional;

@RestController
public class RubriqueController {

    @Autowired
    private RubriqueService rubriqueService;

    /**
     * Lire les details d'une rubrique par son id
     * @param id
     * @return rubrique
     */
    @GetMapping("/rubrique/{id}")
    public Optional<RubriqueDto> getOneRubrique(@PathVariable Long id) {
        return rubriqueService.getRubrique(id);
    }

    /**
     * Modifier les details d'une rubrique par son id
     * @param id
     * @param updatedRubrique
     * @return rubrique avec les modifications
     */
    @PutMapping("/rubrique/{id}")
    public RubriqueDto updateRubrique(@PathVariable Long id, @RequestBody RubriqueDto updatedRubrique) {
        return rubriqueService.updateRubrique(id, updatedRubrique);
    }

    /**
     * Supprimer une rubrique existante
     * @param id
     * @return String: confirmation de suppression
     */
    @DeleteMapping("/rubrique/{id}")
    public String deleteRubrique(@PathVariable Long id) {
        return rubriqueService.deleteRubrique(id);
    }

    /**
     * Liste de toutes les rubriques
     * @return la liste de toutes les rubriques
     */
    @GetMapping("/rubrique")
    public List<RubriqueDto> getRubriques() {
        return rubriqueService.getRubriques();
    }

    /**
     * Créer une nouvelle rubrique
     * @param newRubriqueDto
     * @return le detail de la nouvelle rubrique
     */
    @PostMapping("/rubrique")
    public RubriqueDto createRubrique(@RequestBody RubriqueDto newRubriqueDto) {
        return rubriqueService.saveRubrique(newRubriqueDto);
    }


}