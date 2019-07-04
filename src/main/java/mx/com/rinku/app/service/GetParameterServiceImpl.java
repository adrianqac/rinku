
/*
 * Copyright (C) 2013 AshleyHeyeral
 *
 * The SOFTWARE PRODUCT includes entitlement to limited technical support services  
 * support services
 * SOFTWARE PRODUCT will perform substantially in accordance with 
 * the accompanying written materials.
 */
package mx.com.rinku.app.service;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/* *****************************************************************************
 * @author Ashley Heyeral Ruiz Fernandez  1/08/2013 05:09:40 PM  Description: 
 * GetParameterServiceImpl.java  
 * *****************************************************************************
 */
@Service
public class GetParameterServiceImpl implements GetParameterService
{
    public int getParameterInt(String key, int valorNull) throws Exception
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter(key) == null || request.getParameter(key).equals(""))
        {
            return valorNull;
        } else
        {
            return Integer.parseInt(request.getParameter(key));
        }
    }

    public String getParameterStringNone(String key, String valorNull) throws Exception
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter(key) == null || request.getParameter(key).equals(""))
        {
            return valorNull;
        } else
        {
            return "none";
        }
    }

    public String getParameterString(String key, String valorNull) throws Exception
    {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (request.getParameter(key) == null || request.getParameter(key).equals(""))
        {
            return valorNull;
        } else
        {
            return request.getParameter(key);
        }
    }
}
