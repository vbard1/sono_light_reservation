package sono_light_reservation.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.model.Rubrique;

import java.util.List;

@Repository
public interface RubriqueRepository extends CrudRepository<Rubrique, Long> {
}

