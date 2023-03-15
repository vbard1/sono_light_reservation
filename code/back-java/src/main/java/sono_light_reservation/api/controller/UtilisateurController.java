package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.model.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;
import sono_light_reservation.api.service.UtilisateurService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateur")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getOneUtilisateur(@PathVariable Long id) {return utilisateurService.getUtilisateur(id);}

    @PostMapping("/utilisateur") public Utilisateur createUtilisateur(@RequestBody Utilisateur newUtlisateur) {
        Utilisateur utilisateur = utilisateurService.saveUtilisateur(newUtlisateur);
        return utilisateurService.saveUtilisateur(utilisateur);
    }
}
