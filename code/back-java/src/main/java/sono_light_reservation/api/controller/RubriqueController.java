package sono_light_reservation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.service.RubriqueService;

import java.util.List;
import java.util.Optional;

@RestController
public class RubriqueController {

    /*final List USERStests = Arrays.asList(prenom, prenom);*/

    @Autowired
    private RubriqueService rubriqueService;

    @GetMapping("/rubrique")
    public List<Rubrique> getRubriques() {
        /*System.out.println("getRubrique" + rubriqueService.getRubriques());*/
        return rubriqueService.getRubriques();
    }

    @GetMapping("/rubrique/{id}")
    public Optional<Rubrique> getOneRubrique(@PathVariable Long id) {
        return rubriqueService.getRubrique(id);
    }

    @PostMapping("/rubrique")
    public Rubrique createRubrique(@RequestBody Rubrique newRubrique) {
        Rubrique rubrique = rubriqueService.saveRubrique(newRubrique);
        return rubriqueService.saveRubrique(rubrique);
    }

    @GetMapping("/")
    public String Home() {
        return "Accueil";
    }

}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sono_light_reservation.api.model.Rubrique;
import sono_light_reservation.api.service.RubriqueService;

import java.util.List;
import java.util.Optional;

@RestController
public class RubriqueController {

    /*final List USERStests = Arrays.asList(prenom, prenom);*/

    @Autowired
    private RubriqueService rubriqueService;

    @GetMapping("/rubrique")
    public List<Rubrique> getRubriques() {
        /*System.out.println("getRubrique" + rubriqueService.getRubriques());*/
        return rubriqueService.getRubriques();
    }

    @GetMapping("/rubrique/{id}")
    public Optional<Rubrique> getOneRubrique(@PathVariable Long id) {
        return rubriqueService.getRubrique(id);
    }

    @PostMapping("/rubrique")
    public Rubrique createRubrique(@RequestBody Rubrique newRubrique) {
        Rubrique rubrique = rubriqueService.saveRubrique(newRubrique);
        return rubriqueService.saveRubrique(rubrique);
    }

    @GetMapping("/")
    public String Home() {
        return "Accueil";
    }

}
