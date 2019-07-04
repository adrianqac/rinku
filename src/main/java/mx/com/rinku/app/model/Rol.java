
package mx.com.rinku.app.model;

import org.springframework.security.core.GrantedAuthority;
/**
 *
 * @author Adrian Vazquez
 */
public class Rol implements GrantedAuthority
{

    private String rol;
    private Integer activo;

    public Rol()
    {
        super();
    }

    public Rol(String rol)
    {
        super();
        this.rol = rol;
    }

    @Override
    public String getAuthority()
    {
        return this.rol;
    }

    /**
     * @return the rol
     */
    public String getRol()
    {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol)
    {
        this.rol = rol;
    }

    /**
     * @return the activo
     */
    public Integer getActivo()
    {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Integer activo)
    {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol))
        {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rol.equals(other.rol)))
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 29 * hash + (this.rol != null ? this.rol.hashCode() : 0);
        return hash;
    }
}