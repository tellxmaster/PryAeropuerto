
package models;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_piloto")
public class Piloto {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private int experiencia;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "piloto")
    private List<Vuelo> vuelo;

    public Piloto() {
    }

    public Piloto(String nombre, String apellido, int experiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.experiencia = experiencia;
        this.vuelo = new ArrayList<Vuelo>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List<Vuelo> getVuelo() {
        return vuelo;
    }

    public void setVuelo(List<Vuelo> vuelo) {
        this.vuelo = vuelo;
    }

    @Override
    public String toString() {
        return "Piloto{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", experiencia=" + experiencia + ", vuelo=" + vuelo + '}';
    }
    
    
}
