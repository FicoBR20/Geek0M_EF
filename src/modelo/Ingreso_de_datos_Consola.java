package modelo;

import java.awt.*;
import java.util.Scanner;

public class Ingreso_de_datos_Consola {



    public static void main(String[] args) {

        int sumando  = 220;
        Scanner scanner = new Scanner(System.in);
        System.out.println(" \nHola cual es tu eleccion ?\n");
        int respuesta = scanner.nextInt();
        System.out.println(" escogio bien..va ganando " + respuesta);

        System.out.println(" la suma da " + (sumando + respuesta));



    }
}




