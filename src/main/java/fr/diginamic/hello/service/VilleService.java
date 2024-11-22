package fr.diginamic.hello.service;

import fr.diginamic.hello.entite.Ville;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VilleService {

    public List<Ville> findAll() {
        List<Ville> villes = new ArrayList<Ville>();
        villes.add(new Ville("Montpellier",10000));
        villes.add(new Ville("Marseille",5000));
        return villes;
    }
}
