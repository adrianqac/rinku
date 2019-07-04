package mx.com.rinku.app.controller;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import mx.com.rinku.app.form.LoginForm;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Adrian Vazquez
 */
@Controller
@Lazy
@RequestScoped
public class LoginController implements Serializable
{

    private Logger log = Logger.getLogger(this.getClass());
    private Dusuario usuario = new Dusuario();
    private LoginForm loginForm;
    @Autowired
    private MessageService messageService;

    /**
     * Direccionamiento hacia el contexto de spring
     *
     * @return
     */
    public LoginController()
    {
        try
        {
            this.loginForm = new LoginForm();

        } catch (Exception e)
        {
            this.log.error("Error en la construcción del login", e);
        }
    }

    @PostConstruct
    public void init()
    {
        try
        {
        } catch (Exception e)
        {
            log.error("Ocurrio un error en el postConstructor " + e.getMessage());
        }
    }

    //metodo encargado del login, deja que spring inicie la sesión, todo esto se configura en los XML
    public void login() throws IOException, ServletException
    {
        try
        {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            ServletRequest servletRequest = (ServletRequest) context.getRequest();
            ServletResponse servletResponse = (ServletResponse) context.getResponse();
            servletRequest.setAttribute("pass", this.usuario.getPassword());

            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/j_spring_security_check");
            dispatcher.forward(servletRequest, servletResponse);            
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e)
        {
            log.error("Ocurrio un error en el metodo LoginAction.login", e);
        }
    }

    /**
     * @return the usuario
     */
    public Dusuario getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Dusuario usuario)
    {
        this.usuario = usuario;
    }

    /**
     * @return the loginForm
     */
    public LoginForm getLoginForm()
    {
        return loginForm;
    }

    /**
     * @param loginForm the loginForm to set
     */
    public void setLoginForm(LoginForm loginForm)
    {
        this.loginForm = loginForm;
    }
}