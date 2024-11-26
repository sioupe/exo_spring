package fr.diginamic.hello.service;

import fr.diginamic.hello.Dao.DepartementDao;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementService {
    @Autowired
    DepartementDao departementDao;

    public List<Departement> getAllDepartement() {
        return departementDao.findAll();
    }

    public List<Ville> getPlusGrandDepartement(int nombreVille,Departement departement) {
        List<Ville> listVille = departementDao.findAllVilles(departement);
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
        return departementDao.findById(id);
    }
    public Departement getDepartementByName(String name) {
        return departementDao.findByNom(name);
    }
    public List<Departement> ajouterDepartement(Departement departement) {
        departementDao.insert(departement);
        return departementDao.findAll();
    }
    public List<Departement> updateDepartement(int idDepartement, Departement departement) {
        departementDao.update(departementDao.findById(idDepartement),departement);
        return departementDao.findAll();
    }
    public List<Departement> supprimerDepartement(int id) {
        departementDao.delete(departementDao.findById(id));
        return departementDao.findAll();
    }
}
