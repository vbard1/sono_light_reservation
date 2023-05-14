package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "utilisateur")
@Getter
@Setter
@ToString
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email_verification")
    private Boolean mailVerification;

    @Column(name = "motdepasse")
    private String motDePasse;

    //niveau : 1=superAdmin, 2=admin, 3=user
    @Column(name = "niveau")
    private Integer niveau;

}

