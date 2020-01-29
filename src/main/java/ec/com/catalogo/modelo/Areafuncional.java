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
@Table(name = "areafuncional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areafuncional.findAll", query = "SELECT a FROM Areafuncional a"),
    @NamedQuery(name = "Areafuncional.findByIdAreaFuncional", query = "SELECT a FROM Areafuncional a WHERE a.idAreaFuncional = :idAreaFuncional"),
    @NamedQuery(name = "Areafuncional.findByNombre", query = "SELECT a FROM Areafuncional a WHERE a.nombre = :nombre")})
public class Areafuncional implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_AreaFuncional")
    private Integer idAreaFuncional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaFuncional")
    private Collection<Software> softwareCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAreaFuncional")
    private Collection<Funcionario> funcionarioCollection;

    public Areafuncional() {
    }

    public Areafuncional(Integer idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public Areafuncional(Integer idAreaFuncional, String nombre) {
        this.idAreaFuncional = idAreaFuncional;
        this.nombre = nombre;
    }

    public Integer getIdAreaFuncional() {
        return idAreaFuncional;
    }

    public void setIdAreaFuncional(Integer idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Software> getSoftwareCollection() {
        return softwareCollection;
    }

    public void setSoftwareCollection(Collection<Software> softwareCollection) {
        this.softwareCollection = softwareCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAreaFuncional != null ? idAreaFuncional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areafuncional)) {
            return false;
        }
        Areafuncional other = (Areafuncional) object;
        if ((this.idAreaFuncional == null && other.idAreaFuncional != null) || (this.idAreaFuncional != null && !this.idAreaFuncional.equals(other.idAreaFuncional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Areafuncional[ idAreaFuncional=" + idAreaFuncional + " ]";
    }
    
}
