package sono_light_reservation.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.model.Rubrique;

import java.util.List;


@Service
@Repository
public interface RubriqueRepository extends CrudRepository<Rubrique, Long> {

    Rubrique save(Rubrique user);
}