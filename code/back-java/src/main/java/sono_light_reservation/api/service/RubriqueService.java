package sono_light_reservation.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;

import java.util.Optional;

public class RubriqueService {
    @Autowired
    private RubriqueRepository rubriqueRepository;

    public Optional<Rubrique> getRubrique(final Long id) {
        return rubriqueRepository.findById(id);
    }

    public Iterable<Rubrique> getRubriques() {
        return rubriqueRepository.findAll();
    }

    public void deleteRubrique(final Long id) {
        rubriqueRepository.deleteById(id);
    }

    public Rubrique saveRubrique(Rubrique rubrique) {
        Rubrique savedRubrique = rubriqueRepository.save(rubrique);
        return savedRubrique;
    }
}
