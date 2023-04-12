package sono_light_reservation.api.dto;

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

    private Boolean mailVerification;
    private Integer niveau;

    public UtilisateurDto(Long id, String prenom, String nom, String email, String telephone, Boolean mailVerification, Integer niveau) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.mailVerification = mailVerification;
        this.niveau = niveau;
    }

    public UtilisateurDto(Long id, String prenom, String nom, String email, String telephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
    }
}
