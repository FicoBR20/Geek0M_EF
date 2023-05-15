package modelo;

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
    private Integer[] caras;
    private Integer[] caras_2;

    public Tirar_dados() {
        dado = new Dado[10];
        tiro = 0;
        sumatoria = 0;
        caras = new Integer[10];
        caras_2 = new Integer[10];
        cantidad_de_dados=0;
    }
    public Tirar_dados(int cantidad_de_dados) {
        dado = new Dado[10];
        tiro = 0;
        sumatoria = 0;
        caras = new Integer[10];
        caras_2 = new Integer[10];
        this.cantidad_de_dados=cantidad_de_dados-1;
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

    public void setDado(int posicion) {
        this.dado[posicion] = new Dado();
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
        for (int posicion = 0; posicion <= cantidad_de_dados -1 ; posicion++){
            //Toma un dado y lo mete a un vector de dados
            setDado(posicion);
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras[posicion] = dado[posicion].get_cara();
            sumatoria = caras[posicion] + sumatoria;
            System.out.println("Cara #"+(posicion+1)+" = "+ caras[posicion]);
        }
        //devuelve la cantidad de dados
        int tamano = dado.length;
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sunatoria = "+ sumatoria);
    }
}