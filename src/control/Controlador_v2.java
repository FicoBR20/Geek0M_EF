package control;

import modelo.Dado;
import modelo.Juego_Geek;
import vista.Gui_Basica_3_Buttons;

import java.awt.*;

public class Controlador_v2 {

    public Controlador_v2(){

        inicio();

    }

    public void inicio(){

//        Dado dado;
//        dado = new Dado();
//
//
//
//
//        Juego_Geek juegoGeek;
//        juegoGeek = new Juego_Geek();
//        Gui_Basica_3_Buttons guiBasica3Buttons;
//        guiBasica3Buttons = new Gui_Basica_3_Buttons();
//
//
//
//        juegoGeek.pura_Accion(dado.get_cara());


    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Controlador_v2 myGUI = new Controlador_v2();
            }
        });
    }
}
