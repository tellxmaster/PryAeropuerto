
package controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import models.Pasajero;
import models.Usuario;


public class PasajeroController {
    public void guardar(Pasajero pasajero){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(pasajero);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }

    public List<Pasajero> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Pasajero> query = cl.createQuery("SELECT p FROM Pasajero p ", Pasajero.class);
        List<Pasajero> results = query.getResultList();
        return results;
    }

    public Pasajero recuperarPasajeroById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Pasajero pasajero = cl.createQuery("Select p from Pasajero p WHERE p.id = :id", Pasajero.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return pasajero;
    }

  
    
    public void imprimir(List<Pasajero> pasajeros){
        for(Pasajero pasajero : pasajeros){
            System.out.println(pasajero.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Pasajero").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
