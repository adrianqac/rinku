
package mx.com.rinku.app.service;

import java.util.List;
import mx.com.rinku.app.dao.RolDao;
import mx.com.rinku.app.model.Crol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class RolServiceImpl implements RolService {
    
    @Autowired
    private RolDao rolDao;

    public List<Crol> getRolesDisponibles() throws Exception {
        return this.rolDao.getRolesDisponibles();
    }
    
    

}
