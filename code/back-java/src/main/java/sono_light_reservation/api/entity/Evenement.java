package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Data
@Entity
@Table(name= "evenement")
@Getter
@Setter
@ToString
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "titre", nullable=false)
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "lieu")
    private String lieu;

    //1=Assos INSA, 2=interne KLS, 3=autre-particuler
    @Column(name = "type", nullable=false)
    private Integer type;

    @Column(name = "commentaire_user")
    private String commentaire_user;

    @Column(name = "commentaire_admin")
    private String commentaire_admin;

    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @Column(name = "etat_usure_retour")
    private Date etat_usure_retour;

    @Column(name = "technicien_demande")
    private Boolean technicien_demande;

    @ManyToOne
    @JoinColumn(name = "fk_id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    public Evenement(Long id, String titre, String description, String lieu, Integer type, String commentaire_user, String commentaire_admin, Date date_debut, Date date_fin, Date etat_usure_retour, Boolean technicien_demande) {
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
    }

    public Evenement() {

    }
}
