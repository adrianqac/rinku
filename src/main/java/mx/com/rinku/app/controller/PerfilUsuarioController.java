
package mx.com.rinku.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.model.Rol;
import mx.com.rinku.app.service.MessageService;
import mx.com.rinku.app.service.SessionService;
import mx.com.rinku.app.util.Constant;
import mx.com.rinku.app.util.PerfilEnumeration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Adrian Vazquez
 */
@Controller
@Scope(value = "view")
public class PerfilUsuarioController
{

    @Autowired
    private SessionService sessionService;
    @Autowired
    private MessageService messageService;
    private Logger log = Logger.getLogger(this.getClass());
    private Dusuario usuario;
    private List<Rol> roles;
    private boolean renderPanel;
    
    @PostConstruct
    public void init()
    {
        try
        {
            this.roles = (List<Rol>) this.sessionService.getSessionFromContext(Constant.ROLES_SESSION);
            this.usuario = this.sessionService.getUsuarioFromSession();
            this.roles = this.roles == null ? new ArrayList<Rol>() : this.roles;
            this.renderPanel = !this.roles.isEmpty();
        } catch (Exception e)
        {
            this.log.error("Error en PerfilUsuarioController: ", e);
            this.messageService.addError("Error en PerfilUsuarioController: ", "Ocurrio un error en el controlador de perfiles del usuario");
        }
    }

    public void checkAlarms()
    {
        try
        {
        } catch (Exception e)
        {
            log.error("Ocurrio un error en la notificacion", e);
        }
    }

    public boolean getPerfilAdmin()
    {
        boolean user = this.roles.contains(new Rol(PerfilEnumeration.ROL_ADMINISTRADOR.getConstante()));
        return user;
    }
    
    public boolean getPerfilChofer() 
    {
        boolean user = this.roles.contains(new Rol(PerfilEnumeration.ROL_CHOFER.getConstante()));
        return user;
    }

    /**
     * @return the usuario
     */
    public Dusuario getUsuario()
    {
        return usuario;
    }

    public boolean isRenderPanel() {
        return renderPanel;
    }
    
    

}
