
package services;

import controllers.PilotoController;
import java.util.List;
import models.Piloto;


public class PilotoService {
 
    private static final PilotoController pc = new PilotoController();
    
    public void guardar(Piloto piloto){
        pc.registrar(piloto);
    }

    public List<Piloto> listar(){
        return pc.listar();
    }

    public Piloto recuperarPilotoById(int id){
        return pc.recuperarPilotoById(id);
    }
    
    public Piloto recuperarPilotoByNombre(String nombrePiloto){
        return pc.recuperarPilotoByNombre(nombrePiloto);
    }

    public void imprimir(List<Piloto> pilotos){
        pc.imprimir(pilotos);
    }

    public void eliminar(){
        pc.eliminar();
    }
}
