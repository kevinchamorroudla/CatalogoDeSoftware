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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Funcionario.findByNombreUsuario", query = "SELECT f FROM Funcionario f WHERE f.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Funcionario.findByPassword", query = "SELECT f FROM Funcionario f WHERE f.password = :password"),
    @NamedQuery(name = "Funcionario.findByTipo", query = "SELECT f FROM Funcionario f WHERE f.tipo = :tipo")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Funcionario")
    private Integer idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "id_AreaFuncional", referencedColumnName = "id_AreaFuncional")
    @ManyToOne(optional = false)
    private Areafuncional idAreaFuncional;
    @JoinColumn(name = "id_Persona", referencedColumnName = "id_Persona")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAdmin")
    private Collection<Plataforma> plataformaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOperador")
    private Collection<Plataforma> plataformaCollection1;
    @OneToMany(mappedBy = "idAprobador")
    private Collection<Requerimiento> requerimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitante")
    private Collection<Requerimiento> requerimientoCollection1;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nombreUsuario, String password, String tipo) {
        this.idFuncionario = idFuncionario;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipo = tipo;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Areafuncional getIdAreaFuncional() {
        return idAreaFuncional;
    }

    public void setIdAreaFuncional(Areafuncional idAreaFuncional) {
        this.idAreaFuncional = idAreaFuncional;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @XmlTransient
    public Collection<Plataforma> getPlataformaCollection() {
        return plataformaCollection;
    }

    public void setPlataformaCollection(Collection<Plataforma> plataformaCollection) {
        this.plataformaCollection = plataformaCollection;
    }

    @XmlTransient
    public Collection<Plataforma> getPlataformaCollection1() {
        return plataformaCollection1;
    }

    public void setPlataformaCollection1(Collection<Plataforma> plataformaCollection1) {
        this.plataformaCollection1 = plataformaCollection1;
    }

    @XmlTransient
    public Collection<Requerimiento> getRequerimientoCollection() {
        return requerimientoCollection;
    }

    public void setRequerimientoCollection(Collection<Requerimiento> requerimientoCollection) {
        this.requerimientoCollection = requerimientoCollection;
    }

    @XmlTransient
    public Collection<Requerimiento> getRequerimientoCollection1() {
        return requerimientoCollection1;
    }

    public void setRequerimientoCollection1(Collection<Requerimiento> requerimientoCollection1) {
        this.requerimientoCollection1 = requerimientoCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
