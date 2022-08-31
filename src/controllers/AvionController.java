package controllers;

import models.*;
import java.util.List;
import javax.persistence.*;

public class AvionController {
    public void registrar( Avion avion )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(avion);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<Avion> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Avion> query = cl.createQuery("SELECT u FROM Avion u ", Avion.class);
        List<Avion> results = query.getResultList();
        return results;
    }

    public Avion recuperarAvionById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Avion avion = cl.createQuery("Select a from Avion a WHERE a.id = :id", Avion.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return avion;
    }

    public Avion recuperarAvionByNombre(String nombreAvion){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Avion Avion = cl.createQuery("Select u from Avion u WHERE u.nombreAvion = :nombreAvion", Avion.class).setParameter("nombreAvion", nombreAvion).getSingleResult();
        cl.close();
        clf.close();
        return Avion;
    }
    
    public void updateAsientosDisponibles(int numAsientos, int comprados, Avion avion){
        int disponibles = numAsientos - comprados;
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.find(Avion.class, avion.getId());
        avion.setNumAsiDisponibles(disponibles);
        cl.merge(avion);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }
    
    public int getNumAsientos(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Avion avion = cl.createQuery("Select a from Avion a WHERE a.id = :id", Avion.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        int numAsientos = avion.getNumAsientos();
        return numAsientos;
    }

    public void imprimir(List<Avion> Avions){
        for(Avion Avion : Avions){
            System.out.println(Avion.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Avion").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
