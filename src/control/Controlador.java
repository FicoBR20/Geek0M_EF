package control;

import modelo.Tirar_dados;
import modelo.Juego_Geek;

import javax.swing.*;
import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
    private int numero_de_dados;
    private Vector<Integer> cara;
    private int flag, estado, punto;
    private Vector<String>Estado_string;
    private Integer[] habilitar_dado_inactivo;
    private Integer[] habilitar_dado_usado;

    public Controlador() {
        this.numero_de_dados = numero_de_dados;
        habilitar_dado_inactivo = new Integer[10];
        habilitar_dado_usado = new Integer[10];
    }

    public Controlador(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
        inicio(numero_de_dados);
    }

    public void inicio(int numero_de_dados){
        System.out.println("Entro");
        //Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados
        //creo un objeto que aplicara la regla
        Tirar_dados _tirar_dados = new Tirar_dados();
        Juego_Geek juegoGeek = new Juego_Geek();

        //Aqui tiro el o los dados
        _tirar_dados.iniciar(numero_de_dados);

        //Recojo el resultado de los dados y lo capturo en la clase de regla

//        _model_geekEr.setPunto(getPunto());
//        _model_geekEr.setValidacion_tiro(getFlag());
//        _model_geekEr.setTiro(_tirar_dados.getSumatoria());
//        _model_geekEr.ronda_tiro();
//        setPunto(_model_geekEr.getPunto());


        setCara(_tirar_dados.getCaras());//Toma las caras que se generan en la clase tirar_dados y las guarda en esta clase
//
//        setFlag( _model_geekEr.getValidacion_tiro());
//        setEstado(_model_geekEr.getEstado());
//        setEstado_string(_model_geekEr.getEstado_string());

//        System.out.println("\nCONTROL estado del juego = "+ _model_geekEr.getEstado()+" || El tiro fue "+_tirar_dados.getSumatoria());
//        System.out.println("CONTROL |Bandera|"+ _model_geekEr.getValidacion_tiro());
    }
    public void recoge_dado(int numero_del_dado,int cara_dado){
        if (cara_dado == 1 ){
            for (int i = 0; i<=9; i++){
                    System.out.println("Dado "+(i+1)+"         inactivo = "+habilitar_dado_inactivo[i]+" ||        activo = "+habilitar_dado_usado[i]);
                if (habilitar_dado_inactivo[i] == 0 && habilitar_dado_usado[i] == 1) {
                    habilitar_dado_inactivo[i] = 1;
//                    habilitar_dado_usado[i] = 0;
                    System.out.println("Dado "+(i+1)+" cambia  inactivo = "+habilitar_dado_inactivo[i]+" || cambia activo = "+habilitar_dado_usado[i]);
                }
            }
            System.out.println("________________");
//            if (habilitar_dado_inactivo[0] == 0) {
//                habilitar_dado_inactivo[0] = 1;
//            }
//            if (habilitar_dado_inactivo[1] == 0) {
//                habilitar_dado_inactivo[1] = 1;
//            }
//            if (habilitar_dado_inactivo[2] == 0) {
//                habilitar_dado_inactivo[2] = 1;
//            }
//            else if (habilitar_dado_inactivo[3] == 0) {
//                habilitar_dado_inactivo[3] = 1;
//            }
//            else if (habilitar_dado_inactivo[4] == 0) {
//                habilitar_dado_inactivo[4] = 1;
//            }
//            else if (habilitar_dado_inactivo[5] == 0) {
//                habilitar_dado_inactivo[5] = 1;
//            }
//            else if (habilitar_dado_inactivo[6] == 0) {
//                habilitar_dado_inactivo[6] = 1;
//            }
//            else if (habilitar_dado_inactivo[7] == 0) {
//                habilitar_dado_inactivo[7] = 1;
//            }
//            else if (habilitar_dado_inactivo[8] == 0) {
//                habilitar_dado_inactivo[8] = 1;
//            }
//            else if (habilitar_dado_inactivo[9] == 0) {
//                habilitar_dado_inactivo[9] = 1;
//            }
            JOptionPane.showMessageDialog(null,"Corazon (activa dados inactivo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 2 ){
            JOptionPane.showMessageDialog(null,"Dragon (borra los puntos si es el ultimo dado dela ronda )\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 3 ){
            JOptionPane.showMessageDialog(null,"Meeple (permite relanzar otro dado en juego)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 4 ){
            JOptionPane.showMessageDialog(null,"Ship (manda un dada a los inactivos)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 5 ){
            JOptionPane.showMessageDialog(null,"Hero (gira un dado activo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 6 ){

            JOptionPane.showMessageDialog(null,"Point (permite sumar puntos al final de la ronda)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
    }


    public int dado_activo(int dado){
        return habilitar_dado_inactivo[dado];
    }
    public int dado_usado(int dado){
        return habilitar_dado_inactivo[dado];
    }
    public void deshabilitar_dado_inactivo(int dado){
        habilitar_dado_inactivo[dado] = 0;
    }
    public void habilitar_dado_inactivo(int dado){
        habilitar_dado_inactivo[dado] = 1;
    }
    public void deshabilitar_dado_usado(int dado){
        habilitar_dado_usado[dado] = 0;
    }
    public void habilitar_dado_usado(int dado){
        habilitar_dado_usado[dado] = 1;
    }


    public void dado_estado(){
        switch (estado){
            case 1:
                JOptionPane.showMessageDialog(null,"pasa a dados usados");
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"pasa a dados inactivos");
                break;
            case 3:
                JOptionPane.showMessageDialog(null,"pasa a dados puntos");
                break;
            case 4:
                JOptionPane.showMessageDialog(null,"Este dados esta activos");
                break;
        }
    }
    public void estado_inicio(int estado){
        this.estado = estado;
        dado_estado();
    }

    public int getNumero_de_dados() {
        return numero_de_dados;
    }

    public void setNumero_de_dados(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Vector<Integer> getCara() {
        return cara;
    }

    public void setCara(Vector<Integer> cara) {
        this.cara = cara;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Vector<String> getEstado_string() {
        return Estado_string;
    }

    public void setEstado_string(Vector<String> estado_string) {
        Estado_string = estado_string;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }
}