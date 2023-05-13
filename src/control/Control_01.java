package control;

import javax.swing.*;
import java.awt.*;

public class Control_01 {

    private int ancho_del_Dado;

    private int alto_del_Dado;

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

    private Dimension dimension_Dado;



    public Dimension getDimension_Dado() {
        return dimension_Dado;
    }

    public void setDimension_Dado(Dimension dimension_Dado) {
        this.dimension_Dado = dimension_Dado;
    }

    public Control_01(){

        inicio_Control();


    }

    public void inicio_Control(){

        ancho_del_Dado = 0;
        alto_del_Dado =0;


    }

    public void configuro_Dado(){

        setAncho_del_Dado(Integer.parseInt(JOptionPane.showInputDialog("ingrese medida en X")));

        setAlto_del_Dado(Integer.parseInt(JOptionPane.showInputDialog("ingrese medida en Y")));

        Dimension dimen_Ungresada = new Dimension( getAncho_del_Dado(), getAlto_del_Dado());

        System.out.println(" yo soy el tamaño del dado: [ "+ getAncho_del_Dado() + " ] ; [ " + getAlto_del_Dado() + " ] ");


    }


}
