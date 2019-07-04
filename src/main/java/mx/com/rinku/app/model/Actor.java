
package mx.com.rinku.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 *
 * @author Adrian Vazquez
 */
public class Actor implements UserDetails
{

    private List<GrantedAuthority> roles;
    private Dusuario dUsuario;

    public Actor()
    {
        this.roles = new ArrayList<GrantedAuthority>();
    }

    public Collection<GrantedAuthority> getAuthorities()
    {
        return getRoles();
    }

    public String getPassword()
    {
        return this.dUsuario.getPassword();
    }

    public String getUsername()
    {
        return this.dUsuario.getNombreUsuario();
    }

    public boolean isAccountNonExpired()
    {
        return true;
    }

    public boolean isAccountNonLocked()
    {
        return true;
    }

    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    public boolean isEnabled()
    {
        int indexEnabled = this.dUsuario == null ? 0 : this.dUsuario.getActivo();
        boolean enable = indexEnabled > 0 ? true : false;
        return enable;
    }

    public List<GrantedAuthority> getRoles()
    {
        return roles;
    }

    public void setRoles(List<GrantedAuthority> roles)
    {
        this.roles = roles;
    }

    /**
     * @return the dUsuario
     */
    public Dusuario getdUsuario()
    {
        return dUsuario;
    }

    /**
     * @param dUsuario the dUsuario to set
     */
    public void setdUsuario(Dusuario dUsuario)
    {
        this.dUsuario = dUsuario;
    }
}
