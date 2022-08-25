
package models;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "t_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombreUsuario;
    private String password;
    private String tipo_usr;

    @OneToOne
    @JoinColumn(name="PASAJERO_ID")
    private Pasajero pasajero;

    public Usuario(String nombreUsuario, String password, String tipo_usr) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipo_usr = tipo_usr;
    }
    
    public Usuario() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getTipo_usr() {
        return tipo_usr;
    }

    public void setTipo_usr(String tipo_usr) {
        this.tipo_usr = tipo_usr;
    }

    
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", pasajero=" + pasajero + '}';
    }
    
    
}
