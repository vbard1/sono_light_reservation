package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Event;
import sono_light_reservation.api.entity.Reservation;
import sono_light_reservation.api.repository.ReservationRepository;

import java.util.Optional;

@Data
@Service
public class ReservationMapper {

    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationMapper(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * Convert reservation information to DTO , for  reservationController
     * @param reservation
     * @return reservationDto
     */
    public ReservationDto convertToDto(Optional<Reservation> reservation) {
        int reservation_equipment_id = -1;
        int reservation_category_id = -1;
        int reservation_event_id = -1;
//        if (reservation.get().getCategory() != null) {
//            reservation_equipment_id = reservation.get().getEquipment().getEvent_id();//TODO NOT Event : waiting Equipement class creation
//        }
//        if (reservation.get().getCategory() != null) {
//            reservation_category_id = reservation.get().getCategory().getEvent_id();//TODO NOT Event : waiting category class creation
//        }
        if (reservation.get().getEvent() != null) {
            reservation_event_id = reservation.get().getEvent().getEvent_id();
        }
        return new ReservationDto(reservation.get().getReservation_id(), reservation.get().getReservation_label(), reservation.get().getReservation_state(), reservation_equipment_id, reservation_category_id, reservation_event_id);
    }

    /**
     * Convert reservation information to entity , for reservationRepository
     * @param reservationDto
     * @param event
     * @return
     */
    public Reservation convertToEntity(ReservationDto reservationDto, Event event) {
        Reservation reservation = new Reservation();
        reservation.setReservation_label(reservationDto.getReservation_label());
        reservation.setReservation_state(reservationDto.getReservation_state());
        reservation.setEvent(event);
        reservation.setEquipment(event); //TODO NOT Event : waiting equipment class creation
        reservation.setCategory(event); //TODO NOT Event : waiting category class creation
        return reservation;
    }
}
