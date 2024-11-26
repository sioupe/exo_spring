package fr.diginamic.hello.service;

import fr.diginamic.hello.VilleDao;
import fr.diginamic.hello.entite.Ville;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    @Autowired
    VilleDao villeDao;

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
        villeDao.insertVille(ville);
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
