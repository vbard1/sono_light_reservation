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

    private String adresse;

    private Integer niveau;

    public UtilisateurDto(Long id, String prenom, String nom, String email, String telephone, String adresse,Integer niveau) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
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
