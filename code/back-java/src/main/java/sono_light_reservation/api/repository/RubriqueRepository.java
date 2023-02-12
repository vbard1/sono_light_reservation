package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.model.Rubrique;

@Repository
public interface RubriqueRepository extends CrudRepository<Rubrique, Long> {
}
