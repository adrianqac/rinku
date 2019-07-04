

package mx.com.rinku.app.service;

import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.Dmovimiento;

/**
 *
 * @author Adrian Vazquez
 */
public interface MovimientoService {
    
    public void guardarMovimiento(Dmovimiento dmovimiento) throws Exception;
    
    public List<Dmovimiento> getAllMovimientos() throws Exception;
    
    public Dmovimiento getMovimientoByID(int movimientoID) throws Exception;
    
    public List<Dmovimiento> movimientosByUsuarioIDAndFechas(Integer usuarioID, Date fechaInicial, Date fechafinal) throws Exception;

}
