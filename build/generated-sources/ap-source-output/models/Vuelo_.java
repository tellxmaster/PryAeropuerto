package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Aeropuerto;
import models.Avion;
import models.Piloto;
import models.Reserva;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, Aeropuerto> aeropuerto;
    public static volatile SingularAttribute<Vuelo, Integer> id;
    public static volatile ListAttribute<Vuelo, Reserva> reserva;
    public static volatile SingularAttribute<Vuelo, Avion> avion;
    public static volatile SingularAttribute<Vuelo, Piloto> piloto;

}