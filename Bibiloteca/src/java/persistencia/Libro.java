/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jhon
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByIdlibro", query = "SELECT l FROM Libro l WHERE l.idlibro = :idlibro"),
    @NamedQuery(name = "Libro.findByNombrelibro", query = "SELECT l FROM Libro l WHERE l.nombrelibro = :nombrelibro"),
    @NamedQuery(name = "Libro.findByFechaedicion", query = "SELECT l FROM Libro l WHERE l.fechaedicion = :fechaedicion")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idlibro")
    private Integer idlibro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombrelibro")
    private String nombrelibro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaedicion")
    @Temporal(TemporalType.DATE)
    private Date fechaedicion;
    @JoinColumn(name = "idautor", referencedColumnName = "idautor")
    @ManyToOne(optional = false)
    private Autor idautor;

    public Libro() {
    }

    public Libro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public Libro(Integer idlibro, String nombrelibro, Date fechaedicion) {
        this.idlibro = idlibro;
        this.nombrelibro = nombrelibro;
        this.fechaedicion = fechaedicion;
    }

    public Integer getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(Integer idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public Date getFechaedicion() {
        return fechaedicion;
    }

    public void setFechaedicion(Date fechaedicion) {
        this.fechaedicion = fechaedicion;
    }

    public Autor getIdautor() {
        return idautor;
    }

    public void setIdautor(Autor idautor) {
        this.idautor = idautor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlibro != null ? idlibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.idlibro == null && other.idlibro != null) || (this.idlibro != null && !this.idlibro.equals(other.idlibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistencia.Libro[ idlibro=" + idlibro + " ]";
    }
    
}
