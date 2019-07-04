
package mx.com.rinku.app.controller;

import javax.annotation.PostConstruct;
import mx.com.rinku.app.service.GetParameterService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
/**
 *
 * @author Adrian Vazquez
 */
@Controller
@Scope(value = "view")
public class MainController
{

    @Autowired
    private GetParameterService getParameterService;
    private String mostrar;
    private Logger log = Logger.getLogger(this.getClass());

    public MainController()
    {

    }

    //metodo utilizado para obtener por parametro los templates disponibles
    @PostConstruct
    public void init()
    {
        try
        {
            this.mostrar = this.getParameterService.getParameterStringNone("template", "");
        }
        catch (Exception e)
        {
            log.error("Ocurrio un error en el init " + e);
        }
    }

    /**
     * @return the mostrar
     */
    public String getMostrar()
    {
        return mostrar;
    }

    /**
     * @param mostrar the mostrar to set
     */
    public void setMostrar(String mostrar)
    {
        this.mostrar = mostrar;
    }
}
