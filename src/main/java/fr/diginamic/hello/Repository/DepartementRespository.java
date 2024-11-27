package fr.diginamic.hello.Repository;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementRespository extends JpaRepository<Departement, Integer> {
    public Departement findByNom(String nom);
    public List<Departement> findDepartementsByNomContaining(String nom);
    public List<Ville> findVillesByCodePostalEquals(String codePostal);
}
