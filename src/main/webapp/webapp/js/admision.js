
$ = jQuery;

function showFichaId()
{
    var statusSave = $("#admision-form\\:save").attr("value");
    if (statusSave == 'true')
    {      
        setTimeout("fichaId.show()", 2000);        
    }
}

function displayPacexpTable()
{
    if ($(".PaxexpModel").css("display") == "none")
    {
        $('.PaxexpModel').css("display", "inline");
    }
}

function imprimir() {

    $('.imprimirPDF').jqprint();
}


function disablePersonas()
{
    if (!$('.nomFiador').val())
    {
        !$('.nomFiador').attr("disabled", "disabled");
        !$('.patFiador').attr("disabled", "disabled");
        !$('.matFiador').attr("disabled", "disabled");
    }
    if (!$('.patFiador').val())
    {
        !$('.patFiador').attr("disabled", "disabled");     
    }
    if (!$('.matFiador').val())
    {
        !$('.matFiador').attr("disabled", "disabled");
    } 
    if (!$('.nomRes').val())
    {
        !$('.nomRes').attr("disabled", "disabled");
        !$('.patRes').attr("disabled", "disabled");
        !$('.matRes').attr("disabled", "disabled");
    }
    if (!$('.nomAcom').val())
    {
        !$('.nomAcom').attr("disabled", "disabled");
        !$('.patAcom').attr("disabled", "disabled");
        !$('.matAcom').attr("disabled", "disabled");
    }
    if (!$('.nomPadre').val())
    {
        !$('.nomPadre').attr("disabled", "disabled");
        !$('.patPadre').attr("disabled", "disabled");
        !$('.matPadre').attr("disabled", "disabled");
    }
    if (!$('.nomMadre').val())
    {
        !$('.nomMadre').attr("disabled", "disabled");
        !$('.patMadre').attr("disabled", "disabled");
        !$('.matMadre').attr("disabled", "disabled");
    }
    if (!$('.nomConyu').val())
    {
        !$('.nomConyu').attr("disabled", "disabled");
        !$('.patConyu').attr("disabled", "disabled");
        !$('.matConyu').attr("disabled", "disabled");
    }
}

function disableContactosPaciente()
{
    if (!$('.telCasaPaciente').val())
    {
        $('.telCasaPaciente').attr("disabled", "disabled");
    }
    if (!$('.telCelularPaciente').val())
    {
        $('.telCelularPaciente').attr("disabled", "disabled");
    }
    if (!$('.telOficinaPaciente').val())
    {
        $('.telOficinaPaciente').attr("disabled", "disabled");
    }
    if (!$('.telEmailPaciente').val())
    {
        $('.telEmailPaciente').attr("disabled", "disabled");
    }
}

function disableContactosPersonas()
{    
    /**
     * Fiador
     */
    if (!$('.fiadorTelefonoCasa').val())
    {
        $('.fiadorTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.fiadorTelefonoOficina').val())
    {
        $('.fiadorTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.fiadorCelular').val())
    {
        $('.fiadorCelular').attr("disabled", "disabled");
    }
    if (!$('.fiadorEmail').val())
    {
        $('.fiadorEmail').attr("disabled", "disabled");
    }
    /**
     * Responsable
     */
    if (!$('.responsableTelefonoCasa').val())
    {
        $('.responsableTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.responsableTelefonoOficina').val())
    {
        $('.responsableTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.responsableCelular').val())
    {
        $('.responsableCelular').attr("disabled", "disabled");
    }
    if (!$('.responsableEmail').val())
    {
        $('.responsableEmail').attr("disabled", "disabled");
    }
    /**
     * Acompañante
     */
    if (!$('.acomTelefonoCasa').val())
    {
        $('.acomTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.acomTelefonoOficina').val())
    {
        $('.acomTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.acomCelular').val())
    {
        $('.acomCelular').attr("disabled", "disabled");
    }
    if (!$('.acomEmail').val())
    {
        $('.acomEmail').attr("disabled", "disabled");
    }
    /**
     * Padre
     */
    if (!$('.padreTelefonoCasa').val())
    {
        $('.padreTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.padreTelefonoOficina').val())
    {
        $('.padreTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.padreCelular').val())
    {
        $('.padreCelular').attr("disabled", "disabled");
    }
    if (!$('.padreEmail').val())
    {
        $('.padreEmail').attr("disabled", "disabled");
    }
    /**
     * Madre
     */
    if (!$('.madreTelefonoCasa').val())
    {
        $('.madreTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.madreTelefonoOficina').val())
    {
        $('.madreTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.madreCelular').val())
    {
        $('.madreCelular').attr("disabled", "disabled");
    }
    if (!$('.madreEmail').val())
    {
        $('.madreEmail').attr("disabled", "disabled");
    }
    /**
     * Conyugue
     */
    if (!$('.conyuTelefonoCasa').val())
    {
        $('.conyuTelefonoCasa').attr("disabled", "disabled");
    }
    if (!$('.conyuTelefonoOficina').val())
    {
        $('.conyuTelefonoOficina').attr("disabled", "disabled");
    }
    if (!$('.conyuCelular').val())
    {
        $('.conyuCelular').attr("disabled", "disabled");
    }
    if (!$('.conyuEmail').val())
    {
        $('.conyuEmail').attr("disabled", "disabled");
    }
}

function enableContactos(control)
{
    if (!$(control).attr("disabled") == "")
    {
        $(control).attr("disabled", "");
    }
}

function imprimir(){

    $('.imprimirPDF').jqprint();
}

function printZPL(etiqueta)
{
    if (notReady()) 
    {
        return;
    }
    
    qz.append(etiqueta);

    qz.print();
}

