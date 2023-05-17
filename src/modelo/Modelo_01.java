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
     * Este método genera el arreglo de tipo Integer dados_Activos.
     * Usa un objeto de tipo Dado para generar los campos con volores enteros aleatorios
     * en el rango [1  -->  6]
     * @return dados_Activos[]
     */
//
//    public Vector<Integer> tirada_DadosActivos(){ // lanzamiento de los dados activos en el inicio de cada ronda.
//
//
////        nuevaCara = new Dado_01();
//       dados_Activos.setSize(7);
//
//        System.out.println(" en tirada dados Activos el size es " + dados_Activos.size());
//        String auxiliar = ""; // para probar en consola la funcionalidad
//
//
//
//        for(int i = 0; i < dados_Activos.size(); i++){
//
//            int captura = 6; // inicializacion
//            Random aleatorio = new Random();
//            captura = aleatorio.nextInt(captura)+1;
//
//            System.out.println("el receptor es" + captura);
//            nuevaCara.setSelector_Figura(captura);// obtiene el valor random (int)
//           dados_Activos.setElementAt(nuevaCara,i);// adiciona el valor al arreglo
//
//           auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + dados_Activos.get(i).getSelector_Figura() + "\n";
//           captura=0;
//
//        }
//
//        System.out.println(" \nTirada Inicial Activos-> " + dados_Activos.toString());
//        System.out.println(" \nEl tercer objeto es -> " + dados_Activos.get(2).toString());
//        System.out.println(" \nTirada Inicial Activos Nombres->\n" + auxiliar.toString());
//
//
//
//        return dados_Activos;
//
//    }
//
//    /**
//     * Este método genera el arreglo de Dados Inactivos
//     * @return dados_Inactivos[]
//     */
//
//
//    public Vector<Dado_01> tiradaInactivos(){ // lanzamiento de los dados Inactivos en el inicio de cada ronda.
//
//
////        nuevaCara = new Dado_01();
//        dados_Inactivos.setSize(3);
//
//        System.out.println(" en tirada dados Activos el size es " + dados_Inactivos.size());
//        String auxiliar = ""; // para probar en consola la funcionalidad
//
//
//
//        for(int i = 0; i < dados_Inactivos.size(); i++){
//
//            int captura = 6; // inicializacion
//            Random aleatorio = new Random();
//            captura = aleatorio.nextInt(captura)+1;
//
//            System.out.println("el receptor es" + captura);
//            nuevaCara.setSelector_Figura(captura);// obtiene el valor random (int)
//            dados_Inactivos.setElementAt(nuevaCara,i);// adiciona el valor al arreglo
//
//            auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + dados_Inactivos.get(i).getSelector_Figura() + "\n";
//            captura=0;
//
//        }
//
//        System.out.println(" \nTirada Inicial Inactivos-> " + dados_Inactivos.toString());
//        System.out.println(" \nTirada Inicial Inactivos Nombres->\n" + auxiliar.toString());
//
//
//
//        return dados_Inactivos;
//
//    }

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







