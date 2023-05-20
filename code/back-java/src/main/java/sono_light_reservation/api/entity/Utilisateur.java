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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "prenom", nullable=false)
    private String prenom;

    @Column(name = "nom", nullable=false)
    private String nom;

    @Column(name = "email",nullable=false, unique=true)
    private String email;

    @Column(name = "telephone", unique=true, nullable=false)
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email_verification")
    private Boolean mailVerification;

    @Column(name = "motdepasse")
    private String motDePasse;

    //niveau : 1=superAdmin, 2=admin, 3=user
    @Column(name = "niveau", nullable=false)
    private Integer niveau;

    public Utilisateur(Long id, String prenom, String nom, String email, String telephone, String adresse, Integer niveau) {
    }

    public Utilisateur() {

    }
}