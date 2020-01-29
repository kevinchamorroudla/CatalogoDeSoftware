/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.catalogo.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labmacq
 */
@Entity
@Table(name = "softwarexnavegadorweb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Softwarexnavegadorweb.findAll", query = "SELECT s FROM Softwarexnavegadorweb s"),
    @NamedQuery(name = "Softwarexnavegadorweb.findByIdSoftwareXNavegadorWeb", query = "SELECT s FROM Softwarexnavegadorweb s WHERE s.idSoftwareXNavegadorWeb = :idSoftwareXNavegadorWeb")})
public class Softwarexnavegadorweb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_SoftwareXNavegadorWeb")
    private Integer idSoftwareXNavegadorWeb;
    @JoinColumn(name = "id_NavegadorWeb", referencedColumnName = "id_NavegadorWeb")
    @ManyToOne(optional = false)
    private Navegadorweb idNavegadorWeb;
    @JoinColumn(name = "id_Software", referencedColumnName = "id_Software")
    @ManyToOne(optional = false)
    private Software idSoftware;

    public Softwarexnavegadorweb() {
    }

    public Softwarexnavegadorweb(Integer idSoftwareXNavegadorWeb) {
        this.idSoftwareXNavegadorWeb = idSoftwareXNavegadorWeb;
    }

    public Integer getIdSoftwareXNavegadorWeb() {
        return idSoftwareXNavegadorWeb;
    }

    public void setIdSoftwareXNavegadorWeb(Integer idSoftwareXNavegadorWeb) {
        this.idSoftwareXNavegadorWeb = idSoftwareXNavegadorWeb;
    }

    public Navegadorweb getIdNavegadorWeb() {
        return idNavegadorWeb;
    }

    public void setIdNavegadorWeb(Navegadorweb idNavegadorWeb) {
        this.idNavegadorWeb = idNavegadorWeb;
    }

    public Software getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(Software idSoftware) {
        this.idSoftware = idSoftware;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoftwareXNavegadorWeb != null ? idSoftwareXNavegadorWeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Softwarexnavegadorweb)) {
            return false;
        }
        Softwarexnavegadorweb other = (Softwarexnavegadorweb) object;
        if ((this.idSoftwareXNavegadorWeb == null && other.idSoftwareXNavegadorWeb != null) || (this.idSoftwareXNavegadorWeb != null && !this.idSoftwareXNavegadorWeb.equals(other.idSoftwareXNavegadorWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.catalogo.modelo.Softwarexnavegadorweb[ idSoftwareXNavegadorWeb=" + idSoftwareXNavegadorWeb + " ]";
    }
    
}
