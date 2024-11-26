package fr.diginamic.hello.entite;

import jakarta.persistence.*;

import java.util.Objects;

@Entity (name = "ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    int id;
    @Column(name ="NOM")
    private String nom;
    @Column(name ="NB_HABITANTS")
    private int nbHabitants;
    @ManyToOne
    @JoinColumn(name="ID_DEPARTEMENT")
    private Departement departement;

    public Ville(int id, String nom, int nbHabitants,Departement departement) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
        setDepartement(departement);
    }

    /**
     * constructeur parametre
     * @param nom
     * @param nbHabitants
     */

    public Ville(String nom, int nbHabitants) {
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    public Ville() {

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
     *     copie les données d'une ville dans celle ci
     */
    public void switchDonne(Ville ville){
        setNom(ville.getNom());
        setNbHabitants(ville.getNbHabitants());
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
     * get la valeur du depoartement
     * @return departement
     */
    public Departement getDepartement() {
        return departement;
    }

    /**
     * set la valeur du departement
     * @param departement departement
     */
    public void setDepartement(Departement departement) {
        this.departement = departement;
        departement.getVilles().add(this);
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

    /**
     * methode d'affichage
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ville{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", nbHabitants=").append(nbHabitants);
        sb.append("}\n");
        return sb.toString();
    }
}
