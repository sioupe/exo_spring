package fr.diginamic.hello.restControleurs;

import fr.diginamic.hello.Dto.VilleDto;
import fr.diginamic.hello.entite.Ville;
import fr.diginamic.hello.mappers.VilleMapper;
import fr.diginamic.hello.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    private VilleService villes ;

    @GetMapping
    public List<VilleDto> getVilles(){
        return VilleMapper.toDto(villes.extractVilles());
    }
    @GetMapping(path="/{id}")
    public VilleDto getVilleId(@PathVariable ("id")@RequestParam int id){
        return VilleMapper.toDto(villes.extractVille(id));
    }
    @GetMapping(path="/nomVille/{nom}")
    public VilleDto getVilleId(@PathVariable("nom")@RequestParam String nom){
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


}
