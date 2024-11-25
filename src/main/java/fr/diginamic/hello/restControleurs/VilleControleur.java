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
    @GetMapping(path="/idVille")
    public Ville getVilleId(@RequestParam int id){
        return villes.findById(id);
    }
    @PostMapping
    public ResponseEntity<String> insertVille(@RequestBody Ville ville) {

        if (villes.existID(ville.getId())) {
            return ResponseEntity.badRequest().body("Ville already exists");
        }
        villes.addVille(ville);
        return ResponseEntity.ok("success");
    }
    @PutMapping
    public ResponseEntity<String> updateVille(@RequestBody Ville ville) {
        if (!villes.existID(ville.getId())) {
            return ResponseEntity.badRequest().body("Ville does not exist");
        }
        villes.update(ville);
        return ResponseEntity.ok("success");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteVille(@RequestParam int id) {
        if (!villes.existID(id)) {
            return ResponseEntity.badRequest().body("Ville does not exist");
        }
        villes.delete(id);
        return ResponseEntity.ok("succes");
    }


}
