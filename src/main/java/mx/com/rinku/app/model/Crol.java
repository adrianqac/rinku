
package mx.com.rinku.app.model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian Vazquez
 */
@Entity
@Table(name = "crol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Crol.findAll", query = "SELECT c FROM Crol c"),
    @NamedQuery(name = "Crol.findByRolID", query = "SELECT c FROM Crol c WHERE c.rolID = :rolID"),
    @NamedQuery(name = "Crol.findByDescripcion", query = "SELECT c FROM Crol c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Crol.findByActivo", query = "SELECT c FROM Crol c WHERE c.activo = :activo")})
public class Crol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rolID")
    private Integer rolID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crol")
    private List<Dusuario> dusuarioList;

    public Crol() {
    }

    public Crol(Integer rolID) {
        this.rolID = rolID;
    }

    public Crol(Integer rolID, String descripcion, short activo) {
        this.rolID = rolID;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getRolID() {
        return rolID;
    }

    public void setRolID(Integer rolID) {
        this.rolID = rolID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<Dusuario> getDusuarioList() {
        return dusuarioList;
    }

    public void setDusuarioList(List<Dusuario> dusuarioList) {
        this.dusuarioList = dusuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolID != null ? rolID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crol)) {
            return false;
        }
        Crol other = (Crol) object;
        if ((this.rolID == null && other.rolID != null) || (this.rolID != null && !this.rolID.equals(other.rolID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.rinku.app.model.Crol[ rolID=" + rolID + " ]";
    }

}
