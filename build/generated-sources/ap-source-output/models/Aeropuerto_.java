package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Avion;
import models.Vuelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Aeropuerto.class)
public class Aeropuerto_ { 

    public static volatile ListAttribute<Aeropuerto, Avion> aviones;
    public static volatile SingularAttribute<Aeropuerto, String> ciudad;
    public static volatile ListAttribute<Aeropuerto, Vuelo> vuelos;
    public static volatile SingularAttribute<Aeropuerto, Integer> id;
    public static volatile SingularAttribute<Aeropuerto, String> nombreAeropuerto;
    public static volatile SingularAttribute<Aeropuerto, String> provincia;
    public static volatile SingularAttribute<Aeropuerto, String> pais;

}