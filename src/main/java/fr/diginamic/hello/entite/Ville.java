package fr.diginamic.hello.entite;

import java.util.Objects;

public class Ville {
    int id;
    private String nom;
    private int nbHabitants;

    /**
     * constructeur parametre
     * @param nom
     * @param nbHabitants
     */
    public Ville(int id, String nom, int nbHabitants) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    /**
     * Getter
     *
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id id
     */


    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter
     *
     * @return nom
     */

    public String getNom() {
        return nom;
    }

    /**
     * Setter
     *
     * @param nom nom
     */


    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter
     *
     * @return nbHabitants
     */

    public int getNbHabitants() {
        return nbHabitants;
    }

    /**
     * Setter
     *
     * @param nbHabitants nbHabitants
     */


    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    /**
     * methode equals permet de verifier l'egalite entre differente instance
     */

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ville ville)) return false;
        return id== ville.id && nbHabitants == ville.nbHabitants && Objects.equals(nom, ville.nom);
    }

    /**
     * methode hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(nom, nbHabitants);
    }
}
