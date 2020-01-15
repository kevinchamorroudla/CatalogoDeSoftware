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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Equipo")
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByIpHardware", query = "SELECT e FROM Equipo e WHERE e.ipHardware = :ipHardware"),
    @NamedQuery(name = "Equipo.findByNumerosSerie", query = "SELECT e FROM Equipo e WHERE e.numerosSerie = :numerosSerie"),
    @NamedQuery(name = "Equipo.findByDireccionMAC", query = "SELECT e FROM Equipo e WHERE e.direccionMAC = :direccionMAC"),
    @NamedQuery(name = "Equipo.findByMemoria", query = "SELECT e FROM Equipo e WHERE e.memoria = :memoria"),
    @NamedQuery(name = "Equipo.findByIp", query = "SELECT e FROM Equipo e WHERE e.ip = :ip"),
    @NamedQuery(name = "Equipo.findByCapacidad", query = "SELECT e FROM Equipo e WHERE e.capacidad = :capacidad"),
    @NamedQuery(name = "Equipo.findByIdMotorBaseDeDatos", query = "SELECT e FROM Equipo e WHERE e.idMotorBaseDeDatos = :idMotorBaseDeDatos")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ip_Hardware")
    private int ipHardware;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "numerosSerie")
    private String numerosSerie;
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
    @Column(name = "IP")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "capacidad")
    private String capacidad;
    @Column(name = "id_MotorBaseDeDatos")
    private Integer idMotorBaseDeDatos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo")
    private List<SoftwareEquipo> softwareEquipoList;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, int ipHardware, String numerosSerie, String direccionMAC, String memoria, String ip, String capacidad) {
        this.idEquipo = idEquipo;
        this.ipHardware = ipHardware;
        this.numerosSerie = numerosSerie;
        this.direccionMAC = direccionMAC;
        this.memoria = memoria;
        this.ip = ip;
        this.capacidad = capacidad;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIpHardware() {
        return ipHardware;
    }

    public void setIpHardware(int ipHardware) {
        this.ipHardware = ipHardware;
    }

    public String getNumerosSerie() {
        return numerosSerie;
    }

    public void setNumerosSerie(String numerosSerie) {
        this.numerosSerie = numerosSerie;
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

    public Integer getIdMotorBaseDeDatos() {
        return idMotorBaseDeDatos;
    }

    public void setIdMotorBaseDeDatos(Integer idMotorBaseDeDatos) {
        this.idMotorBaseDeDatos = idMotorBaseDeDatos;
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
