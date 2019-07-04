
package mx.com.rinku.app.service;

import mx.com.rinku.app.model.Dusuario;


public interface SessionService
{

    public void createSession(String nameSession, Object objectSession) throws Exception;

    public Object getSessionFromContext(String nameSession) throws Exception;

    public Dusuario getUsuarioFromSession() throws Exception;

    public void removeObjectFromSession(String nameSession) throws Exception;
    
    public String getNombreUsuario() throws Exception;
    
}
