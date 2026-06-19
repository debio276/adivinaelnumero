package adivinaelnumero.logica;

import adivinaelnumero.modelo.Rango;
import adivinaelnumero.modelo.ResultadoAdivinanza;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private String chopper = """
            ⣟⣯⣟⣯⡇⠀⣿⢩⣛⡼⣏⠀⠈⠋⠀⣈⡷⣙⢎⡳⣙⢮⣙⢮⣙⢎⡳⣙⢾⣿ 
            ⢿⡾⣽⡞⣷⣤⣏⡳⡜⡼⠗⠁⢀⠀⠙⢧⠳⣍⢞⡱⣭⠲⣍⠶⣩⢞⡱⡭⣾⣿ 
            ⠈⠻⠧⢿⣧⣿⠶⣵⢻⢞⡷⢲⡟⡶⢴⡭⢿⣜⣮⡱⢎⡳⣍⢞⡱⢮⡱⣳⣿⣽ 
            ⠀⣰⣶⡏⢷⣈⣿⣸⣇⣾⣸⣿⣾⣹⣆⡹⡎⡶⢇⡿⣹⢷⣾⣈⠷⣇⢷⣿⣿⣹ 
            ⣾⣻⣭⣿⣾⣿⣿⣟⣿⣿⡿⣽⡿⣿⢿⣿⣿⣿⣾⣶⣵⣾⠲⣭⢳⣞⣾⡿⣷⣿ 
            ⣿⣿⣿⣯⣷⣿⣿⠿⢝⠚⠋⠉⠉⠉⠙⠚⠛⡾⢿⣿⣻⣿⣿⣶⣏⠶⣩⠿⣿⡈ 
            ⣿⣟⣿⣻⣿⡏⠀⠀⠀⠳⡀⠀⠀⠀⠀⠰⠊⠀⠀⠈⠙⠳⣿⣿⣿⣿⣧⣻⣿⣿ 
            ⠘⢻⣿⣿⣽⡇⠈⠧⣄⠀⠀⠀⠀⠀⠀⢀⣄⡤⠴⠚⠀⠀⠀⠙⢿⣷⡿⣿⣿⣿ 
            ⠀⠠⢈⢛⣿⠀⠚⠉⠉⠱⣼⡷⠀⠀⠀⠀⠉⠉⠑⠶⠀⠀⠀⠀⠀⠻⣿⣿⣾⢿ 
            ⠀⠡⠈⠉⠹⡀⠀⠀⡄⠀⣸⡀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣯⣿⢿ 
            ⠀⠁⢶⣶⠀⢷⠀⠀⠉⠉⠀⠈⠉⠶⠆⠈⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣾⣿ 
            ⠀⠡⢸⢹⠏⡍⠓⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣺⡟⠋⠉⢹⢭⢣ 
            ⠀⠀⢸⣹⡏⠭⠭⠭⠙⣲⣦⣤⣤⣀⣀⣀⣀⣤⣤⣶⣞⠉⠙⠛⠷⢀⣀⠘⣎⠧ 
            ⢁⣈⣀⣀⢀⣀⣀⣀⣼⠟⠹⢿⣯⣟⣿⣻⡿⠿⠛⢿⣿⣦⡀⠀⠀⠀⠀⠉⠉⠘ 
            """;

    // el rango para adivinar un numero
    private Rango rango;
    // las vidas iniciales, por defecto son 3
    private int vidas = 3;
    // el numero que vamos a generar para adivinar
    private int paraAdivinar;
    // la clase scanner, que nos va a permitir interactuar
    private Scanner scanner;

    public Juego(Rango rango, Scanner scanner) {
        this.rango = rango;
        this.scanner = scanner;
        this.paraAdivinar = generarNumeroParaAdivinar(this.rango);
    }

    public Juego(Rango rango, int vidas, Scanner scanner) {
        this.rango = rango;
        this.vidas = vidas;
        this.scanner = scanner;
        this.paraAdivinar = generarNumeroParaAdivinar(this.rango);
    }

    public int getVidas() {
        return vidas;
    }

    /**
     * Hay que adivinar el numero hasta que te quedes sin vidas, o hasta que se adivine el numero
     * la cantidad de vidas por defecto son 3
     */
    public void comenzarJuego() {
        System.out.println("========== COMIENZA EL JUEGO ===========");
        boolean adivinado = false;

        // mientras el jugador tenga vidas y no haya adivinado, el juego continua
        while (vidas > 0 && !adivinado) {
            System.out.println("♡ " + getVidas());

            System.out.println("Ingrese el numero a adivinar: ");


            // vamos a pedir un numero
            // aqui solo verificamos que el valor ingresado sea un numero,controlando el input mismatch exception
            int numeroIngresado = pedirNumero();
            ResultadoAdivinanza resultado = intentarAdivinar(numeroIngresado);

            adivinado = resultado.isExito();

            // si no se adivino el numero, le mostramos al jugador un mensaje con una ayuda
            if (!adivinado) {
                System.out.print("Psst! ಠ‿↼ ");
                System.out.println(resultado.getMensajeDeAyuda());
            } else {
                // si se adivino el numero, le informamos que gano!
                System.out.println("GANASTE! Adivinaste el numero generado!");
                System.out.println(chopper);
            }
        }

        // si el usuario no adivino el numero y ya no tiene intentos entonces le informamos que no tiene vidas :(
        if (!adivinado) {
            System.out.println("Te quedaste sin vidas :(. Intentalo de nuevo!");
        }
    }

    /**
     * el metodo intentarAdivinar se va a fijar el numero que se recibio y lo evaluara
     * En base a su evaluacion devolvera un objeto de la clase ResultadoAdivinanza
     * La clase ResultadoAdivinanza nos va a decir si el intento fue exitoso o no, y un mensaje de ayuda
     * <p>
     * * no exitoso -> numero por encima del rango
     * * no exitoso ->numero por debajo del rango
     * * no exitoso ->numero por encima del generado
     * * no exitoso ->numero por encima del generado
     * * exitoso -> numero correcto!
     */
    private ResultadoAdivinanza intentarAdivinar(int numero) {
        // Se consume una vida del jugador
        vidas--;

        // primero chequeamos que el numero este dentro del rango

        if (numero > rango.getFin()) {
            return new ResultadoAdivinanza(false, "Te fuiste del rango! Estas muy arriba. Maximo: " + rango.getFin());
        }

        if (numero < rango.getInicio()) {
            return new ResultadoAdivinanza(false, "Te fuiste del rango! Estas muy abajo. Minimo: " + rango.getInicio());
        }

        // ahora chequeamos si el numero es muy alto o muy bajo
        if (numero > paraAdivinar) {
            return new ResultadoAdivinanza(false, "Es muy alto, un poco menos :D");
        }

        if (numero < paraAdivinar) {
            return new ResultadoAdivinanza(false, "Es muy bajo, un poco mas :D ");
        }

        // en este punto de ejecucion la conclusion logica es exito
        return new ResultadoAdivinanza(true);
    }

    private int pedirNumero() {
        int numeroIngresado = 0;
        while (numeroIngresado <= 0) {
            try {
                numeroIngresado = scanner.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Debe ingresar un numero");
                scanner.nextLine();
            }
        }
        return numeroIngresado;
    }

    /**
     * Queremos un numero automatico entre un numero de inicio inclusivo:
     * inicio > 0
     * Y un fin inclusivo tambien
     * fin > inicio > 0
     */
    private int generarNumeroParaAdivinar(Rango rango) {
        return new Random().nextInt(rango.getInicio(), rango.getFin() + 1);
    }

}
