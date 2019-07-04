
package mx.com.rinku.app.service;

import java.util.Date;
import java.util.List;
import mx.com.rinku.app.dao.MovimientoDao;
import mx.com.rinku.app.model.Dmovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class MovimientoServiceImpl implements MovimientoService {
    
    @Autowired
    private MovimientoDao movimientoDao;

    public void guardarMovimiento(Dmovimiento dmovimiento) throws Exception {
        this.movimientoDao.saveOrUpdate(dmovimiento);
    }

    public List<Dmovimiento> getAllMovimientos() throws Exception {
        return this.movimientoDao.getAll();
    }

    public Dmovimiento getMovimientoByID(int movimientoID) throws Exception {
        return this.movimientoDao.findById(movimientoID);
    }

    public List<Dmovimiento> movimientosByUsuarioIDAndFechas(Integer usuarioID, Date fechaInicial, Date fechafinal) throws Exception {
        return this.movimientoDao.movimientosByUsuarioIDAndFechas(usuarioID, fechaInicial, fechafinal);
    }

}
