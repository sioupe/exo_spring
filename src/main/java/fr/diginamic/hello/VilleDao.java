package fr.diginamic.hello;

import fr.diginamic.hello.entite.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VilleDao {
    @PersistenceContext
    private EntityManager em;

    /**
     * methode d'extraction de données de la bdd ville
     * @return
     */
    public List<Ville> extractAll(){
        return em.createQuery("select v from ville v", Ville.class).getResultList();
    }

    /**
     * methode d'extraction de données par id de la bdd ville
     * @param id
     * @return
     */
    public Ville findById(int id){
        return em.find(Ville.class, id);
    }
    /**
     * methode d'extraction de données par nom   de la bdd ville
     * @param nom
     * @return
     */
    public Ville findByNom(String nom){
        return em.createQuery("FROM ville WHERE nom= ville.nom",Ville.class).getSingleResult();
    }

    /**
     * methode de rajout d'une ville dans la bdd ville
     * @param ville
     */
    @Transactional
    public void insertVille(Ville ville){
        em.persist(ville);
    }

    /**
     * met a jour les données d'une ville dans la bdd ville
     * @param ancienneVille
     * @param nouvelleVille
     */
    @Transactional
    public void update(Ville ancienneVille, Ville nouvelleVille){
        delete(ancienneVille);
        ancienneVille.switchDonne(nouvelleVille);
        insertVille(ancienneVille);
    }

    /**
     * methode de suppression d'une ville dans la bdd ville
     * @param ville
     */
    @Transactional
    public void delete(Ville ville){
        em.remove(ville);
    }
}
