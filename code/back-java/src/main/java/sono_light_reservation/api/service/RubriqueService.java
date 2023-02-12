package sono_light_reservation.api.service;

<<<<<<< HEAD
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
=======
import lombok.Data;
>>>>>>> 8284867 (tests with H2 db)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;

import java.util.Optional;

<<<<<<< HEAD
public class RubriqueService {
>>>>>>> 2541d90 (feature in progress)
=======
@Data
@Service
public
class RubriqueService {
>>>>>>> 8284867 (tests with H2 db)
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 2541d90 (feature in progress)
=======
}
>>>>>>> 8284867 (tests with H2 db)
