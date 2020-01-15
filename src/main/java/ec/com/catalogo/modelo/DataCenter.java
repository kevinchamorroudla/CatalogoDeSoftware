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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "DataCenter")
@NamedQueries({
    @NamedQuery(name = "DataCenter.findAll", query = "SELECT d FROM DataCenter d"),
    @NamedQuery(name = "DataCenter.findByIdDataCenter", query = "SELECT d FROM DataCenter d WHERE d.idDataCenter = :idDataCenter"),
    @NamedQuery(name = "DataCenter.findBySector", query = "SELECT d FROM DataCenter d WHERE d.sector = :sector"),
    @NamedQuery(name = "DataCenter.findByArea", query = "SELECT d FROM DataCenter d WHERE d.area = :area"),
    @NamedQuery(name = "DataCenter.findByCalle1", query = "SELECT d FROM DataCenter d WHERE d.calle1 = :calle1"),
    @NamedQuery(name = "DataCenter.findByCalle2", query = "SELECT d FROM DataCenter d WHERE d.calle2 = :calle2"),
    @NamedQuery(name = "DataCenter.findByNumero", query = "SELECT d FROM DataCenter d WHERE d.numero = :numero"),
    @NamedQuery(name = "DataCenter.findByDescripcion", query = "SELECT d FROM DataCenter d WHERE d.descripcion = :descripcion")})
public class DataCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_DataCenter")
    private Integer idDataCenter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "sector")
    private String sector;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle1")
    private String calle1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle2")
    private String calle2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numero")
    private String numero;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public DataCenter() {
    }

    public DataCenter(Integer idDataCenter) {
        this.idDataCenter = idDataCenter;
    }

    public DataCenter(Integer idDataCenter, String sector, String area, String calle1, String calle2, String numero) {
        this.idDataCenter = idDataCenter;
        this.sector = sector;
        this.area = area;
        this.calle1 = calle1;
        this.calle2 = calle2;
        this.numero = numero;
    }

    public Integer getIdDataCenter() {
        return idDataCenter;
    }

    public void setIdDataCenter(Integer idDataCenter) {
        this.idDataCenter = idDataCenter;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1 = calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2 = calle2;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDataCenter != null ? idDataCenter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataCenter)) {
            return false;
        }
        DataCenter other = (DataCenter) object;
        if ((this.idDataCenter == null && other.idDataCenter != null) || (this.idDataCenter != null && !this.idDataCenter.equals(other.idDataCenter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.DataCenter[ idDataCenter=" + idDataCenter + " ]";
    }
    
}
