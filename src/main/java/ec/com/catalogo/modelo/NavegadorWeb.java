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
@Table(name = "NavegadorWeb")
@NamedQueries({
    @NamedQuery(name = "NavegadorWeb.findAll", query = "SELECT n FROM NavegadorWeb n"),
    @NamedQuery(name = "NavegadorWeb.findByIdNavegadorWeb", query = "SELECT n FROM NavegadorWeb n WHERE n.idNavegadorWeb = :idNavegadorWeb"),
    @NamedQuery(name = "NavegadorWeb.findByNombre", query = "SELECT n FROM NavegadorWeb n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "NavegadorWeb.findByVersion", query = "SELECT n FROM NavegadorWeb n WHERE n.version = :version"),
    @NamedQuery(name = "NavegadorWeb.findByIdFabricanteSoftware", query = "SELECT n FROM NavegadorWeb n WHERE n.idFabricanteSoftware = :idFabricanteSoftware")})
public class NavegadorWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_NavegadorWeb")
    private Integer idNavegadorWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_FabricanteSoftware")
    private int idFabricanteSoftware;

    public NavegadorWeb() {
    }

    public NavegadorWeb(Integer idNavegadorWeb) {
        this.idNavegadorWeb = idNavegadorWeb;
    }

    public NavegadorWeb(Integer idNavegadorWeb, String nombre, String version, int idFabricanteSoftware) {
        this.idNavegadorWeb = idNavegadorWeb;
        this.nombre = nombre;
        this.version = version;
        this.idFabricanteSoftware = idFabricanteSoftware;
    }

    public Integer getIdNavegadorWeb() {
        return idNavegadorWeb;
    }

    public void setIdNavegadorWeb(Integer idNavegadorWeb) {
        this.idNavegadorWeb = idNavegadorWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getIdFabricanteSoftware() {
        return idFabricanteSoftware;
    }

    public void setIdFabricanteSoftware(int idFabricanteSoftware) {
        this.idFabricanteSoftware = idFabricanteSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNavegadorWeb != null ? idNavegadorWeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NavegadorWeb)) {
            return false;
        }
        NavegadorWeb other = (NavegadorWeb) object;
        if ((this.idNavegadorWeb == null && other.idNavegadorWeb != null) || (this.idNavegadorWeb != null && !this.idNavegadorWeb.equals(other.idNavegadorWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.NavegadorWeb[ idNavegadorWeb=" + idNavegadorWeb + " ]";
    }
    
}
