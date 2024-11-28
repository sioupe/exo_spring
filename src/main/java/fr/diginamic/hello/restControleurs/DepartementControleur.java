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


    @GetMapping
    public List<DepartementDto> getDepartements() {

        return DepartementMapper.toDto(departementService.getAllDepartement());
    }
    @GetMapping(path = "/{id}")
    public DepartementDto getDepartementById(@PathVariable("id")@RequestParam int id) {
        return DepartementMapper.toDto(departementService.getDepartementById(id));
    }
    @GetMapping(path = "/{nom}")
    public DepartementDto getDepartementByName(@PathVariable("nom") @RequestParam String name) {
        return DepartementMapper.toDto(departementService.getDepartementByName(name));
    }
    @PostMapping
    public List<DepartementDto> addDepartement(@RequestBody Departement departement) {
        return DepartementMapper.toDto(departementService.ajouterDepartement(departement));
    }
    @PutMapping
    List<DepartementDto> updateDepartement(@RequestBody Departement nouveauDepartement) {
        return DepartementMapper.toDto(departementService.updateDepartement(nouveauDepartement.getId(),nouveauDepartement));
    }
    @DeleteMapping
    public List<DepartementDto> deleteDepartement(@RequestParam int id) {
        return DepartementMapper.toDto(departementService.supprimerDepartement(id));
    }
}
