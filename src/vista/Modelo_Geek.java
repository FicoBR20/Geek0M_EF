package vista;

import java.awt.*;
import java.util.Random;

/**
 * Clase que implementa las reglas del juego.
 */

public class Modelo_Geek {
    private int cara;

/*
getCara retorna un valor entreo entre 1 y 6
cada entero se osociara a una imagen diversa.
 */

    public int getCara() {
        Random random = new Random();
        cara = random.nextInt(6)+1;
        System.out.println(" cara es " + cara);
        return cara;
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Modelo_Geek modelo = new Modelo_Geek();
            modelo.getCara();
        });
    }


}
