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
@Table(name = "Almacenamiento")
@NamedQueries({
    @NamedQuery(name = "Almacenamiento.findAll", query = "SELECT a FROM Almacenamiento a"),
    @NamedQuery(name = "Almacenamiento.findByIdAlmacenamiento", query = "SELECT a FROM Almacenamiento a WHERE a.idAlmacenamiento = :idAlmacenamiento"),
    @NamedQuery(name = "Almacenamiento.findByHost", query = "SELECT a FROM Almacenamiento a WHERE a.host = :host"),
    @NamedQuery(name = "Almacenamiento.findByLicencia", query = "SELECT a FROM Almacenamiento a WHERE a.licencia = :licencia"),
    @NamedQuery(name = "Almacenamiento.findByIp", query = "SELECT a FROM Almacenamiento a WHERE a.ip = :ip"),
    @NamedQuery(name = "Almacenamiento.findByDescripcion", query = "SELECT a FROM Almacenamiento a WHERE a.descripcion = :descripcion")})
public class Almacenamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Almacenamiento")
    private Integer idAlmacenamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "host")
    private String host;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "licencia")
    private String licencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ip")
    private String ip;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public Almacenamiento() {
    }

    public Almacenamiento(Integer idAlmacenamiento) {
        this.idAlmacenamiento = idAlmacenamiento;
    }

    public Almacenamiento(Integer idAlmacenamiento, String host, String licencia, String ip) {
        this.idAlmacenamiento = idAlmacenamiento;
        this.host = host;
        this.licencia = licencia;
        this.ip = ip;
    }

    public Integer getIdAlmacenamiento() {
        return idAlmacenamiento;
    }

    public void setIdAlmacenamiento(Integer idAlmacenamiento) {
        this.idAlmacenamiento = idAlmacenamiento;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        hash += (idAlmacenamiento != null ? idAlmacenamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenamiento)) {
            return false;
        }
        Almacenamiento other = (Almacenamiento) object;
        if ((this.idAlmacenamiento == null && other.idAlmacenamiento != null) || (this.idAlmacenamiento != null && !this.idAlmacenamiento.equals(other.idAlmacenamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Almacenamiento[ idAlmacenamiento=" + idAlmacenamiento + " ]";
    }
    
}
