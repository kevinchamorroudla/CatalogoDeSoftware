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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "EquipoVirtual")
@NamedQueries({
    @NamedQuery(name = "EquipoVirtual.findAll", query = "SELECT e FROM EquipoVirtual e"),
    @NamedQuery(name = "EquipoVirtual.findByIpCuchillaVirtual", query = "SELECT e FROM EquipoVirtual e WHERE e.ipCuchillaVirtual = :ipCuchillaVirtual")})
public class EquipoVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ipCuchillaVirtual")
    private Integer ipCuchillaVirtual;

    public EquipoVirtual() {
    }

    public EquipoVirtual(Integer ipCuchillaVirtual) {
        this.ipCuchillaVirtual = ipCuchillaVirtual;
    }

    public Integer getIpCuchillaVirtual() {
        return ipCuchillaVirtual;
    }

    public void setIpCuchillaVirtual(Integer ipCuchillaVirtual) {
        this.ipCuchillaVirtual = ipCuchillaVirtual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ipCuchillaVirtual != null ? ipCuchillaVirtual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoVirtual)) {
            return false;
        }
        EquipoVirtual other = (EquipoVirtual) object;
        if ((this.ipCuchillaVirtual == null && other.ipCuchillaVirtual != null) || (this.ipCuchillaVirtual != null && !this.ipCuchillaVirtual.equals(other.ipCuchillaVirtual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.EquipoVirtual[ ipCuchillaVirtual=" + ipCuchillaVirtual + " ]";
    }
    
}
