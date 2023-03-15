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

    public LinkedList<Utilisateur> getUtilisateurs() {return (LinkedList<Utilisateur>) utilisateurRepository.findAll();}

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return savedUtilisateur;
    }

   /* public Utilisateur updateUtilisateur(Long id, Utilisateur askedUpdatesUtlisateur) {
        Optional<Utilisateur> optionalUtilisateur = getUtilisateur(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get()
            utilisateur.get().setPrenom(askedUpdatesUtlisateur.getPrenom());
            utilisateur.get().setNom(askedUpdatesUtlisateur.getNom());
            utilisateur.get().setEmail(askedUpdatesUtlisateur.getEmail());
            utilisateur.get().setTelephone(askedUpdatesUtlisateur.getTelephone());
            utilisateur.get().setNiveau(askedUpdatesUtlisateur.getNiveau());
            if (utilisateur != null) {Optional.fromNullable(utilisateurRepository.save(utilisateur))}
        }
        if(utilisateur.isPresent())

        return Optional.utilisateurRepository.save(utilisateur);
        }
    }*/
}
