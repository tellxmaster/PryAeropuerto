/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import controllers.AeropuertoController;
import controllers.AvionController;
import java.util.List;
import models.Aeropuerto;
import models.Avion;

/**
 *
 * @author tellxmaster
 */
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
}
