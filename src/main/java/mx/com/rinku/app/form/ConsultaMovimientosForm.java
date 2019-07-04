
package mx.com.rinku.app.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.ConsultaMovimientosModel;
import mx.com.rinku.app.model.Dmovimiento;
import mx.com.rinku.app.model.Dusuario;

/**
 *
 * @author Adrian Vazquez
 */
public class ConsultaMovimientosForm {
    
    private List<ConsultaMovimientosModel> modelList;
    private ConsultaMovimientosModel modelSelected;
    private List<Dmovimiento> movimientos;
    private Dusuario usuario;
    private Dmovimiento movimiento;
    private Date fechaActual;
    
    private Date fecha;
    
    public ConsultaMovimientosForm(){
        this.modelList = new ArrayList<ConsultaMovimientosModel>();
        this.movimientos = new ArrayList<Dmovimiento>();
        this.modelSelected = new ConsultaMovimientosModel();
        this.usuario = new Dusuario();
        this.movimiento = new Dmovimiento();
        this.fechaActual = new Date();
        
    }

    public List<Dmovimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Dmovimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    public List<ConsultaMovimientosModel> getModelList() {
        return modelList;
    }

    public void setModelList(List<ConsultaMovimientosModel> modelList) {
        this.modelList = modelList;
    }

    public ConsultaMovimientosModel getModelSelected() {
        return modelSelected;
    }

    public void setModelSelected(ConsultaMovimientosModel modelSelected) {
        this.modelSelected = modelSelected;
    }

    public Dusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Dusuario usuario) {
        this.usuario = usuario;
    }

    public Dmovimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Dmovimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
        
    
}
