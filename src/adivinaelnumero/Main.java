package adivinaelnumero;

import adivinaelnumero.logica.Juego;
import adivinaelnumero.modelo.Rango;

import java.util.Scanner;

public class Main {

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== VAMOS A JUGAR! ADIVINA EL NUMERO =====");

        int opcionElegida = 0;
        do {
            System.out.println("\n===== SELECCIONE DIFICULTAD =====");
            System.out.println("1. Facil (1-5)");
            System.out.println("2. Normal (1-10)");
            System.out.println("3. Dificil (1-20)");
            System.out.println("4. Personalizado");
            System.out.println("0. Salir");
            System.out.print("Ingrese seleccion: ");
            opcionElegida = scanner.nextInt();

            switch (opcionElegida) {
                case 1:
                    // facil es del 1 al 5
                    Rango rangoFacil = new Rango(1, 5);
                    Juego juegoFacil = new Juego(rangoFacil, scanner);

                    juegoFacil.comenzarJuego();
                    break;
                case 2:
                    // normal es del 1 al 10
                    Rango rangoNormal = new Rango(1, 10);
                    Juego juegoNormal = new Juego(rangoNormal, scanner);

                    juegoNormal.comenzarJuego();
                    break;
                case 3:
                    // dificil es del 1 al 20
                    Rango rangoDificil = new Rango(1, 20);
                    Juego juegoDificil = new Juego(rangoDificil, scanner);

                    juegoDificil.comenzarJuego();
                    break;
                case 4:
                    System.out.println("===== DIFICULTAD PERSONALIZADA =====");

                    int comienzoDelRango = ingresarYObtenerNumero(0, scanner,
                            "Ingrese el comienzo del rango (inclusivo): ",
                            "Debe ingresar un numero mayor a 0");

                    System.out.println("Ingrese el fin del rango (inclusivo): ");
                    int finDelRango = comienzoDelRango;
                    while (finDelRango <= comienzoDelRango) {
                        finDelRango = scanner.nextInt();
                        if(finDelRango <= comienzoDelRango) {
                            System.out.println("Debe ingresar un numero mayor a 0 y superior al comienzo (" + comienzoDelRango + ")");
                        }
                    }

                    int vidasDelJugador = ingresarYObtenerNumero(0, scanner,
                            "Ingrese la cantidad de vidas del jugador: ",
                            "El jugador debe comenzar con al menos 1 vida");

                    Rango rangoPersonalizado = new Rango(comienzoDelRango, finDelRango);
                    Juego juegoPersonalizado = new Juego(rangoPersonalizado, vidasDelJugador, scanner);

                    juegoPersonalizado.comenzarJuego();
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

        } while (opcionElegida != 0);

        scanner.close();
    }

    /**
     * Para evitar repetirnos creamos este metodo
     */
    private static int ingresarYObtenerNumero(int valorInicial, Scanner scanner, String mensajeDeEntrada, String mensajeDeError) {
        System.out.println(mensajeDeEntrada);
        int numeroIngresado = valorInicial;
        while (numeroIngresado <= 0) {
            numeroIngresado = scanner.nextInt();
            if (numeroIngresado <= 0) {
                System.out.println(mensajeDeError);
            }
        }
        return numeroIngresado;
    }
}