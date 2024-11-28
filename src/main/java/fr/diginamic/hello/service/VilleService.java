package fr.diginamic.hello.service;

import fr.diginamic.hello.Dto.VilleDto;
import fr.diginamic.hello.Repository.DepartementRespository;
import fr.diginamic.hello.Repository.VilleRespository;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    VilleRespository villeRepository;
    @Autowired
    DepartementRespository departementRepository;




    public List<Ville> extractVilles() {
        return villeRepository.findAll();
    }
    public List<Ville> extractVilles  (Pageable pageable) {
        return villeRepository.findAll(pageable).getContent();
    }

    public Ville extractVille(int id) {

        return villeRepository.findById(id).orElse(null);
    }
    public Ville extractVille(String nom) {
        return villeRepository.findByNom(nom);
    }

    @Transactional
    public List<Ville> ajouterVille(Ville ville) {
        if (ville.getDepartement() != null) {
            if (departementRepository.findById(ville.getDepartement().getId()) == null) {
                departementRepository.save(ville.getDepartement());
            }
            villeRepository.save(ville);
        }
       return villeRepository.findAll();
    }

    @Transactional
    public List<Ville> update(int idVille,Ville ville) {
        villeRepository.delete(villeRepository.findById(idVille).orElse(null));

        return villeRepository.findAll();
    }

    @Transactional
    public List<Ville> delete(int id) {
        villeRepository.delete(villeRepository.findById(id).orElse(null));
        return villeRepository.findAll();
    }
    public List<Ville> listVillePlusNbHabitant(int min){
        return villeRepository.findByNbHabitantsIsGreaterThan(min);
    }
    public List<Ville> listVillePlusNbHabitantParDepartement(int min, Departement departement){
        return villeRepository.findByDepartementAndNbHabitantsIsGreaterThan(departement,min);
    }

    public List<Ville> listVilleNbHabitantComprisEntre(int min,int max){
        return villeRepository.findByNbHabitantsBetween(min,max);
    }
    public List<Ville> listVilleNbHabitantComprisEntreParDepartement(int min,int max,Departement departement){
        return villeRepository.findByDepartementAndNbHabitantsBetween(departement,min,max);
    }

    public List<Ville> trouverNPlusGrandeVille(Ville ville,int n) {
        Pageable pagination = PageRequest.of(0,n);
        return villeRepository.findByDepartementOrderByNbHabitantsDesc(ville.getDepartement(), pagination);
    }

}
