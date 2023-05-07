package vista;

import java.awt.*;
import java.util.Random;

/**
 * Clase que genera la cara del dado, valor entero aliatorio entre [1, 6]
 * cada numero se le asociara un icono y asi conformar las 6 caras del dado.
 */

public class Dado_Geek {
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
            Dado_Geek modelo = new Dado_Geek();
            modelo.getCara();
        });
    }


}
