/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "requerimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requerimiento.findAll", query = "SELECT r FROM Requerimiento r"),
    @NamedQuery(name = "Requerimiento.findByIdRequerimiento", query = "SELECT r FROM Requerimiento r WHERE r.idRequerimiento = :idRequerimiento"),
    @NamedQuery(name = "Requerimiento.findByEstado", query = "SELECT r FROM Requerimiento r WHERE r.estado = :estado"),
    @NamedQuery(name = "Requerimiento.findByTipo", query = "SELECT r FROM Requerimiento r WHERE r.tipo = :tipo"),
    @NamedQuery(name = "Requerimiento.findByPrioridad", query = "SELECT r FROM Requerimiento r WHERE r.prioridad = :prioridad"),
    @NamedQuery(name = "Requerimiento.findByDescripcion", query = "SELECT r FROM Requerimiento r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Requerimiento.findByFechaSolicitud", query = "SELECT r FROM Requerimiento r WHERE r.fechaSolicitud = :fechaSolicitud"),
    @NamedQuery(name = "Requerimiento.findByDireccionCoordinacion", query = "SELECT r FROM Requerimiento r WHERE r.direccionCoordinacion = :direccionCoordinacion"),
    @NamedQuery(name = "Requerimiento.findByBeneficios", query = "SELECT r FROM Requerimiento r WHERE r.beneficios = :beneficios")})
public class Requerimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Requerimiento")
    private Integer idRequerimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "prioridad")
    private String prioridad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_Solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Size(max = 512)
    @Column(name = "direccion_Coordinacion")
    private String direccionCoordinacion;
    @Size(max = 512)
    @Column(name = "beneficios")
    private String beneficios;
    @JoinColumn(name = "id_Aprobador", referencedColumnName = "id_Funcionario")
    @ManyToOne
    private Funcionario idAprobador;
    @JoinColumn(name = "id_Solicitante", referencedColumnName = "id_Funcionario")
    @ManyToOne(optional = false)
    private Funcionario idSolicitante;

    public Requerimiento() {
    }

    public Requerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public Requerimiento(Integer idRequerimiento, String estado, String tipo, String prioridad, String descripcion) {
        this.idRequerimiento = idRequerimiento;
        this.estado = estado;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    public Integer getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(Integer idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getDireccionCoordinacion() {
        return direccionCoordinacion;
    }

    public void setDireccionCoordinacion(String direccionCoordinacion) {
        this.direccionCoordinacion = direccionCoordinacion;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public Funcionario getIdAprobador() {
        return idAprobador;
    }

    public void setIdAprobador(Funcionario idAprobador) {
        this.idAprobador = idAprobador;
    }

    public Funcionario getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(Funcionario idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRequerimiento != null ? idRequerimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requerimiento)) {
            return false;
        }
        Requerimiento other = (Requerimiento) object;
        if ((this.idRequerimiento == null && other.idRequerimiento != null) || (this.idRequerimiento != null && !this.idRequerimiento.equals(other.idRequerimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Requerimiento{" + "idRequerimiento=" + idRequerimiento + ", estado=" + estado + ", tipo=" + tipo + ", prioridad=" + prioridad 
                + ", descripcion=" + descripcion + ", fechaSolicitud=" + fechaSolicitud.toString() + ", direccionCoordinacion=" + direccionCoordinacion 
                + ", beneficios=" + beneficios + ", idAprobador=" + idAprobador + ", idSolicitante=" + idSolicitante + '}';
    }

    
    
}
