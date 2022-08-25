
package models;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    private Date fecha_nacimiento;

    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL, mappedBy = "pasajero")
    private List<Reserva> reserva;

    @OneToOne(cascade = CascadeType.ALL,mappedBy="pasajero")
    private Usuario usuario;

    public Pasajero() {
    }

    public Pasajero(String nombre, String apellido, String direccion, String telefono, String email, Date fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.reserva = new ArrayList<Reserva>();
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    @Override
    public String toString() {
        return "Pasajero{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", fecha_nacimiento=" + fecha_nacimiento + ", reserva=" + reserva + ", usuario=" + usuario +'}';
    }
    
    

}
