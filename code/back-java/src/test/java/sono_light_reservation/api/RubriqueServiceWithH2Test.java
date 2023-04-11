package sono_light_reservation.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;
import sono_light_reservation.api.service.RubriqueService;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RubriqueServiceWithH2Test {
    @Autowired
    private RubriqueRepository rubriqueRepository;

    @Autowired
    private RubriqueService rubriqueService;

    @BeforeEach
    public void setup() {
    }

    @Test
    public void shouldGetRubriqueFromTheDb(){
        Rubrique rubrique_vet = new Rubrique();
        rubrique_vet.setLibelle("vetemements");
        Rubrique rubrique_cha = new Rubrique();
        rubrique_cha.setLibelle("chaussures");
        rubriqueRepository.save(rubrique_vet);
        rubriqueRepository.save(rubrique_cha);

        final List<Rubrique> rubriquesList = (List<Rubrique>) rubriqueService.getRubriques();
        System.out.println("Resultats : " + rubriquesList);
    }
}
