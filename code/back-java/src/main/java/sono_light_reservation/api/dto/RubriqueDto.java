package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class RubriqueDto {
    private Long id;
    private String libelle;

    public RubriqueDto(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public RubriqueDto() {

    }
}
