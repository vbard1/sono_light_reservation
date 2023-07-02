package sono_light_reservation.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import sono_light_reservation.api.entity.Equipment;

import java.util.List;

public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {

    @Query("SELECT eq FROM Equipment eq WHERE eq.category.category_id = :categoryId")
    List<Equipment> findEquipmentsByCategory(@Param("categoryId") int categoryId);

    @Query("SELECT eq FROM Equipment eq WHERE eq.category.section.section_id = :sectionId")
    List<Equipment> findEquipmentsBySection(@Param("sectionId") int sectionId);
}
