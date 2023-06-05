package sono_light_reservation.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
public class ReservationDto {
    private int reservation_id;
    private String reservation_label;
    private Integer reservation_state;
    private int equipment_id;
    private int category_id;
    private int event_id;

    public ReservationDto(int reservationId, String reservationLabel, Integer reservationState, int reservationEquipmentId, int reservationCategoryId, int reservationEventId) {
    }
}
