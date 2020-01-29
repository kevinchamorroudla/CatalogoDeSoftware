/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plataforma.findAll", query = "SELECT p FROM Plataforma p"),
    @NamedQuery(name = "Plataforma.findByIdPlataforma", query = "SELECT p FROM Plataforma p WHERE p.idPlataforma = :idPlataforma"),
    @NamedQuery(name = "Plataforma.findByNombre", query = "SELECT p FROM Plataforma p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plataforma.findByTamanio", query = "SELECT p FROM Plataforma p WHERE p.tamanio = :tamanio"),
    @NamedQuery(name = "Plataforma.findByUsoDisco", query = "SELECT p FROM Plataforma p WHERE p.usoDisco = :usoDisco"),
    @NamedQuery(name = "Plataforma.findByEstado", query = "SELECT p FROM Plataforma p WHERE p.estado = :estado")})
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlataforma")
    private Collection<Instanciabasededatos> instanciabasededatosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlataforma")
    private Collection<Servidordeaplicaciones> servidordeaplicacionesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlataforma")
    private Collection<Respaldo> respaldoCollection;
    @JoinColumn(name = "id_Admin", referencedColumnName = "id_Funcionario")
    @ManyToOne(optional = false)
    private Funcionario idAdmin;
    @JoinColumn(name = "id_Equipo", referencedColumnName = "id_Equipo")
    @ManyToOne(optional = false)
    private Equipo idEquipo;
    @JoinColumn(name = "id_Fabricante", referencedColumnName = "id_Fabricante")
    @ManyToOne(optional = false)
    private Fabricante idFabricante;
    @JoinColumn(name = "id_Operador", referencedColumnName = "id_Funcionario")
    @ManyToOne(optional = false)
    private Funcionario idOperador;
    @JoinColumn(name = "id_Software", referencedColumnName = "id_Software")
    @ManyToOne(optional = false)
    private Software idSoftware;
    @JoinColumn(name = "id_TipoPlataforma", referencedColumnName = "id_TipoPlataforma")
    @ManyToOne(optional = false)
    private Tipoplataforma idTipoPlataforma;

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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Instanciabasededatos> getInstanciabasededatosCollection() {
        return instanciabasededatosCollection;
    }

    public void setInstanciabasededatosCollection(Collection<Instanciabasededatos> instanciabasededatosCollection) {
        this.instanciabasededatosCollection = instanciabasededatosCollection;
    }

    @XmlTransient
    public Collection<Servidordeaplicaciones> getServidordeaplicacionesCollection() {
        return servidordeaplicacionesCollection;
    }

    public void setServidordeaplicacionesCollection(Collection<Servidordeaplicaciones> servidordeaplicacionesCollection) {
        this.servidordeaplicacionesCollection = servidordeaplicacionesCollection;
    }

    @XmlTransient
    public Collection<Respaldo> getRespaldoCollection() {
        return respaldoCollection;
    }

    public void setRespaldoCollection(Collection<Respaldo> respaldoCollection) {
        this.respaldoCollection = respaldoCollection;
    }

    public Funcionario getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Funcionario idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Fabricante getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(Fabricante idFabricante) {
        this.idFabricante = idFabricante;
    }

    public Funcionario getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(Funcionario idOperador) {
        this.idOperador = idOperador;
    }

    public Software getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Software idSoftware) {
        this.idSoftware = idSoftware;
    }

    public Tipoplataforma getIdTipoPlataforma() {
        return idTipoPlataforma;
    }

    public void setIdTipoPlataforma(Tipoplataforma idTipoPlataforma) {
        this.idTipoPlataforma = idTipoPlataforma;
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
