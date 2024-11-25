package fr.diginamic.hello.restControleurs;

import fr.diginamic.hello.entite.Ville;
import fr.diginamic.hello.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    private VilleService villes ;

    @GetMapping
    public List<Ville> getVilles(){
        return villes.findAll();
    }
    @PostMapping
    public ResponseEntity<String> insertVille(@RequestBody Ville ville) {

        if (villes.exist(ville)) {
            return ResponseEntity.badRequest().body("Ville already exists");
        }
        villes.addVille(ville);
        return ResponseEntity.ok("success");
    }

}
