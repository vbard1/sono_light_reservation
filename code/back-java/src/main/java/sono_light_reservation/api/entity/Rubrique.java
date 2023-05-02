package sono_light_reservation.api.entity;

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