package mx.com.rinku.app.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.Criterion;
/**
 *
 * @author Adrian Vazquez
 */

//interfaz utilizada para que implementaran los daos
public interface AbstractDao<E, I extends Serializable>
{

    E findById(I id);

    void saveOrUpdate(E e);
    
    void saveOrUpdate(List<E> es);

    void delete(E e);
    
    List<E> findByCriteria(Criterion criterion);

    public List<E> getAll();
    
    public List<E> getAllInactive();
   
}
