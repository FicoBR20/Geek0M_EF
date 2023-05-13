package modelo;

import java.util.Random;

public class Dado_01 {

    private String info_Auxiliar;
    /**
     * Cantidad de caras del Dado
     */
    private int selector_Figura;

    public String getInfo_Auxiliar() {
        return info_Auxiliar;
    }

    public void setInfo_Auxiliar(String info_Auxiliar) {
        this.info_Auxiliar = info_Auxiliar;
    }

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

    public Dado_01(){

        info_Auxiliar = " Hola soy Dado 01";
        selector_Figura = 6; // valor por defecto
    }


}
