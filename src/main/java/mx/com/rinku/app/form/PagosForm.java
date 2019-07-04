
package mx.com.rinku.app.form;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.Dmovimiento;
import mx.com.rinku.app.model.Dusuario;

/**
 *
 * @author Adrian Vazquez
 */
public class PagosForm {
    
    private List<Dusuario> usuarios;
    private Dusuario usuarioSelected;
    private Date fechaInicial;
    private Date fechaFinal;
    private Date fechaActual;
    private boolean renderPagos;    
    private Integer diasLaborados;
    private Integer sueldoBase;
    private List<Dmovimiento> movimientos;
    private Double sueldoTotal;
    private Double valesDespensa;
    
    public PagosForm(){
        this.usuarios = new ArrayList<Dusuario>();
        this.movimientos = new ArrayList<Dmovimiento>();
        this.usuarioSelected = new Dusuario();
        this.fechaInicial = new Date();
        this.fechaFinal = new Date();
        this.fechaActual = new Date();
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

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public boolean isRenderPagos() {
        return renderPagos;
    }

    public void setRenderPagos(boolean renderPagos) {
        this.renderPagos = renderPagos;
    }

    public Integer getDiasLaborados() {
        return diasLaborados;
    }

    public void setDiasLaborados(Integer diasLaborados) {
        this.diasLaborados = diasLaborados;
    }

    public Integer getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(Integer sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public List<Dmovimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Dmovimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public Double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(Double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    public Double getValesDespensa() {
        return valesDespensa;
    }

    public void setValesDespensa(Double valesDespensa) {
        this.valesDespensa = valesDespensa;
    }
    
    
}
