
package mx.com.rinku.app.model;

import java.util.Date;

/**
 *
 * @author Adrian Vazquez
 */
public class ConsultaMovimientosModel {
    
    private Integer usuarioID;
    private String nombre;
    private Date fechaMovimiento;
    private Integer movimientoID;
    
    public ConsultaMovimientosModel(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Integer getMovimientoID() {
        return movimientoID;
    }

    public void setMovimientoID(Integer movimientoID) {
        this.movimientoID = movimientoID;
    }

    public Integer getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(Integer usuarioID) {
        this.usuarioID = usuarioID;
    }

}
