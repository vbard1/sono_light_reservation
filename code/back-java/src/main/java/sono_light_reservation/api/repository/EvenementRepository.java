package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.entity.Evenement;

@Repository
public interface EvenementRepository extends CrudRepository<Evenement, Long> {
}
