package sono_light_reservation.api.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sono_light_reservation.api.dto.EventDto;

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
    private Event equipment; //TODO NOT Event : waiting Equipement class creation
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Event category; //TODO NOT Event : waiting Category class creation
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Reservation(int reservation_id, String reservation_label, Integer reservation_state, Event equipment, Event category, Event event) {
        this.reservation_id = reservation_id;
        this.reservation_label = reservation_label;
        this.reservation_state = reservation_state;
        this.equipment = equipment;
        this.category = category;
        this.event = event;
    }

    public Reservation() {
        this.reservation_id = reservation_id;
    }
}
