package fr.diginamic.hello.entite;

public class Ville {
    private String nom;
    private int nbHabitants;

    /**
     * constructeur parametre
     * @param nom
     * @param nbHabitants
     */
    public Ville(String nom, int nbHabitants) {
        this.nom = nom;
        this.nbHabitants = nbHabitants;
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
}