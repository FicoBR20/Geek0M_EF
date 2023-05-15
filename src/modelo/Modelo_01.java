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
    private Vector<Integer>puntos_de_Ronda; // registra los puntos obtenidos en cada ronda.

    private String [] string_Arreglo_Auxiliar;

    public void setDados_Activos(Vector<Dado_01> dados_Activos) {
        this.dados_Activos = dados_Activos;
    }

    public Vector<Dado_01> getDados_Activos() {
        return dados_Activos;
    }

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

    public Vector<Dado_01> tirada_DadosActivos(){ // lanzamiento de los dados activos en el inicio de cada ronda.


       dados_Activos.setSize(7);

        String auxiliar = ""; // para probar en consola la funcionalidad



        for(int i = 0; i < dados_Activos.size(); i++){

            int captura = 6; // inicializacion
            Random aleatorio = new Random();
            captura = aleatorio.nextInt(captura)+1;

//            System.out.println("el receptor es" + captura);
            nuevaCara.setSelector_Figura(captura);// obtiene el valor random (int)
           dados_Activos.setElementAt(nuevaCara,i);// adiciona el valor al arreglo

           auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + dados_Activos.get(i).getSelector_Figura() + "\n";
           captura=0;

        }

        System.out.println(" \nTirada Inicial Activos Nombres->\n" + auxiliar.toString());





        return dados_Activos;

    }

    /**
     * Este método genera el arreglo de Dados Inactivos
     * @return dados_Inactivos[]
     */


    public Vector<Dado_01> tiradaInactivos(){ // lanzamiento de los dados Inactivos en el inicio de cada ronda.


        dados_Inactivos.setSize(3);

        String auxiliar = ""; // para probar en consola la funcionalidad



        for(int i = 0; i < dados_Inactivos.size(); i++){

            int captura = 6; // inicializacion
            Random aleatorio = new Random();
            captura = aleatorio.nextInt(captura)+1;

            nuevaCara.setSelector_Figura(captura);// obtiene el valor random (int)
            dados_Inactivos.setElementAt(nuevaCara,i);// adiciona el valor al arreglo

            auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + dados_Inactivos.get(i).getSelector_Figura() + "\n";
            captura=0;

        }

        System.out.println(" \nTirada Inicial Inactivos Nombres->\n" + auxiliar.toString());



        return dados_Inactivos;

    }


    /**
     * este método modifica una sola posición del arreglo de dados_Activos,
     * retornando el arreglo dados_Activos (CON EL MISMO SIZE) y ya con esa modificación.
     * @param dado01 ->  entero que se busca en el arreglo, de existir, se cambiara
     * por un valor random entre [1 , 6] y en la misma ubicacion del vector.
     * @return dados_Activos
     */

    public Vector<Dado_01> jugar_Un_Solo_Dado( Dado_01 dado01) { // dado_buscado --> representa la cara del dado que selecciono para volverla a lanzar

        nuevaCara = new Dado_01();



        nuevaCara.setSelector_Figura(dado01.getSelector_Figura());



        int recoge_La_Posicion=999; // recogera la posicion en donde está ubicado [dado_buscado]. se inicializa con cualquier valor.

        int auxiliar = 111; // variable auxiliar inicializada.

        if (dados_Activos.contains(nuevaCara)){ // verifica que exista...que este disponible.

            recoge_La_Posicion = dados_Activos.indexOf(nuevaCara);

        System.out.println(" El Dado de cara "+ nuevaCara.getSelector_Figura() + " es " + recoge_La_Posicion);

            auxiliar = nuevaCara.busqueda_Aleatoria(); // cambia a un nuevo valor random


            nuevaCara.setSelector_Figura(auxiliar);

            dados_Activos.setElementAt(nuevaCara, recoge_La_Posicion);//cambia al nuevo valor en la misma poscion

            System.out.println(" dado_buscado..si exite y su primera ubicacion es " + recoge_La_Posicion);


        }

        else {
            System.out.println(" la cara  de dadp" + nuevaCara.getSelector_Figura() + " no esta disponible,\n" +
                    " esa cara de dado NO exite "); // check

        }

        // impresion del arreglo de salids

        for (int i = 0; i < dados_Activos.size(); i++) {
            System.out.println(" el arreglo modificado es; [ " + dados_Activos.get(i).getSelector_Figura() + " ]\n");

        }



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

    public void probarArreglos(){

        System.out.println(" en probar Arreglos");

        Vector<Dado_01>losdados;
        losdados = new Vector<Dado_01>();
        losdados.setSize(7);


        String auxiliar = ""; // para probar en consola la funcionalidad



        for(int i = 0; i < losdados.size(); i++){

            int captura = 6; // inicializacion
            Random aleatorio = new Random();
            captura = aleatorio.nextInt(captura)+1;

            System.out.println("El arreglo de preubas es [ " + captura + " ]");
            nuevaCara.setSelector_Figura(captura);// obtiene el valor random (int)
            dados_Activos.setElementAt(nuevaCara,i);// adiciona el valor al arreglo

            auxiliar = auxiliar + "La cara para pruebas [ "+ (i+1) + " ] es: " + captura;
            captura=0;

        }
        nuevaCara = new Dado_01();
        nuevaCara.setSelector_Figura(5);

        jugar_Un_Solo_Dado (nuevaCara);


    }

    /**
     * Este método dirige toas las acciones segun el valor de la cara del dado
     * @param jugado
     */

    public void accion_Directa(int jugado){ // toma el entero y desarrolla las acciones  según las reglas del juego.

        System.out.println(" soy Accion Directa");


        String auxiliar =""; // para pruebas.
        if ( jugado==1){
            System.out.println(" programar lo que hace el corazon");
            if (jugado==2){
                System.out.println(" programar lo que hace dragon");
            }
            else{
                System.out.println(" todo pasará");
            }
        }
        else {
            System.out.println(" se sigue o no");;
        }
//
//        switch (jugado) {
//            case 1:
//                //accion_Corazon(1);
//                auxiliar = "EL Corazon está en acción debe programarse \n en la funcion accion_Directa de la clase Modelo_01.";
//                break;
//            case 2:
//                // accion_Dragon(2);
//                auxiliar = "EL Dragon está en acción";
//                break;
//            case 3:
//                //  accion_Mepplet(3);
//                auxiliar = "EL Meeple está en acción";
//                break;
//            case 4:
//                // accion_Cohete(4);
//                auxiliar = "EL Cohete está en acción";
//                break;
//            case 5:
//                // accion_SuperHeroe(5);
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



    }

    /**
     * Metodo para probar conectividad etre las clases.
     */

    public void probadoraComexion (){

        System.out.println(" probando conectividad entre clases");
    }
















//
//    /**
//     * Método que ejecuta las acciones pertinentes al personaje CORAZON.
//     * Este personaje está representado por el numero 1 [ int = 1 ]
//     * Retorna el nuevo estado del arreglo dados_Activos
//     * @param cara_Recibida
//     * @return dados_Activos
//     */
//
//    public Vector<Integer> accion_Corazon(int cara_Recibida){ // [ 1 ] -> Lanza un dado de los inactivos
//
//        cara_Obtenida = new Dado();
//
//        if (cara_Recibida==1) {
//
//            borra_Activos_Jugados(cara_Recibida); // borra el corazon qqe activó
//
//            dados_Activos.setSize(dados_Activos.size() );
//
//            int auxiliar =999;
//
//            auxiliar = cara_Obtenida.get_cara();
//
//
//            jugar_Un_Solo_Dado( auxiliar); // método de clase invocado.
//
//
//
//            return dados_Activos;
//        }
//        else{
//            System.out.println(" para CORAZON Usa el numero 1... TODO QUEDO IGUAL." + dados_Activos.toString());
//        }
//
//        return dados_Activos;
//
//    }
//
//    /**
//     * Método que ejecuta las acciones pertinentes al personaje DRAGON.
//     * Este personaje está representado por el numero 2 [ int = 2 ]
//     * Retorna el  arreglo dados_Activos CLEAR y un MENSAJE de "el juego se perdio"
//     * @param cara_Recibida
//     * @return dados_Activos
//     */
//
//    public Vector<Integer> accion_Dragon(int cara_Recibida){ // [ 2 ] -> el jugador pierde el juego
//
//        if (cara_Recibida==2) {
//
//            for (int i = 0; i < dados_Activos.size(); i++) {
//
//                if (dados_Activos.elementAt(i) == cara_Recibida) {
//
//                    System.out.println(" El juego terminó....Perdiste todo.");
//
//                    setCantidad_FichasGanadoras(0); // no obtiene puntos en la ronda.
//                }
//
//
//            }
//
//
//            dados_Activos.clear();
//
//
//            System.out.println(" El juego terminó....Perdiste todo." + dados_Activos.toString());
//
//
//            return dados_Activos;
//        }
//        else {
//            System.out.println(" para DRAGON Usa el numero .2.. TODO QUEDO IGUAL." + dados_Activos.toString());
//
//        }
//
//        return dados_Activos;
//
//    }
//
//
//    /**
//     * Método para ingresar un valor de tipo int vía consola, retornandolo
//     * @return respuesta
//     */

//public int solicitaEntero(){ // se solicita un entero via consola
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.println(" \nHola cual es tu eleccion ?\n");
//            int respuesta = scanner.nextInt();
//            System.out.println(" escogio bien..va ganando " + respuesta);
//
//            return respuesta;
//
//    }

//
//    /**
//     * Metodo que ejecuta el accionar del Meeple, retirando un Meeple del
//     * arreglo de dados_Activos y aleatoriamente, modificar una posición del
//     * arreglo de dados_Activos.
//     * Al final entrega un arreglo de dados Activos actualizado en su nuevo size y con
//     * un elemento (field) modificado
//     * @param cara_Recibida
//     * @return dados_Activos
//     */
//
//    public Vector<Integer> accion_Mepplet(int cara_Recibida){ // [3] -> meeplet permite relanzar un dado de los activos.
//
//        cara_Obtenida = new Dado();
//
//        if (cara_Recibida==3){
//
//            borra_Activos_Jugados(cara_Recibida); // borra el meeplet qqe activó
//
//            int cara_seleccionada_para_Modificar = 999; // nueva cara para ingresar al arreglo, sera RANDOM.
//
//            cara_seleccionada_para_Modificar = cara_Obtenida.get_cara();
//
//            System.out.println(" La cara que modicaré será " + cara_seleccionada_para_Modificar);
//
//            int contador_Auxiliar = 0; // para desbloquear ciclo.
//
//            while (dados_Activos.contains(cara_seleccionada_para_Modificar)) {
//
//                jugar_Un_Solo_Dado(cara_seleccionada_para_Modificar);
//
//                contador_Auxiliar += 1;
//
//                if (contador_Auxiliar == 2) {
//
//                    break;
//                }
//
//            }
//
//
//            System.out.println(" El nuevo arreglo de dados Activos es:" + dados_Activos.toString());
//
//
//            return dados_Activos;
//
//        }
//        else {
//
//            System.out.println(" para usar el Meeple debe ingresar el numero 3" + dados_Activos.toString());
//        }
//
//        return dados_Activos;
//
//
//    }
//
//    /**
//     * Este método rige la acción del COHETE eliminando un dado de los activos
//     * Entrega el arreglo dados_Activos actualizado.
//     * @param cara_Recibida
//     * @return dados_Activos
//     */
//
//
//    public Vector<Integer> accion_Cohete(int cara_Recibida){ // [4] -> cohete permite eliminar un dado de los activos.
//
//        cara_Obtenida = new Dado();
//
//        if (cara_Recibida==4){
//
//            borra_Activos_Jugados(cara_Recibida); // borra el meeplet qqe activó
//
//            int cara_seleccionada_para_Eliminar = 999; // nueva cara para eliminar del arreglo, sera RANDOM.
//
//            cara_seleccionada_para_Eliminar = cara_Obtenida.get_cara();
//
//            System.out.println(" La cara que eliminaré será " + cara_seleccionada_para_Eliminar);
//
//            int contador_Auxiliar = 0; // para desbloquear ciclo.
//
//            while (dados_Activos.contains(cara_seleccionada_para_Eliminar)) {
//
//                //jugar_Un_Solo_Dado(cara_seleccionada_para_Eliminar);
//
//                dados_Activos.remove(cara_seleccionada_para_Eliminar);
//
//
//
//                contador_Auxiliar += 1;
//
//                if (contador_Auxiliar == 1) {
//
//                    break;
//                }
//
//            }
//
//
//            System.out.println(" Después del COHETE -->: " + dados_Activos.toString());
//
//
//            return dados_Activos;
//
//        }
//        else {
//
//            System.out.println(" Para usar el COHETE debes ingresar el número 4 " + dados_Activos.toString());
//        }
//
//        return dados_Activos;
//
//
//    }
//
//    /**
//     * Metodo que gestiona el accionar del SuperHeroe.
//     * Entrega el arreglo dados_Activos actualizado
//     * @param cara_Recibida
//     * @return dados_Activos
//     */
//
//
//    public Vector<Integer> accion_SuperHeroe(int cara_Recibida){ // [5] -> SuperHeroe permite voltear un dado de los activos.
//
//        cara_Obtenida = new Dado();
//
//        if (cara_Recibida==5) {
//
//            borra_Activos_Jugados(cara_Recibida); // borra el SuperHeroe qqe activó
//
//
//            int cara_para_Girar = 999; //  cara a ser girada, existe en el arreglo, sera RANDOM .. inicialización
//
//            cara_para_Girar = cara_Obtenida.get_cara();
//
//            int cara_Opuesta = 999; // cara opuesta a la cara para girar.. inicialización
//
//            String auxiliar = "";
//
//
//
//
//                System.out.println(" La cara que se girará será " + cara_para_Girar);
//
//                switch (cara_para_Girar) {
//                    case 1:
//                        cara_Opuesta = 6;
//                        auxiliar = "antes Corazon..ahora 42";
//                        break;
//                    case 2:
//                        cara_Opuesta = 5;
//                        auxiliar = "antes Dragon ..ahora SuperHeroe";
//                        break;
//                    case 3:
//                        cara_Opuesta = 4;
//                        auxiliar = "antes Meeple...ahora Cohete";
//                        break;
//                    case 4:
//                        cara_Opuesta = 3;
//                        auxiliar = "antes Cohete..ahora Meeple";
//                        break;
//                    case 5:
//                        cara_Opuesta = 3;
//                        auxiliar = "antes SuperHeroe...ahora Dragón";
//                        break;
//                    case 6:
//                        cara_Opuesta = 1;
//                        auxiliar = " antes 42...ahora Corazón";
//                        break;
//                    default:
//                        cara_Opuesta = 6600;
//                        auxiliar = " hay problemas..en acción_Superheroe.";
//
//                }
//
//
//                //cara_Opuesta ya está definida, cara_para_Girar..tambien.
//
//                int contador_Auxiliar = 0; // para desbloquear ciclo.
//
//                int ubicacionCaraParaGirar = 999; // auxiliar ...inicialización.
//
//                while (dados_Activos.contains(cara_para_Girar)) {
//
//                    ubicacionCaraParaGirar = dados_Activos.indexOf(cara_para_Girar);
//
//                    dados_Activos.set(ubicacionCaraParaGirar, cara_Opuesta);
//
//
//                    contador_Auxiliar += 1;
//
//                    if (contador_Auxiliar == 1) {
//
//                        break;
//                    }
//
//                }
//
//
//                System.out.println(" Después del SUPERHEROE -->: " + dados_Activos.toString());
//
//
//                return dados_Activos;
//
//
//        }
//        else {
//
//            System.out.println(" Para usar el SUPERHEROR debes ingresar el número 5 " + dados_Activos.toString());
//        }
//
//        return dados_Activos;
//
//
//    }
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





    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Modelo_01 myGUI = new Modelo_01();
            }
        });
    }

}
