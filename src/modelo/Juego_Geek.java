package modelo;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;
import java.util.Scanner;
import java.util.Vector;

/**
 * Esta clase gestinorá la lógica del juego, las reglas.
 */

public class Juego_Geek {

    private Dado cara_Obtenida; // objeto Dado entrega un entero representativo de la cara del dado.
/*
definimos algunas variables constantes.
 */
    private int cant_Dados_Activos_Iniciales; // cantidad de dados  para iniciar el juego.
    private int cant_Dados_Inactivos_Iniciales; // candidad de dados inactivos al inicio del juego

    private int cuantas_Rondas; // define el numero de rondas a jugar.


    /*
    definimos los arreglos.
     */

    private Vector<Integer> dados_Activos; // guarda el estado de los dados activos al inicio del juego
    private Vector<Integer> dados_Inactivos; // guarda el estado del os dados inactivos al inicio del juego.

    private Vector<Integer>dados_Utilizados; // guarda los dados utilizados

    private Vector<Integer>puntos_de_Ronda; // registra los puntos obtenidos en cada ronda.

    private int cantidad_FichasGanadoras; // totaliza al final cuantos dados "42" quedaron para aplicar a puntuación.

    private int rondes_de_Turnos; // registra la cantidad de turnos del jugador.

    private String [] string_Nombres_Iconos;

    public void setDados_Activos(Vector<Integer> dados_Activos) {
        this.dados_Activos = dados_Activos;
    }

    public Vector<Integer> getDados_Activos() {
        return dados_Activos;
    }

    public int getRondes_de_Turnos() {
        return rondes_de_Turnos;
    }

    public void setRondes_de_Turnos(int rondes_de_Turnos) {
        this.rondes_de_Turnos = rondes_de_Turnos;
    }

    public int getCantidad_FichasGanadoras() {
        return cantidad_FichasGanadoras;
    }

    public void setCantidad_FichasGanadoras(int cantidad_FichasGanadoras) {
        this.cantidad_FichasGanadoras = cantidad_FichasGanadoras;
    }


    public Juego_Geek() { // constructor
        cant_Dados_Activos_Iniciales = 7;
        cant_Dados_Inactivos_Iniciales=3;
        cantidad_FichasGanadoras=0;
        rondes_de_Turnos=5;
        inicio();


    }


    /**
     * Este método gestina el inicio del juego
     */

    public void inicio(){ // funcion inicializadora

        System.out.println("\nInicio el juego");


    }

    /**
     * Este método genera el arreglo de tipo Integer dados_Activos.
     * Usa un objeto de tipo Dado para generar los campos con volores enteros aleatorios
     * en el rango [1  -->  6]
     * @return dados_Activos
     */

    public Vector<Integer> tirada_DadosActivos(){ // lanzamiento de los dados activos en el inicio de cada ronda.
        cara_Obtenida = new Dado();
        dados_Activos = new Vector<Integer>(cant_Dados_Activos_Iniciales);

        String auxiliar = ""; // para probar en consola la funcionalidad



        for(int i = 0; i < cant_Dados_Activos_Iniciales; i++){
            int receptor = cara_Obtenida.get_cara(); // obtiene el valor random (int)
           dados_Activos.add(receptor);// adiciona el valor al arreglo

           auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + cara_Obtenida.get_Nombre_Cara(receptor-1) + "\n";

        }

        System.out.println(" \nTirada Inicial Activos-> " + dados_Activos.toString());
        System.out.println(" \nTirada Inicial Activos Nombres->\n" + auxiliar.toString());



        return dados_Activos;

    }

    /**
     * Este método genera el arreglo de tipo Integer dados_Inactivos.
     * Usa un objeto de tipo Dado para generar los campos con volores enteros aleatorios
     * en el rango [1  -->  6]
     * @return dados_Inactivos
     */

    public Vector<Integer> tirada_DadosInactivos(){// lanzamiento de los dados inactivos en el inicio de cada ronda.
        cara_Obtenida = new Dado();
        dados_Inactivos = new Vector<Integer>(cant_Dados_Inactivos_Iniciales);

        String auxiliar = "";

        for(int i = 0; i < cant_Dados_Inactivos_Iniciales; i++){
            int receptor = cara_Obtenida.get_cara();
            dados_Inactivos.add(receptor);
            auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + cara_Obtenida.get_Nombre_Cara(receptor-1) + "\n";


        }

        System.out.println(" \nTirada Inicial Inactivos -> " + dados_Inactivos.toString());
        System.out.println(" \nTirada Inicial Inactivos Nombres->\n" + auxiliar.toString());


        return dados_Inactivos;

    }

