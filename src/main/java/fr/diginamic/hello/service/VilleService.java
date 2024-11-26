package fr.diginamic.hello.service;

import fr.diginamic.hello.Dao.DepartementDao;
import fr.diginamic.hello.Dao.VilleDao;
import fr.diginamic.hello.entite.Ville;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    VilleDao villeDao;
    @Autowired
    DepartementDao departementDao;

    public List<Ville> extractVilles  () {
        return villeDao.extractAll();
    }

    public Ville extractVille(int id) {

        return villeDao.findById(id);
    }
    public Ville extractVille(String nom) {
        return villeDao.findByNom(nom);
    }

    public List<Ville> ajouterVille(Ville ville) {
        if (ville.getDepartement() != null) {
            if (departementDao.findById(ville.getDepartement().getId()) == null) {
                departementDao.insert(ville.getDepartement());
            }
            villeDao.insertVille(ville);
        }
       return villeDao.extractAll();
    }

    public List<Ville> update(int idVille,Ville ville) {
        villeDao.update(villeDao.findById(idVille), ville);
        return villeDao.extractAll();
    }

    public List<Ville> delete(int id) {
        villeDao.delete(villeDao.findById(id));
        return villeDao.extractAll();
    }


}
