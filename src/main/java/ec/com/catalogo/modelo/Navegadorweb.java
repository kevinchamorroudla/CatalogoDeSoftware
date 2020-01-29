/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labmacq
 */
@Entity
@Table(name = "navegadorweb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Navegadorweb.findAll", query = "SELECT n FROM Navegadorweb n"),
    @NamedQuery(name = "Navegadorweb.findByIdNavegadorWeb", query = "SELECT n FROM Navegadorweb n WHERE n.idNavegadorWeb = :idNavegadorWeb"),
    @NamedQuery(name = "Navegadorweb.findByNombre", query = "SELECT n FROM Navegadorweb n WHERE n.nombre = :nombre"),
    @NamedQuery(name = "Navegadorweb.findByVersion", query = "SELECT n FROM Navegadorweb n WHERE n.version = :version")})
public class Navegadorweb implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNavegadorWeb")
    private Collection<Softwarexnavegadorweb> softwarexnavegadorwebCollection;
    @JoinColumn(name = "id_Fabricante", referencedColumnName = "id_Fabricante")
    @ManyToOne(optional = false)
    private Fabricante idFabricante;

    public Navegadorweb() {
    }

    public Navegadorweb(Integer idNavegadorWeb) {
        this.idNavegadorWeb = idNavegadorWeb;
    }

    public Navegadorweb(Integer idNavegadorWeb, String nombre, String version) {
        this.idNavegadorWeb = idNavegadorWeb;
        this.nombre = nombre;
        this.version = version;
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

    @XmlTransient
    public Collection<Softwarexnavegadorweb> getSoftwarexnavegadorwebCollection() {
        return softwarexnavegadorwebCollection;
    }

    public void setSoftwarexnavegadorwebCollection(Collection<Softwarexnavegadorweb> softwarexnavegadorwebCollection) {
        this.softwarexnavegadorwebCollection = softwarexnavegadorwebCollection;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
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
        if (!(object instanceof Navegadorweb)) {
            return false;
        }
        Navegadorweb other = (Navegadorweb) object;
        if ((this.idNavegadorWeb == null && other.idNavegadorWeb != null) || (this.idNavegadorWeb != null && !this.idNavegadorWeb.equals(other.idNavegadorWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Navegadorweb[ idNavegadorWeb=" + idNavegadorWeb + " ]";
    }
    
}
