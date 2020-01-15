/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
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

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "SoftwareEquipo")
@NamedQueries({
    @NamedQuery(name = "SoftwareEquipo.findAll", query = "SELECT s FROM SoftwareEquipo s"),
    @NamedQuery(name = "SoftwareEquipo.findByIdSoftwareEquipo", query = "SELECT s FROM SoftwareEquipo s WHERE s.idSoftwareEquipo = :idSoftwareEquipo")})
public class SoftwareEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_SoftwareEquipo")
    private Integer idSoftwareEquipo;
    @JoinColumn(name = "id_Equipo", referencedColumnName = "id_Equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_Software", referencedColumnName = "id_Software")
    @ManyToOne(optional = false)
    private Software idSoftware;

    public SoftwareEquipo() {
    }

    public SoftwareEquipo(Integer idSoftwareEquipo) {
        this.idSoftwareEquipo = idSoftwareEquipo;
    }

    public Integer getIdSoftwareEquipo() {
        return idSoftwareEquipo;
    }

    public void setIdSoftwareEquipo(Integer idSoftwareEquipo) {
        this.idSoftwareEquipo = idSoftwareEquipo;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Software getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Software idSoftware) {
        this.idSoftware = idSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftwareEquipo != null ? idSoftwareEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareEquipo)) {
            return false;
        }
        SoftwareEquipo other = (SoftwareEquipo) object;
        if ((this.idSoftwareEquipo == null && other.idSoftwareEquipo != null) || (this.idSoftwareEquipo != null && !this.idSoftwareEquipo.equals(other.idSoftwareEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.SoftwareEquipo[ idSoftwareEquipo=" + idSoftwareEquipo + " ]";
    }
    
}
