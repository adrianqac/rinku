
package mx.com.rinku.app.dao;

import java.util.List;
import mx.com.rinku.app.model.Dusuario;
/**
 *
 * @author Adrian Vazquez
 */
public interface UsuarioDao extends AbstractDao<Dusuario, Integer>
{    
    
    public Dusuario getUsuarioByUserName(String userName) throws Exception;
    
    public List<Dusuario> getEmpleados() throws Exception;
    
}