//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//
//
//    /**
//     * Este método vefifica que solo existan fichas tipo "42" en el arrego de dados_Activos
//     * Si se cumple esa condicion, actualiza cantidad_FichasGanadoras y cierra ronda y o juego.
//     * De lo contrario..sigue el juego normal...sale un mensaje...sugue jugando...animo.
//     * @param cara_Recibida
//     * @return cantidad_FichasGanadoras
//     */
//
//
//    public Vector<Integer> accion_Cuarenta_y_Dos(int cara_Recibida){ // [ 6 ] -> genera el puntaje del juego
//
//        if (cara_Recibida==6) {
//
//            int contador=0; // acumulador de dados tipo "42" al recorrer el arreglo dados_Activos.
//
//            for (int i = 0; i < dados_Activos.size(); i++) {
//
//                if (dados_Activos.get(i)==cara_Recibida){
//
//                    contador++;
//
//                    System.out.println("somos igualitas." + contador);
//                }
//
//            }
//
//
//            if (contador==dados_Activos.size()){ // Todas son fichas ganadoras..se procede a calcular puntaje obtenido.
//
//                setCantidad_FichasGanadoras(contador);
//
//                dados_Activos.clear(); // termina suamando puntos.
//
//                JOptionPane.showMessageDialog(null, "..felicitaciones...has ganado");
//
//                /*
//                dados_Activos despues del clear final, puede mostrar un saludo...o algo..animacion..en fin..
//                 */
//
//                /*
//                AQUI TERMINA UNA RONDA CON PUNTUACION...DEBE PREGUNTARSE QUE RONDA ES ..SI ES 5TA .
//                .TERMINA EL JUEGO...Y ENTREGA RESULTADOS..SINO REINICIA DE NUEVO CON LANZAMIENTO INCIAL...SIN
//                BORRAR LOS RESULTADOS.. A MENOS QUE DRAGON APAREZCA..
//                 */
//            }
//
//            else {
//
//                setCantidad_FichasGanadoras(0);
//
//                JOptionPane.showMessageDialog(null, "..Debes seguir jugando...\n..quedan fichas aun.");
//
//                /*
//                Se puede programar un aviso de un mensaje que diga ...sigue jugando..
//                porque todavia existen otras fichas.
//                 */
//
//            }
//
//
//        }
//
//
//
//
//        return dados_Activos;
//
//    }
//
////
//
//    /**
//     * Este método calcula la cantidad de puntos ganados segun el número de
//     * dados ganadores que se tenga al final de la ronda. (Representados por el numero 6)
//     * @param contidadGanadores
//     * @return cantidad_FichasGanadoras
//     */
//
//    public int sumatorioPuntos (int contidadGanadores) { // camtodad de dadps 42 -> representados por el numero 6
//
//
//        if (contidadGanadores==1){
//            setCantidad_FichasGanadoras(1);
//
//        }
//        else{
//
//            setCantidad_FichasGanadoras(contidadGanadores + sumatorioPuntos(contidadGanadores-1));
//        }
//
//        System.out.println(" los puntos ganados son " + getCantidad_FichasGanadoras());
//
//        return cantidad_FichasGanadoras;
//
//
//    }
//
//    public int registraPuntosDe_UnaRonda(int cierraRonda){
//
//        int acumulador = 0;
//
//
//        System.out.println(" aqui deben de ir las condiciones para puntear" +
//                "por ejemplo; que solo queden dados 42 representados por el" +
//                "numero 6 en ésta implementación.");
//
//
//        return acumulador;
//
//    }

//
//
//
//    public void pura_Accion(int jugado){ // toma el entero y desarrolla las acciones  según las reglas del juego.
//
////        dados_Activos = new Vector<Integer>(7);
////
////        int entrega=999; // retornará el entero que reprenta la cara obtenida al jugar.
//
//        String auxiliar =""; // para pruebas.
//
//        switch (jugado) {
//            case 1:
//                //accion_Corazon(1);
//                auxiliar = "EL Corazon está en acción";
//                break;
//            case 2:
//              // accion_Dragon(2);
//                auxiliar = "EL Dragon está en acción";
//                break;
//            case 3:
//              //  accion_Mepplet(3);
//                auxiliar = "EL Meeple está en acción";
//                break;
//            case 4:
//               // accion_Cohete(4);
//                auxiliar = "EL Cohete está en acción";
//                break;
//            case 5:
//               // accion_SuperHeroe(5);
//                auxiliar = "EL SuperHeroe está en acción";
//                break;
//            case 6:
//                //accion_Cuarenta_y_Dos();
//                auxiliar = " a sumar puntos con el 42";
//                break;
//            default:
//
//                auxiliar = " hay problemas..para RESOLVER en el método puraAccion.";
//        }
//
//
//
//    }
//
//
////    +++++++++++++______+++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS
//
//    public Vector<Integer> puraTrampa(){ // lanzamiento de los dados GANADORES
//
//        cara_Obtenida = new Dado();
//        dados_Activos = new Vector<Integer>();
//
//        String auxiliar = ""; // para probar en consola la funcionalidad
//
//
//        int sizeCaprichoso = cara_Obtenida.get_cara(); // valor de size aleatorio
//
//        dados_Activos.setSize(sizeCaprichoso);
//
//        System.out.println(" soy el caprichoso " + sizeCaprichoso + " " + dados_Activos.toString());
//
//        dados_Activos.clear();
//
//        for(int i = 0; i < sizeCaprichoso; i++){
//
//            int receptor = 6; // obtiene el valor random (int)
//
//
//          dados_Activos.insertElementAt(receptor, i);// adiciona el valor al arreglo TODOS SON 6... TODOS PUNTUAN..
//
//            auxiliar = auxiliar + " Este juego tramposo ..la cara [ "+ (i+1) + " ] SIEMPRE es: " + receptor + "\n" +
//                    " El size es "+ dados_Activos.size() + "\n";
//
//        }
//
//
//        System.out.println(" \nTirada Inicial TRAMPOSA-> " + dados_Activos.toString());
//        System.out.println(" \nTirada Inicial TRAMPOSA Nombres->\n" + auxiliar);
//
//
//
//        return dados_Activos;
//
//    }
//
//
//
//
//
//
//
//
//
//
////    +++++++++++++______+++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS


