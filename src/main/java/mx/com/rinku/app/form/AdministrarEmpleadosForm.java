
package mx.com.rinku.app.form;

import java.util.ArrayList;
import java.util.List;
import mx.com.rinku.app.model.Crol;
import mx.com.rinku.app.model.Ctipoempleado;
import mx.com.rinku.app.model.Dusuario;

/**
 *
 * @author Adrian Vazquez
 */
public class AdministrarEmpleadosForm {
    
    private String titulo;
    private boolean nuevo;
    private Dusuario usuarioSelected;
    private List<Dusuario> usuarios;
    private String nombre;
    private String aPaterno;
    private String aMaterno;
    private Crol rol;
    private List<Crol> roles;
    private Ctipoempleado tipoempleado;
    private List<Ctipoempleado> tiposEmpleadoList;
    private String usuarioGenerado;
    private String passwordGenerado;
    private boolean renderGrowl;
    
    
    public AdministrarEmpleadosForm(){
        this.usuarioSelected = new Dusuario();
        this.usuarios = new ArrayList<Dusuario>();
        this.rol = new Crol();
        this.roles = new ArrayList<Crol>();
        this.tipoempleado = new Ctipoempleado();
        this.tiposEmpleadoList = new ArrayList<Ctipoempleado>();
    }

    public List<Dusuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Dusuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Dusuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Dusuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getaPaterno() {
        return aPaterno;
    }

    public void setaPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getaMaterno() {
        return aMaterno;
    }

    public void setaMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public Crol getRol() {
        return rol;
    }

    public void setRol(Crol rol) {
        this.rol = rol;
    }

    public List<Crol> getRoles() {
        return roles;
    }

    public void setRoles(List<Crol> roles) {
        this.roles = roles;
    }

    public Ctipoempleado getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(Ctipoempleado tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public List<Ctipoempleado> getTiposEmpleadoList() {
        return tiposEmpleadoList;
    }

    public void setTiposEmpleadoList(List<Ctipoempleado> tiposEmpleadoList) {
        this.tiposEmpleadoList = tiposEmpleadoList;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public String getUsuarioGenerado() {
        return usuarioGenerado;
    }

    public void setUsuarioGenerado(String usuarioGenerado) {
        this.usuarioGenerado = usuarioGenerado;
    }

    public String getPasswordGenerado() {
        return passwordGenerado;
    }

    public void setPasswordGenerado(String passwordGenerado) {
        this.passwordGenerado = passwordGenerado;
    }

    public boolean isRenderGrowl() {
        return renderGrowl;
    }

    public void setRenderGrowl(boolean renderGrowl) {
        this.renderGrowl = renderGrowl;
    }
    
    
}
