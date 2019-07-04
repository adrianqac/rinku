
package mx.com.rinku.app.dao;

import java.util.List;
import mx.com.rinku.app.model.Crol;
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
public class RolDaoImpl extends AbstractDaoImpl<Crol, Integer> implements RolDao{

    public RolDaoImpl() {
        super(Crol.class);
    }

    //Este metodo se utiliza para conocer los roles disponibles, exceto el rol de administrador
    public List<Crol> getRolesDisponibles() throws Exception {
        Criteria criteria = getCurrentSession().createCriteria(Crol.class);
        criteria.add(Restrictions.ne("rolID", Constant.ID_ADMIN));
        return criteria.list();
    }
    
}
