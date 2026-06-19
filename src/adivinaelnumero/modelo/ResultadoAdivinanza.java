package adivinaelnumero.modelo;

public class ResultadoAdivinanza {

    private String mensajeDeAyuda;
    private boolean exito;

    public ResultadoAdivinanza(boolean exito) {
        this.exito = exito;
    }

    public ResultadoAdivinanza(boolean exito, String mensajeDeAyuda) {
        this.exito = exito;
        this.mensajeDeAyuda = mensajeDeAyuda;
    }

    public String getMensajeDeAyuda() {
        return mensajeDeAyuda;
    }

    public void setMensajeDeAyuda(String mensajeDeAyuda) {
        this.mensajeDeAyuda = mensajeDeAyuda;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }
}
