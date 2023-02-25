package sono_light_reservation.api.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "rubrique")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prenom")
    private String firstname;

    @Column(name = "nom")
    private String lastname;

    @Column
    private String email;

    @Column(name = "telephone")
    private String phone;

    @Column(name = "email_verification")
    private Boolean email_check;

    @Column(name = "motdepasse")
    private String password;

    @Column(name = "niveau")
    private Integer level;


}
