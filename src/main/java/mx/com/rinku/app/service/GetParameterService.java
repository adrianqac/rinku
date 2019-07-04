
package mx.com.rinku.app.service;

/**
 *
 * @author Adrian Vazquez
 */
public interface GetParameterService
{

    public int getParameterInt(String key, int valorNull) throws Exception;

    public String getParameterStringNone(String key, String valorNull) throws Exception;

    public String getParameterString(String key, String valorNull) throws Exception;
}
