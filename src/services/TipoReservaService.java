
package services;

import controllers.*;
import java.util.List;
import models.Reserva;
import models.TipoReserva;

public class TipoReservaService {
    
    private static final TipoReservaController rc = new TipoReservaController();
    
    public void guardar(TipoReserva tipo){
        rc.registrar(tipo);
    }

    public List<TipoReserva> listar(){
        return rc.listar();
    }

    public TipoReserva recuperarTipoReservaById(int id){
        return rc.recuperarTipoReservaById(id);
    }

    public void imprimir(List<TipoReserva> reservas){
        rc.imprimir(reservas);
    }

    public void eliminar(){
        rc.eliminar();
    }
}
