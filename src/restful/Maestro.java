/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "MAESTRO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maestro.findAll", query = "SELECT m FROM Maestro m"),
    @NamedQuery(name = "Maestro.findByNumeroMaestro", query = "SELECT m FROM Maestro m WHERE m.numeroMaestro = :numeroMaestro"),
    @NamedQuery(name = "Maestro.findByNombreMaestro", query = "SELECT m FROM Maestro m WHERE m.nombreMaestro = :nombreMaestro")})
public class Maestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_MAESTRO")
    private Integer numeroMaestro;
    @Column(name = "NOMBRE_MAESTRO")
    private String nombreMaestro;
    @OneToMany(mappedBy = "profesor")
    private Collection<Estudiante> estudianteCollection;

    public Maestro() {
    }

    public Maestro(Integer numeroMaestro) {
        this.numeroMaestro = numeroMaestro;
    }

    public Integer getNumeroMaestro() {
        return numeroMaestro;
    }

    public void setNumeroMaestro(Integer numeroMaestro) {
        this.numeroMaestro = numeroMaestro;
    }

    public String getNombreMaestro() {
        return nombreMaestro;
    }

    public void setNombreMaestro(String nombreMaestro) {
        this.nombreMaestro = nombreMaestro;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMaestro != null ? numeroMaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maestro)) {
            return false;
        }
        Maestro other = (Maestro) object;
        if ((this.numeroMaestro == null && other.numeroMaestro != null) || (this.numeroMaestro != null && !this.numeroMaestro.equals(other.numeroMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restful.Maestro[ numeroMaestro=" + numeroMaestro + " ]";
    }
    
}
