package fr.diginamic.hello.Dto;

import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class VilleDto {
    int id;
    private String nom;
    private int nbHabitants;
    private Departement departement;

    public VilleDto(Ville ville) {
        this.id = ville.getId();
        this.nom = ville.getNom();
        this.nbHabitants = ville.getNbHabitants();
        this.departement = ville.getDepartement();
    }
}
