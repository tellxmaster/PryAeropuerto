package models;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Pasajero;
import models.TipoReserva;
import models.Vuelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, TipoReserva> tipo_reserva;
    public static volatile SingularAttribute<Reserva, LocalDateTime> fecha;
    public static volatile SingularAttribute<Reserva, Pasajero> pasajero;
    public static volatile SingularAttribute<Reserva, String> numAsiento;
    public static volatile SingularAttribute<Reserva, Integer> id;
    public static volatile SingularAttribute<Reserva, Vuelo> vuelo;

}