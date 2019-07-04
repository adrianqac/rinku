
package mx.com.rinku.app.service;

/**
 *
 * @author Adrian Vazquez
 */
public interface MessageService
{

    /**
     * Mensaje informativo
     *
     * @param title
     * @param description
     */
    public void addInfo(String title, String description);

    /**
     * Mensaje de error
     *
     * @param title
     * @param description
     */
    public void addError(String title, String description);

    /**
     * Mensajes de advertencia
     *
     * @param title
     * @param description
     */
    public void addWarn(String title, String description);

    /**
     *
     * @param title
     * @param description
     */
    public void addFatal(String title, String description);
}
