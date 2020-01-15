/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "SoftwareRequerimiento")
@NamedQueries({
    @NamedQuery(name = "SoftwareRequerimiento.findAll", query = "SELECT s FROM SoftwareRequerimiento s"),
    @NamedQuery(name = "SoftwareRequerimiento.findByIdServicio", query = "SELECT s FROM SoftwareRequerimiento s WHERE s.softwareRequerimientoPK.idServicio = :idServicio"),
    @NamedQuery(name = "SoftwareRequerimiento.findByIdRequerimiento", query = "SELECT s FROM SoftwareRequerimiento s WHERE s.softwareRequerimientoPK.idRequerimiento = :idRequerimiento"),
    @NamedQuery(name = "SoftwareRequerimiento.findByFecha", query = "SELECT s FROM SoftwareRequerimiento s WHERE s.fecha = :fecha")})
public class SoftwareRequerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SoftwareRequerimientoPK softwareRequerimientoPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "id_Requerimiento", referencedColumnName = "id_Requerimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Requerimiento requerimiento;
    @JoinColumn(name = "id_Servicio", referencedColumnName = "id_Software", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Software software;

    public SoftwareRequerimiento() {
    }

    public SoftwareRequerimiento(SoftwareRequerimientoPK softwareRequerimientoPK) {
        this.softwareRequerimientoPK = softwareRequerimientoPK;
    }

    public SoftwareRequerimiento(int idServicio, int idRequerimiento) {
        this.softwareRequerimientoPK = new SoftwareRequerimientoPK(idServicio, idRequerimiento);
    }

    public SoftwareRequerimientoPK getSoftwareRequerimientoPK() {
        return softwareRequerimientoPK;
    }

    public void setSoftwareRequerimientoPK(SoftwareRequerimientoPK softwareRequerimientoPK) {
        this.softwareRequerimientoPK = softwareRequerimientoPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (softwareRequerimientoPK != null ? softwareRequerimientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareRequerimiento)) {
            return false;
        }
        SoftwareRequerimiento other = (SoftwareRequerimiento) object;
        if ((this.softwareRequerimientoPK == null && other.softwareRequerimientoPK != null) || (this.softwareRequerimientoPK != null && !this.softwareRequerimientoPK.equals(other.softwareRequerimientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.SoftwareRequerimiento[ softwareRequerimientoPK=" + softwareRequerimientoPK + " ]";
    }
    
}
