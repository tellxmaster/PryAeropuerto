package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Vuelo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:50", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Piloto.class)
public class Piloto_ { 

    public static volatile SingularAttribute<Piloto, String> apellido;
    public static volatile SingularAttribute<Piloto, Integer> experiencia;
    public static volatile SingularAttribute<Piloto, Integer> id;
    public static volatile ListAttribute<Piloto, Vuelo> vuelo;
    public static volatile SingularAttribute<Piloto, String> nombre;

}