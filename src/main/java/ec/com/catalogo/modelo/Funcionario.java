/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlosballadares
 */
@Entity
@Table(name = "Funcionario")
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByIdPersona", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPK.idPersona = :idPersona"),
    @NamedQuery(name = "Funcionario.findByIdAprobador", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPK.idAprobador = :idAprobador"),
    @NamedQuery(name = "Funcionario.findByIdArea", query = "SELECT f FROM Funcionario f WHERE f.funcionarioPK.idArea = :idArea")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FuncionarioPK funcionarioPK;
    @JoinColumn(name = "id_Aprobador", referencedColumnName = "id_Persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_Area", referencedColumnName = "id_Area", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "id_Persona", referencedColumnName = "id_Persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;
    @OneToMany(mappedBy = "idAprobador")
    private List<Requerimiento> requerimientoList;
    @OneToMany(mappedBy = "idSolicitante")
    private List<Requerimiento> requerimientoList1;

    public Funcionario() {
    }

    public Funcionario(FuncionarioPK funcionarioPK) {
        this.funcionarioPK = funcionarioPK;
    }

    public Funcionario(int idPersona, int idAprobador, int idArea) {
        this.funcionarioPK = new FuncionarioPK(idPersona, idAprobador, idArea);
    }

    public FuncionarioPK getFuncionarioPK() {
        return funcionarioPK;
    }

    public void setFuncionarioPK(FuncionarioPK funcionarioPK) {
        this.funcionarioPK = funcionarioPK;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public List<Requerimiento> getRequerimientoList() {
        return requerimientoList;
    }

    public void setRequerimientoList(List<Requerimiento> requerimientoList) {
        this.requerimientoList = requerimientoList;
    }

    public List<Requerimiento> getRequerimientoList1() {
        return requerimientoList1;
    }

    public void setRequerimientoList1(List<Requerimiento> requerimientoList1) {
        this.requerimientoList1 = requerimientoList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcionarioPK != null ? funcionarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funcionarioPK == null && other.funcionarioPK != null) || (this.funcionarioPK != null && !this.funcionarioPK.equals(other.funcionarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Funcionario[ funcionarioPK=" + funcionarioPK + " ]";
    }
    
}
