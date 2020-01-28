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
 * @author Kevin
 */
@Entity
@Table(name = "equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByNombre", query = "SELECT e FROM Equipo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipo.findByHost", query = "SELECT e FROM Equipo e WHERE e.host = :host"),
    @NamedQuery(name = "Equipo.findByDireccionMAC", query = "SELECT e FROM Equipo e WHERE e.direccionMAC = :direccionMAC"),
    @NamedQuery(name = "Equipo.findByMemoria", query = "SELECT e FROM Equipo e WHERE e.memoria = :memoria"),
    @NamedQuery(name = "Equipo.findByIp", query = "SELECT e FROM Equipo e WHERE e.ip = :ip"),
    @NamedQuery(name = "Equipo.findByCapacidad", query = "SELECT e FROM Equipo e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Equipo.findByDescripcion", query = "SELECT e FROM Equipo e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Equipo.findByTipoEquipo", query = "SELECT e FROM Equipo e WHERE e.tipoEquipo = :tipoEquipo")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "host")
    private String host;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionMAC")
    private String direccionMAC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memoria")
    private String memoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "capacidad")
    private String capacidad;
    @Size(max = 120)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tipoEquipo")
    private String tipoEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Motorbasededatos> motorbasededatosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Equipofisico> equipofisicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Softwarexequipo> softwarexequipoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Equipovirtual> equipovirtualCollection;
    @JoinColumn(name = "id_DataCenter", referencedColumnName = "id_DataCenter")
    @ManyToOne(optional = false)
    private Datacenter idDataCenter;
    @JoinColumn(name = "id_Procesador", referencedColumnName = "id_Procesador")
    @ManyToOne(optional = false)
    private Procesador idProcesador;
    @JoinColumn(name = "id_SistemaOperativo", referencedColumnName = "id_SistemaOperativo")
    @ManyToOne(optional = false)
    private Sistemaoperativo idSistemaOperativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private Collection<Plataforma> plataformaCollection;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String nombre, String host, String direccionMAC, String memoria, String ip, String capacidad, String tipoEquipo) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.host = host;
        this.direccionMAC = direccionMAC;
        this.memoria = memoria;
        this.ip = ip;
        this.capacidad = capacidad;
        this.tipoEquipo = tipoEquipo;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDireccionMAC() {
        return direccionMAC;
    }

    public void setDireccionMAC(String direccionMAC) {
        this.direccionMAC = direccionMAC;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(String tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    @XmlTransient
    public Collection<Motorbasededatos> getMotorbasededatosCollection() {
        return motorbasededatosCollection;
    }

    public void setMotorbasededatosCollection(Collection<Motorbasededatos> motorbasededatosCollection) {
        this.motorbasededatosCollection = motorbasededatosCollection;
    }

    @XmlTransient
    public Collection<Equipofisico> getEquipofisicoCollection() {
        return equipofisicoCollection;
    }

    public void setEquipofisicoCollection(Collection<Equipofisico> equipofisicoCollection) {
        this.equipofisicoCollection = equipofisicoCollection;
    }

    @XmlTransient
    public Collection<Softwarexequipo> getSoftwarexequipoCollection() {
        return softwarexequipoCollection;
    }

    public void setSoftwarexequipoCollection(Collection<Softwarexequipo> softwarexequipoCollection) {
        this.softwarexequipoCollection = softwarexequipoCollection;
    }

    @XmlTransient
    public Collection<Equipovirtual> getEquipovirtualCollection() {
        return equipovirtualCollection;
    }

    public void setEquipovirtualCollection(Collection<Equipovirtual> equipovirtualCollection) {
        this.equipovirtualCollection = equipovirtualCollection;
    }

    public Datacenter getIdDataCenter() {
        return idDataCenter;
    }

    public void setIdDataCenter(Datacenter idDataCenter) {
        this.idDataCenter = idDataCenter;
    }

    public Procesador getIdProcesador() {
        return idProcesador;
    }

    public void setIdProcesador(Procesador idProcesador) {
        this.idProcesador = idProcesador;
    }

    public Sistemaoperativo getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(Sistemaoperativo idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
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
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
