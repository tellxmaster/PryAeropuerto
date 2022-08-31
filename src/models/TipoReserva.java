
package models;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_tipo_reserva")
public class TipoReserva {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreTipo;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "tipo_reserva")
    private List<Reserva> reserva;

    public TipoReserva() {
    }

    public TipoReserva(String nombreTipo) {
        this.nombreTipo = nombreTipo;
        this.reserva = new ArrayList<Reserva>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "TipoReserva{" + "id=" + id + ", nombreTipo=" + nombreTipo + ", reserva=" + reserva + '}';
    }

    
    
}
