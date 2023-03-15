package sono_light_reservation.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "utilisateur")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom", nullable=false)
    private String prenom;

    @Column(name = "nom", nullable=false)
    private String nom;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(name = "telephone", unique=true, nullable=false)
    private String telephone;

    @Column(name = "email_verification")
    private Boolean mailVerification;

    @Column(name = "motdepasse")
    private String motdepasse;

    @Column(name = "niveau", nullable=false)
    private Integer niveau;


}
