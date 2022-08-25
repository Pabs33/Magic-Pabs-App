package clases;

import clases.Eventos;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T20:06:51", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, Integer> idCliente;
    public static volatile CollectionAttribute<Clientes, Eventos> eventosCollection;
    public static volatile SingularAttribute<Clientes, String> telefono;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile SingularAttribute<Clientes, String> email;

}