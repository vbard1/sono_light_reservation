package sono_light_reservation.api.service.mapper;

import lombok.Data;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.UtilisateurDto;
import sono_light_reservation.api.entity.Utilisateur;

import java.util.Optional;

@Data
@Service
public class UtilisateurMapper {

    /**
     * Choisir les éléments de l'utilisateur qui seront GET dans le controller
     * @param utilisateur
     * @return
     */
    public UtilisateurDto convertToDto(Optional<Utilisateur> utilisateur) {
        return new UtilisateurDto(utilisateur.get().getId(), utilisateur.get().getPrenom(), utilisateur.get().getNom(), utilisateur.get().getEmail(), utilisateur.get().getTelephone(), utilisateur.get().getAdresse(), utilisateur.get().getNiveau());
    }

    public Utilisateur convertToEntity(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setTelephone(utilisateurDto.getTelephone());
        utilisateur.setAdresse(utilisateurDto.getAdresse());
        utilisateur.setNiveau(utilisateurDto.getNiveau());
        return utilisateur;
    }


}