    /**
     * Este método gestiona el arreglo de dados_Utilizados.
     * Recibe un entero en el rango [1  -->  6]
     * @param paraRecibir
     * @return dados_Activos
     */

    public Vector<Integer> recibe_utilizados(int paraRecibir){// actualiza (recibe) los dados ya utilizados en un arreglo;

        dados_Utilizados = new Vector<Integer>();// defaul size 10, cada campo es igual a 0;
       dados_Utilizados.setSize(10);



        System.out.println(" al inicio del juego \n el tamaño del Vector tirada_Activos es " + dados_Activos.size() + "\n");


       // dados_Utilizados.set(0,789); // para prueba

        String auxiliar = ""; // variable local

        for(int i = 0; i < dados_Utilizados.size()-1; i++){
            if (dados_Utilizados.get(i)==null){
                dados_Utilizados.set(i,paraRecibir);
                auxiliar = auxiliar + "Dados Utilizados [ "+ i + " ] es: " + dados_Utilizados.get(i) + "\n";
                break;
            }

        }


        System.out.println("los dados utilizados son "+ dados_Utilizados.toString());


        return dados_Utilizados;

    }


    /**
     * Este método gestiona el arreglo de dados_Inactivos.
     * Recibe un entero en el rango [1  -->  6]
     * @param paraEntregar
     * @return dados_Inactivos
     */
    public Vector<Integer> entrega_Inactivos(int paraEntregar){// actualiza (entrega) los dados inactivos en un arreglo;

        paraEntregar = dados_Inactivos.remove(0);


        System.out.println(" \n el tamaño del Vector dados_Inactivos es " + dados_Inactivos.size() + "\n");


        System.out.println(dados_Inactivos.toString());


        return dados_Inactivos;

    }



    /**
     * Este método gestiona el arreglo de dados_Activos asi;
     * cada vez que se juegue un dado, lo elimina del arreglo dados_Activos
     * retornando el nuevo estado del arreglo dados_Activos
     * Recibe un entero en el rango [1  -->  6]
     * @param caraDado
     * @return dados_Activos
     */

