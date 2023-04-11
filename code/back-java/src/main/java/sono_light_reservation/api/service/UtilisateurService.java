package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.entity.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Lire les details d'un utilisateur par son id
     * @param id
     * @return utilisateur
     */
    public Optional<Utilisateur> getUtilisateur(final Long id) {return utilisateurRepository.findById(id);}

    /**
     * Liste de tous les utilisateurs
     * @return La liste de tous les utilisateurs
     */
    public List<Utilisateur> getUtilisateurs() {return (List<Utilisateur>) utilisateurRepository.findAll();}

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        if (utilisateur.getNiveau() == null){
            utilisateur.setNiveau(3);
        }
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur;
    }

    /**
     * Supprimer un utilisateur existant
     * @param id
     * @return String: confirmation de suppression
     */
    public String deleteUtilisateur(final Long id){
        utilisateurRepository.deleteById(id);
        return "Utilisateur supprimé";
    }

    /**
     * Modifier les details d'un utilisateur par son id
     * @param id
     * @param updatedUtilisateur
     * @return utilisateur avec les modifications
     */
    public Utilisateur updateUtilisateur(Long id, Utilisateur updatedUtilisateur) {
       Utilisateur utilisateur = utilisateurRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
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
       if (updatedUtilisateur.getNiveau() != null ) {
           utilisateur.setNiveau(updatedUtilisateur.getNiveau());
       }
       return utilisateurRepository.save(utilisateur);
    }
}
