package fr.diginamic.hello.Repository;
import fr.diginamic.hello.entite.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRespository extends JpaRepository<Departement, Integer> {
}
