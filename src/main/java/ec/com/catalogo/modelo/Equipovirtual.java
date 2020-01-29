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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labmacq
 */
@Entity
@Table(name = "equipovirtual")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipovirtual.findAll", query = "SELECT e FROM Equipovirtual e"),
    @NamedQuery(name = "Equipovirtual.findByIdEquipoVirtual", query = "SELECT e FROM Equipovirtual e WHERE e.idEquipoVirtual = :idEquipoVirtual")})
public class Equipovirtual implements Serializable {

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

    public Equipovirtual() {
    }

    public Equipovirtual(Integer idEquipoVirtual) {
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
        if (!(object instanceof Equipovirtual)) {
            return false;
        }
        Equipovirtual other = (Equipovirtual) object;
        if ((this.idEquipoVirtual == null && other.idEquipoVirtual != null) || (this.idEquipoVirtual != null && !this.idEquipoVirtual.equals(other.idEquipoVirtual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Equipovirtual[ idEquipoVirtual=" + idEquipoVirtual + " ]";
    }
    
}
