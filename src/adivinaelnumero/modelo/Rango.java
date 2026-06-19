package adivinaelnumero.modelo;

/**
 * Esta es una clase rango, nos va a ayudar a encapsular los datos de un numero minimo y uno maximo
 */
public class Rango {
    private int inicio;
    private int fin;

    // no queremos construir una clase rango que no tenga minimo o maximo
    // asi que dejamos solo 1 constructor que si o si pida minimo y maximo
    public Rango(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
}
