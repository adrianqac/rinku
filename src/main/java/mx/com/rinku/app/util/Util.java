package mx.com.rinku.app.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class Util
{

    private Logger log = Logger.getLogger(this.getClass());

    public static String encriptarMd5(String valor)
    {
        try
        {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            valor = md5.encodePassword(valor, null);
        } catch (Exception e)
        {
            valor = "";
        }
        return valor;
    }

    public static String encriptarSha(String valor)
    {
        try
        {
            LdapShaPasswordEncoder sha = new LdapShaPasswordEncoder();
            valor = sha.encodePassword(valor, null);
        } catch (Exception e)
        {
            valor = "";
        }
        return valor;
    }

    public String getDateTime(String format)
    {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static Date getFechaActual()
    {
        return Calendar.getInstance().getTime();
    }

    public static Date getFechaAyer()
    {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }

    public static Date getFechaMañana()
    {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    public static String CalculaEdadFormatoConPuntos(Date nacimiento)
    {
        String edad = "";
        String mes;
        String dia;
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        try
        {
            final Date birthday = nacimiento;
            long lbirthday = birthday.getTime();

            Calendar age = Calendar.getInstance();
            age.setTimeInMillis(Math.abs(lbirthday - System.currentTimeMillis()));
            if (age.get(Calendar.MONTH) < 10)
            {
                mes = "0" + age.get(Calendar.MONTH);
            }
            else
            {
                mes = "" + age.get(Calendar.MONTH);
            }
            if (age.get(Calendar.DAY_OF_MONTH) < 10)
            {
                dia = "0" + age.get(Calendar.DAY_OF_MONTH);
            }
            else
            {
                dia = "" + age.get(Calendar.DAY_OF_MONTH);
            }
            edad = (age.get(Calendar.YEAR) - 1970 + "." + mes + "." + dia);
        } catch (Exception e)
        {
        }
        return edad;
    }

    public static Integer restaDias(Calendar fechaActual, Date fechaInicioPa)
    {
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.setTime(fechaInicioPa);
        Integer dia = fechaActual.get(Calendar.DAY_OF_YEAR) - fechaInicio.get(Calendar.DAY_OF_YEAR);
        return dia;
    }

}
