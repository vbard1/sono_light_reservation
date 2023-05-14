package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.dto.UtilisateurDto;
import sono_light_reservation.api.entity.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;
import sono_light_reservation.api.service.mapper.UtilisateurMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapper utilisateurMapper;

    /**
     * Lire les details d'un utilisateur par son id
     * @param id
     * @return utilisateur
     */
    public Optional<UtilisateurDto> getUtilisateur(final Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        UtilisateurDto utilisateurDto = utilisateurMapper.convertToDto(utilisateur);
        return Optional.of(utilisateurDto);
    }

    /**
     * Liste de tous les utilisateurs
     * @return La liste de tous les utilisateurs
     */
    public List<UtilisateurDto> getUtilisateurs() {
        return ((List<Utilisateur>) utilisateurRepository.findAll()).stream().map(utilisateur -> utilisateurMapper.convertToDto(Optional.ofNullable(utilisateur))).collect(Collectors.toList());
    }

    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        if (utilisateurDto.getNiveau() == null){
            utilisateurDto.setNiveau(3);  //1=superAdmin, 2=admin, 3=user
        }
        Utilisateur utilisateur = utilisateurMapper.convertToEntity(utilisateurDto);
        return utilisateurMapper.convertToDto(Optional.of(utilisateurRepository.save(utilisateur)));
    }

    /**
     * Supprimer un utilisateur existant
     * @param id
     * @return String: confirmation de suppression
     */
    public String deleteUtilisateur(final Long id){
        utilisateurRepository.deleteById(id);
        if (utilisateurRepository.findById(id).isEmpty()) {
            return "Utilisateur supprimé";
        } else {
            return "Erreur dans la suppression";
        }
    }

    /**
     * Modifier les details d'un utilisateur par son id
     * @param id
     * @param updatedUtilisateur
     * @return utilisateur avec les modifications
     */
    public UtilisateurDto updateUtilisateur(Long id, UtilisateurDto updatedUtilisateur) {

        Utilisateur utilisateur = utilisateurRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Id utilisateur invalide:" + id));

       if (updatedUtilisateur.getPrenom() != null) {
           utilisateur.setPrenom(updatedUtilisateur.getPrenom());
       }
       if (updatedUtilisateur.getNom() != null ) {
           utilisateur.setNom(updatedUtilisateur.getNom());
       }
       if (updatedUtilisateur.getEmail() != null ) {
           utilisateur.setEmail(updatedUtilisateur.getEmail());
       }
       if (updatedUtilisateur.getTelephone() != null ) {
           utilisateur.setTelephone(updatedUtilisateur.getTelephone());
       }
        if (updatedUtilisateur.getAdresse() != null ) {
            utilisateur.setTelephone(updatedUtilisateur.getAdresse());
        }
       if (updatedUtilisateur.getNiveau() != null ) {
           utilisateur.setNiveau(updatedUtilisateur.getNiveau());
       }
       return utilisateurMapper.convertToDto(Optional.of(utilisateurRepository.save(utilisateur)));
    }
}
