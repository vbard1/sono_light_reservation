package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "category")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String desciption;

    @Column(name = "picture_link")
    private String picture_link;

}

