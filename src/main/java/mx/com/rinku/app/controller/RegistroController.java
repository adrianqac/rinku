
package mx.com.rinku.app.controller;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import mx.com.rinku.app.form.RegistroForm;
import mx.com.rinku.app.service.RegistroService;
import mx.com.rinku.app.service.RolService;
import mx.com.rinku.app.service.TipoEmpleadoService;
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
public class RegistroController {
    
    @Autowired
    private RolService rolService;
    @Autowired
    private TipoEmpleadoService tipoEmpleadoService;
    @Autowired
    private RegistroService registroService;
    
    private Logger log = Logger.getLogger(this.getClass());
    private RegistroForm registroForm;
    
    public RegistroController(){
        this.registroForm = new RegistroForm();
    }
    
    @PostConstruct
    public void init(){
        try {
            this.registroForm.setRoles(this.rolService.getRolesDisponibles());
            this.registroForm.setTiposEmpleado(this.tipoEmpleadoService.getEmpleados());
        } catch (Exception e) {
            this.log.error("Error al cargar las listas: ", e);
        }
    }
    
    public void registrarPersona() {
        try
        {
//            this.registroService.registrarPersona(this.registroForm);
            this.registroForm.setRenderGrowl(true);
        } catch (Exception e)
        {
            log.error("Ocurrio un error inscribiendo a la persona ", e);
        }
    }
    
    public void redireccionarLogin()
    {
        try
        {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath());
        } catch (Exception e)
        {
            log.error("Ocurrio un error redireccionando: ", e);
        }

    }
    
    public RegistroForm getRegistroForm() {
        return registroForm;
    }

    public void setRegistroForm(RegistroForm registroForm) {
        this.registroForm = registroForm;
    }
    
}
