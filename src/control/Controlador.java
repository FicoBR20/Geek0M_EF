package control;

import modelo.Dado;
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
    private final Integer[] habilitar_dado_inactivo;
    private final Integer[] habilitar_dado_usado;
    private final Integer[] habiltar_relance_dado;
    private final Integer[] estado;
    private final Integer[] estado_dado;
    private Tirar_dados tirar_dados;

    public Controlador() {
        habilitar_dado_inactivo = new Integer[10];
        habilitar_dado_usado = new Integer[10];
        habiltar_relance_dado = new Integer[10];
        cara = new Vector<Integer>();
        estado = new Integer[10];
        estado_dado = new Integer[10];
    }

//    public Controlador(int numero_de_dados) {
//        this.numero_de_dados = numero_de_dados;
//        lanzar_inicio(numero_de_dados);
//    }

    public void lanzar_inicio(int numero_de_dados){

        tirar_dados = new Tirar_dados();//Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados
        Model_Geek juegoGeek = new Model_Geek();//creo un objeto que aplicara la regla

        //Aqui tiro el o los dados
        tirar_dados.iniciar(numero_de_dados);
        setCara(tirar_dados.getCaras());//Toma las caras que se generan en la clase tirar_dados y las guarda en esta clase
    }

    public void recoger_dado_con_switch(int i, int cara_dado){
        switch (cara_dado) {
            case 1 -> {
                desbloquear_dados_inactivos();
                bloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste Corazon");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                }
//                else {
//                }
            case 2 -> {
                bloquear_dados_inactivos();
                bloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste Dragon");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                }
//                else {
//                }
            case 3 -> {
                bloquear_dados_inactivos();
                desbloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste Meeple");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//                    bloquear_relanzar_dado();
//                }
//                else {
//                }
            case 4 -> {
                bloquear_dados_inactivos();
                bloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste ship");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                }
//                else {
//                }
            case 5 -> {
                bloquear_dados_inactivos();
                bloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste Hero");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                }
//                else {
//                }
            case 6 -> {
                bloquear_dados_inactivos();
                bloquear_relanzar_dado();
                JOptionPane.showMessageDialog(null, "Seleccionaste point");
            }
//                if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                }
//                else {
//                }
        }
    }

//    public void recoger_dado(int numero_del_dado, int cara_dado){
//        if (cara_dado == 1 ){
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                JOptionPane.showMessageDialog(null,"se giro Corazon");
//            }
//            else {
//                desbloquear_dados_inactivos();
//                bloquear_relanzar_dado();
//            }
//
////            JOptionPane.showMessageDialog(null,"Corazon (activa dados inactivo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//        else if (cara_dado == 2 ){
//                bloquear_dados_inactivos();
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                JOptionPane.showMessageDialog(null,"se giro Dragon");
//            }
//            else {
//                bloquear_relanzar_dado();
//            }
//
////            JOptionPane.showMessageDialog(null,"Dragon (borra los puntos si es el ultimo dado dela ronda )\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//        else if (cara_dado == 3 ){
//                bloquear_dados_inactivos();
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//                JOptionPane.showMessageDialog(null,"se giro Meeple");
//                bloquear_relanzar_dado();
//            }
//            else {
//                desbloquear_relanzar_dado();
//            }
//
////            JOptionPane.showMessageDialog(null,"Meeple (permite relanzar otro dado en juego)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//        else if (cara_dado == 4 ){
//                bloquear_dados_inactivos();
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                JOptionPane.showMessageDialog(null,"se giro ship");
//            }
//            else {
//                bloquear_relanzar_dado();
//            }
//
////            JOptionPane.showMessageDialog(null,"Ship (manda un dada a los inactivos)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//        //Gira dado
//        else if (cara_dado == 5 ){
//                bloquear_dados_inactivos();
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                JOptionPane.showMessageDialog(null,"se giro Hero");
//            }
//            else {
//                bloquear_relanzar_dado();
//            }
//
////            JOptionPane.showMessageDialog(null,"Hero (gira un dado activo)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//        else if (cara_dado == 6 ){
//                bloquear_dados_inactivos();
//            if (habiltar_relance_dado[numero_del_dado] == 1){
//
//                JOptionPane.showMessageDialog(null,"se giro point");
//            }
//            else {
//                bloquear_relanzar_dado();
//            };
//
////            JOptionPane.showMessageDialog(null,"Point (permite sumar puntos al final de la ronda)\n "+"dado #"+(numero_del_dado+1)+" cara = "+ cara_dado);
//        }
//    }
    public void  set_estado_dado(int posicion, int _estado_dado){
        estado_dado[posicion] = _estado_dado;
    }
    public int  get_estado_dado(int posicion){
        return estado_dado[posicion];
    }

    public   void desbloquear_relanzar_dado(){
        for (int i=0; i<=9;i++){
            if (habilitar_dado_inactivo[i] == 1 && habilitar_dado_usado[i] == 1){
                habiltar_relance_dado[i] = 1;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden girar");
    }

    public   void bloquear_relanzar_dado(){
        for (int i=0; i<=9;i++){
            if (habilitar_dado_inactivo[i] == 1 && habilitar_dado_usado[i] == 1){
                habiltar_relance_dado[i] = 0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" no puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden girar");
    }
    public void  desbloquear_dados_inactivos(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0) {
                estado_dado[i] = 2;
//                setEstado(i,2);
                JOptionPane.showMessageDialog(null,"Se desbloqueo el dado = "+(i+1));
//                JOptionPane.showMessageDialog(null,
//                        "inactivo "+habilitar_dado_inactivo[i]+"usado "+habilitar_dado_usado[i]+"relance "+habiltar_relance_dado[i]);
//
            }
        }
    }

    public void  bloquear_dados_inactivos(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==2){
//                habilitar_dado_inactivo[i] = 0;
//                habilitar_dado_usado[i] = 1;
                estado_dado[i] = 0;
                JOptionPane.showMessageDialog(null,"Se bloqueo el dado = "+(i+1));
            }
        }
    }
//    public void  desbloquear_dados_inactivos(){
//        for (int i=0; i<=9;i++){
//            if (habilitar_dado_inactivo[i] == 0 && habilitar_dado_usado[i] == 1) {
//                habilitar_dado_inactivo[i] = 1;
//                habilitar_dado_usado[i] = 0;
////                setEstado(i,2);
//                JOptionPane.showMessageDialog(null,"Se desbloqueo el dado = "+(i+1));
////                JOptionPane.showMessageDialog(null,
////                        "inactivo "+habilitar_dado_inactivo[i]+"usado "+habilitar_dado_usado[i]+"relance "+habiltar_relance_dado[i]);
////
//            }
//        }
//    }
//
//    public void  bloquear_dados_inactivos(){
//        for (int i=0; i<=9;i++){
//            if (habilitar_dado_inactivo[i] == 1 && habilitar_dado_usado[i] == 0){
////                habilitar_dado_inactivo[i] = 0;
////                habilitar_dado_usado[i] = 1;
//                estado_dado[i] = 2;
//                JOptionPane.showMessageDialog(null,"Se bloqueo el dado = "+(i+1));
//            }
//        }
//    }


    public int get_dado_activo(int dado){
        return habilitar_dado_inactivo[dado];
    }
    public int get_dado_usado(int dado){
        return habilitar_dado_inactivo[dado];
    }
    public int get_girar_dado(int dado) {return habiltar_relance_dado[dado];};
    public void habilitar_giro(int dado){habiltar_relance_dado[dado]=1;}
    public void deshabilitar_giro(int dado){habiltar_relance_dado[dado]=0;}
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
        switch (estado[dado]) {
            case 1 -> JOptionPane.showMessageDialog(null, "pasa a dados usados");
            case 2 -> JOptionPane.showMessageDialog(null, "pasa a dados inactivos");
            case 3 -> JOptionPane.showMessageDialog(null, "pasa a dados puntos");
            case 4 -> JOptionPane.showMessageDialog(null, "Este dados esta activos");
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
    public void setCara_dado(int posicion, int cara) {
        this.cara.add(posicion,cara);
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

    public void setDado(Dado dado) {
        tirar_dados.setDado(dado);
    }

    public Vector<Dado> getDado() {
        return tirar_dados.getDado();
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

}