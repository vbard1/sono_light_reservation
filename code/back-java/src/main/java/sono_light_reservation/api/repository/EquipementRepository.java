package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.entity.Equipement;

@Repository
public interface EquipementRepository extends CrudRepository<Equipement, Integer> {
}
