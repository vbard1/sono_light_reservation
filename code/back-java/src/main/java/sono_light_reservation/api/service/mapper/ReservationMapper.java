package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Reservation;

import java.util.Optional;

@Data
@Service
public class ReservationMapper {

    public ReservationDto convertToDto(Optional<Reservation> reservation) {
        int reservation_equipment_id = -1;
        int reservation_category_id = -1;
        int reservation_event_id = -1;
        if (reservation.get().getEquipment() != null) {
            reservation_equipment_id = reservation.get().getEquipment().getUser_id();//TODO NOT USER : waiting Equipement class creation
        }
        if (reservation.get().getCategory() != null) {
            reservation_category_id = reservation.get().getCategory().getUser_id();//TODO NOT USER : waiting category class creation
        }
        if (reservation.get().getEvent() != null) {
            reservation_event_id = reservation.get().getEvent().getUser_id(); //TODO NOT USER : waiting event class creation
        }
        return new ReservationDto(reservation.get().getReservation_id(), reservation.get().getReservation_label(), reservation.get().getReservation_state(), reservation_equipment_id, reservation_category_id, reservation_event_id);
    }
}
