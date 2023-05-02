package sono_light_reservation.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sono_light_reservation.api.dto.RubriqueDto;
import sono_light_reservation.api.entity.Rubrique;
import sono_light_reservation.api.repository.RubriqueRepository;
import sono_light_reservation.api.service.RubriqueService;

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
        RubriqueDto rubriqueDto = new RubriqueDto();
        rubriqueDto.setId(4L);
        rubriqueDto.setLibelle("Enceinte");

        // When
        rubriqueService.saveRubrique(rubriqueDto);

        // Then
        System.out.println("Rubrique sauvegardée : " + rubriqueService.saveRubrique(rubriqueDto));
    }
}

