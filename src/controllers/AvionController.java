package controllers;

import models.*;
import java.util.List;
import javax.persistence.*;

public class AvionController {
    public void registrar( Avion avion )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAvionPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(avion);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<Avion> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAvionPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Avion> query = cl.createQuery("SELECT u FROM Avion u ", Avion.class);
        List<Avion> results = query.getResultList();
        return results;
    }

    public Avion recuperarAvionById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAvionPU");
        EntityManager cl = clf.createEntityManager();
        Avion Avion = cl.createQuery("Select u from Avion u WHERE u.id = :id", Avion.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return Avion;
    }

    public Avion recuperarAvionByNombre(String nombreAvion){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAvionPU");
        EntityManager cl = clf.createEntityManager();
        Avion Avion = cl.createQuery("Select u from Avion u WHERE u.nombreAvion = :nombreAvion", Avion.class).setParameter("nombreAvion", nombreAvion).getSingleResult();
        cl.close();
        clf.close();
        return Avion;
    }

    public void imprimir(List<Avion> Avions){
        for(Avion Avion : Avions){
            System.out.println(Avion.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAvionPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Avion").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
