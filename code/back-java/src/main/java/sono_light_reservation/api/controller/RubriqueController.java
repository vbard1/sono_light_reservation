package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.service.RubriqueService;

@RestController
public class RubriqueController {

    @Autowired
    private RubriqueService rubriqueService;

    @GetMapping("/rubriques")
    public String getRubrique() {
    /*public Iterable<Rubrique> getRubrique() {
        return rubriqueService.getRubriques();*/
        return "un max de rubriques!!";
    }

    @GetMapping("/")
    public String Home() {
        return "Accueil";
    }

}