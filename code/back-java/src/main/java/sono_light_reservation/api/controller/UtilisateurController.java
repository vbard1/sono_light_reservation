package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sono_light_reservation.api.dto.UtilisateurDto;
import sono_light_reservation.api.entity.Utilisateur;
import sono_light_reservation.api.service.UtilisateurService;
import sono_light_reservation.api.service.mapper.UtilisateurMapper;

import java.net.URI;
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
    public Optional<UtilisateurDto> getOneUtilisateur(@PathVariable Long id) {
        return utilisateurService.getUtilisateur(id);
    }

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
    public List<UtilisateurDto> getUtilisateurs() {
        return utilisateurService.getUtilisateurs();
    }

    /**
     * Créer un nouvel utilisateur
     *
     * @param newUtilisateur
     * @return le detail du nouvel utilisateur
     */
    @PostMapping("/utilisateur")
    public ResponseEntity<?> createUtilisateur(@RequestBody Utilisateur newUtilisateur) {
        try {
            Utilisateur utilisateur = utilisateurService.saveUtilisateur(newUtilisateur);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(utilisateur.getId()).toUri();
            return ResponseEntity.created(location).body(utilisateur);
        }
        catch (DataIntegrityViolationException e){
            String message = "Erreur dans la creation de l'utilisateur";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    }
}
