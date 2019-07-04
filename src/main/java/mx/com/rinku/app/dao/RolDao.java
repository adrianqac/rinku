
package mx.com.rinku.app.dao;

import java.util.List;
import mx.com.rinku.app.model.Crol;
/**
 *
 * @author Adrian Vazquez
 */
public interface RolDao extends AbstractDao<Crol, Integer> {
    
    public List<Crol> getRolesDisponibles() throws Exception;
    
}
