package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Aeropuerto;
import models.Vuelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Avion.class)
public class Avion_ { 

    public static volatile SingularAttribute<Avion, Aeropuerto> aeropuerto;
    public static volatile ListAttribute<Avion, Vuelo> vuelos;
    public static volatile SingularAttribute<Avion, String> Fabricante;
    public static volatile SingularAttribute<Avion, Integer> id;
    public static volatile SingularAttribute<Avion, String> modelo;
    public static volatile SingularAttribute<Avion, Integer> numAsientos;

}