/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "Plataforma")
@NamedQueries({
    @NamedQuery(name = "Plataforma.findAll", query = "SELECT p FROM Plataforma p"),
    @NamedQuery(name = "Plataforma.findByIdPlataforma", query = "SELECT p FROM Plataforma p WHERE p.idPlataforma = :idPlataforma"),
    @NamedQuery(name = "Plataforma.findByNombre", query = "SELECT p FROM Plataforma p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plataforma.findByTamanio", query = "SELECT p FROM Plataforma p WHERE p.tamanio = :tamanio"),
    @NamedQuery(name = "Plataforma.findByUsoDisco", query = "SELECT p FROM Plataforma p WHERE p.usoDisco = :usoDisco"),
    @NamedQuery(name = "Plataforma.findByIdTipoPlataforma", query = "SELECT p FROM Plataforma p WHERE p.idTipoPlataforma = :idTipoPlataforma"),
    @NamedQuery(name = "Plataforma.findByEstado", query = "SELECT p FROM Plataforma p WHERE p.estado = :estado"),
    @NamedQuery(name = "Plataforma.findByIdAdmin", query = "SELECT p FROM Plataforma p WHERE p.idAdmin = :idAdmin"),
    @NamedQuery(name = "Plataforma.findByIdAdminUser", query = "SELECT p FROM Plataforma p WHERE p.idAdminUser = :idAdminUser"),
    @NamedQuery(name = "Plataforma.findByIdOperador", query = "SELECT p FROM Plataforma p WHERE p.idOperador = :idOperador"),
    @NamedQuery(name = "Plataforma.findByIdOperadorUser", query = "SELECT p FROM Plataforma p WHERE p.idOperadorUser = :idOperadorUser"),
    @NamedQuery(name = "Plataforma.findByIdFabricante", query = "SELECT p FROM Plataforma p WHERE p.idFabricante = :idFabricante"),
    @NamedQuery(name = "Plataforma.findByIdEquipo", query = "SELECT p FROM Plataforma p WHERE p.idEquipo = :idEquipo"),
    @NamedQuery(name = "Plataforma.findByIdSoftware", query = "SELECT p FROM Plataforma p WHERE p.idSoftware = :idSoftware")})
public class Plataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Plataforma")
    private Integer idPlataforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tamanio")
    private BigDecimal tamanio;
    @Column(name = "usoDisco")
    private BigDecimal usoDisco;
    @Column(name = "id_TipoPlataforma")
    private Integer idTipoPlataforma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_Admin")
    private Integer idAdmin;
    @Column(name = "id_AdminUser")
    private Integer idAdminUser;
    @Column(name = "id_Operador")
    private Integer idOperador;
    @Column(name = "id_OperadorUser")
    private Integer idOperadorUser;
    @Column(name = "id_Fabricante")
    private Integer idFabricante;
    @Size(max = 45)
    @Column(name = "id_Equipo")
    private String idEquipo;
    @Size(max = 45)
    @Column(name = "id_Software")
    private String idSoftware;

    public Plataforma() {
    }

    public Plataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public Plataforma(Integer idPlataforma, String nombre, boolean estado) {
        this.idPlataforma = idPlataforma;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Integer getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getTamanio() {
        return tamanio;
    }

    public void setTamanio(BigDecimal tamanio) {
        this.tamanio = tamanio;
    }

    public BigDecimal getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(BigDecimal usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Integer getIdTipoPlataforma() {
        return idTipoPlataforma;
    }

    public void setIdTipoPlataforma(Integer idTipoPlataforma) {
        this.idTipoPlataforma = idTipoPlataforma;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Integer getIdAdminUser() {
        return idAdminUser;
    }

    public void setIdAdminUser(Integer idAdminUser) {
        this.idAdminUser = idAdminUser;
    }

    public Integer getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Integer idOperador) {
        this.idOperador = idOperador;
    }

    public Integer getIdOperadorUser() {
        return idOperadorUser;
    }

    public void setIdOperadorUser(Integer idOperadorUser) {
        this.idOperadorUser = idOperadorUser;
    }

    public Integer getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Integer idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(String idSoftware) {
        this.idSoftware = idSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlataforma != null ? idPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataforma)) {
            return false;
        }
        Plataforma other = (Plataforma) object;
        if ((this.idPlataforma == null && other.idPlataforma != null) || (this.idPlataforma != null && !this.idPlataforma.equals(other.idPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Plataforma[ idPlataforma=" + idPlataforma + " ]";
    }
    
}
