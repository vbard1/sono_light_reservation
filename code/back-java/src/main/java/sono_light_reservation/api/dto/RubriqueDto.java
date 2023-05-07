package sono_light_reservation.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@ToString
public class RubriqueDto {
    private Long id;
    @NotNull
    private String libelle;

    public RubriqueDto(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public RubriqueDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
