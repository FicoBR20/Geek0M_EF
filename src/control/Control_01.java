package control;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase tendra la funcion de relacionar el modelo con la vista.
 */

public class Control_01 {
    /**
     * Valor en pixeles del ancho de la imagen
     * a ser usada para la cara del dado
     * * Nota: TODAS las 6 imágenes deberán terner
     * el mismo tamaño.
     */
    private int ancho_del_Dado;
    /**
     * Valor en pixeles del alto de la imagen
     * a ser usada para la cara del dado
     * Nota: TODAS las 6 imágenes deberán terner
     * el mismo tamaño.
     */

    private int alto_del_Dado;
    private Dimension dimension_Dado;

    public int getAncho_del_Dado() {
        return ancho_del_Dado;
    }

    public void setAncho_del_Dado(int ancho_del_Dado) {
        this.ancho_del_Dado = ancho_del_Dado;
    }

    public int getAlto_del_Dado() {
        return alto_del_Dado;
    }

    public void setAlto_del_Dado(int alto_del_Dado) {
        this.alto_del_Dado = alto_del_Dado;
    }


    public Dimension getDimension_Dado() {

        return dimension_Dado;
    }

    public void setDimension_Dado() {

        this.getAlto_del_Dado();
        this.getAncho_del_Dado();

        this.dimension_Dado = dimension_Dado;
    }

    public Control_01(){

        inicio_Control();


    }

    /**
     * Método que inicia configurando el tamaño
     * de los dados
     */
    public void inicio_Control(){

        /**
         * Se asigna el valor 42 dado que las imágenes
         * de los dados que se disponen tienen esa medida.
         */

        ancho_del_Dado = 42;
        alto_del_Dado =42;


    }

    /**
     * Método que configura la dimensión de los dados
     * @return dimension_Dado
     */

    public Dimension configuro_Dado(){

        dimension_Dado = new Dimension();

        setAncho_del_Dado(Integer.parseInt(JOptionPane.showInputDialog("ingrese medida en X")));

        setAlto_del_Dado(Integer.parseInt(JOptionPane.showInputDialog("ingrese medida en Y")));

        Dimension dimen_Ungresada = new Dimension( getAncho_del_Dado(), getAlto_del_Dado());

        System.out.println(" yo soy el tamaño del dado: [ "+ getAncho_del_Dado() + " ] ; [ " + getAlto_del_Dado() + " ] ");

        return dimension_Dado;


    }


}
