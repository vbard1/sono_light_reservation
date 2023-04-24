package sono_light_reservation.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;
import sono_light_reservation.api.service.RubriqueService;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest
public class RubriqueDataBaseTest {

    @Autowired
    private RubriqueRepository rubriqueRepository;

    @Autowired
    private RubriqueService rubriqueService;

    @BeforeEach
    public void setup() {
        // initialisation de la base avant chaque test.
    }

    @Test
    public void shouldInsertOrderIntoDB() {
        // Given
        Rubrique rubrique = new Rubrique();
        rubrique.setId(4L);
        rubrique.setLibelle("Rubrique Enceinte");

        // When
        rubriqueRepository.save(rubrique);

        // Then
        System.out.println("Rubrique sauvegardée : " + rubriqueRepository.save(rubrique));
    }
}

