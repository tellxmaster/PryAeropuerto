
package models;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String modelo;
    private int numAsientos;
    private int numAsiDisponibles;
    private String Fabricante;

    @ManyToOne
    private Aeropuerto aeropuerto;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "avion")
    private List<Vuelo> vuelos;

    public Avion() {
    }

    public Avion(String modelo, int numAsientos, String Fabricante, Aeropuerto aeropuerto, int numAsiDisponibles) {
        this.modelo = modelo;
        this.numAsientos = numAsientos;
        this.Fabricante = Fabricante;
        this.aeropuerto = aeropuerto;
        this.numAsiDisponibles = numAsiDisponibles;
        this.vuelos = new ArrayList<Vuelo>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public int getNumAsiDisponibles() {
        return numAsiDisponibles;
    }

    public void setNumAsiDisponibles(int numAsiDisponibles) {
        this.numAsiDisponibles = numAsiDisponibles;
    }
    
    

    @Override
    public String toString() {
        return "Avion{" + "id=" + id + ", modelo=" + modelo + ", numAsientos=" + numAsientos + ", Fabricante=" + Fabricante + ", aeropuerto=" + aeropuerto;
    }
    
    
}
