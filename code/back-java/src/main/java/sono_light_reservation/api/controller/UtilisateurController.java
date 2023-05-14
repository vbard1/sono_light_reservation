package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.dto.UtilisateurDto;
import sono_light_reservation.api.entity.Utilisateur;
import sono_light_reservation.api.repository.UtilisateurRepository;
import sono_light_reservation.api.service.UtilisateurService;

import java.util.List;
import java.util.Optional;

@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

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
    public UtilisateurDto updateUtilisateur(@PathVariable Long id, @RequestBody UtilisateurDto updatedUtilisateur) {
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
     * @param newUtilisateurDto
     * @return le detail du nouvel utilisateur
     */
    @PostMapping("/utilisateur")
    public UtilisateurDto createUtilisateur(@RequestBody UtilisateurDto newUtilisateurDto) {
        System.out.println("newUtilisateur" + newUtilisateurDto);
        return utilisateurService.saveUtilisateur(newUtilisateurDto);
    }
}
