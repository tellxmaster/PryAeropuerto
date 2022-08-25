
package controllers;

import models.*;
import java.util.List;
import javax.persistence.*;

public class ReservaController {
    public void registrar( Reserva reserva )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYReservaPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(reserva);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<Reserva> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYReservaPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Reserva> query = cl.createQuery("SELECT u FROM Reserva u ", Reserva.class);
        List<Reserva> results = query.getResultList();
        return results;
    }

    public Reserva recuperarReservaById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYReservaPU");
        EntityManager cl = clf.createEntityManager();
        Reserva Reserva = cl.createQuery("Select u from Reserva u WHERE u.id = :id", Reserva.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return Reserva;
    }

    public Reserva recuperarReservaByNombre(String nombreReserva){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYReservaPU");
        EntityManager cl = clf.createEntityManager();
        Reserva Reserva = cl.createQuery("Select u from Reserva u WHERE u.nombreReserva = :nombreReserva", Reserva.class).setParameter("nombreReserva", nombreReserva).getSingleResult();
        cl.close();
        clf.close();
        return Reserva;
    }

    public void imprimir(List<Reserva> Reservas){
        for(Reserva Reserva : Reservas){
            System.out.println(Reserva.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYReservaPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Reserva").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
