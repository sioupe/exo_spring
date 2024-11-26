package fr.diginamic.hello.Dao;

import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementDao {
    @PersistenceContext
    private EntityManager em;

    public List<Departement> findAll() {
        return em.createQuery("from departement", Departement.class).getResultList();
    }

    public Departement findById(int id) {
        return em.find(Departement.class, id);
    }

    public Departement findByNom(String nom) {
        return em.createQuery("FROM departement WHERE nom= departement.nom", Departement.class).getSingleResult();

    }
    public void insert(Departement departement) {
        em.persist(departement);
    }

    public void update(Departement ancienDepartement ,Departement nouveauDepartement) {
        delete(ancienDepartement);
        ancienDepartement.switchDonne(nouveauDepartement);
        insert(ancienDepartement);
    }

    public void delete(Departement departement) {
        em.remove(departement);
    }
}
