package fr.diginamic.hello.service;

import fr.diginamic.hello.Repository.DepartementRespository;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementService {
    @Autowired
    DepartementRespository departementRespository;

    public List<Departement> getAllDepartement() {
        return departementRespository.findAll();
    }

    public List<Ville> getPlusGrandDepartement(int nombreVille,Departement departement) {
        List<Ville> listVille = departementRespository.findVillesByCodePostalEquals(departement.getCodePostal());
        List<Ville> plusGrandesVilles = new ArrayList<Ville>();
        for (int i = 0; i < nombreVille; i++) {
            Ville villeTampon = new Ville("",0);
            for (Ville ville : listVille) {
                if (villeTampon.getNbHabitants() <ville.getNbHabitants()) {
                    villeTampon=ville;
                }
            }
            plusGrandesVilles.add(villeTampon);
            listVille.remove(villeTampon);
        }
        return plusGrandesVilles;
    }
    public Departement getDepartementById(int id) {
        return departementRespository.findById(id).orElse(null);
    }
    public Departement getDepartementByName(String name) {
        return departementRespository.findByNom(name);
    }
    @Transactional
    public List<Departement> ajouterDepartement(Departement departement) {
        departementRespository.save(departement);
        return departementRespository.findAll();
    }
    @Transactional
    public List<Departement> updateDepartement(int idDepartement, Departement departement) {
        departementRespository.delete(departementRespository.findById(idDepartement).orElse(null));
        departementRespository.save(departement);
        return departementRespository.findAll();
    }
    @Transactional
    public List<Departement> supprimerDepartement(int id) {
        departementRespository.delete(departementRespository.findById(id).orElse(null));
        return departementRespository.findAll();
    }
}
