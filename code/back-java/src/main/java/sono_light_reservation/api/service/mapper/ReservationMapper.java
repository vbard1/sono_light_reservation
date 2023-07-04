package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.ReservationDto;
import sono_light_reservation.api.entity.Category;
import sono_light_reservation.api.entity.Equipment;
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
        if (reservation.get().getEquipment() != null) {
            reservation_equipment_id = reservation.get().getEquipment().getEquipment_id();
        }
        if (reservation.get().getCategory() != null) {
            reservation_category_id = reservation.get().getCategory().getCategory_id();
        }
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
    public Reservation convertToEntity(ReservationDto reservationDto, Event event, Equipment equipment, Category category) {
        Reservation reservation = new Reservation();
        reservation.setReservation_label(reservationDto.getReservation_label());
        reservation.setReservation_state(reservationDto.getReservation_state());
        reservation.setEvent(event);
        reservation.setEquipment(equipment);
        reservation.setCategory(category);
        return reservation;
    }
}
