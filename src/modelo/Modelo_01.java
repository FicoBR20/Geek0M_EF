package modelo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * Esta clase gestinorá la lógica del juego, las reglas.
 */
public class Modelo_01 {


    /**
     * Objeto de tipo Dado_01
     */
    private Dado_01 nuevaCara;
    /**
     * Inician 7 dados activos
     */
    private int cant_Dados_Activos_Iniciales; // cantidad de dados  para iniciar el juego.
    /**
     * Se incia con 3 dados inactivos
     */
    private int cant_Dados_Inactivos_Iniciales; // candidad de dados inactivos al inicio del juego
    /**
     * Atributo que representa la cantidad de rondas de
     * un jugador
     */
    private int cuantas_Rondas; // define el numero de rondas a jugar.
    /**
     * Arreglo que contiene los dados Activos
     * durante el juego
     */
    private Vector<Dado_01> dados_Activos; // guarda el estado de los dados activos al inicio del juego
    /**
     * Arreglo que contiene los dados Inactivos
     * durantes el juego.
     */
    private Vector<Dado_01> dados_Inactivos; // guarda el estado del os dados inactivos al inicio del juego.
    /**
     * Arreglo que contiene los dados Utilizados
     * durante el juego
     */
    private Vector<Dado_01>dados_Utilizados; // guarda los dados utilizados
    /**
     * Arreglo que contiene los puntos obtenidos en el juego
     */
    private Vector<Dado_01>puntos_de_Ronda; // registra los puntos obtenidos en cada ronda.

    private String [] string_Arreglo_Auxiliar;



    /**
     * Método contructor
     */
    public Modelo_01() {

        System.out.println(" contructor Modelo_01");

        nuevaCara = new Dado_01();


        dados_Activos = new Vector<Dado_01>();
        dados_Inactivos = new Vector<Dado_01>();
        dados_Utilizados = new Vector<Dado_01>();


    }







    /**
     * Metodo usado para probar métodos de la clase Vector
     * y sacar provecho de ellos en el proyecto.
     * @param buscado
     */

    public void probadora(int buscado) {

        if (dados_Activos.contains(buscado)){
            System.out.println(" Se encontro lo buscado");
        }
        else {
            System.out.println(" NO Se encontro lo buscado");
        }

    }

    /**
     * Método para ingresar un valor de tipo int vía consola, retornandolo
     * @return respuesta
     */

    public int solicitaEntero(){ // se solicita un entero via consola

        Scanner scanner = new Scanner(System.in);
        System.out.println(" \nHola cual es tu eleccion ?\n");
        int respuesta = scanner.nextInt();
        System.out.println(" escogio bien..va ganando " + respuesta);

        return respuesta;

    }



    /**
     * este método modifica una sola posición del arreglo de dados_Activos,
     * retornando el arreglo dados_Activos (CON EL MISMO SIZE) y ya con esa modificación.
     * @param dado_buscado ->  entero que se busca en el arreglo, de existir, se cambiara
     * por un valor random entre [1 , 6] y en la misma ubicacion del vector.
     * @return dados_Activos
     */

    public Vector<Dado_01> jugar_Un_Solo_Dado(Vector<Dado_01> arregloOriginal, int dado_buscado) { // dado_buscado --> representa la cara del dado que selecciono para volverla a lanzar

        nuevaCara = new Dado_01();

        arregloOriginal = new Vector<>();

       int recoge_La_Posicion=999; // recogera la posicion en donde está ubicado [dado_buscado]. se inicializa con cualquier valor.

       int auxiliar = 111; // variable auxiliar inicializada.

        if (arregloOriginal.contains(dado_buscado)){ // verifica que exista...que este disponible.

          recoge_La_Posicion = arregloOriginal.indexOf(dado_buscado);

           auxiliar = nuevaCara.busqueda_Aleatoria(); // se genera un int aleatorio para una nueva cara

            nuevaCara.setSelector_Figura(auxiliar); // se le asiga el valor al Dado_o1

           dados_Activos.setElementAt(nuevaCara, recoge_La_Posicion);//cambia al nuevo valor en la misma poscion

            System.out.println(" dado_buscado..si exite y su primera ubicacion es " + recoge_La_Posicion);


        }

        else {
            System.out.println(" la cara " + dado_buscado + " no esta disponible, ese dado NO exite "); // check

        }


        System.out.println(arregloOriginal.toString());

        return arregloOriginal;
    }

    public Vector<Dado_01> borra_Activos_Jugados(int caraDado) {// caraDado tiene rango [1 -> 6]

        dados_Activos = new Vector<Dado_01>();


        for (int i = 0; i < dados_Activos.size(); i++) {

            if (dados_Activos.elementAt(i).getSelector_Figura()== caraDado){

                dados_Activos.removeElementAt(i);

                System.out.println(" Nuevo size de dados Activos " + dados_Activos.size());

                break;
            }

        }

        System.out.println(" Vector sin el elemento jugado " + dados_Activos.toString());


        return dados_Activos;

    }






    public void pura_Accion(int jugado){ // toma el entero y desarrolla las acciones  según las reglas del juego.

//        dados_Activos = new Vector<Integer>(7);
//
//        int entrega=999; // retornará el entero que reprenta la cara obtenida al jugar.

        String auxiliar =""; // para pruebas.

        switch (jugado) {
            case 1:
                borra_Activos_Jugados(1);
                //accion_Corazon(1);
                auxiliar = "EL Corazon está en acción";
                System.out.println(auxiliar + "\n" +
                        "1 - Se va del arreglo de dados activos\n" +
                        "2 - Trae un dado de los inactivos\n" +
                        "3 - Lanza ese nuevo dado que trajo a los dados activos'\n" +
                        "4 - El size del arreglo de dados Activos queda igualito\n" +
                        "5 - El size del arreglo de dado Inactivos queda meno uno -1 \n" +
                        "6 - retona el arreglo de dados activos con la cara modificada en donde estaba el corazon\n" +
                        "7 - Se pregunta por el size de Dados Activos, si es 1, entonces se acaba el juego sin puntos\n" +
                        "");
                break;

            case 2:
              // accion_Dragon(2);
                auxiliar = "EL Dragon está en acción...que sera que hace ?";
                System.out.println(auxiliar + "\n" );

                break;
            case 3:
              //  accion_Mepplet(3);
                auxiliar = "EL Meeple está en acción...que sera que hace ?";
                System.out.println(auxiliar + "\n" );

                break;
            case 4:
               // accion_Cohete(4);
                auxiliar = "EL Cohete está en acción...que sera que hace ?";
                System.out.println(auxiliar + "\n" );

                break;
            case 5:
               // accion_SuperHeroe(5);
                auxiliar = "EL SuperHeroe está en acción...que sera que hace ?";
                System.out.println(auxiliar + "\n" );

                break;
            case 6:
                //accion_Cuarenta_y_Dos();
                auxiliar = " a sumar puntos con el 42...que sera que hace ?";
                System.out.println(auxiliar + "\n" );

                break;
            default:

                auxiliar = " Seguir implementando las otras...";
        }



    }




    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Modelo_01 myGUI = new Modelo_01();
            }
        });
    }

}





