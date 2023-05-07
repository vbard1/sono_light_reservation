package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sono_light_reservation.api.dto.EvenementDto;
import sono_light_reservation.api.service.EvenementService;

import java.util.List;
import java.util.Optional;

@RestController
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    /**
     * Lire les details d'un evenement par son id
     * @param id
     * @return evenement
     */
    @GetMapping("/evenement/{id}")
    public Optional<EvenementDto> getOneEvenement(@PathVariable Long id) {
        return Optional.ofNullable(evenementService.getEvenement(id));
    }

    /**
     * Liste de tous les évènements
     * @return La liste de tous les évènements
     */
    @GetMapping("/evenement")
    public List<EvenementDto> getEvenements() {
        return evenementService.getEvenements();
    }

}
