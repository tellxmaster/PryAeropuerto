
package services;

import controllers.PasajeroController;
import java.util.List;
import models.Pasajero;
import models.Usuario;

public class PasajeroService {
        
    
    private static final PasajeroController pc = new PasajeroController();
    
    
    public void guardar(Pasajero pasajero){
        pc.guardar(pasajero);
    }

    public List<Pasajero> listar(){
        return listar();
    }

    public Pasajero recuperarPasajeroById(int id){
        return pc.recuperarPasajeroById(id);
    }


    public void eliminar(){
        pc.eliminar();
    }
    
    public void imprimir(List<Pasajero> pasajeros){
        pc.imprimir(pasajeros);
    }
}
