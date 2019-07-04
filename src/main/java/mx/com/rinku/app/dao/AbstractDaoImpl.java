package mx.com.rinku.app.dao;

import java.io.Serializable;
import java.util.List;
import mx.com.rinku.app.util.Constant;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Adrian Vazquez
 */
@Repository
@Transactional
public abstract class AbstractDaoImpl<E, I extends Serializable> implements AbstractDao<E, I> {

    private Class<E> entityClass;

    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public List<E> getAll() {

        return this.getCurrentSession().createQuery("from " + this.entityClass.getName() + " e where e.activo =" + Constant.ACTIVO).list();

    }
    
    public List<E> getAllInactive() {

        return this.getCurrentSession().createQuery("from " + this.entityClass.getName() + " e ").list();

    }

    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Override
    public void saveOrUpdate(List<E> es) {
        for (Object e : es) {
            getCurrentSession().saveOrUpdate(e);
        }
    }

    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    @Override
    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);

        criteria.add(criterion);
        return criteria.list();
    }
}
