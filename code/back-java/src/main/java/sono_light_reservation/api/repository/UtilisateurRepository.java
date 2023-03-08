package sono_light_reservation.api.repository;

import org.springframework.data.repository.CrudRepository;
import sono_light_reservation.api.model.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
}
