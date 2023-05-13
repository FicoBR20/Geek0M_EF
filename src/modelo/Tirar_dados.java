package modelo;

import java.net.Inet4Address;
import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Tirar_dados {
    private Dado[] dado;
    private int tiro;
    private int cantidad_de_dados;
    private int sumatoria;
    //Vector donde se guarda las dos caras del dado
    private Integer[] caras,caras_2;

    public Tirar_dados() {
        dado = new Dado[10];
        tiro = 0;
        sumatoria = 0;
        caras = new Integer[10];
        caras_2 = new Integer[10];
        cantidad_de_dados=0;
    }

    public int getCantidad_de_dados() {
        return cantidad_de_dados;
    }

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

    public Integer[] getCaras() {
        return caras;
    }

    public void setCaras(Integer[] caras) {
        this.caras = caras;
    }

    public void iniciar(int cantidad_de_dados) {
        for (int i = 0; i <= cantidad_de_dados -1 ; i++){
            //Toma un dado y lo mete a un vector de dados
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
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sunatoria = "+ sumatoria);
    }
}