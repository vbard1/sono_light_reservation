package sono_light_reservation.api.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sono_light_reservation.api.model.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Optional<Utilisateur> getUtilisateur(final Long id) {return utilisateurRepository.findById(id);}

    public List<Utilisateur> getUtilisateurs() {return (List<Utilisateur>) utilisateurRepository.findAll();}

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur;
    }

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
