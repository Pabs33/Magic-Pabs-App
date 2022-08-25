/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "espectaculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Espectaculos.findAll", query = "SELECT e FROM Espectaculos e"),
    @NamedQuery(name = "Espectaculos.findByIdEspectaculo", query = "SELECT e FROM Espectaculos e WHERE e.idEspectaculo = :idEspectaculo"),
    @NamedQuery(name = "Espectaculos.findByTitulo", query = "SELECT e FROM Espectaculos e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Espectaculos.findByDescripcion", query = "SELECT e FROM Espectaculos e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Espectaculos.findByDuracion", query = "SELECT e FROM Espectaculos e WHERE e.duracion = :duracion")})
public class Espectaculos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_espectaculo")
    private Integer idEspectaculo;
    @Size(max = 255)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "duracion")
    private Integer duracion;
    @OneToMany(mappedBy = "idEspectaculoEventos")
    @JsonbTransient
    private Collection<Eventos> eventosCollection;

    public Espectaculos() {
    }

    public Espectaculos(Integer idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }

    public Integer getIdEspectaculo() {
        return idEspectaculo;
    }

    public void setIdEspectaculo(Integer idEspectaculo) {
        this.idEspectaculo = idEspectaculo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @XmlTransient
    public Collection<Eventos> getEventosCollection() {
        return eventosCollection;
    }

    public void setEventosCollection(Collection<Eventos> eventosCollection) {
        this.eventosCollection = eventosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspectaculo != null ? idEspectaculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Espectaculos)) {
            return false;
        }
        Espectaculos other = (Espectaculos) object;
        if ((this.idEspectaculo == null && other.idEspectaculo != null) || (this.idEspectaculo != null && !this.idEspectaculo.equals(other.idEspectaculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Espectaculos[ idEspectaculo=" + idEspectaculo + " ]";
    }
    
}
