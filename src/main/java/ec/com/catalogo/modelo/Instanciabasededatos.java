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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labmacq
 */
@Entity
@Table(name = "instanciabasededatos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instanciabasededatos.findAll", query = "SELECT i FROM Instanciabasededatos i"),
    @NamedQuery(name = "Instanciabasededatos.findByIdInstanciaBaseDeDatos", query = "SELECT i FROM Instanciabasededatos i WHERE i.idInstanciaBaseDeDatos = :idInstanciaBaseDeDatos"),
    @NamedQuery(name = "Instanciabasededatos.findByNombre", query = "SELECT i FROM Instanciabasededatos i WHERE i.nombre = :nombre")})
public class Instanciabasededatos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_InstanciaBaseDeDatos")
    private Integer idInstanciaBaseDeDatos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "id_MotorBaseDeDatos", referencedColumnName = "id_MotorBaseDeDatos")
    @ManyToOne(optional = false)
    private Motorbasededatos idMotorBaseDeDatos;
    @JoinColumn(name = "id_Plataforma", referencedColumnName = "id_Plataforma")
    @ManyToOne(optional = false)
    private Plataforma idPlataforma;

    public Instanciabasededatos() {
    }

    public Instanciabasededatos(Integer idInstanciaBaseDeDatos) {
        this.idInstanciaBaseDeDatos = idInstanciaBaseDeDatos;
    }

    public Instanciabasededatos(Integer idInstanciaBaseDeDatos, String nombre) {
        this.idInstanciaBaseDeDatos = idInstanciaBaseDeDatos;
        this.nombre = nombre;
    }

    public Integer getIdInstanciaBaseDeDatos() {
        return idInstanciaBaseDeDatos;
    }

    public void setIdInstanciaBaseDeDatos(Integer idInstanciaBaseDeDatos) {
        this.idInstanciaBaseDeDatos = idInstanciaBaseDeDatos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Motorbasededatos getIdMotorBaseDeDatos() {
        return idMotorBaseDeDatos;
    }

    public void setIdMotorBaseDeDatos(Motorbasededatos idMotorBaseDeDatos) {
        this.idMotorBaseDeDatos = idMotorBaseDeDatos;
    }

    public Plataforma getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Plataforma idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstanciaBaseDeDatos != null ? idInstanciaBaseDeDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instanciabasededatos)) {
            return false;
        }
        Instanciabasededatos other = (Instanciabasededatos) object;
        if ((this.idInstanciaBaseDeDatos == null && other.idInstanciaBaseDeDatos != null) || (this.idInstanciaBaseDeDatos != null && !this.idInstanciaBaseDeDatos.equals(other.idInstanciaBaseDeDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Instanciabasededatos[ idInstanciaBaseDeDatos=" + idInstanciaBaseDeDatos + " ]";
    }
    
}
