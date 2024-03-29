package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sono_light_reservation.api.entity.ReservationStateEnum;

@Data
@Getter
@Setter
@ToString
public class ReservationDto {
    private int reservation_id;
    private String reservation_label;
    private ReservationStateEnum reservation_state; //reservation_state : 0=enAttente, 1=validée, 2=enCours, 3=terminée
    private int equipment_id;
    private int category_id;
    private int event_id;

    public ReservationDto(int reservation_id, String reservation_label, ReservationStateEnum reservation_state, int equipment_id, int category_id, int event_id) {
        this.reservation_id = reservation_id;
        this.reservation_label = reservation_label;
        this.reservation_state = reservation_state;
        this.equipment_id = equipment_id;
        this.category_id = category_id;
        this.event_id = event_id;
    }
}
