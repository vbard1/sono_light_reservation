package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name= "section")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int section_id;
    @Column(name = "label", nullable=false, unique=true)
    private String label;
}