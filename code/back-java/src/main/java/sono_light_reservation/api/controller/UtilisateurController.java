package sono_light_reservation.api.controller;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.model.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;
import sono_light_reservation.api.service.UtilisateurService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    private Utilisateur utilisateur;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateur")
    public LinkedList<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getOneUtilisateur(@PathVariable Long id) {return utilisateurService.getUtilisateur(id);}

    @PutMapping("/utilisateur/{id}")
    public Optional<Utilisateur> updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur askedUpdatesUtlisateur) {
        /*Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateur(id);
        utilisateur.get().setNom(askedUpdatesUtlisateur.getNom());*/
        return utilisateurService.updateUtilisateur(id, askedUpdatesUtlisateur);
    }

    @PostMapping("/utilisateur") public Utilisateur createUtilisateur(@RequestBody Utilisateur newUtlisateur) {
        Utilisateur utilisateur = utilisateurService.saveUtilisateur(newUtlisateur);
        return utilisateurService.saveUtilisateur(utilisateur);
    }
}
