
package controllers;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.Pasajero;
import models.Usuario;


public class UsuarioController {
    
    public void registrar( Usuario usuario )
    {   
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        cl.getTransaction().begin();
        cl.persist(usuario);
        cl.getTransaction().commit();
        cl.close();
        clf.close();
    }
    
    
    public List<Usuario> listar(){
        EntityManagerFactory clf = Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        TypedQuery<Usuario> query = cl.createQuery("SELECT u FROM Usuario u ", Usuario.class);
        List<Usuario> results = query.getResultList();
        return results;
    }

    public Usuario recuperarUsuarioById(int id){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Usuario usuario = cl.createQuery("Select u from Usuario u WHERE u.id = :id", Usuario.class).setParameter("id", id).getSingleResult();
        cl.close();
        clf.close();
        return usuario;
    }

    public Usuario recuperarUsuarioByUsername(String nombreUsuario){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Usuario usuario = cl.createQuery("Select u from Usuario u WHERE u.nombreUsuario = :nombreUsuario", Usuario.class).setParameter("nombreUsuario", nombreUsuario).getSingleResult();
        cl.close();
        clf.close();
        return usuario;
    }
    
  
    public boolean login(String nombreUsuario, String password){
        EntityManagerFactory clf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager cl = clf.createEntityManager();
        Usuario usuario = cl.createQuery("Select u from Usuario u WHERE u.nombreUsuario = :nombreUsuario", Usuario.class).setParameter("nombreUsuario", nombreUsuario).getSingleResult();
        cl.close();
        clf.close(); 
        return (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(password) ? true:false);
    }

  
    
    public void imprimir(List<Usuario> usuarios){
        for(Usuario usuario : usuarios){
            System.out.println(usuario.toString());
        }
    }

    public void eliminar(){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("PRYAeropuertoPU");
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("Delete from Usuario").executeUpdate();
        System.out.println("Registros Eliminados");
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
