package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.EvenementDto;
import sono_light_reservation.api.dto.UtilisateurDto;
import sono_light_reservation.api.entity.Evenement;
import sono_light_reservation.api.entity.Utilisateur;

import java.util.Optional;

@Data
@Service
public class EvenementMapper {

    /**
     * Choisir les éléments de l'utilisateur qui seront GET dans le controller
     * @param evenement
     * @return
     */
    public EvenementDto convertToDto(Optional<Evenement> evenement) {
        return new EvenementDto(evenement.get().getId(), evenement.get().getTitre(), evenement.get().getDescription(), evenement.get().getLieu(),
                evenement.get().getType(), evenement.get().getCommentaire_user(), evenement.get().getCommentaire_admin(), evenement.get().getDate_debut(),
                evenement.get().getDate_fin(), evenement.get().getEtat_usure_retour(), evenement.get().getTechnicien_demande(), evenement.get().getUtilisateur());
    }

    public Evenement convertToEntity(EvenementDto evenementDto) {
        Evenement evenement = new Evenement();
        evenement.setTitre(evenementDto.getTitre());
        evenement.setDescription(evenementDto.getDescription());
        evenement.setLieu(evenementDto.getLieu());
        evenement.setType(evenementDto.getType());
        evenement.setCommentaire_user(evenementDto.getCommentaire_user());
        evenement.setCommentaire_admin(evenementDto.getCommentaire_admin());
        evenement.setDate_debut(evenementDto.getDate_debut());
        evenement.setDate_fin(evenementDto.getDate_fin());
        evenement.setEtat_usure_retour(evenementDto.getEtat_usure_retour());
        evenement.setTechnicien_demande(evenementDto.getTechnicien_demande());
        evenement.setUtilisateur(evenementDto.getUtilisateur());
        return evenement;
    }
}
