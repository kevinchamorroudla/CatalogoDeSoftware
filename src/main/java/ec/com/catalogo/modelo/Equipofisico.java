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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "equipofisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipofisico.findAll", query = "SELECT e FROM Equipofisico e"),
    @NamedQuery(name = "Equipofisico.findByIdEquipoFisico", query = "SELECT e FROM Equipofisico e WHERE e.idEquipoFisico = :idEquipoFisico"),
    @NamedQuery(name = "Equipofisico.findByModelo", query = "SELECT e FROM Equipofisico e WHERE e.modelo = :modelo"),
    @NamedQuery(name = "Equipofisico.findByEnergia", query = "SELECT e FROM Equipofisico e WHERE e.energia = :energia"),
    @NamedQuery(name = "Equipofisico.findByDisco", query = "SELECT e FROM Equipofisico e WHERE e.disco = :disco")})
public class Equipofisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_EquipoFisico")
    private Integer idEquipoFisico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "energia")
    private String energia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "disco")
    private String disco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoFisico")
    private Collection<Cuchilla> cuchillaCollection;
    @JoinColumn(name = "id_Equipo", referencedColumnName = "id_Equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipoFisico")
    private Collection<Almacenamiento> almacenamientoCollection;

    public Equipofisico() {
    }

    public Equipofisico(Integer idEquipoFisico) {
        this.idEquipoFisico = idEquipoFisico;
    }

    public Equipofisico(Integer idEquipoFisico, String modelo, String energia, String disco) {
        this.idEquipoFisico = idEquipoFisico;
        this.modelo = modelo;
        this.energia = energia;
        this.disco = disco;
    }

    public Integer getIdEquipoFisico() {
        return idEquipoFisico;
    }

    public void setIdEquipoFisico(Integer idEquipoFisico) {
        this.idEquipoFisico = idEquipoFisico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    @XmlTransient
    public Collection<Cuchilla> getCuchillaCollection() {
        return cuchillaCollection;
    }

    public void setCuchillaCollection(Collection<Cuchilla> cuchillaCollection) {
        this.cuchillaCollection = cuchillaCollection;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @XmlTransient
    public Collection<Almacenamiento> getAlmacenamientoCollection() {
        return almacenamientoCollection;
    }

    public void setAlmacenamientoCollection(Collection<Almacenamiento> almacenamientoCollection) {
        this.almacenamientoCollection = almacenamientoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoFisico != null ? idEquipoFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipofisico)) {
            return false;
        }
        Equipofisico other = (Equipofisico) object;
        if ((this.idEquipoFisico == null && other.idEquipoFisico != null) || (this.idEquipoFisico != null && !this.idEquipoFisico.equals(other.idEquipoFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Equipofisico[ idEquipoFisico=" + idEquipoFisico + " ]";
    }
    
}
