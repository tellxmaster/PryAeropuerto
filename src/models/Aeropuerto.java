package models;

import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_aeropuerto")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreAeropuerto;
    private String ciudad;
    private String provincia;
    private String pais;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, mappedBy = "aeropuerto")
    private List<Vuelo> vuelos;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, mappedBy = "aeropuerto")
    private List<Avion> aviones;

    public Aeropuerto() {
    }

    public Aeropuerto(String nombreAeropuerto, String ciudad, String provincia, String pais) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.vuelos = new ArrayList<Vuelo>();
        this.aviones = new ArrayList<Avion>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(List<Avion> aviones) {
        this.aviones = aviones;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" + "id=" + id + ", nombreAeropuerto=" + nombreAeropuerto + ", ciudad=" + ciudad + ", provincia=" + provincia + ", pais=" + pais + ", vuelos=" + vuelos + ", aviones=" + aviones + '}';
    }
    
    
}
