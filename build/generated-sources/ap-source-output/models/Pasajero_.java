package models;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Reserva;
import models.Usuario;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pasajero.class)
public class Pasajero_ { 

    public static volatile SingularAttribute<Pasajero, String> apellido;
    public static volatile SingularAttribute<Pasajero, String> direccion;
    public static volatile SingularAttribute<Pasajero, Date> fecha_nacimiento;
    public static volatile SingularAttribute<Pasajero, Usuario> usuario;
    public static volatile SingularAttribute<Pasajero, Integer> id;
    public static volatile SingularAttribute<Pasajero, String> telefono;
    public static volatile ListAttribute<Pasajero, Reserva> reserva;
    public static volatile SingularAttribute<Pasajero, String> nombre;
    public static volatile SingularAttribute<Pasajero, String> email;

}