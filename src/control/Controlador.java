package control;

import modelo.Model_Geek;
import modelo.Tirar_dados;

import javax.swing.*;
import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
    private int numero_de_dados;
    private Vector<Integer> cara;
    private int flag, punto;
    private Vector<String>Estado_string;
    private Integer[] habilitar_dado_inactivo;
    private Integer[] habilitar_dado_usado;
    private Integer[] estado;

    public Controlador() {
        habilitar_dado_inactivo = new Integer[10];
        habilitar_dado_usado = new Integer[10];
        estado = new Integer[10];
    }

    public Controlador(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
        inicio(numero_de_dados);
    }

    public void inicio(int numero_de_dados){

        //Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados
        //creo un objeto que aplicara la regla
        Tirar_dados _tirar_dados = new Tirar_dados();
        Model_Geek juegoGeek = new Model_Geek();

        //Aqui tiro el o los dados
        _tirar_dados.iniciar(numero_de_dados);
        setCara(_tirar_dados.getCaras());//Toma las caras que se generan en la clase tirar_dados y las guarda en esta clase
    }
    public void recoger_dado(int numero_del_dado, int cara_dado){
        if (cara_dado == 1 ){
            desbloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Corazon (activa dados inactivo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 2 ){
            bloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Dragon (borra los puntos si es el ultimo dado dela ronda )\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 3 ){
            bloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Meeple (permite relanzar otro dado en juego)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 4 ){
            bloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Ship (manda un dada a los inactivos)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        //Gira dado
        else if (cara_dado == 5 ){
            bloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Hero (gira un dado activo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
        else if (cara_dado == 6 ){
            bloquear_dados_inactivos();

//            JOptionPane.showMessageDialog(null,"Point (permite sumar puntos al final de la ronda)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
        }
    }

    private void  desbloquear_dados_inactivos(){
        for (int i=0; i<=9;i++){
            if (habilitar_dado_inactivo[i] == 0 && habilitar_dado_usado[i] == 1) {
                habilitar_dado_inactivo[i] = 1;
                habilitar_dado_usado[i] = 0;
//                setEstado(0,4);
                JOptionPane.showMessageDialog(null,"Cambió = "+i);
            }
        }
    }

    private void  bloquear_dados_inactivos(){
        for (int i=0; i<=9;i++){
            if (habilitar_dado_inactivo[i] == 1 && habilitar_dado_usado[i] == 0){
                habilitar_dado_inactivo[i] = 0;
                habilitar_dado_usado[i] = 1;
                JOptionPane.showMessageDialog(null,"Cambió 2 = "+i);
            }
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


    public void dado_estado(int dado){
        switch (estado[dado]){
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
//    public void estado_inicio(int estado){
//        this.estado[dado] = estado;
//        dado_estado();
//    }

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

    public int getEstado(int dado) {
        return estado[dado];
    }

    public void setEstado(int dado, int estado) {
        this.estado[dado] = estado;
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