
package mx.com.rinku.app.controller;

import javax.annotation.PostConstruct;
import mx.com.rinku.app.form.MovimientosForm;
import mx.com.rinku.app.model.Dmovimiento;
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
public class MovimientosController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MovimientoService movimientoService;

    private MovimientosForm movimientosForm;
    private Logger log = Logger.getLogger(this.getClass());

    public MovimientosController() {
        this.movimientosForm = new MovimientosForm();
    }

    @PostConstruct
    public void init() {
        try {
            this.movimientosForm.setUsuarios(this.usuarioService.getEmpleados());
        } catch (Exception e) {
            log.error("Error al llenar las listas", e);
        }
    }

    public void resetValues() {
        this.movimientosForm.setCantidadEntregas(0);
        this.movimientosForm.setTipoEmpleadoID(2);
        this.movimientosForm.setCubrioTurno(false);
    }

    public void guardarMovimiento() {
        try {
            if (this.movimientosForm.getCantidadEntregas() <= 0) {
                this.messageService.addError("Necesita capturar al menos una cantidad de entrega", null);
            } else {
                Dmovimiento movimiento = new Dmovimiento();
                movimiento.setActivo(Constant.ACTIVO);
                movimiento.setCantidadEntregas(this.movimientosForm.getCantidadEntregas());
                movimiento.setCubrirTurno(this.movimientosForm.isCubrioTurno());
                movimiento.setTipoEmpleadoIDCubierto(this.movimientosForm.getTipoEmpleadoID());
                movimiento.setFecha(this.movimientosForm.getFecha());
                movimiento.setUsuarioID(this.movimientosForm.getUsuarioSelected().getUsuarioID());
                this.movimientoService.guardarMovimiento(movimiento);
                this.messageService.addInfo("El movimiento se guardó exitosamente", null);
            }
        } catch (Exception e) {
            log.error("Ocurrió un error al guardar el mobimiento", e);
            this.messageService.addError("Ocurrió un error al guardar el movimiento", null);
        }

    }

    public MovimientosForm getMovimientosForm() {
        return movimientosForm;
    }

    public void setMovimientosForm(MovimientosForm movimientosForm) {
        this.movimientosForm = movimientosForm;
    }

}
