package fr.diginamic.hello.restControleurs;

import fr.diginamic.hello.Dto.VilleDto;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import fr.diginamic.hello.mappers.VilleMapper;
import fr.diginamic.hello.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.ListView;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    private VilleService villes ;

    @GetMapping
    public List<VilleDto> getAllVilles() {
        return VilleMapper.toDto(villes.extractVilles());
    }
    @GetMapping("/pageable")
    public List<VilleDto> getVilles(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return VilleMapper.toDto(villes.extractVilles(pageable));
    }
    @GetMapping(path="/{id}")
    public VilleDto getVilleId(@PathVariable ("id")@RequestParam int id){
        return VilleMapper.toDto(villes.extractVille(id));
    }
    @GetMapping(path="/nomVille/{nom}")
    public VilleDto getVilleNom(@PathVariable("nom")@RequestParam String nom){
        return VilleMapper.toDto(villes.extractVille(nom));
    }
   @PostMapping
    public List<VilleDto> insertVille(@RequestBody Ville ville) {
        return VilleMapper.toDto(villes.ajouterVille(ville));
    }

    @PutMapping
    public List<VilleDto> updateVille(@RequestBody Ville ville) {
        return VilleMapper.toDto(villes.update(ville.getId(), ville));
    }

    @DeleteMapping()
    public List<VilleDto> deleteVille(@RequestParam int id) {
       return VilleMapper.toDto(villes.delete(id));
    }

    @GetMapping(path="/PlusQue{min}NbHabitant")
    public List<VilleDto> listVillePlusNbHabitant(@PathVariable("min")@RequestParam int min) {
        return VilleMapper.toDto(villes.listVillePlusNbHabitant(min));
    }
    @GetMapping(path="/{departement}/PlusQue{min}NbHabitant")
    public List<VilleDto> listVillePlusNbHabitantParDepartement(@PathVariable("min") @RequestParam int min,@PathVariable ("departement") @RequestBody Departement departement) {
        return VilleMapper.toDto(villes.listVillePlusNbHabitantParDepartement(min, departement));
    }
    @GetMapping(path = "/{min},{max}")
    public List<VilleDto> listVilleNbHabitantEntre(@PathVariable("min") @RequestParam int min,@PathVariable("max") @RequestParam int max) {
        return VilleMapper.toDto(villes.listVilleNbHabitantComprisEntre(min, max));
    }
    @GetMapping(path = "/{departement}/{min},{max}")
    public List<VilleDto> listVilleNbHabitantEntre(@PathVariable("min") @RequestParam int min,@PathVariable("max") @RequestParam int max, @PathVariable ("departement") @RequestParam Departement departement) {
        return VilleMapper.toDto(villes.listVilleNbHabitantComprisEntreParDepartement(min, max, departement));
    }
    @GetMapping("/PlusGrandeVille")
    public List<VilleDto> trouverNPlusGrandeVilles(@RequestBody Ville ville,@RequestParam int n) {
        return VilleMapper.toDto(villes.trouverNPlusGrandeVille(ville, n));
    }


}
