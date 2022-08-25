
package controllers;

import models.*;
import javax.persistence.*;
import java.util.List;

public class PilotoController {
    public void registrar( Piloto Piloto )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(Piloto);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<Piloto> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Piloto> query = cl.createQuery("SELECT u FROM Piloto u ", Piloto.class);
        List<Piloto> results = query.getResultList();
        return results;
    }

    public Piloto recuperarPilotoById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Piloto Piloto = cl.createQuery("Select u from Piloto u WHERE u.id = :id", Piloto.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return Piloto;
    }

    public Piloto recuperarPilotoByNombre(String nombrePiloto){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Piloto Piloto = cl.createQuery("Select u from Piloto u WHERE u.nombrePiloto = :nombrePiloto", Piloto.class).setParameter("nombrePiloto", nombrePiloto).getSingleResult();
        cl.close();
        clf.close();
        return Piloto;
    }

    public void imprimir(List<Piloto> Pilotos){
        for(Piloto Piloto : Pilotos){
            System.out.println(Piloto.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Piloto").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
