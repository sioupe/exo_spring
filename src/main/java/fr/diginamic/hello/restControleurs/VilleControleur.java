package fr.diginamic.hello.restControleurs;

import fr.diginamic.hello.entite.Ville;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {

    @GetMapping
    public List<Ville> getVilles(){

        List<Ville> villes = new ArrayList<Ville>();
        villes.add(new Ville("Montpellier",10000));
        villes.add(new Ville("Marseille",5000));

        return villes;
    }
}
