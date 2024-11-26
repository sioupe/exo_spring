package fr.diginamic.hello.entite;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity (name = "departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    int id;
    @Column(name ="NOM")
    String nom;
    @Column(name ="CODE_POSTAL")
    String codePostal;
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    List<Ville> villes;

    {
        villes = new ArrayList<Ville>();
    }

    public Departement() {
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
     * @return codePostal
     */

    public String getCodePostal() {
        return codePostal;
    }

    /**
     * Setter
     *
     * @param codePostal codePostal
     */


    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    /**
     *     copie les données d'un deparetement dans celle ci
     */
    public void switchDonne(Departement departement){
        setNom(departement.getNom());
        setCodePostal(departement.getCodePostal());
    }

}
