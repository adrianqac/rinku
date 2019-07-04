package mx.com.rinku.app.service;

import java.util.ArrayList;
import java.util.List;
import mx.com.rinku.app.dao.RolDao;
import mx.com.rinku.app.dao.UsuarioDao;
import mx.com.rinku.app.model.Actor;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.model.Rol;
import mx.com.rinku.app.util.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Adrian Vazquez
 */
public class AutenticacionServiceImpl implements UserDetailsService, AutenticacionService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private RolDao rolDao;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private MessageService messageService;
    private Logger log = Logger.getLogger(this.getClass());

    /**
     * spring: Realiza el match del usuario, clave introducida con el usuario,
     * clave disponible en BD
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Actor actor = new Actor();
        try {
            Dusuario usuario = this.usuarioDao.getUsuarioByUserName(username);
            List<Rol> roles = new ArrayList<Rol>();
            Rol r = new Rol();
            r.setActivo(1);
            r.setRol(usuario.getCrol().getDescripcion());
            roles.add(r);
            actor.setdUsuario(usuario);
            actor.getRoles().addAll(roles);
            this.sessionService.createSession(Constant.USUARIO_SESSION, usuario);
            this.sessionService.createSession(Constant.ROLES_SESSION, roles);
        } catch (Exception e) {
            this.log.error("Ha ocurrido un error en la autenticación", e);
            this.messageService.addError("Error el la autenticación", " Ha ocurrido un error en la autenticación");
        }
        return actor;
    }

    /**
     * Eliminar los datos del usuario
     */
    public void removeSessionUser() {
        try {
            this.sessionService.removeObjectFromSession(Constant.USUARIO_SESSION);
        } catch (Exception e) {
            this.log.error("Ha ocurrido un error al dar de baja la session del usuario", e);
        }
    }
}
