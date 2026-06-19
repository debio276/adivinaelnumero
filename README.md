# Adivina el numero!
Adivina el numero es una aplicacion de consola de java. 

## Requisitos minimos
* Java 25+

## El Juego

### Como se juega
El juego genera un numero aleatorio dentro de un rango determinado, el jugador debe intentar adivinar el
numero generado por el juego. El juego proporcionara pistas pudiendo indicarle al usuario lo siguiente: 

* Numero mas alla del rango permitido 
* Numero menor al rango permitido 
* Numero mayor al generado por el juego
* Numero menor al generado por el juego

Al acertar correctamente se indicara un mensaje y un arte ASCII del personaje Tony Tony Chopper.

#### Nota importante:
El juego indica al lado de cada dificultad el rango en el que el juego puede generar un numero aleatorio. Este rango es inclusivo.

### Niveles
El juego consta de 3 niveles predeterminados y una opcion para generar un juego personalizado. 
Cada nivel es descripto en el menu inicial con su respectivo rango al lado (los rangos son inclusivos)

### Nivel Personalizado
Para el nivel personalizado el usuario va a poder configurar los siguientes aspectos del juego: 
* El inicio del rango
* El fin del rango 
* Vidas del jugador

Una vez configurado el usuario va a poder jugar su partida personalizada.

## Aspectos Tecnicos 
**Nota importante:** Ademas del presente documento cada clase cuenta con sus respectivos comentarios dentro. 

### Orden y paquetes
* adivinaelnumero: nuestro paquete principal y padre de los siguientes tiene la clase Main, el inicio del programa. 
* logica: Dentro del paquete **logica** hemos creado nuestra clase **Juego** descripta en profundidad posteriormente
* modelo: Dentro del paquete modelo creamos aquellas clases que nos sirven para moldear un conjunto de datos. Por ejemplo para representar un rango de numeros tenemos la clase Rango la cual tiene un inicio y un fin

### Descripcion Tecnica

#### Clase Rango
Es una clase que nos va a ayudar a representar un rango.

**Atributos:**
* int inicio: El inicio del ranog
* int fin: El fin del rango

**Metodos:**
* getters y setters de atributos

#### Clase ResultadoAdivinanza
Es una clase que nos va a ayudar a devolver el resultado de una adivinanza. 

**Atributos:**
* boolean exito: Si el resultado es exitoso o no
* String mensajeAyuda: Un mensaje de ayuda que se imprimira al usuario si no fue exitoso

**Metodos:**
* getters y setters de atributos

#### Clase Main
La clase main sera el nucleo que ejecutara nuestro juego y controlara la logica del menu del mismo.
El menu se muestra utilizando un bucle do while que correra hasta que el usuario ingrese la opcion 0 para salir del mismo.
En caso de que el numero de la opcion ingresada no sea valido (es decir no es 1,2,3,4 ni 0) se mostrara el mensaje "Opcion no valida"

El juego personalizado: 
Una vez que se selecciona la opcion del juego personalizado la clase main le pedira al usuario los datos necesarios:

* Comienzo del rango (inclusivo): debe ser un numero mayor que 0. 
* Fin del rango (inclusivo): El fin del rango es un numero que se inicializa con el valor del comienzo del rango. Si el final ingresado no es mayor que el rango se muestra un mensaje invalido. 
* Vidas del jugador: Debe ser al menos 1

#### Clase Juego
**Atributos:**     
* chopper: El arte ASCII
* rango: El rango del juego, tiene un comienzo y un final. 
* vidas: Las vidas del jugador
* paraAdivinar: El numero generado por el juego dentro del rango establecido
* scanner: Es el scanner de java creado por la clase Main.

**Metodos:** 
**public void comenzarJuego**: El metodo publico que comienza el juego. 
**private ResultadoAdivinanza intentarAdivinar(numero)**: Un metodo que recibe el numero que el usuario ingreso y se evalua. Se devuelve un objeto de la clase ResultadoAdivinanza. 
**private int pedirNumero**: Un metodo ayuda que controla si el input del usuario no correpsonde a un numero. Usamos try catch controlando InputMismatchException.

