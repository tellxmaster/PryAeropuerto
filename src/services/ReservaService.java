
package services;

import controllers.*;
import java.util.List;
import models.*;



public class ReservaService {
    
    private static final ReservaController rc = new ReservaController();
    
    public void guardar(Reserva reserva){
        rc.registrar(reserva);
    }

    public List<Reserva> listar(){
        return rc.listar();
    }

    public Reserva recuperarReservaById(int id){
        return rc.recuperarReservaById(id);
    }

    public void imprimir(List<Reserva> reservas){
        rc.imprimir(reservas);
    }

    public void eliminar(){
        rc.eliminar();
    }
}
