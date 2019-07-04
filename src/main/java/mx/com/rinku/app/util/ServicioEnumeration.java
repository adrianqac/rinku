
package mx.com.rinku.app.util;
/**
 *
 * @author Adrian Vazquez
 */
public enum ServicioEnumeration
{

    INFORMES("INFORMES"),
    CAJA("CAJA"),
    TRABAJO_SOCIAL("TRABAJO_SOCIAL"),
    ADMISION("ADMISION"),
    HOSPITAL("HOSPITAL"),
    ENFERMERIA("ENFERMERIA"),
    TERAPIA_INTENSIVA("TERAPIA_INTENSIVA"),
    NUTRICION("NUTRICION"),
    QUIROFANO("QUIROFANO"),
    CONSULTA_EXTERNA("CONSULTA_EXTERNA"),
    URGENCIAS("URGENCIAS"),
    CIRUGIA_AMBULATORIA("CIRUGIA_AMBULATORIA"),
    LABORATORIO("LABORATORIO"),
    IMAGENOLOGIA("IMAGENOLOGIA"),
    FARMACIA("FARMACIA"),
    CEYE("CEYE"),
    CATALOGOS("CATALOGOS"),
    EXPEDIENTE_HOSPITALIZADO("EXPEDIENTE_HOSPITALIZADO"),
    EXPEDIENTE_HISTORICO("EXPEDIENTE_HISTORICO"),
    EDUCACION_PACIENTE("EDUCACION_PACIENTE"),
    CITAS("CITAS"),
    RECEPCION("RECEPCION"),
    ENFERMERIA_CEX("ENFERMERIA_CEX"),
    CONSULTA("CONSULTA"),
    REPORTES_CEX("REPORTES_CEX"),
    FARMACIA_CEX("FARMACIA_CEX");
    
    private String constante;

    private ServicioEnumeration(String constante)
    {
        this.constante = constante;
    }

    /**
     * @return the constante
     */
    public String getConstante()
    {
        return constante;
    }

    /**
     * @param constante the constante to set
     */
    public void setConstante(String constante)
    {
        this.constante = constante;
    }
}
