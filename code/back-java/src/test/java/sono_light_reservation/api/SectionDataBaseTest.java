package sono_light_reservation.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sono_light_reservation.api.dto.SectionDto;
import sono_light_reservation.api.repository.SectionRepository;
import sono_light_reservation.api.service.SectionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest
public class SectionDataBaseTest {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionService sectionService;

    @BeforeEach
    public void setup() {
        // initialisation de la base avant chaque test.
    }

    @Test
    public void shouldInsertOrderIntoDB() {
        // Given
        SectionDto sectionDto = new SectionDto();
        sectionDto.setId(4);
        sectionDto.setLabel("Enceinte");

        // When
        sectionService.saveSection(sectionDto);

        // Then
        System.out.println("Rubrique sauvegardée : " + sectionService.saveSection(sectionDto));
    }
}

