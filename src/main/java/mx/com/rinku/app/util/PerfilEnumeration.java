package mx.com.rinku.app.util;

public enum PerfilEnumeration
{

    ROL_ADMINISTRADOR("Administrador"),
    ROL_CHOFER("Chofer"),
    ROL_CARGADOR("Cargador"),
    ROL_AUXILIAR("Auxiliar"),;
    
    
    private String constante;

    private PerfilEnumeration(String constante)
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
