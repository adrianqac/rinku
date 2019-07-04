
package mx.com.rinku.app.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.Dusuario;

/**
 *
 * @author Adrian Vazquez
 */
public class MovimientosForm {
    
    private List<Dusuario> usuarios;
    private Dusuario usuarioSelected;
    private Date fechaActual;
    private Date fecha;
    private Integer cantidadEntregas;
    private boolean cubrioTurno;
    private int tipoEmpleadoID;
    
    public MovimientosForm(){
        this.usuarios = new ArrayList<Dusuario>();
        this.usuarioSelected = new Dusuario();
        this.fecha = new Date();
        this.fechaActual = new Date();
        this.cantidadEntregas = 0;
        this.tipoEmpleadoID = 2;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Integer getCantidadEntregas() {
        return cantidadEntregas;
    }

    public void setCantidadEntregas(Integer cantidadEntregas) {
        this.cantidadEntregas = cantidadEntregas;
    }

    public boolean isCubrioTurno() {
        return cubrioTurno;
    }

    public void setCubrioTurno(boolean cubrioTurno) {
        this.cubrioTurno = cubrioTurno;
    }

    public int getTipoEmpleadoID() {
        return tipoEmpleadoID;
    }

    public void setTipoEmpleadoID(int tipoEmpleadoID) {
        this.tipoEmpleadoID = tipoEmpleadoID;
    }

}
