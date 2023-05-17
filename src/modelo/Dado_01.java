package modelo;

import java.util.Random;

/**
 * Clase que implementa el objeto Dado_01.
 * Representa las 6 caras del dado, maneja un
 * valor entero comprendido en el rango [1 ; 6]
 */

public class Dado_01 {

    /**
     * Cantidad de caras del Dado
     */
    private int selector_Figura;

    public int getSelector_Figura() {
        return selector_Figura;
    }

    public void setSelector_Figura(int selector_Figura) {
        this.selector_Figura = selector_Figura;
    }

    /**
     * Método aleatorio que entrega un entero en un
     * rango [ 1 ; 6 ]
     * @return captura.
     */
    public int busqueda_Aleatoria(){

        int captura = 999; // inicializacion
        Random aleatorio = new Random();
        captura = aleatorio.nextInt(selector_Figura)+1;
        return captura;


    }

    /**
     * Método constructor de Dado_01
     */

    public Dado_01(){

        selector_Figura = 6; // valor por defecto
    }


}
