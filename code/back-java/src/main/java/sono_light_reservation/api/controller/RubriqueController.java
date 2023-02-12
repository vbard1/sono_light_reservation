package sono_light_reservation.api.controller;

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
public class RubriqueController {

}
>>>>>>> 2541d90 (feature in progress)
=======
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
>>>>>>> 8284867 (tests with H2 db)
