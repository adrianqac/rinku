
package mx.com.rinku.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrian Vazquez
 */
@Entity
@Table(name = "dmovimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dmovimiento.findAll", query = "SELECT d FROM Dmovimiento d"),
    @NamedQuery(name = "Dmovimiento.findByMovimientoID", query = "SELECT d FROM Dmovimiento d WHERE d.movimientoID = :movimientoID"),
    @NamedQuery(name = "Dmovimiento.findByFecha", query = "SELECT d FROM Dmovimiento d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "Dmovimiento.findByCantidadEntregas", query = "SELECT d FROM Dmovimiento d WHERE d.cantidadEntregas = :cantidadEntregas"),
    @NamedQuery(name = "Dmovimiento.findByCubrirTurno", query = "SELECT d FROM Dmovimiento d WHERE d.cubrirTurno = :cubrirTurno"),
    @NamedQuery(name = "Dmovimiento.findByActivo", query = "SELECT d FROM Dmovimiento d WHERE d.activo = :activo"),
    @NamedQuery(name = "Dmovimiento.findByUsuarioID", query = "SELECT d FROM Dmovimiento d WHERE d.usuarioID = :usuarioID")})
public class Dmovimiento implements Serializable {
    @Column(name = "tipoEmpleadoIDCubierto")
    private Integer tipoEmpleadoIDCubierto;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "movimientoID")
    private Integer movimientoID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "cantidadEntregas")
    private Integer cantidadEntregas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cubrirTurno")
    private boolean cubrirTurno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuarioID")
    private int usuarioID;

    public Dmovimiento() {
    }

    public Dmovimiento(Integer movimientoID) {
        this.movimientoID = movimientoID;
    }

    public Dmovimiento(Integer movimientoID, Date fecha, boolean cubrirTurno, short activo, int usuarioID) {
        this.movimientoID = movimientoID;
        this.fecha = fecha;
        this.cubrirTurno = cubrirTurno;
        this.activo = activo;
        this.usuarioID = usuarioID;
    }

    public Integer getMovimientoID() {
        return movimientoID;
    }

    public void setMovimientoID(Integer movimientoID) {
        this.movimientoID = movimientoID;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadEntregas() {
        return cantidadEntregas;
    }

    public void setCantidadEntregas(Integer cantidadEntregas) {
        this.cantidadEntregas = cantidadEntregas;
    }

    public boolean getCubrirTurno() {
        return cubrirTurno;
    }

    public void setCubrirTurno(boolean cubrirTurno) {
        this.cubrirTurno = cubrirTurno;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movimientoID != null ? movimientoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dmovimiento)) {
            return false;
        }
        Dmovimiento other = (Dmovimiento) object;
        if ((this.movimientoID == null && other.movimientoID != null) || (this.movimientoID != null && !this.movimientoID.equals(other.movimientoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.com.rinku.app.model.Dmovimiento[ movimientoID=" + movimientoID + " ]";
    }

    public Integer getTipoEmpleadoIDCubierto() {
        return tipoEmpleadoIDCubierto;
    }

    public void setTipoEmpleadoIDCubierto(Integer tipoEmpleadoIDCubierto) {
        this.tipoEmpleadoIDCubierto = tipoEmpleadoIDCubierto;
    }

}
