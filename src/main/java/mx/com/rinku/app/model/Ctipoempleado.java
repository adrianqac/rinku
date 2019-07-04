
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
@Table(name = "ctipoempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ctipoempleado.findAll", query = "SELECT c FROM Ctipoempleado c"),
    @NamedQuery(name = "Ctipoempleado.findByTipoEmpleadoID", query = "SELECT c FROM Ctipoempleado c WHERE c.tipoEmpleadoID = :tipoEmpleadoID"),
    @NamedQuery(name = "Ctipoempleado.findByDescripcion", query = "SELECT c FROM Ctipoempleado c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "Ctipoempleado.findByActivo", query = "SELECT c FROM Ctipoempleado c WHERE c.activo = :activo")})
public class Ctipoempleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoEmpleadoID")
    private Integer tipoEmpleadoID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ctipoempleado")
    private List<Dusuario> dusuarioList;

    public Ctipoempleado() {
    }

    public Ctipoempleado(Integer tipoEmpleadoID) {
        this.tipoEmpleadoID = tipoEmpleadoID;
    }

    public Ctipoempleado(Integer tipoEmpleadoID, String descripcion, short activo) {
        this.tipoEmpleadoID = tipoEmpleadoID;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Integer getTipoEmpleadoID() {
        return tipoEmpleadoID;
    }

    public void setTipoEmpleadoID(Integer tipoEmpleadoID) {
        this.tipoEmpleadoID = tipoEmpleadoID;
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
        hash += (tipoEmpleadoID != null ? tipoEmpleadoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ctipoempleado)) {
            return false;
        }
        Ctipoempleado other = (Ctipoempleado) object;
        if ((this.tipoEmpleadoID == null && other.tipoEmpleadoID != null) || (this.tipoEmpleadoID != null && !this.tipoEmpleadoID.equals(other.tipoEmpleadoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.rinku.app.model.Ctipoempleado[ tipoEmpleadoID=" + tipoEmpleadoID + " ]";
    }

}
