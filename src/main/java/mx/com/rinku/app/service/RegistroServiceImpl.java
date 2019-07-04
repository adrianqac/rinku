/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.rinku.app.service;

import java.util.Date;
import mx.com.rinku.app.dao.UsuarioDao;
import mx.com.rinku.app.form.AdministrarEmpleadosForm;
import mx.com.rinku.app.model.Dusuario;
import mx.com.rinku.app.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian Vazquez
 */
@Service
public class RegistroServiceImpl implements RegistroService {
    
    @Autowired
    private UsuarioService personaService;
    @Autowired
    private UsuarioDao usuarioDao;
    
    public String generarUsuario(Dusuario usuario)
    {
        return usuario.getNombre().substring(0, 1) + usuario.getAPaterno().substring(0, 1) + usuario.getAMaterno().substring(0, 1);

    }
    
    public String generarUsuario(String nombre, String aPaterno, String aMaterno)
    {
        return nombre.substring(0, 1) + aPaterno.substring(0, 1) + aMaterno.substring(0, 1);

    }

    public void registrarPersona(AdministrarEmpleadosForm administrarEmpleadosForm) throws Exception {
        Dusuario dusuario = new Dusuario();
        dusuario.setNombre(administrarEmpleadosForm.getNombre());
        dusuario.setAPaterno(administrarEmpleadosForm.getaPaterno());
        dusuario.setAMaterno(administrarEmpleadosForm.getaMaterno());
        dusuario.setNombreUsuario(this.generarUsuario(administrarEmpleadosForm.getNombre(), administrarEmpleadosForm.getaPaterno(), administrarEmpleadosForm.getaMaterno() ));
        dusuario.setPassword(this.personaService.encondePasswdWithSha( dusuario.getNombreUsuario() ));
        dusuario.setCrol(administrarEmpleadosForm.getRol());
        dusuario.setCtipoempleado(administrarEmpleadosForm.getTipoempleado());
        dusuario.setFechaRegistro(new Date());
        dusuario.setActivo(Constant.ACTIVO);
        this.usuarioDao.saveOrUpdate(dusuario);
        
        administrarEmpleadosForm.setUsuarioGenerado(dusuario.getNombreUsuario());
        administrarEmpleadosForm.setPasswordGenerado(dusuario.getNombreUsuario());
    }

}
