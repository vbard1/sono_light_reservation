package sono_light_reservation.api.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class UtilisateurDto {

   private Long id;

    private String prenom;

    private String nom;

    private String email;

    private String telephone;

    private String adresse;

    private Boolean mailVerification;

    private String motDePasse;

    //niveau : 1=superAdmin, 2=admin, 3=user

    private Integer niveau;

    public UtilisateurDto(Long id, String prenom, String nom, String email, String telephone, String adresse, Integer niveau) {
    }
}
