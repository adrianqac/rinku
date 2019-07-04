
package mx.com.rinku.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrian Vazquez
 */
@Entity
@Table(name = "dusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dusuario.findAll", query = "SELECT d FROM Dusuario d"),
    @NamedQuery(name = "Dusuario.findByUsuarioID", query = "SELECT d FROM Dusuario d WHERE d.usuarioID = :usuarioID"),
    @NamedQuery(name = "Dusuario.findByTipoEmpleadoID", query = "SELECT d FROM Dusuario d WHERE d.ctipoempleado.tipoEmpleadoID = :tipoEmpleadoID"),
    @NamedQuery(name = "Dusuario.findByRolID", query = "SELECT d FROM Dusuario d WHERE d.crol.rolID = :rolID"),
    @NamedQuery(name = "Dusuario.findByNombreUsuario", query = "SELECT d FROM Dusuario d WHERE d.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "Dusuario.findByPassword", query = "SELECT d FROM Dusuario d WHERE d.password = :password"),
    @NamedQuery(name = "Dusuario.findByFechaRegistro", query = "SELECT d FROM Dusuario d WHERE d.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Dusuario.findByAPaterno", query = "SELECT d FROM Dusuario d WHERE d.aPaterno = :aPaterno"),
    @NamedQuery(name = "Dusuario.findByAMaterno", query = "SELECT d FROM Dusuario d WHERE d.aMaterno = :aMaterno"),
    @NamedQuery(name = "Dusuario.findByNombre", query = "SELECT d FROM Dusuario d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dusuario.findByActivo", query = "SELECT d FROM Dusuario d WHERE d.activo = :activo")})
public class Dusuario implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioID")
    private List<Dmovimiento> dmovimientoList;
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioID")
    private int usuarioID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "aPaterno")
    private String aPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "aMaterno")
    private String aMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;
    @JoinColumn(name = "rolID", referencedColumnName = "rolID")
    @ManyToOne(optional = false)
    private Crol crol;
    @JoinColumn(name = "tipoEmpleadoID", referencedColumnName = "tipoEmpleadoID")
    @ManyToOne(optional = false)
    private Ctipoempleado ctipoempleado;

    public Dusuario() {
    }

    public Dusuario(int usuarioID, String nombreUsuario, String password, Date fechaRegistro, String aPaterno, String aMaterno, String nombre, short activo) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.nombre = nombre;
        this.activo = activo;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public Crol getCrol() {
        return crol;
    }

    public void setCrol(Crol crol) {
        this.crol = crol;
    }

    public Ctipoempleado getCtipoempleado() {
        return ctipoempleado;
    }

    public void setCtipoempleado(Ctipoempleado ctipoempleado) {
        this.ctipoempleado = ctipoempleado;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    @XmlTransient
    public List<Dmovimiento> getDmovimientoList() {
        return dmovimientoList;
    }

    public void setDmovimientoList(List<Dmovimiento> dmovimientoList) {
        this.dmovimientoList = dmovimientoList;
    }


}
