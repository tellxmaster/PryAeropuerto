
package services;

import controllers.UsuarioController;
import java.util.List;
import models.Usuario;



public class UsuarioService {
    
    private static final UsuarioController uc = new UsuarioController();
    
    public void registrar(Usuario usuario){
        uc.registrar(usuario);
    }

    public List<Usuario> listar(){
        return uc.listar();
    }

    public Usuario recuperarUsuarioById(int id){
        return uc.recuperarUsuarioById(id);
    }
    
    public Usuario recuperarUsuarioByUsername(String nombreUsuario){
        return uc.recuperarUsuarioByUsername(nombreUsuario);
    }
    
    public boolean login(String nombreUsuario, String password){
        return uc.login(nombreUsuario, password);
    }
    
    public boolean comprobarUsuario(String nombreUsuario){
        return uc.comprobarUsuario(nombreUsuario);
    }

    public void eliminar(){
        uc.eliminar();
    }
    
    public void imprimir(List<Usuario> usuarios){
        uc.imprimir(usuarios);
    }
}
