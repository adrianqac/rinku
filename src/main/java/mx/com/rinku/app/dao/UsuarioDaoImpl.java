
package mx.com.rinku.app.dao;

import java.util.List;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.util.Constant;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Adrian Vazquez
 */
@Repository
@Transactional
public class UsuarioDaoImpl extends AbstractDaoImpl<Dusuario, Integer> implements UsuarioDao
{

    public UsuarioDaoImpl()
    {
        super(Dusuario.class);
    }

    public Dusuario getUsuarioByUserName(String userName) throws Exception {
        Criteria criteria = getCurrentSession().createCriteria(Dusuario.class);
        criteria.add(Restrictions.eq("nombreUsuario", userName));
        criteria.add(Restrictions.eq("activo", Constant.ACTIVO));
        return (Dusuario) criteria.uniqueResult();
    }

    public List<Dusuario> getEmpleados() throws Exception {
        Criteria criteria = getCurrentSession().createCriteria(Dusuario.class);
        criteria.add(Restrictions.ne("crol.rolID", 1));
        criteria.add(Restrictions.eq("activo", Constant.ACTIVO));
        return criteria.list();
    }
    
}
