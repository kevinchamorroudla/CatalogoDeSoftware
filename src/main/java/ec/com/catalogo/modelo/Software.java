/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Software")
@NamedQueries({
    @NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s"),
    @NamedQuery(name = "Software.findByIdSoftware", query = "SELECT s FROM Software s WHERE s.idSoftware = :idSoftware"),
    @NamedQuery(name = "Software.findByNombre", query = "SELECT s FROM Software s WHERE s.nombre = :nombre"),
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
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Column(name = "web")
    private byte[] web;
    @Size(max = 45)
    @Column(name = "version")
    private String version;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "path")
    private String path;
    @Size(max = 45)
    @Column(name = "numUsers")
    private String numUsers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "software")
    private List<SoftwareRequerimiento> softwareRequerimientoList;
    @JoinColumn(name = "id_Ambito", referencedColumnName = "id_Ambito")
    @ManyToOne(optional = false)
    private Ambito idAmbito;
    @JoinColumn(name = "id_AreaFuncional", referencedColumnName = "id_AreaFuncional")
    @ManyToOne(optional = false)
    private AreaFuncional idAreaFuncional;
    @JoinColumn(name = "id_Clasificacion", referencedColumnName = "id_Clasificacion")
    @ManyToOne(optional = false)
    private Clasificacion idClasificacion;
    @JoinColumn(name = "id_Dominio", referencedColumnName = "id_Dominio")
    @ManyToOne(optional = false)
    private Dominio idDominio;
    @JoinColumn(name = "id_Lenguaje", referencedColumnName = "id_Lenguaje")
    @ManyToOne(optional = false)
    private Lenguaje idLenguaje;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSoftware")
    private List<SoftwareEquipo> softwareEquipoList;

    public Software() {
    }

    public Software(Integer idSoftware) {
        this.idSoftware = idSoftware;
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

    public byte[] getWeb() {
        return web;
    }

    public void setWeb(byte[] web) {
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

    public String getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(String numUsers) {
        this.numUsers = numUsers;
    }

    public List<SoftwareRequerimiento> getSoftwareRequerimientoList() {
        return softwareRequerimientoList;
    }

    public void setSoftwareRequerimientoList(List<SoftwareRequerimiento> softwareRequerimientoList) {
        this.softwareRequerimientoList = softwareRequerimientoList;
    }

    public Ambito getIdAmbito() {
        return idAmbito;
    }

    public void setIdAmbito(Ambito idAmbito) {
        this.idAmbito = idAmbito;
    }

    public AreaFuncional getIdAreaFuncional() {
        return idAreaFuncional;
    }

    public void setIdAreaFuncional(AreaFuncional idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public Clasificacion getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Clasificacion idClasificacion) {
        this.idClasificacion = idClasificacion;
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

    public List<SoftwareEquipo> getSoftwareEquipoList() {
        return softwareEquipoList;
    }

    public void setSoftwareEquipoList(List<SoftwareEquipo> softwareEquipoList) {
        this.softwareEquipoList = softwareEquipoList;
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
