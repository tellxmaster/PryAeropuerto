
package controllers;

import java.util.List;
import javax.persistence.*;
import models.Aeropuerto;

/**
 *
 * @author tellxmaster
 */
public class AeropuertoController {
    public void guardar(Aeropuerto aereopuerto){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(aereopuerto);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }

    public List<Aeropuerto> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Aeropuerto> query = cl.createQuery("SELECT p FROM Aeropuerto p ", Aeropuerto.class);
        List<Aeropuerto> results = query.getResultList();
        return results;
    }

    public Aeropuerto recuperarAropuertoById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Aeropuerto aeropuerto = cl.createQuery("Select p from Aeropuerto p WHERE p.id = :id", Aeropuerto.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return aeropuerto;
    }

  
    
    public void imprimir(List<Aeropuerto> aeropuertos){
        for(Aeropuerto aeropuerto : aeropuertos){
            System.out.println(aeropuerto.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Aeropuerto").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
