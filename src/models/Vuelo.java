package models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_vuelo")
public class Vuelo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "vuelo")
    private List<Reserva> reserva;

    @ManyToOne
    private Aeropuerto aeropuerto;

    @ManyToOne
    private Avion avion;

    @ManyToOne
    private Piloto piloto;
    
    public Vuelo() {
    }

    public Vuelo(List<Reserva> reserva, Aeropuerto aeropuerto, Avion avion) {
        this.reserva = reserva;
        this.aeropuerto = aeropuerto;
        this.avion = avion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "id=" + id + ", reserva=" + reserva + ", aeropuerto=" + aeropuerto + ", avion=" + avion + '}';
    }
    
    
    
}

