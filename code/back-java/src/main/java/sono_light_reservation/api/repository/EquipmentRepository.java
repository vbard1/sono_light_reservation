package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import sono_light_reservation.api.entity.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {
}
