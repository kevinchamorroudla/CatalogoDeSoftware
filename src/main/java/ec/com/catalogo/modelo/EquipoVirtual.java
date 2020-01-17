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
@Table(name = "EquipoVirtual")
@NamedQueries({
    @NamedQuery(name = "EquipoVirtual.findAll", query = "SELECT e FROM EquipoVirtual e"),
    @NamedQuery(name = "EquipoVirtual.findByIdEquipoVirtual", query = "SELECT e FROM EquipoVirtual e WHERE e.idEquipoVirtual = :idEquipoVirtual")})
public class EquipoVirtual implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_EquipoVirtual")
    private Integer idEquipoVirtual;
    @JoinColumn(name = "id_Cuchilla", referencedColumnName = "id_Cuchilla")
    @ManyToOne(optional = false)
    private Cuchilla idCuchilla;
    @JoinColumn(name = "id_Equipo", referencedColumnName = "id_Equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;

    public EquipoVirtual() {
    }

    public EquipoVirtual(Integer idEquipoVirtual) {
        this.idEquipoVirtual = idEquipoVirtual;
    }

    public Integer getIdEquipoVirtual() {
        return idEquipoVirtual;
    }

    public void setIdEquipoVirtual(Integer idEquipoVirtual) {
        this.idEquipoVirtual = idEquipoVirtual;
    }

    public Cuchilla getIdCuchilla() {
        return idCuchilla;
    }

    public void setIdCuchilla(Cuchilla idCuchilla) {
        this.idCuchilla = idCuchilla;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipoVirtual != null ? idEquipoVirtual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipoVirtual)) {
            return false;
        }
        EquipoVirtual other = (EquipoVirtual) object;
        if ((this.idEquipoVirtual == null && other.idEquipoVirtual != null) || (this.idEquipoVirtual != null && !this.idEquipoVirtual.equals(other.idEquipoVirtual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.EquipoVirtual[ idEquipoVirtual=" + idEquipoVirtual + " ]";
    }
    
}
