
package services;

import controllers.VueloController;
import java.util.List;
import models.Vuelo;

public class VueloService {
        private static final VueloController vc = new VueloController();
    
    public void guardar(Vuelo vuelo){
        vc.registrar(vuelo);
    }

    public List<Vuelo> listar(){
        return vc.listar();
    }

    public Vuelo recuperarVueloById(int id){
        return vc.recuperarVueloById(id);
    }

    public void imprimir(List<Vuelo> vuelos){
        vc.imprimir(vuelos);
    }

    public void eliminar(){
        vc.eliminar();
    }
}
