package fr.diginamic.hello.service;

import fr.diginamic.hello.entite.Ville;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    List<Ville> villes;

    public VilleService(List<Ville> villes) {
        this.villes = villes;
        this.villes.add(new Ville("Montpellier",10000));
        this.villes.add(new Ville("Marseille",5000));
    }

    public List<Ville> findAll() {

        return villes;
    }

    public boolean exist(Ville ville) {
        for (Ville v : villes) {
            if (ville.equals(v)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Getter
     *
     * @return villes
     */

    public List<Ville> getVilles() {
        return villes;
    }

    /**
     * Setter
     *
     * @param ville ville
     */


    public void addVille(Ville ville) {
        this.villes.add(ville);
    }

}
