package vista;

import java.awt.*;

public class Modelo_Geek {

    int totalizaPuntosObtenidos;

    public Modelo_Geek(){

        totalizaPuntosObtenidos=0;
    }

    public int puntajeRonda( int cuantos_42){
        if (cuantos_42==1){
            totalizaPuntosObtenidos=1;
        }
        else{
           totalizaPuntosObtenidos += puntajeRonda(cuantos_42-1);
        }
        System.out.println("cantidad de dados ganadores " + cuantos_42 + " esto suma "+ totalizaPuntosObtenidos);

        return totalizaPuntosObtenidos;
    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            Modelo_Geek modelo = new Modelo_Geek();
            modelo.puntajeRonda(1);
            modelo.puntajeRonda(2);

            modelo.puntajeRonda(6);
            modelo.puntajeRonda(8);
            modelo.puntajeRonda(10);

        });
    }
}
