
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
public class RegistroForm {;
    
    private Dusuario usuario;
    private Crol rolSelected;
    private Ctipoempleado tipoEmpleadoSelected;
    private List<Crol> roles;
    private List<Ctipoempleado> tiposEmpleado;
    private String usuarioGenerado;
    private String contraseniaGenerada;
    private boolean renderGrowl;
    
    public RegistroForm(){
        this.usuario = new Dusuario();
        this.rolSelected = new Crol();
        this.tipoEmpleadoSelected = new Ctipoempleado();
        this.tiposEmpleado = new ArrayList<Ctipoempleado>();
        this.roles = new ArrayList<Crol>();
    }

    public Dusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Dusuario usuario) {
        this.usuario = usuario;
    }

    public boolean isRenderGrowl() {
        return renderGrowl;
    }

    public void setRenderGrowl(boolean renderGrowl) {
        this.renderGrowl = renderGrowl;
    }

    public List<Crol> getRoles() {
        return roles;
    }

    public void setRoles(List<Crol> roles) {
        this.roles = roles;
    }

    public List<Ctipoempleado> getTiposEmpleado() {
        return tiposEmpleado;
    }

    public void setTiposEmpleado(List<Ctipoempleado> tiposEmpleado) {
        this.tiposEmpleado = tiposEmpleado;
    }

    public Crol getRolSelected() {
        return rolSelected;
    }

    public void setRolSelected(Crol rolSelected) {
        this.rolSelected = rolSelected;
    }

    public Ctipoempleado getTipoEmpleadoSelected() {
        return tipoEmpleadoSelected;
    }

    public void setTipoEmpleadoSelected(Ctipoempleado empleadoSelected) {
        this.tipoEmpleadoSelected = empleadoSelected;
    }        

    public String getUsuarioGenerado() {
        return usuarioGenerado;
    }

    public void setUsuarioGenerado(String usuarioGenerado) {
        this.usuarioGenerado = usuarioGenerado;
    }

    public String getContraseniaGenerada() {
        return contraseniaGenerada;
    }

    public void setContraseniaGenerada(String contraseniaGenerada) {
        this.contraseniaGenerada = contraseniaGenerada;
    }

    
}
