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
        return villes.extractVilles();
    }
    @GetMapping(path="/{id}")
    public Ville getVilleId(@PathVariable ("id")@RequestParam int id){
        return villes.extractVille(id);
    }
    @GetMapping(path="/nomVille/{nom}")
    public Ville getVilleId(@PathVariable("nom")@RequestParam String nom){
        return villes.extractVille(nom);
    }
   @PostMapping
    public List<Ville> insertVille(@RequestBody Ville ville) {
        return villes.ajouterVille(ville);
    }

    @PutMapping
    public List<Ville> updateVille(@RequestBody Ville ville) {
        System.out.println("_______________________________________________________________");
        System.out.println(ville.getId());
        return villes.update(ville.getId(), ville);
    }

    @DeleteMapping()
    public List<Ville> deleteVille(@RequestParam int id) {
       return villes.delete(id);
    }


}
