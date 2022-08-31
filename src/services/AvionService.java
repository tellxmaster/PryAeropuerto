
package services;

import controllers.AeropuertoController;
import controllers.AvionController;
import java.util.List;
import models.Aeropuerto;
import models.Avion;


public class AvionService {
    private static final AvionController ac = new AvionController();
    
    public void guardar(Avion avion){
        ac.registrar(avion);
    }

    public List<Avion> listar(){
        return ac.listar();
    }

    public Avion recuperarAvionById(int id){
        return ac.recuperarAvionById(id);
    }

    public void imprimir(List<Avion> aviones){
        ac.imprimir(aviones);
    }

    public void eliminar(){
        ac.eliminar();
    }
    
    public void updateAsientosDisponibles(int numAsientos, int comprados, Avion avion){
        ac.updateAsientosDisponibles(numAsientos,comprados, avion);
    }
    
    public int getNumAsientos(int id){
        return ac.getNumAsientos(id);
    }
}
