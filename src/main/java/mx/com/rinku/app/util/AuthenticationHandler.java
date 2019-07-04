package mx.com.rinku.app.util;


import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.rinku.app.service.MessageService;
import mx.com.rinku.app.service.SessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
/**
 *
 * @author Adrian Vazquez
 */
public class AuthenticationHandler extends SimpleUrlAuthenticationFailureHandler
{

    @Autowired
    MessageService messageService;
    @Autowired
    private SessionService sessionService;
    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws ServletException, IOException
    {
        try
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o Clave incorrectos");
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("mensajeLogin", message);
            this.messageService.addWarn("Aviso:", "Usuario o clave incorrectos");
            this.sessionService.removeObjectFromSession(Constant.USUARIO_SESSION);
            this.sessionService.removeObjectFromSession(Constant.ROLES_SESSION);
            super.onAuthenticationFailure(request, response, auth);
        } catch (Exception e)
        {
            this.log.error("Error mientras se daba de baja la sesión del usuario");
        }

    }
}
