package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name= "reservation")
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;

    @Column(name="reservation_label")
    private String reservation_label;

    //reservation_state : 1=enAttente, 2=validée, 3=enCours, 4=terminée
    @Column(name = "reservation_state")
    private Integer reservation_state;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private User equipment; //TODO NOT USER : waiting Equipement class creation
    @ManyToOne
    @JoinColumn(name = "category_id")
    private User category; //TODO NOT USER : waiting Category class creation
    @ManyToOne
    @JoinColumn(name = "event_id")
    private User event; //TODO NOT USER : waiting Event class creation


}
