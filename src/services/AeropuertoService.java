/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import controllers.*;
import java.util.List;
import models.Aeropuerto;

/**
 *
 * @author tellxmaster
 */
public class AeropuertoService {
    
    private static final AeropuertoController ac = new AeropuertoController();
    
    public void guardar(Aeropuerto aereopuerto){
        ac.guardar(aereopuerto);
    }

    public List<Aeropuerto> listar(){
        return ac.listar();
    }

    public Aeropuerto recuperarAropuertoById(int id){
        return ac.recuperarAropuertoById(id);
    }
    
    public Aeropuerto recuperarAeropuetoByNombre(String nombreaeropuerto){
        return ac.recuperarAeropuertoByNombre(nombreaeropuerto);
    }
    
    public List<Aeropuerto> recuperarAeropuertosByCiudad(String ciudad){
        return ac.recuperarAeropuertosByCiudad(ciudad);
    }
    

    public void imprimir(List<Aeropuerto> aeropuertos){
        ac.imprimir(aeropuertos);
    }

    public void eliminar(){
        ac.eliminar();
    }
}
