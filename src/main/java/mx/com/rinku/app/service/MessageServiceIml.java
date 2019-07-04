
package mx.com.rinku.app.service;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class MessageServiceIml implements MessageService
{

    private static final Logger log = Logger.getLogger(MessageServiceIml.class);

    public void addInfo(String title, String description)
    {
        try
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, description));
        } catch (Exception e)
        {
                  log.error("Ocurrio un error en el metodo CapturaEncuestaAnterioriServiceImpl.addInfo", e);
        }
    }

    public void addError(String title, String description)
    {
        try
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, description));
        } catch (Exception e)
        {
            //  log.error("Ocurrio un error en el metodo CapturaEncuestaAnterioriServiceImpl.addInfo", e);
        }
    }

    public void addWarn(String title, String description)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, title, description));
    }

    public void addFatal(String title, String description)
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, title, description));
    }
}
