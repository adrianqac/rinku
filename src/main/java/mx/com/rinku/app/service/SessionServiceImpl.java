
package mx.com.rinku.app.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.util.Constant;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class SessionServiceImpl implements SessionService
{

    /**
     * Subir objeto a session
     *
     * @param nameSession
     * @param objectOnSession
     * @throws Exception
     */
    public void createSession(String nameSession, Object objectOnSession) throws Exception
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(true);
        httpSession.setAttribute(nameSession, objectOnSession);
    }

    /**
     * Obtener la session
     *
     * @param nameSession
     * @return
     */
    public Object getSessionFromContext(String nameSession) throws Exception
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(true);
        Object session = httpSession.getAttribute(nameSession);
        return session;
    }

    /**
     * Baja el objeto de la session
     *
     * @param nameSession
     * @throws Exception
     */
    public void removeObjectFromSession(String nameSession) throws Exception
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(true);
        httpSession.removeAttribute(nameSession);
    }

    /**
     * Bajar de la sesión al objecto usuario
     *
     * @return
     * @throws Exception
     */
    public Dusuario getUsuarioFromSession() throws Exception
    {
        Dusuario usuario = (Dusuario) this.getSessionFromContext(Constant.USUARIO_SESSION);
        return usuario;
    }

    public String getNombreUsuario() throws Exception
    {
        Dusuario usuario = this.getUsuarioFromSession();
        return usuario.getNombre() + " " + usuario.getAPaterno() + " " + usuario.getAMaterno();
    }
    
}
