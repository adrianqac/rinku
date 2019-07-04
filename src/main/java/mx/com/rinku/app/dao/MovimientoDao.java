
package mx.com.rinku.app.dao;

import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.Dmovimiento;

/**
 *
 * @author Adrian Vazquez
 */
public interface MovimientoDao extends AbstractDao<Dmovimiento, Integer> {
    
    public List<Dmovimiento> movimientosByUsuarioIDAndFechas(Integer usuarioID, Date fechaInicial, Date fechafinal) throws Exception;

}
