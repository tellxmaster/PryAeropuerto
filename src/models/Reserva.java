
package models;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_reserva")
public class Reserva {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    private String numAsiento;
    private LocalDateTime fecha;
    @ManyToOne
    private Pasajero pasajero;

    @ManyToOne
    private Vuelo vuelo;

    @ManyToOne
    private TipoReserva tipo_reserva;

    public Reserva() {
    }

    public Reserva(String numAsiento, LocalDateTime fecha, Pasajero pasajero, Vuelo vuelo, TipoReserva tipo_reserva) {
        this.numAsiento = numAsiento;
        this.fecha = fecha;
        this.pasajero = pasajero;
        this.vuelo = vuelo;
        this.tipo_reserva = tipo_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", numAsiento=" + numAsiento + ", fecha=" + fecha + ", pasajero=" + pasajero + ", vuelo=" + vuelo + ", tipo_reserva=" + tipo_reserva + '}';
    }
    
    
}
