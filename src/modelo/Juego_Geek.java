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

    private Vector<Integer>tirada_Activos; // guarda el estado de los dados activos al inicio del juego
    private Vector<Integer>tirada_Inactivos; // guarda el estado del os dados inactivos al inicio del juego.

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

       // tirada_Activos = new Vector<Integer>(cant_Dados_Actuvos_Iniciales);

    }

    public Vector<Integer> tirada_DadosActivos(){ // lanzamiento de los dados activos en el inicio de cada ronda.
        cara_Obtenida = new Dado();
        tirada_Activos = new Vector<Integer>(cant_Dados_Actuvos_Iniciales);

        String auxiliar = "";



        for(int i = 0; i < cant_Dados_Actuvos_Iniciales; i++){
            int receptor = cara_Obtenida.get_cara();
           tirada_Activos.add(receptor);
           auxiliar = auxiliar + "La cara del dado [ "+ (i+1) + " ] es: " + cara_Obtenida.get_Nombre_Cara(receptor-1) + "\n";
           //System.out.println(" nombres Activos" + tirada_Activos.get(i));
        }

        System.out.println(" \nTirada Inicial Activos-> " + tirada_Activos.toString());
        System.out.println(" \nTirada Inicial Nombres->\n" + auxiliar.toString());



        return tirada_Activos;

    }

    public Vector<Integer> tirada_DadosInactivos(){// lanzamiento de los dados inactivos en el inicio de cada ronda.
        cara_Obtenida = new Dado();
        tirada_Inactivos = new Vector<Integer>(cant_Dados_Inactivos_Iniciales);

        for(int i = 0; i < cant_Dados_Inactivos_Iniciales; i++){
            tirada_Inactivos.add(cara_Obtenida.get_cara());
        }

        System.out.println(" \nTirada Inicial Inactivos -> " + tirada_Inactivos.toString());

        return tirada_Inactivos;

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
