/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pablo
 */
@Entity
@Table(name = "eventos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eventos.findAll", query = "SELECT e FROM Eventos e"),
    @NamedQuery(name = "Eventos.findByIdEvento", query = "SELECT e FROM Eventos e WHERE e.idEvento = :idEvento"),
    @NamedQuery(name = "Eventos.findByFecha", query = "SELECT e FROM Eventos e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Eventos.findByDireccion", query = "SELECT e FROM Eventos e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Eventos.findByTipoEvento", query = "SELECT e FROM Eventos e WHERE e.tipoEvento = :tipoEvento")})
public class Eventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_evento")
    private Integer idEvento;
    @Size(max = 255)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 255)
    @Column(name = "tipo_evento")
    private String tipoEvento;
    @JoinColumn(name = "id_cliente_eventos", referencedColumnName = "id_cliente")
    @ManyToOne
    private Clientes idClienteEventos;
    @JoinColumn(name = "id_espectaculo_eventos", referencedColumnName = "id_espectaculo")
    @ManyToOne
    private Espectaculos idEspectaculoEventos;

    public Eventos() {
    }

    public Eventos(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Clientes getIdClienteEventos() {
        return idClienteEventos;
    }

    public void setIdClienteEventos(Clientes idClienteEventos) {
        this.idClienteEventos = idClienteEventos;
    }

    public Espectaculos getIdEspectaculoEventos() {
        return idEspectaculoEventos;
    }

    public void setIdEspectaculoEventos(Espectaculos idEspectaculoEventos) {
        this.idEspectaculoEventos = idEspectaculoEventos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvento != null ? idEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eventos)) {
            return false;
        }
        Eventos other = (Eventos) object;
        if ((this.idEvento == null && other.idEvento != null) || (this.idEvento != null && !this.idEvento.equals(other.idEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "clases.Eventos[ idEvento=" + idEvento + " ]";
    }
    
}
