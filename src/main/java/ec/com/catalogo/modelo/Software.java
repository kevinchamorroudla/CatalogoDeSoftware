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
@Table(name = "software")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s"),
    @NamedQuery(name = "Software.findByIdSoftware", query = "SELECT s FROM Software s WHERE s.idSoftware = :idSoftware"),
    @NamedQuery(name = "Software.findByNombre", query = "SELECT s FROM Software s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Software.findByWeb", query = "SELECT s FROM Software s WHERE s.web = :web"),
    @NamedQuery(name = "Software.findByVersion", query = "SELECT s FROM Software s WHERE s.version = :version"),
    @NamedQuery(name = "Software.findByDescripcion", query = "SELECT s FROM Software s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Software.findByPath", query = "SELECT s FROM Software s WHERE s.path = :path"),
    @NamedQuery(name = "Software.findByNumUsers", query = "SELECT s FROM Software s WHERE s.numUsers = :numUsers")})
public class Software implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Software")
    private Integer idSoftware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "web")
    private boolean web;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numUsers")
    private int numUsers;
    @JoinColumn(name = "id_Clasificacion", referencedColumnName = "id_Clasificacion")
    @ManyToOne(optional = false)
    private Clasificacion idClasificacion;
    @JoinColumn(name = "id_Ambito", referencedColumnName = "id_Ambito")
    @ManyToOne(optional = false)
    private Ambito idAmbito;
    @JoinColumn(name = "id_AreaFuncional", referencedColumnName = "id_AreaFuncional")
    @ManyToOne(optional = false)
    private Areafuncional idAreaFuncional;
    @JoinColumn(name = "id_Dominio", referencedColumnName = "id_Dominio")
    @ManyToOne(optional = false)
    private Dominio idDominio;
    @JoinColumn(name = "id_Lenguaje", referencedColumnName = "id_Lenguaje")
    @ManyToOne(optional = false)
    private Lenguaje idLenguaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoftware")
    private Collection<Softwarexnavegadorweb> softwarexnavegadorwebCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoftware")
    private Collection<Softwarexequipo> softwarexequipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoftware")
    private Collection<Plataforma> plataformaCollection;

    public Software() {
    }

    public Software(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public Software(Integer idSoftware, String nombre, boolean web, String version, String descripcion, String path, int numUsers) {
        this.idSoftware = idSoftware;
        this.nombre = nombre;
        this.web = web;
        this.version = version;
        this.descripcion = descripcion;
        this.path = path;
        this.numUsers = numUsers;
    }

    public Integer getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Integer idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    public Clasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Ambito getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(Ambito idAmbito) {
        this.idAmbito = idAmbito;
    }

    public Areafuncional getIdAreaFuncional() {
        return idAreaFuncional;
    }

    public void setIdAreaFuncional(Areafuncional idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public Dominio getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Dominio idDominio) {
        this.idDominio = idDominio;
    }

    public Lenguaje getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Lenguaje idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    @XmlTransient
    public Collection<Softwarexnavegadorweb> getSoftwarexnavegadorwebCollection() {
        return softwarexnavegadorwebCollection;
    }

    public void setSoftwarexnavegadorwebCollection(Collection<Softwarexnavegadorweb> softwarexnavegadorwebCollection) {
        this.softwarexnavegadorwebCollection = softwarexnavegadorwebCollection;
    }

    @XmlTransient
    public Collection<Softwarexequipo> getSoftwarexequipoCollection() {
        return softwarexequipoCollection;
    }

    public void setSoftwarexequipoCollection(Collection<Softwarexequipo> softwarexequipoCollection) {
        this.softwarexequipoCollection = softwarexequipoCollection;
    }

    @XmlTransient
    public Collection<Plataforma> getPlataformaCollection() {
        return plataformaCollection;
    }

    public void setPlataformaCollection(Collection<Plataforma> plataformaCollection) {
        this.plataformaCollection = plataformaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftware != null ? idSoftware.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Software)) {
            return false;
        }
        Software other = (Software) object;
        if ((this.idSoftware == null && other.idSoftware != null) || (this.idSoftware != null && !this.idSoftware.equals(other.idSoftware))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Software[ idSoftware=" + idSoftware + " ]";
    }
    
}
