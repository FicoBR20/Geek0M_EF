package modelo;

import java.awt.*;
import java.util.Vector;

public class Juego_Geek {

    private Dado cara_Obtenida; // objeto Dado entrega un entero representativo de la cara del dado.
/*
definimos algunas variables constantes.
 */
    private int cant_Dados_Actuvos_Iniciales; // cantidad de dados  para iniciar el juego.
    private int cant_Dados_Inactivos_Iniciales; // candidad de dados inactivos al inicio del juego

    private int cuantas_Rondas; // define el numero de rondas a jugar.


    /*
    definimos los arreglos.
     */

    private Vector<Integer> dados_Activos; // guarda el estado de los dados activos al inicio del juego
    private Vector<Integer> dados_Inactivos; // guarda el estado del os dados inactivos al inicio del juego.

    private Vector<Integer>dados_Utilizados; // guarda los dados utilizados

    private Vector<Integer>ronda_del_Juego; // control de la ronda del juego [1 ; 5]

    private String [] string_Nombres_Iconos;




    public Juego_Geek() { // constructor
        cant_Dados_Actuvos_Iniciales = 7;
        cant_Dados_Inactivos_Iniciales=3;
        inicio();


    }

    public void inicio(){ // funcion inicializadora
        System.out.println("\nInicio el juego");
        tirada_DadosActivos();
        tirada_DadosInactivos();
        recibe_utilizados(99);//prueba
        recibe_utilizados(88);//prueba
        entrega_Inactivos(3);//prueba // reduce en 1 el arreglo dados_Inactivos.


        //recibe_utilizados(2);

       // tirada_Activos = new Vector<Integer>(cant_Dados_Actuvos_Iniciales);

    }

    public Vector<Integer> tirada_DadosActivos(){ // lanzamiento de los dados activos en el inicio de cada ronda.
        cara_Obtenida = new Dado();
        dados_Activos = new Vector<Integer>(cant_Dados_Actuvos_Iniciales);

        String auxiliar = ""; // para probar en consola la funcionalidad



        for(int i = 0; i < cant_Dados_Actuvos_Iniciales; i++){
            int receptor = cara_Obtenida.get_cara();
           dados_Activos.add(receptor);
           auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + cara_Obtenida.get_Nombre_Cara(receptor-1) + "\n";

        }

        System.out.println(" \nTirada Inicial Activos-> " + dados_Activos.toString());
        System.out.println(" \nTirada Inicial Activos Nombres->\n" + auxiliar.toString());



        return dados_Activos;

    }

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

    public Vector<Integer> recibe_utilizados(int paraRecibir){// actualiza (recibe) los dados ya utilizados en un arreglo;

        dados_Utilizados = new Vector<Integer>(10);// defaul size 10, cada campo es igual a 0;
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


        System.out.println(dados_Utilizados.toString());


        return dados_Utilizados;

    }
/*
Metodo que reduce en 1 el arreglo de dados_Inactivos, removiendo siempre la posición inicial.
 */
    public Vector<Integer> entrega_Inactivos(int paraEntregar){// actualiza (entrega) los dados inactivos en un arreglo;

        paraEntregar = dados_Inactivos.remove(0);


        System.out.println(" \n el tamaño del Vector dados_Inactivos es " + dados_Inactivos.size() + "\n");


        System.out.println(dados_Inactivos.toString());


        return dados_Inactivos;

    }



    public void pura_Accion(int jugado){ // toma el entero y desarrolla las acciones  según las reglas del juego.

        int entrega=999; // se inicializa

        String auxiliar =""; // para pruebas.

        switch (jugado) {
            case 0:
                entrega=6;
                auxiliar = "Corazon";
                break;
            case 1:
                auxiliar = "Dragon";
                break;
            case 2:
                auxiliar = "Mepplet";
                break;
            case 3:
                auxiliar = "Cohete";
                break;
            case 4:
                auxiliar = "Super-heroe";
                break;
            case 5:
                auxiliar = "42";
                break;
            default:
                auxiliar = " hay problemas..";
        }




    }














    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Juego_Geek myGUI = new Juego_Geek();
            }
        });
    }

}
