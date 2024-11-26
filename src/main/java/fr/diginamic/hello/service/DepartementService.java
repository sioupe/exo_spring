package fr.diginamic.hello.service;

import fr.diginamic.hello.Dao.DepartementDao;
import fr.diginamic.hello.entite.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementService {
    @Autowired
    DepartementDao departementDao;

    public List<Departement> getAllDepartement() {
        return departementDao.findAll();
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
