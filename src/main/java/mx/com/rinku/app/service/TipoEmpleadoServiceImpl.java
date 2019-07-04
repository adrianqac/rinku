
package mx.com.rinku.app.service;

import java.util.List;
import mx.com.rinku.app.dao.TipoEmpleadoDao;
import mx.com.rinku.app.model.Ctipoempleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class TipoEmpleadoServiceImpl implements TipoEmpleadoService {
    
    @Autowired
    private TipoEmpleadoDao tipoEmpleadoDao;

    public List<Ctipoempleado> getEmpleados() throws Exception {
        return this.tipoEmpleadoDao.getAll();
    }

}
