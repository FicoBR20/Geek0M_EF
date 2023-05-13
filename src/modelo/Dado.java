package modelo;

import java.awt.*;
import java.util.Random;

/**
 * Clase dado que genera un numero aleatorio entre 1 y 6
 * @autor Jose Erley Murillo Torres
 * @version v.0.0.0 data 18/04/2023
 * */
public class Dado {

    //Atributo que retorna un lado de la cara del dado
    private int cara;

    private String [] string_Nombres_Iconos;

    public Dado(int cara, String[] string_Nombres_Iconos) {
        this.cara = cara;
        this.string_Nombres_Iconos = string_Nombres_Iconos;
    }

    public void setCara(int cara) {
        this.cara = cara;
    }

    public void setString_Nombres_Iconos(String[] string_Nombres_Iconos) {
        this.string_Nombres_Iconos = string_Nombres_Iconos;
    }

    public Dado(){ // contructor vacio

        inicioDado(); // inicia el arreglo de los nombres.

        cara = 999;
        //pruebas

        // System.out.println("El primer elemento es " + get_Nombre_Cara(0)+ "\n");

    }


    public int get_cara() {

        //Creo un objeto randon que me permite crear un numeros aleatorios
        int auxiliar=999;
        Random aleatorio = new Random();
        auxiliar = aleatorio.nextInt(6)+1;
        cara=auxiliar;
        return cara;
    }

    public void inicioDado(){ // se llena el arreglo con los nombres de las caras del dado.

        string_Nombres_Iconos = new String[6];

        string_Nombres_Iconos[0]="Corazon";
        string_Nombres_Iconos[1]="Dragon";
        string_Nombres_Iconos[2]="Mepplet";
        string_Nombres_Iconos[3]="Cohete";
        string_Nombres_Iconos[4]="Super_Heroe";
        string_Nombres_Iconos[5]="42";


    }

    public String get_Nombre_Cara(int posicion){ // entrega el string con el nombre de la cara segun la posicion en el arreglo
        String entrega ="";
        switch (posicion) {
            case 0:
                entrega = "Corazon";
                break;
            case 1:
                entrega = "Dragon";
                break;
            case 2:
                entrega = "Mepplet";
                break;
            case 3:
                entrega = "Cohete";
                break;
            case 4:
                entrega = "Super-heroe";
                break;
            case 5:
                entrega = "42";
                break;
            default:
                entrega = " hay problemas..";
        }

        return entrega;


    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dado myGUI = new Dado();
            }
        });
    }







}
