package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Clase dado que genera un numero aleatorio entre 1 y 6
 * @autor Jose Erley Murillo Torres
 * @version v.0.0.0 data 18/04/2023
 * */
public class Dado extends JFrame {
    //Atributo que retorna un lado de la cara del dado
    private int cara;

    private Escucha escucha;



    public Dado(){ // contructor vacio

        inicioDado();




    }
    //Si presiono "Alt + Insert" genera un método predefinido
    public int get_cara() {
        //Creo un objeto randon que me permite crear un numeros aleatorios
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        return cara;
    }

    public void inicioDado(){

        escucha = new Escucha();

    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dado myGUI = new Dado();
            }
        });
    }

    private class Escucha implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }





}
