package fr.diginamic.hello.Repository;

import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VilleRespository extends JpaRepository<Ville, Integer> {


    Ville findByNom(String nom);

    List<Ville> findByNbHabitantsIsGreaterThan(int min);

    List<Ville> findByNbHabitantsBetween(int min, int max);

    List<Ville> findByDepartementAndNbHabitantsIsGreaterThan(Departement departement, int nbHabitants);

    List<Ville> findByDepartementAndNbHabitantsBetween(Departement departement, int min, int max);

    List<Ville> findByDepartementOrderByNbHabitantsDesc(Departement departement, Pageable pageable);
}