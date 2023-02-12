package sono_light_reservation.api.service;

<<<<<<< HEAD
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public
class RubriqueService {
=======
import org.springframework.beans.factory.annotation.Autowired;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;

import java.util.Optional;

public class RubriqueService {
>>>>>>> 2541d90 (feature in progress)
    @Autowired
    private RubriqueRepository rubriqueRepository;

    public Optional<Rubrique> getRubrique(final Long id) {
        return rubriqueRepository.findById(id);
    }

<<<<<<< HEAD
    public List<Rubrique> getRubriques() {
        return (List<Rubrique>) rubriqueRepository.findAll();
=======
    public Iterable<Rubrique> getRubriques() {
        return rubriqueRepository.findAll();
>>>>>>> 2541d90 (feature in progress)
    }

    public void deleteRubrique(final Long id) {
        rubriqueRepository.deleteById(id);
    }

    public Rubrique saveRubrique(Rubrique rubrique) {
        Rubrique savedRubrique = rubriqueRepository.save(rubrique);
        return savedRubrique;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 2541d90 (feature in progress)
