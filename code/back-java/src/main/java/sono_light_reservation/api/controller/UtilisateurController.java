package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.entity.Utilisateur;
import sono_light_reservation.api.service.UtilisateurService;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    /**
     * Lire les details d'un utilisateur par son id
     * @param id
     * @return utilisateur
     */
    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getOneUtilisateur(@PathVariable Long id) {return utilisateurService.getUtilisateur(id);}

    /**
     * Modifier les details d'un utilisateur par son id
     * @param id
     * @param updatedUtilisateur
     * @return utilisateur avec les modifications
     */
    @PutMapping("/utilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable Long id, @RequestBody Utilisateur updatedUtilisateur) {
        return utilisateurService.updateUtilisateur(id, updatedUtilisateur);
    }

    /**
     * Supprimer un utilisateur existant
     * @param id
     * @return String: confirmation de suppression
     */
    @DeleteMapping("/utilisateur/{id}")
    public String deleteUtilisateur(@PathVariable Long id) {
        return utilisateurService.deleteUtilisateur(id);
    }

    /**
     * Liste de tous les utilisateurs
     * @return La liste de tous les utilisateurs
     */
    @GetMapping("/utilisateur")
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

<<<<<<< HEAD
    /**
     * Créer un nouvel utilisateur
     * @param newUtilisateur
     * @return le detail du nouvel utilisateur
     */
    @PostMapping("/utilisateur")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur newUtilisateur) {
        Utilisateur utilisateur = utilisateurService.saveUtilisateur(newUtilisateur);
=======
    @GetMapping("/utilisateur/{id}")
    public Optional<Utilisateur> getOneUtilisateur(@PathVariable Long id) {return utilisateurService.getUtilisateur(id);}

    @PostMapping("/utilisateur") public Utilisateur createUtilisateur(@RequestBody Utilisateur newUtlisateur) {
        Utilisateur utilisateur = utilisateurService.saveUtilisateur(newUtlisateur);
>>>>>>> developpement
        return utilisateurService.saveUtilisateur(utilisateur);
    }
}
