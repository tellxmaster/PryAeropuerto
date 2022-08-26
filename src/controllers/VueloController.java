
package controllers;


import models.*;
import java.util.List;
import javax.persistence.*;

public class VueloController {
    public void registrar( Vuelo vuelo )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(vuelo);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<Vuelo> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Vuelo> query = cl.createQuery("SELECT u FROM Vuelo u ", Vuelo.class);
        List<Vuelo> results = query.getResultList();
        return results;
    }

    public Vuelo recuperarVueloById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Vuelo Vuelo = cl.createQuery("Select u from Vuelo u WHERE u.id = :id", Vuelo.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return Vuelo;
    }

    public Vuelo recuperarVueloByNombre(String nombreVuelo){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Vuelo Vuelo = cl.createQuery("Select u from Vuelo u WHERE u.nombreVuelo = :nombreVuelo", Vuelo.class).setParameter("nombreVuelo", nombreVuelo).getSingleResult();
        cl.close();
        clf.close();
        return Vuelo;
    }
    
    public List<Vuelo> recuperarDestinosByOrigen(String ciudad){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Vuelo> query = cl.createQuery("Select a from Vuelo a WHERE a.ciudadOrigen = :ciudad", Vuelo.class).setParameter("ciudad", ciudad);
        List<Vuelo> results = query.getResultList();
        cl.close();
        clf.close();
        return results;
    }

    public void imprimir(List<Vuelo> Vuelos){
        for(Vuelo Vuelo : Vuelos){
            System.out.println(Vuelo.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Vuelo").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public List<Vuelo> recuperarDestinosByOrigenAndDestino(String origen, String destino) {
        
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Vuelo> query = cl.createQuery("Select a from Vuelo a WHERE a.ciudadOrigen = :origen AND a.ciudadDestino = :destino", Vuelo.class).setParameter("origen", origen).setParameter("destino", destino);
        List<Vuelo> results = query.getResultList();
        cl.close();
        clf.close();
        return results;
       
    }
}
