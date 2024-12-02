package fr.diginamic.hello.Dto;

import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;

import org.springframework.stereotype.Component;


public class VilleDto {
    private int codeVille;
    private String nomVille;
    private int nbHabitants;
    private String codeDepartement;
    private String nomDepartement;


    /**
     * Getter
     *
     * @return nomVille
     */

    public String getNomVille() {
        return nomVille;
    }

    /**
     * Setter
     *
     * @param nomVille nomVille
     */


    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    /**
     * Getter
     *
     * @return codeVille
     */

    public int getCodeVille() {
        return codeVille;
    }

    /**
     * Setter
     *
     * @param codeVille codeVille
     */


    public void setCodeVille(int codeVille) {
        this.codeVille = codeVille;
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
     * Getter
     *
     * @return codeDepartement
     */

    public String getCodeDepartement() {
        return codeDepartement;
    }

    /**
     * Setter
     *
     * @param codeDepartement codeDepartement
     */


    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    /**
     * Getter
     *
     * @return nomDepartement
     */

    public String getNomDepartement() {
        return nomDepartement;
    }

    /**
     * Setter
     *
     * @param nomDepartement nomDepartement
     */


    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    /**
     * methode d'affichage
     */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ville ");
        sb.append(nomVille).append(" ");
        sb.append(" nombre d'habitant : ").append(nbHabitants);
        sb.append(" code postale : ").append(codeDepartement);
        sb.append(" ").append(nomDepartement);
        sb.append("\n");
        return sb.toString();
    }
}
