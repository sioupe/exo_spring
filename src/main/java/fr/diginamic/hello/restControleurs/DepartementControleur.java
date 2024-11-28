package fr.diginamic.hello.restControleurs;

import ch.qos.logback.core.Layout;
import fr.diginamic.hello.Dto.DepartementDto;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.mappers.DepartementMapper;
import fr.diginamic.hello.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementControleur {
    @Autowired
    private DepartementService departementService;
    @Autowired
    private DepartementMapper departementMapper;

    @GetMapping
    public List<DepartementDto> getDepartements() {
        List<DepartementDto> departementDtos = new ArrayList<>();
        for (Departement departement :departementService.getAllDepartement()){
            departementDtos.add(departementMapper.toDto(departement));
        }
        return departementDtos;
    }
    @GetMapping(path = "/{id}")
    public DepartementDto getDepartementById(@PathVariable("id")@RequestParam int id) {
        return departementMapper.toDto(departementService.getDepartementById(id));
    }
    @GetMapping(path = "/{nom}")
    public DepartementDto getDepartementByName(@PathVariable("nom") @RequestParam String name) {
        return departementMapper.toDto(departementService.getDepartementByName(name));
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
