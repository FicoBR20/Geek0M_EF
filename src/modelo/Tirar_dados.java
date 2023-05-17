package modelo;

import java.util.Vector;
/**
 *   @archivo Tirar_dado.jar
 *   @author federico.barbetti:  Codigo es 2181247-2724
 *   @email federico.barbetti@correounivalle.edu.co
 *   @author Jose Erley Murillo Torres:  Codigo es 2177964-2724
 *   @email jose.erley.murillo@correounivalle.edu.co
 *   @version v.1.0.0 date:18/04/2023
 *   @licencia GPL
 */

/**
 * Esta clase aplica las reglas del juego
 * */
public class Tirar_dados {
    private Dado[] dado;
    private int tiro;
    private int cantidad_de_dados;
    private int sumatoria;
<<<<<<< HEAD
    //Array donde se guarda las dos caras del dado
    private Integer[] caras;
    private Integer[] caras_2;
=======
    //Vector donde se guarda las dos caras del dado
    private Integer[] caras,caras_2;
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c

    public Tirar_dados() {
        dado = new Dado[10];
        tiro = 0;
        sumatoria = 0;
        caras = new Integer[10];
        caras_2 = new Integer[10];
        cantidad_de_dados=0;
    }
<<<<<<< HEAD
    public Tirar_dados(int cantidad_de_dados) {
        dado = new Dado[10];
        tiro = 0;
        sumatoria = 0;
        caras = new Integer[10];
        caras_2 = new Integer[10];
        this.cantidad_de_dados=cantidad_de_dados-1;
    }
=======
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c


    public void setDado(int posicion) {
        this.dado[posicion] = new Dado();
    }

<<<<<<< HEAD
=======
    public void setCantidad_de_dados(int cantidad_de_dados) {
        this.cantidad_de_dados = cantidad_de_dados - 1;
    }

    public Dado[] getDado() {
        return dado;
    }

    public int getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(int sumatoria) {
        this.sumatoria = sumatoria;
    }

    public void setDado(int posicion, Dado dado) {
        this.dado[posicion] = dado;
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
    public Integer[] getCaras() {
        return caras;
    }

<<<<<<< HEAD
=======
    public void setCaras(Integer[] caras) {
        this.caras = caras;
    }

>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
    public void iniciar(int cantidad_de_dados) {
        for (int posicion = 0; posicion <= cantidad_de_dados -1 ; posicion++){
            //Toma un dado y lo mete a un vector de dados
<<<<<<< HEAD
            setDado(posicion);
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras[posicion] = dado[posicion].get_cara();
            sumatoria = caras[posicion] + sumatoria;
            System.out.println("Cara #"+(posicion+1)+" = "+ caras[posicion]);
        }
        //devuelve la cantidad de dados
        int tamano = dado.length;
=======
            setDado(i, new Dado());
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras[i] = dado[i].get_cara();
            sumatoria = caras[i] + sumatoria;
            System.out.println("Cara #"+(i+1)+" = "+ caras[i]);
        }
        //devuelve la cantidad de dados
        int tamano = dado.length;
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sunatoria = "+ sumatoria);
    }
    public void re_iniciar(int cantidad_de_dados) {
        for (int i = 0; i <= cantidad_de_dados -1 ; i++){
            //Toma un dado y lo mete a un vector de dados
            setDado(i, new Dado());
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras_2[i] = dado[i].get_cara();
            sumatoria = caras_2[i] + sumatoria;
            System.out.println("Cambio la cara #"+(i+1)+" de "+caras[i]+" a "+ caras_2[i]);
        }
        //devuelve la cantidad de dados
        int tamano = dado.length;
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sunatoria = "+ sumatoria);
    }
}