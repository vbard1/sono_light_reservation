package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sono_light_reservation.api.entity.Utilisateur;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    /*@Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Utilisateur u set u where u.id == ")
    void update */
}
