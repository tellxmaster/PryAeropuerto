package models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Reserva;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T18:39:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(TipoReserva.class)
public class TipoReserva_ { 

    public static volatile SingularAttribute<TipoReserva, String> nombreTipo;
    public static volatile SingularAttribute<TipoReserva, Integer> id;
    public static volatile ListAttribute<TipoReserva, Reserva> reserva;

}