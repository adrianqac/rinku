/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.rinku.app.dao;

import java.util.Date;
import java.util.List;
import mx.com.rinku.app.model.Dmovimiento;
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
public class MovimientoDaoImpl extends AbstractDaoImpl<Dmovimiento, Integer> implements MovimientoDao {

    public MovimientoDaoImpl() {
        super(Dmovimiento.class);
    }

    //se utiliza este método para consultar en BD los movimientos dependiendo del rango de fechas seleccionadas por el usuario
    public List<Dmovimiento> movimientosByUsuarioIDAndFechas(Integer usuarioID, Date fechaInicial, Date fechafinal) throws Exception {
        Criteria criteria = getCurrentSession().createCriteria(Dmovimiento.class);
        criteria.add(Restrictions.between("fecha", fechaInicial, fechafinal));
        criteria.add(Restrictions.eq("usuarioID", usuarioID));
        criteria.add(Restrictions.eq("activo", Constant.ACTIVO));
        return criteria.list();
    }

}
