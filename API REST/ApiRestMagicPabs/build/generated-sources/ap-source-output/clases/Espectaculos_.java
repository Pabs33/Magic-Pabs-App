package clases;

import clases.Eventos;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-08-25T20:06:51", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Espectaculos.class)
public class Espectaculos_ { 

    public static volatile SingularAttribute<Espectaculos, String> descripcion;
    public static volatile SingularAttribute<Espectaculos, String> titulo;
    public static volatile SingularAttribute<Espectaculos, Integer> duracion;
    public static volatile SingularAttribute<Espectaculos, Integer> idEspectaculo;
    public static volatile CollectionAttribute<Espectaculos, Eventos> eventosCollection;

}