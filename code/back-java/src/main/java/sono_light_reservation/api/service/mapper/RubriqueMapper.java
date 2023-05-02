package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.RubriqueDto;
import sono_light_reservation.api.entity.Rubrique;

import java.util.Optional;

@Data
@Service
public class RubriqueMapper {
    public RubriqueDto convertToDto(Optional<Rubrique> rubrique) {
        return new RubriqueDto(rubrique.get().getId(), rubrique.get().getLibelle());
    }

    public Rubrique convertToEntity(RubriqueDto rubriqueDto) {
        Rubrique rubrique = new Rubrique();
        rubrique.setLibelle(rubriqueDto.getLibelle());
        return rubrique;
    }

}
