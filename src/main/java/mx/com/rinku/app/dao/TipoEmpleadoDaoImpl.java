
package mx.com.rinku.app.dao;

import mx.com.rinku.app.model.Ctipoempleado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Adrian Vazquez
 */
@Repository
@Transactional
public class TipoEmpleadoDaoImpl extends AbstractDaoImpl<Ctipoempleado, Integer> implements TipoEmpleadoDao {

    public TipoEmpleadoDaoImpl() {
        super(Ctipoempleado.class);
    }

}
