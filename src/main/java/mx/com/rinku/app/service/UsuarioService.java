
package mx.com.rinku.app.service;

import java.util.List;
import mx.com.rinku.app.model.Dusuario;

/**
 *
 * @author Adrian Vazquez
 */
public interface UsuarioService {
    
    public String encondePasswdWithSha(String valor) throws Exception;
    
    public List<Dusuario> getEmpleados() throws Exception;
    
    public void saveUsuario(Dusuario dusuario) throws Exception;
    
    public Dusuario getUsuarioByID(Integer usuarioID) throws Exception;

}
