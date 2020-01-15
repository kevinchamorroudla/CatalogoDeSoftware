/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author carlosballadares
 */
@Embeddable
public class SoftwareRequerimientoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Servicio")
    private int idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Requerimiento")
    private int idRequerimiento;

    public SoftwareRequerimientoPK() {
    }

    public SoftwareRequerimientoPK(int idServicio, int idRequerimiento) {
        this.idServicio = idServicio;
        this.idRequerimiento = idRequerimiento;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idServicio;
        hash += (int) idRequerimiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SoftwareRequerimientoPK)) {
            return false;
        }
        SoftwareRequerimientoPK other = (SoftwareRequerimientoPK) object;
        if (this.idServicio != other.idServicio) {
            return false;
        }
        if (this.idRequerimiento != other.idRequerimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.SoftwareRequerimientoPK[ idServicio=" + idServicio + ", idRequerimiento=" + idRequerimiento + " ]";
    }
    
}
