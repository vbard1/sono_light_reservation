package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sono_light_reservation.api.entity.Utilisateur;

import java.util.Date;

@Data
@Getter
@Setter
@ToString
public class EvenementDto {

    private Long id;

//    @NotNull
    private String titre;

    private String description;

    private String lieu;

    //1=Assos INSA, 2=interne KLS, 3=autre-particuler
    private Integer type;

    private String commentaire_user;

    private String commentaire_admin;

    private Date date_debut;

    private Date date_fin;

    private Date etat_usure_retour;

    private Boolean technicien_demande;

    private Utilisateur utilisateur;

    public EvenementDto(Long id, String titre, String description, String lieu, Integer type, String commentaire_user, String commentaire_admin, Date date_debut, Date date_fin, Date etat_usure_retour, Boolean technicien_demande, Utilisateur utilisateur) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.lieu = lieu;
        this.type = type;
        this.commentaire_user = commentaire_user;
        this.commentaire_admin = commentaire_admin;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.etat_usure_retour = etat_usure_retour;
        this.technicien_demande = technicien_demande;
        this.utilisateur = utilisateur;
    }
}
