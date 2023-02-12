package sono_light_reservation.api.model;

<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

=======
import lombok.*;

import javax.persistence.*;

>>>>>>> 2541d90 (feature in progress)
=======
import jakarta.persistence.*;
import lombok.*;

>>>>>>> 8284867 (tests with H2 db)
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
<<<<<<< HEAD
    @Column(name = "libelle")
    private String libelle;
}
=======
    @Column(name="libelllé")
    private String libelle;

}

>>>>>>> 2541d90 (feature in progress)
=======
    @Column(name = "libelle")
    private String libelle;
}
>>>>>>> 8284867 (tests with H2 db)
