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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Instancia")
@NamedQueries({
    @NamedQuery(name = "Instancia.findAll", query = "SELECT i FROM Instancia i"),
    @NamedQuery(name = "Instancia.findByIdInstancia", query = "SELECT i FROM Instancia i WHERE i.idInstancia = :idInstancia"),
    @NamedQuery(name = "Instancia.findByNombre", query = "SELECT i FROM Instancia i WHERE i.nombre = :nombre")})
public class Instancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Instancia")
    private Integer idInstancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_Motor", referencedColumnName = "id_MotorBaseDeDatos")
    @ManyToOne(optional = false)
    private MotorBaseDeDatos idMotor;

    public Instancia() {
    }

    public Instancia(Integer idInstancia) {
        this.idInstancia = idInstancia;
    }

    public Instancia(Integer idInstancia, String nombre) {
        this.idInstancia = idInstancia;
        this.nombre = nombre;
    }

    public Integer getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Integer idInstancia) {
        this.idInstancia = idInstancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MotorBaseDeDatos getIdMotor() {
        return idMotor;
    }

    public void setIdMotor(MotorBaseDeDatos idMotor) {
        this.idMotor = idMotor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstancia != null ? idInstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instancia)) {
            return false;
        }
        Instancia other = (Instancia) object;
        if ((this.idInstancia == null && other.idInstancia != null) || (this.idInstancia != null && !this.idInstancia.equals(other.idInstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Instancia[ idInstancia=" + idInstancia + " ]";
    }
    
}
