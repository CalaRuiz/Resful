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
@Table(name = "CLASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByNumeroClase", query = "SELECT c FROM Clase c WHERE c.numeroClase = :numeroClase"),
    @NamedQuery(name = "Clase.findByNombreClase", query = "SELECT c FROM Clase c WHERE c.nombreClase = :nombreClase")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO_CLASE")
    private Integer numeroClase;
    @Column(name = "NOMBRE_CLASE")
    private String nombreClase;
    @OneToMany(mappedBy = "clase")
    private Collection<Estudiante> estudianteCollection;

    public Clase() {
    }

    public Clase(Integer numeroClase) {
        this.numeroClase = numeroClase;
    }

    public Integer getNumeroClase() {
        return numeroClase;
    }

    public void setNumeroClase(Integer numeroClase) {
        this.numeroClase = numeroClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
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
        hash += (numeroClase != null ? numeroClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.numeroClase == null && other.numeroClase != null) || (this.numeroClase != null && !this.numeroClase.equals(other.numeroClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "restful.Clase[ numeroClase=" + numeroClase + " ]";
    }
    
}