    public Vector<Integer> borra_Activos_Jugados(int caraDado) {// caraDado tiene rango [1 -> 6]

       // dados_Activos = new Vector<Integer>(cant_Dados_Activos_Iniciales);


        for (int i = 0; i < dados_Activos.size(); i++) {

            if (dados_Activos.elementAt(i)== caraDado){

                dados_Activos.removeElementAt(i);

                System.out.println(" Nuevo size de dados Activos " + dados_Activos.size());

                break;
            }

        }

        System.out.println(" Vector sin el elemento jugado " + dados_Activos.toString());


        return dados_Activos;

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
     * Método que ejecuta las acciones pertinentes al personaje CORAZON.
     * Este personaje está representado por el numero 1 [ int = 1 ]
     * Retorna el nuevo estado del arreglo dados_Activos
     * @param cara_Recibida
     * @return dados_Activos
     */

    public Vector<Integer> accion_Corazon(int cara_Recibida){ // [ 1 ] -> Lanza un dado de los inactivos

        cara_Obtenida = new Dado();

        if (cara_Recibida==1) {

            borra_Activos_Jugados(cara_Recibida); // borra el corazon qqe activó

            dados_Activos.setSize(dados_Activos.size() );

            int auxiliar =999;

            auxiliar = cara_Obtenida.get_cara();


            jugar_Un_Solo_Dado( auxiliar); // método de clase invocado.



            return dados_Activos;
        }
        else{
            System.out.println(" para CORAZON Usa el numero 1... TODO QUEDO IGUAL." + dados_Activos.toString());
        }

        return dados_Activos;

    }

    /**
     * Método que ejecuta las acciones pertinentes al personaje DRAGON.
     * Este personaje está representado por el numero 2 [ int = 2 ]
     * Retorna el  arreglo dados_Activos CLEAR y un MENSAJE de "el juego se perdio"
     * @param cara_Recibida
     * @return dados_Activos
     */

    public Vector<Integer> accion_Dragon(int cara_Recibida){ // [ 2 ] -> el jugador pierde el juego

        if (cara_Recibida==2) {

            for (int i = 0; i < dados_Activos.size(); i++) {

                if (dados_Activos.elementAt(i) == cara_Recibida) {

                    System.out.println(" El juego terminó....Perdiste todo.");

                    setCantidad_FichasGanadoras(0); // no obtiene puntos en la ronda.
                }


            }


            dados_Activos.clear();


            System.out.println(" El juego terminó....Perdiste todo." + dados_Activos.toString());


            return dados_Activos;
        }
        else {
            System.out.println(" para DRAGON Usa el numero .2.. TODO QUEDO IGUAL." + dados_Activos.toString());

        }

        return dados_Activos;

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
     *                     por un valor random entre [1 , 6] y en la misma ubicacion del vector.
     * @return dados_Activos
     */

    public Vector<Integer> jugar_Un_Solo_Dado(int dado_buscado) { // dado_buscado --> representa la cara del dado que selecciono para volverla a lanzar

        cara_Obtenida = new Dado();

       int recoge_La_Posicion=999; // recogera la posicion en donde está ubicado [dado_buscado]. se inicializa con cualquier valor.

       int auxiliar = 111; // variable auxiliar inicializada.

        if (dados_Activos.contains(dado_buscado)){ // verifica que exista...que este disponible.

          recoge_La_Posicion = dados_Activos.indexOf(dado_buscado);

           auxiliar = cara_Obtenida.get_cara(); // cambia a un nuevo valor

           dados_Activos.setElementAt(auxiliar,recoge_La_Posicion);//cambia al nuevo valor en la misma poscion

            System.out.println(" dado_buscado..si exite y su primera ubicacion es " + recoge_La_Posicion);


        }

        else {
            System.out.println(" la cara " + dado_buscado + " no esta disponible, ese dado NO exite "); // check

        }


        System.out.println(dados_Activos.toString());

        return dados_Activos;
    }

    /**
     * Metodo que ejecuta el accionar del Meeple, retirando un Meeple del
     * arreglo de dados_Activos y aleatoriamente, modificar una posición del
     * arreglo de dados_Activos.
     * Al final entrega un arreglo de dados Activos actualizado en su nuevo size y con
     * un elemento (field) modificado
     * @param cara_Recibida
     * @return dados_Activos
     */

    public Vector<Integer> accion_Mepplet(int cara_Recibida){ // [3] -> meeplet permite relanzar un dado de los activos.

        cara_Obtenida = new Dado();

        if (cara_Recibida==3){

            borra_Activos_Jugados(cara_Recibida); // borra el meeplet qqe activó

            int cara_seleccionada_para_Modificar = 999; // nueva cara para ingresar al arreglo, sera RANDOM.

            cara_seleccionada_para_Modificar = cara_Obtenida.get_cara();

            System.out.println(" La cara que modicaré será " + cara_seleccionada_para_Modificar);

            int contador_Auxiliar = 0; // para desbloquear ciclo.

            while (dados_Activos.contains(cara_seleccionada_para_Modificar)) {

                jugar_Un_Solo_Dado(cara_seleccionada_para_Modificar);

                contador_Auxiliar += 1;

                if (contador_Auxiliar == 2) {

                    break;
                }

            }


            System.out.println(" El nuevo arreglo de dados Activos es:" + dados_Activos.toString());


            return dados_Activos;

        }
        else {

            System.out.println(" para usar el Meeple debe ingresar el numero 3" + dados_Activos.toString());
        }

        return dados_Activos;


    }

    /**
     * Este método rige la acción del COHETE eliminando un dado de los activos
     * Entrega el arreglo dados_Activos actualizado.
     * @param cara_Recibida
     * @return dados_Activos
     */


    public Vector<Integer> accion_Cohete(int cara_Recibida){ // [4] -> cohete permite eliminar un dado de los activos.

        cara_Obtenida = new Dado();

        if (cara_Recibida==4){

            borra_Activos_Jugados(cara_Recibida); // borra el meeplet qqe activó

            int cara_seleccionada_para_Eliminar = 999; // nueva cara para eliminar del arreglo, sera RANDOM.

            cara_seleccionada_para_Eliminar = cara_Obtenida.get_cara();

            System.out.println(" La cara que eliminaré será " + cara_seleccionada_para_Eliminar);

            int contador_Auxiliar = 0; // para desbloquear ciclo.

            while (dados_Activos.contains(cara_seleccionada_para_Eliminar)) {

                //jugar_Un_Solo_Dado(cara_seleccionada_para_Eliminar);

                dados_Activos.remove(cara_seleccionada_para_Eliminar);



                contador_Auxiliar += 1;

                if (contador_Auxiliar == 1) {

                    break;
                }

            }


            System.out.println(" Después del COHETE -->: " + dados_Activos.toString());


            return dados_Activos;

        }
        else {

            System.out.println(" Para usar el COHETE debes ingresar el número 4 " + dados_Activos.toString());
        }

        return dados_Activos;


    }

    /**
     * Metodo que gestiona el accionar del SuperHeroe.
     * Entrega el arreglo dados_Activos actualizado
     * @param cara_Recibida
     * @return dados_Activos
     */


    public Vector<Integer> accion_SuperHeroe(int cara_Recibida){ // [5] -> SuperHeroe permite voltear un dado de los activos.

        cara_Obtenida = new Dado();

        if (cara_Recibida==5) {

            borra_Activos_Jugados(cara_Recibida); // borra el SuperHeroe qqe activó


            int cara_para_Girar = 999; //  cara a ser girada, existe en el arreglo, sera RANDOM .. inicialización

            cara_para_Girar = cara_Obtenida.get_cara();

            int cara_Opuesta = 999; // cara opuesta a la cara para girar.. inicialización

            String auxiliar = "";




                System.out.println(" La cara que se girará será " + cara_para_Girar);

                switch (cara_para_Girar) {
                    case 1:
                        cara_Opuesta = 6;
                        auxiliar = "antes Corazon..ahora 42";
                        break;
                    case 2:
                        cara_Opuesta = 5;
                        auxiliar = "antes Dragon ..ahora SuperHeroe";
                        break;
                    case 3:
                        cara_Opuesta = 4;
                        auxiliar = "antes Meeple...ahora Cohete";
                        break;
                    case 4:
                        cara_Opuesta = 3;
                        auxiliar = "antes Cohete..ahora Meeple";
                        break;
                    case 5:
                        cara_Opuesta = 3;
                        auxiliar = "antes SuperHeroe...ahora Dragón";
                        break;
                    case 6:
                        cara_Opuesta = 1;
                        auxiliar = " antes 42...ahora Corazón";
                        break;
                    default:
                        cara_Opuesta = 6600;
                        auxiliar = " hay problemas..en acción_Superheroe.";

                }


                //cara_Opuesta ya está definida, cara_para_Girar..tambien.

                int contador_Auxiliar = 0; // para desbloquear ciclo.

                int ubicacionCaraParaGirar = 999; // auxiliar ...inicialización.

                while (dados_Activos.contains(cara_para_Girar)) {

                    ubicacionCaraParaGirar = dados_Activos.indexOf(cara_para_Girar);

                    dados_Activos.set(ubicacionCaraParaGirar, cara_Opuesta);


                    contador_Auxiliar += 1;

                    if (contador_Auxiliar == 1) {

                        break;
                    }

                }


                System.out.println(" Después del SUPERHEROE -->: " + dados_Activos.toString());


                return dados_Activos;


        }
        else {

            System.out.println(" Para usar el SUPERHEROR debes ingresar el número 5 " + dados_Activos.toString());
        }

        return dados_Activos;


    }

    /**
     * Este método vefifica que solo existan fichas tipo "42" en el arrego de dados_Activos
     * Si se cumple esa condicion, actualiza cantidad_FichasGanadoras y cierra ronda y o juego.
     * De lo contrario..sigue el juego normal...sale un mensaje...sugue jugando...animo.
     * @param cara_Recibida
     * @return cantidad_FichasGanadoras
     */


    public Vector<Integer> accion_Cuarenta_y_Dos(int cara_Recibida){ // [ 6 ] -> genera el puntaje del juego

        if (cara_Recibida==6) {

            int contador=0; // acumulador de dados tipo "42" al recorrer el arreglo dados_Activos.

            for (int i = 0; i < dados_Activos.size(); i++) {

                if (dados_Activos.get(i)==cara_Recibida){

                    contador++;

                    System.out.println("somos igualitas." + contador);
                }

            }


            if (contador==dados_Activos.size()){ // Todas son fichas ganadoras..se procede a calcular puntaje obtenido.

                setCantidad_FichasGanadoras(contador);

                dados_Activos.clear(); // termina suamando puntos.

                JOptionPane.showMessageDialog(null, "..felicitaciones...has ganado");

                /*
                dados_Activos despues del clear final, puede mostrar un saludo...o algo..animacion..en fin..
                 */

                /*
                AQUI TERMINA UNA RONDA CON PUNTUACION...DEBE PREGUNTARSE QUE RONDA ES ..SI ES 5TA .
                .TERMINA EL JUEGO...Y ENTREGA RESULTADOS..SINO REINICIA DE NUEVO CON LANZAMIENTO INCIAL...SIN
                BORRAR LOS RESULTADOS.. A MENOS QUE DRAGON APAREZCA..
                 */
            }

            else {

                setCantidad_FichasGanadoras(0);

                JOptionPane.showMessageDialog(null, "..Debes seguir jugando...\n..quedan fichas aun.");

                /*
                Se puede programar un aviso de un mensaje que diga ...sigue jugando..
                porque todavia existen otras fichas.
                 */

            }


        }




        return dados_Activos;

    }

    /**
     * Este método calcula la cantidad de puntos ganados segun el número de
     * dados ganadores que se tenga al final de la ronda. (Representados por el numero 6)
     * @param contidadGanadores
     * @return cantidad_FichasGanadoras
     */

    public int sumatorioPuntos (int contidadGanadores) { // camtodad de dadps 42 -> representados por el numero 6


        if (contidadGanadores==1){
            setCantidad_FichasGanadoras(1);

        }
        else{

            setCantidad_FichasGanadoras(contidadGanadores + sumatorioPuntos(contidadGanadores-1));
        }

        System.out.println(" los puntos ganados son " + getCantidad_FichasGanadoras());

        return cantidad_FichasGanadoras;


    }

    public int registraPuntosDe_UnaRonda(int cierraRonda){

        int acumulador = 0;


        System.out.println(" aqui deben de ir las condiciones para puntear" +
                "por ejemplo; que solo queden dados 42 representados por el" +
                "numero 6 en ésta implementación.");


        return acumulador;

    }














    public void pura_Accion(int jugado){ // toma el entero y desarrolla las acciones  según las reglas del juego.

        dados_Activos = new Vector<Integer>(7);

        int entrega=999; // retornará el entero que reprenta la cara obtenida al jugar.

        String auxiliar =""; // para pruebas.

        switch (jugado) {
            case 1:
                //accion_Corazon(1);
                auxiliar = "EL Corazon está en acción";
                break;
            case 2:
              // accion_Dragon(2);
                auxiliar = "EL Dragon está en acción";
                break;
            case 3:
              //  accion_Mepplet(3);
                auxiliar = "EL Meeple está en acción";
                break;
            case 4:
               // accion_Cohete(4);
                auxiliar = "EL Cohete está en acción";
                break;
            case 5:
               // accion_SuperHeroe(5);
                auxiliar = "EL SuperHeroe está en acción";
                break;
            case 6:
                //accion_Cuarenta_y_Dos();
                auxiliar = " a sumar puntos con el 42";
                break;
            default:

                auxiliar = " hay problemas..para RESOLVER en el método puraAccion.";
        }



    }


//    +++++++++++++______+++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS

    public Vector<Integer> puraTrampa(){ // lanzamiento de los dados GANADORES

        cara_Obtenida = new Dado();
        dados_Activos = new Vector<Integer>();

        String auxiliar = ""; // para probar en consola la funcionalidad


        int sizeCaprichoso = cara_Obtenida.get_cara(); // valor de size aleatorio

        dados_Activos.setSize(sizeCaprichoso);

        System.out.println(" soy el caprichoso " + sizeCaprichoso + " " + dados_Activos.toString());

        dados_Activos.clear();

        for(int i = 0; i < sizeCaprichoso; i++){

            int receptor = 6; // obtiene el valor random (int)


          dados_Activos.insertElementAt(receptor, i);// adiciona el valor al arreglo TODOS SON 6... TODOS PUNTUAN..

            auxiliar = auxiliar + " Este juego tramposo ..la cara [ "+ (i+1) + " ] SIEMPRE es: " + receptor + "\n" +
                    " El size es "+ dados_Activos.size() + "\n";

        }


        System.out.println(" \nTirada Inicial TRAMPOSA-> " + dados_Activos.toString());
        System.out.println(" \nTirada Inicial TRAMPOSA Nombres->\n" + auxiliar);



        return dados_Activos;

    }










//    +++++++++++++______+++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS++++++++)))))))))))) AREA DE PRUEBAS....ONLY PROOFS





    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Juego_Geek myGUI = new Juego_Geek();
            }
        });
    }

}
