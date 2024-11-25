package fr.diginamic.hello.service;

import fr.diginamic.hello.entite.Ville;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    List<Ville> villes;

    public VilleService(List<Ville> villes) {
        this.villes = villes;
        this.villes.add(new Ville(1,"Montpellier",10000));
        this.villes.add(new Ville(2,"Marseille",5000));
    }

    public List<Ville> findAll() {

        return villes;
    }
    public Ville findById(int id) {
        for (Ville ville : villes) {
            if (ville.getId() == id) {
                return ville;
            }
        }
        return null;
    }
    public boolean exist(Ville ville) {
        for (Ville v : villes) {
            if (ville.equals(v)) {
                return true;
            }
        }
        return false;
    }
    public void update(Ville ville) {
        for (Ville v : villes) {
            if (v.getId() == ville.getId()) {
                villes.remove(v);
                villes.add(ville);
            }
        }
    }
    public void delete(int id) {
        villes.removeIf(ville -> ville.getId() == id);
    }


    public boolean existID(int id) {
        for (Ville v : villes) {
            if (v.getId() == id) {
                return true;
            }
        }
        return false;
    }




    /**
     * rajoute une ville dans la liste de ville
     *
     * @param ville ville
     */


    public void addVille(Ville ville) {
        this.villes.add(ville);
    }

}
