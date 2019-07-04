
package mx.com.rinku.app.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import mx.com.rinku.app.form.ConsultaMovimientosForm;
import mx.com.rinku.app.model.ConsultaMovimientosModel;
import mx.com.rinku.app.model.Dmovimiento;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.service.MessageService;
import mx.com.rinku.app.service.MovimientoService;
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
public class ConsultarMovimientosController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private MovimientoService movimientoService;
    @Autowired
    private UsuarioService usuarioService;

    private ConsultaMovimientosForm consultaMovimientosForm;
    private Logger log = Logger.getLogger(this.getClass());

    public ConsultarMovimientosController() {
        this.consultaMovimientosForm = new ConsultaMovimientosForm();
    }

    @PostConstruct
    public void init() {
        try {
            this.consultaMovimientosForm.setMovimientos(this.movimientoService.getAllMovimientos());
            List<ConsultaMovimientosModel> modelo = new ArrayList<ConsultaMovimientosModel>();
            for (Dmovimiento d : this.consultaMovimientosForm.getMovimientos()) {
                ConsultaMovimientosModel model = new ConsultaMovimientosModel();
                model.setFechaMovimiento(d.getFecha());
                model.setMovimientoID(d.getMovimientoID());
                Dusuario dusuario = usuarioService.getUsuarioByID(d.getUsuarioID());
                model.setUsuarioID(d.getUsuarioID());
                model.setNombre(dusuario.getNombre() + " " + dusuario.getAPaterno() + " " + dusuario.getAMaterno());
                modelo.add(model);
            }
            this.consultaMovimientosForm.setModelList(modelo);
        } catch (Exception e) {
            log.error("Error al llenar las listas", e);
        }
    }

    public void eliminarMovimiento() {
        try {
            Dmovimiento dmovimiento = this.movimientoService.getMovimientoByID(this.consultaMovimientosForm.getModelSelected().getMovimientoID());
            dmovimiento.setActivo(Constant.INACTIVO);
            this.movimientoService.guardarMovimiento(dmovimiento);
            this.init();
            this.messageService.addInfo("El movimiento se elimino correctamente", null);
        } catch (Exception e) {
            log.error("Error al intentar eliminar el movimiento", e);
            this.messageService.addError("Error al intentar eliminar el movimiento", null);
        }
    }

    public void clickModificar() {
        try {
            this.consultaMovimientosForm.setUsuario(this.usuarioService.getUsuarioByID(this.consultaMovimientosForm.getModelSelected().getUsuarioID()));
            this.consultaMovimientosForm.setMovimiento(this.movimientoService.getMovimientoByID(this.consultaMovimientosForm.getModelSelected().getMovimientoID()));
            this.consultaMovimientosForm.setFecha(this.consultaMovimientosForm.getMovimiento().getFecha());
        } catch (Exception e) {
        }

    }

    public void actualizarMovimiento() {
        try {
            this.consultaMovimientosForm.getMovimiento().setFecha(this.consultaMovimientosForm.getFecha());
            this.movimientoService.guardarMovimiento(this.consultaMovimientosForm.getMovimiento());
            this.init();
            this.messageService.addInfo("El movimiento se actualizó correctamente", null);
        } catch (Exception e) {
            log.error("Error al actualizar el movimiento:", e);
            this.messageService.addError("No se pudo actualizar el registro", null);
        }

    }

    public ConsultaMovimientosForm getConsultaMovimientosForm() {
        return consultaMovimientosForm;
    }

    public void setConsultaMovimientosForm(ConsultaMovimientosForm consultaMovimientosForm) {
        this.consultaMovimientosForm = consultaMovimientosForm;
    }

}
