package sono_light_reservation.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sono_light_reservation.api.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    @Query("FROM Reservation WHERE event.event_id = :event_id")
    List<Reservation> findReservationByEventId(@Param("event_id")int event_id);
}
