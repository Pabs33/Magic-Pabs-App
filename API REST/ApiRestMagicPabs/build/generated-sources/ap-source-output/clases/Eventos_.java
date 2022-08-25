package clases;

import clases.Clientes;
import clases.Espectaculos;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T20:06:51", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Eventos.class)
public class Eventos_ { 

    public static volatile SingularAttribute<Eventos, String> fecha;
    public static volatile SingularAttribute<Eventos, Espectaculos> idEspectaculoEventos;
    public static volatile SingularAttribute<Eventos, String> tipoEvento;
    public static volatile SingularAttribute<Eventos, Integer> idEvento;
    public static volatile SingularAttribute<Eventos, String> direccion;
    public static volatile SingularAttribute<Eventos, Clientes> idClienteEventos;

}