package fr.diginamic.hello.restControleurs;

import ch.qos.logback.core.Layout;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementControleur {
    @Autowired
    private DepartementService departementService;

    @GetMapping
    public List<Departement> getDepartements() {
        return departementService.getAllDepartement();
    }
    @GetMapping(path = "/{id}")
    public Departement getDepartementById(@PathVariable("id")@RequestParam int id) {
        return departementService.getDepartementById(id);
    }
    @GetMapping(path = "/{nom}")
    public Departement getDepartementByName(@PathVariable("nom") @RequestParam String name) {
        return departementService.getDepartementByName(name);
    }
    @PostMapping
    public List<Departement> addDepartement(@RequestBody Departement departement) {
        return departementService.ajouterDepartement(departement);
    }
    @PutMapping
    List<Departement> updateDepartement(@RequestBody Departement nouveauDepartement) {
        return departementService.updateDepartement(nouveauDepartement.getId(),nouveauDepartement);
    }
    @DeleteMapping
    public List<Departement> deleteDepartement(@RequestParam int id) {
        return departementService.supprimerDepartement(id);
    }
}
