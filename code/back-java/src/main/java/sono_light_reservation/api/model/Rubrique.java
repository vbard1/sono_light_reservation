package sono_light_reservation.api.model;

import lombok.*;

import javax.persistence.*;

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
    @Column(name="libelllé")
    private String libelle;

}

