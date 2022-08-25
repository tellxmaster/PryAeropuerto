
package controllers;

import models.*;
import java.util.List;
import javax.persistence.*;

public class TipoReservaController {
    public void registrar( TipoReserva tipoReserva )
    {
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYTipoReservaPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(tipoReserva);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }


    public List<TipoReserva> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYTipoReservaPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<TipoReserva> query = cl.createQuery("SELECT u FROM TipoReserva u ", TipoReserva.class);
        List<TipoReserva> results = query.getResultList();
        return results;
    }

    public TipoReserva recuperarTipoReservaById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYTipoReservaPU");
        EntityManager cl = clf.createEntityManager();
        TipoReserva TipoReserva = cl.createQuery("Select u from TipoReserva u WHERE u.id = :id", TipoReserva.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return TipoReserva;
    }

    public TipoReserva recuperarTipoReservaByNombre(String nombreTipoReserva){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYTipoReservaPU");
        EntityManager cl = clf.createEntityManager();
        TipoReserva TipoReserva = cl.createQuery("Select u from TipoReserva u WHERE u.nombreTipoReserva = :nombreTipoReserva", TipoReserva.class).setParameter("nombreTipoReserva", nombreTipoReserva).getSingleResult();
        cl.close();
        clf.close();
        return TipoReserva;
    }

    public void imprimir(List<TipoReserva> TipoReservas){
        for(TipoReserva TipoReserva : TipoReservas){
            System.out.println(TipoReserva.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYTipoReservaPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from TipoReserva").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
