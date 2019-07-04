
package mx.com.rinku.app.service;

import java.util.List;
import mx.com.rinku.app.dao.UsuarioDao;
import mx.com.rinku.app.model.Dusuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioDao usuarioDao;
    
    public String encondePasswdWithSha(String valor) throws Exception {
        ShaPasswordEncoder sha = new ShaPasswordEncoder();
        valor = sha.encodePassword(valor, null);
        return valor;
    }

    public List<Dusuario> getEmpleados() throws Exception {
        return this.usuarioDao.getEmpleados();
    }

    public void saveUsuario(Dusuario dusuario) throws Exception {
        this.usuarioDao.saveOrUpdate(dusuario);
    }

    public Dusuario getUsuarioByID(Integer usuarioID) {
        return this.usuarioDao.findById(usuarioID);
    }


}
