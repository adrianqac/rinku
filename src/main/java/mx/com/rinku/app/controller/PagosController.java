
package mx.com.rinku.app.controller;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import mx.com.rinku.app.form.PagosForm;
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
public class PagosController {
    
    @Autowired
    private MessageService messageService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MovimientoService movimientoService;
    
    private PagosForm pagosForm;
    private Logger log = Logger.getLogger(this.getClass());
    
    public PagosController(){
        this.pagosForm = new PagosForm();
    }
    
    @PostConstruct
    public void init(){
        try {
            //cargamos los usuarios
            this.pagosForm.setUsuarios(this.usuarioService.getEmpleados());
        } catch (Exception e) {
            log.error("Error al cargar las listas iniciales", e);
        }
    }
    
    public void calcularPago() {
        try {
            
            this.pagosForm.setMovimientos(this.movimientoService.movimientosByUsuarioIDAndFechas(
                    this.pagosForm.getUsuarioSelected().getUsuarioID(),
                    this.pagosForm.getFechaInicial(),
                    this.pagosForm.getFechaFinal())
            );            
            this.calcularSueldoBase();
            
            //Los trabajadores se les paga $5 por cada entrega que hagan al cliente.            
            int cantidadDeEntregas = 0;
            for(Dmovimiento d : this.pagosForm.getMovimientos()){
                cantidadDeEntregas += d.getCantidadEntregas();
            }
            this.pagosForm.setSueldoBase( (cantidadDeEntregas * 5) + this.pagosForm.getSueldoBase() ); 
            
            
            //Los choferes reciben $10 de bono por hora 
            if(this.pagosForm.getUsuarioSelected().getCrol().getRolID() == Constant.ID_CHOFER ) {
                this.pagosForm.setSueldoBase( (this.pagosForm.getDiasLaborados() * 8) * 10 );
            }
            //Los cargadores reciben $5 de bono por hora 
            else if(this.pagosForm.getUsuarioSelected().getCrol().getRolID() == Constant.ID_CARGADOR) {
                this.pagosForm.setSueldoBase( (this.pagosForm.getDiasLaborados() * 8) * 5 );
            }
            //Los trabajadores auxiliares pueden cubrir a los choferes y cargadores en caso de falta, recibiran el bono correspondiente
            else if(this.pagosForm.getUsuarioSelected().getCrol().getRolID() == Constant.ID_AUXILIAR) {
                int sueldoAuxiliar = 0;
                for(Dmovimiento d : this.pagosForm.getMovimientos()){
                    if(d.getTipoEmpleadoIDCubierto() == Constant.ID_CHOFER){
                        //El empleado cubrió a un chofer
                        sueldoAuxiliar += 10;
                    } else if(d.getTipoEmpleadoIDCubierto() == Constant.ID_CARGADOR) {
                        //El empleado cubrió a un cargador
                        sueldoAuxiliar += 5;
                    }
                }
                this.pagosForm.setSueldoBase(sueldoAuxiliar);
            }
            
            //Los empleados reciben un 4% en vales de despensa antes de impuestos
            double d = (this.pagosForm.getSueldoBase() * 4) ;
            this.pagosForm.setValesDespensa(d/100);
            
            //Se retiene a todos los empleados un 9% de ISR y si sobrepasan los $16,000 se les retiene un 3% adicional            
            if(this.pagosForm.getSueldoBase() >= 16000){
                double isr = (this.pagosForm.getSueldoBase() * 12)/100;
                this.getPagosForm().setSueldoTotal( this.pagosForm.getSueldoBase().doubleValue() - isr );
            } else {
                double isr = (this.pagosForm.getSueldoBase() * 9)/100;
                this.getPagosForm().setSueldoTotal( this.pagosForm.getSueldoBase().doubleValue() - isr );
            }
            
            
            this.pagosForm.setRenderPagos(true);
        } catch (Exception e) {
            this.messageService.addError("Error al intentar calcular el pago", null);
            log.error("Error al intentar calcualar el pago", e);
        }
    }
    
    public void calcularSueldoBase(){
        Calendar fi = Calendar.getInstance();
        Calendar ff = Calendar.getInstance();
        fi.setTime(this.pagosForm.getFechaInicial());
        ff.setTime(this.pagosForm.getFechaFinal());        
        int dias = 0;        
        
        while(fi.compareTo(ff) <= 0){
            dias += 1;
            fi.add(Calendar.DATE, 1);
        }
        
        this.pagosForm.setSueldoBase(dias * 240); // 240 se obtiene al multiplicar $30 por 8 horas
        this.pagosForm.setDiasLaborados(dias);
    }
    
    public void cerrarDialog(){
        this.pagosForm.setRenderPagos(false);
        this.pagosForm.setFechaFinal(new Date());
        this.pagosForm.setFechaInicial(new Date());
    }

    public PagosForm getPagosForm() {
        return pagosForm;
    }

    public void setPagosForm(PagosForm pagosForm) {
        this.pagosForm = pagosForm;
    }

}
