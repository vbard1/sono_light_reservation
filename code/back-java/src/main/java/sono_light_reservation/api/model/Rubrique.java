package sono_light_reservation.api.model;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

=======
import lombok.*;

import javax.persistence.*;

>>>>>>> 2541d90 (feature in progress)
@Data
@Entity
@Table(name= "rubrique")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Rubrique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    @Column(name = "libelle")
    private String libelle;
}
=======
    @Column(name="libelllé")
    private String libelle;

}

>>>>>>> 2541d90 (feature in progress)
