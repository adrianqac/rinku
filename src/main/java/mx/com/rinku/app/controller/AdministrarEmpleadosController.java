package mx.com.rinku.app.controller;

import javax.annotation.PostConstruct;
import mx.com.rinku.app.form.AdministrarEmpleadosForm;
import mx.com.rinku.app.model.Crol;
import mx.com.rinku.app.model.Ctipoempleado;
import mx.com.rinku.app.service.MessageService;
import mx.com.rinku.app.service.RegistroService;
import mx.com.rinku.app.service.RolService;
import mx.com.rinku.app.service.TipoEmpleadoService;
import mx.com.rinku.app.service.UsuarioService;
import mx.com.rinku.app.util.Constant;
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
public class AdministrarEmpleadosController {
    
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private TipoEmpleadoService tipoEmpleadoService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private RegistroService registroService;
    
    private AdministrarEmpleadosForm administrarEmpleadosForm;
    private Logger log = Logger.getLogger(this.getClass());
    
    public AdministrarEmpleadosController(){
        this.administrarEmpleadosForm = new AdministrarEmpleadosForm();
    }
    
    @PostConstruct
    public void init(){
        try {
            //LLenamos las listas inciales
            this.administrarEmpleadosForm.setUsuarios(this.usuarioService.getEmpleados());
            this.administrarEmpleadosForm.setRoles(this.rolService.getRolesDisponibles());
            this.administrarEmpleadosForm.setTiposEmpleadoList(this.tipoEmpleadoService.getEmpleados());
        } catch (Exception e) {
            log.error("Ocurrió un error al obtener la lista de empelados:", e);
        }
    }
    
    //metodo que elimina logicamente el empleado, sigue existiendo en base de datos para contar el registro
    //pero ya no es visible para la consulta
    public void eliminarEmpleado(){
        try {
            this.administrarEmpleadosForm.getUsuarioSelected().setActivo(Constant.INACTIVO);
            this.usuarioService.saveUsuario(this.administrarEmpleadosForm.getUsuarioSelected());
            this.init();
            this.messageService.addInfo("El empleado se eliminó correctamente", null);
        } catch (Exception e) {
            log.error("Error: no se pudo eliminiar el usuario.", e);
            this.messageService.addInfo("Error: El empleado no se pudo eliminar", null);
        }
    }
    
    //método para modificar usuario
    public void clickModificar(){
        this.administrarEmpleadosForm.setNuevo(false);
        this.administrarEmpleadosForm.setTitulo("Modificar Empleado");
        this.administrarEmpleadosForm.setNombre(this.administrarEmpleadosForm.getUsuarioSelected().getNombre());
        this.administrarEmpleadosForm.setaPaterno(this.administrarEmpleadosForm.getUsuarioSelected().getAPaterno());
        this.administrarEmpleadosForm.setaMaterno(this.administrarEmpleadosForm.getUsuarioSelected().getAMaterno());
        this.administrarEmpleadosForm.setRol(this.administrarEmpleadosForm.getUsuarioSelected().getCrol());
        this.administrarEmpleadosForm.setTipoempleado(this.administrarEmpleadosForm.getUsuarioSelected().getCtipoempleado());
    }
    
    public void clickAgregar(){
        this.administrarEmpleadosForm.setNuevo(true);
        this.administrarEmpleadosForm.setTitulo("Agregar Empleado"); //seteamos el titulo
        this.administrarEmpleadosForm.setNombre("");
        this.administrarEmpleadosForm.setaPaterno("");
        this.administrarEmpleadosForm.setaMaterno("");
        this.administrarEmpleadosForm.setRol(new Crol(1));
        this.administrarEmpleadosForm.setTipoempleado(new Ctipoempleado(1));
    }
    
    public void actualizarEmpleado(){
        try {
            this.administrarEmpleadosForm.getUsuarioSelected().setNombre(this.administrarEmpleadosForm.getNombre());
            this.administrarEmpleadosForm.getUsuarioSelected().setAPaterno(this.administrarEmpleadosForm.getaPaterno());
            this.administrarEmpleadosForm.getUsuarioSelected().setAMaterno(this.administrarEmpleadosForm.getaMaterno());
            this.administrarEmpleadosForm.getUsuarioSelected().setCrol(new Crol(this.administrarEmpleadosForm.getRol().getRolID()));
            this.administrarEmpleadosForm.getUsuarioSelected().setCtipoempleado(new Ctipoempleado(this.administrarEmpleadosForm.getTipoempleado().getTipoEmpleadoID()));
            this.usuarioService.saveUsuario(this.administrarEmpleadosForm.getUsuarioSelected());
            this.administrarEmpleadosForm.setUsuarios(this.usuarioService.getEmpleados());
            this.messageService.addInfo("El empleado se actualizó correctamente", null);
        } catch (Exception e) {
            log.error("Error al modificar el usuario: ", e);
            this.messageService.addError("Error: El empleado no pudo ser actualizado", null);
        }
    }    
    
    public void registrarPersona() {
        try
        {
            this.registroService.registrarPersona(this.administrarEmpleadosForm);
            this.init();
            this.administrarEmpleadosForm.setRenderGrowl(true);
        } catch (Exception e)
        {
            log.error("Ocurrio un error inscribiendo a la persona ", e);
        }
    }
    
    public void cerrarDialog(){
        this.administrarEmpleadosForm.setRenderGrowl(false);
    }
    
    public void guardarEmpleado(){
        try {
            if(this.administrarEmpleadosForm.isNuevo()){ //si es nuevo registra a la persona, en caso contrario actualiza el registro
                this.registrarPersona();
            } else {
                this.actualizarEmpleado();
            }
        } catch (Exception e) {
            this.log.error("Error al registrar o modificar a la persona", e);
            this.messageService.addError("Error: no se pudo completar la petición", null);
        }
    }

    public AdministrarEmpleadosForm getAdministrarEmpleadosForm() {
        return administrarEmpleadosForm;
    }
    
   
}
