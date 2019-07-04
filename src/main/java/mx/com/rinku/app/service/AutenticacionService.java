package mx.com.rinku.app.service;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 *
 * @author Adrian Vazquez
 */
public interface AutenticacionService
{

    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException, DataAccessException;

    public void removeSessionUser();
}
