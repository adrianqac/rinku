
package mx.com.rinku.app.service;

import java.util.List;
import mx.com.rinku.app.model.Crol;

/**
 *
 * @author Adrian Vazquez
 */
public interface RolService {
    
    public List<Crol> getRolesDisponibles() throws Exception;

}
