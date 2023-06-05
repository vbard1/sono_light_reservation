package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import sono_light_reservation.api.entity.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
}
