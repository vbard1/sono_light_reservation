package sono_light_reservation.api.model;

import jakarta.persistence.*;
import lombok.*;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "libelle")
    private String libelle;
}
    @Column(name="libelllé")
    private String libelle;
