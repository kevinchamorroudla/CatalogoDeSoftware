/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labmacq
 */
@Entity
@Table(name = "tipoplataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoplataforma.findAll", query = "SELECT t FROM Tipoplataforma t"),
    @NamedQuery(name = "Tipoplataforma.findByIdTipoPlataforma", query = "SELECT t FROM Tipoplataforma t WHERE t.idTipoPlataforma = :idTipoPlataforma"),
    @NamedQuery(name = "Tipoplataforma.findByNombre", query = "SELECT t FROM Tipoplataforma t WHERE t.nombre = :nombre")})
public class Tipoplataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_TipoPlataforma")
    private Integer idTipoPlataforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPlataforma")
    private Collection<Plataforma> plataformaCollection;

    public Tipoplataforma() {
    }

    public Tipoplataforma(Integer idTipoPlataforma) {
        this.idTipoPlataforma = idTipoPlataforma;
    }

    public Tipoplataforma(Integer idTipoPlataforma, String nombre) {
        this.idTipoPlataforma = idTipoPlataforma;
        this.nombre = nombre;
    }

    public Integer getIdTipoPlataforma() {
        return idTipoPlataforma;
    }

    public void setIdTipoPlataforma(Integer idTipoPlataforma) {
        this.idTipoPlataforma = idTipoPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Plataforma> getPlataformaCollection() {
        return plataformaCollection;
    }

    public void setPlataformaCollection(Collection<Plataforma> plataformaCollection) {
        this.plataformaCollection = plataformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPlataforma != null ? idTipoPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoplataforma)) {
            return false;
        }
        Tipoplataforma other = (Tipoplataforma) object;
        if ((this.idTipoPlataforma == null && other.idTipoPlataforma != null) || (this.idTipoPlataforma != null && !this.idTipoPlataforma.equals(other.idTipoPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Tipoplataforma[ idTipoPlataforma=" + idTipoPlataforma + " ]";
    }
    
}
