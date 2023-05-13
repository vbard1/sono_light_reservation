package sono_light_reservation.api.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.entity.Section;


@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {

}