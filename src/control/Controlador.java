package control;

import modelo.Dado;
import modelo.Juego_Geek;
import modelo.Model_Geek;
import modelo.Tirar_dados;

import javax.swing.*;
import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
    private int numero_de_dados;
    private Integer[] cara;
    private int flag, punto;
    private String[] Estado_string;
//    private final Integer[] habilitar_dado_inactivo;
//    private final Integer[] habilitar_dado_usado;
//    private final Integer[] habiltar_relance_dado;
    private final Integer[] estado;
    private final Integer[] estado_dado;
    private Tirar_dados tirar_dados;
    private  Juego_Geek juegoGeek;
    private int cantidad_en_usados,cantidad_en_inactivos,cantidad_en_puntos,cantidad_en_activo;

    public Controlador() {

        cara = new Integer[10];
        estado = new Integer[10];
        estado_dado = new Integer[10];
        cantidad_en_usados = 0;
        cantidad_en_inactivos = 0;
        cantidad_en_puntos = 0;
        cantidad_en_activo = 0;
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

    public void activar_dado(int i, int cara_dado){
        switch (cara_dado) {
            case 1 -> {
                desbloquear_corazon();
                bloquear_nave();
                bloquear_heroe();
                bloquear_punto();
                bloquear_dragon();
                bloquear_meeple();
                estado[i] = 4;
                JOptionPane.showMessageDialog(null, "Seleccionaste Corazon");
            }

            case 2 -> {
//                desbloquear_dragon();
                bloquear_nave();
                bloquear_heroe();
                bloquear_punto();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 4;
                JOptionPane.showMessageDialog(null, "Seleccionaste Dragon");
            }

            case 3 -> {
                desbloquear_meeple();
                bloquear_nave();
                bloquear_heroe();
                bloquear_punto();
                bloquear_dragon();
                bloquear_corazon();
                estado[i] = 4;
                JOptionPane.showMessageDialog(null, "Seleccionaste Meeple");
            }

            case 4 -> {
                desbloquear_nave();
                bloquear_heroe();
                bloquear_punto();
                bloquear_dragon();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 4;
                JOptionPane.showMessageDialog(null, "Seleccionaste ship");
            }

            case 5 -> {

                desbloquear_heroe();
                bloquear_nave();
                bloquear_punto();
                bloquear_dragon();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 4;
                JOptionPane.showMessageDialog(null, "Seleccionaste Hero");
            }

            case 6 -> {

//                desbloquear_punto();
                bloquear_nave();
                bloquear_heroe();
                bloquear_dragon();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 3;
//                juegoGeek.accion_Cuarenta_y_Dos(6);
                JOptionPane.showMessageDialog(null, "Seleccionaste point");
            }
        }
    }

    public int getCantidad_en_usados() {
        return cantidad_en_usados;
    }

    public int getCantidad_en_inactivos() {
        return cantidad_en_inactivos;
    }

    public int getCantidad_en_puntos() {
        return cantidad_en_puntos;
    }

    public int getCantidad_en_activo() {
        return cantidad_en_activo;
    }



    public void cuenta_dados_usados() {
        cantidad_en_usados++;
    }
    public void cuenta_dados_inactivos() {

        cantidad_en_inactivos++;
    }
    public void cuenta_dados_enPunto() {

        cantidad_en_puntos++;
    }
    public void cuenta_dados_activos() {

        cantidad_en_activo++;
    }


    public void resta_dados_usados() {
        cantidad_en_usados--;
    }
    public void resta_dados_inactivos() {

        cantidad_en_inactivos--;
    }
    public void resta_dados_enPunto() {

        cantidad_en_puntos--;
    }
    public void resta_dados_activos() {

        cantidad_en_activo--;
    }








    public int getPunto() {

        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public void voltear_dado(int posicion){
//        for (int i=0; i<=9;i++){
            switch (cara[posicion]) {
                case 1 -> cara[posicion]=6;
                case 2 -> cara[posicion]=5;
                case 3 -> cara[posicion]=4;
                case 4 -> cara[posicion]=3;
                case 5 -> cara[posicion]=2;
                case 6 -> cara[posicion]=1;
            }
//        }
    }

    public void desbloquear_punto() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=6;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden poner punto");
    }
    public void bloquear_punto() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==6){
                estado_dado[i]=0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden poner punto");
    }

    public void desbloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=5;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden votear");
    }
    public void bloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==5){
                estado_dado[i]=0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden voltear");
    }

    public void desbloquear_nave() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=4;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden destruir");
    }
    public void bloquear_nave() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==4){
                estado_dado[i]=0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden destruir");
    }

    public   void desbloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=3;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden girar");
    }
    public   void bloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==3){
                estado_dado[i]=0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" no puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden girar");
    }

    public void desbloquear_dragon() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=2;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden quitar punto");
    }
    public void bloquear_dragon() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==2){
                estado_dado[i]=0;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden quitar punto");
    }

    public void desbloquear_corazon(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==7) {
                estado_dado[i] = 1;
//                setEstado(i,2);
                JOptionPane.showMessageDialog(null,"Se desbloqueo el dado = "+(i+1));
//                JOptionPane.showMessageDialog(null,
//                        "inactivo "+habilitar_dado_inactivo[i]+"usado "+habilitar_dado_usado[i]+"relance "+habiltar_relance_dado[i]);
//
            }
        }
    }
    public void bloquear_corazon(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==1){
//                habilitar_dado_inactivo[i] = 0;
//                habilitar_dado_usado[i] = 1;
                estado_dado[i] = 7;
                JOptionPane.showMessageDialog(null,"Se bloqueo el dado = "+(i+1));
            }
        }
    }

    public void  set_estado_dado(int posicion, int _estado_dado){
        estado_dado[posicion] = _estado_dado;
    }
    public int  get_estado_dado(int posicion){
        return estado_dado[posicion];
    }

    public void dado_estado(int dado){
        switch (estado[dado]) {
            case 1 -> JOptionPane.showMessageDialog(null, "pasa a dados usados");
            case 2 -> JOptionPane.showMessageDialog(null, "pasa a dados inactivos");
            case 3 -> JOptionPane.showMessageDialog(null, "pasa a dados puntos");
            case 4 -> JOptionPane.showMessageDialog(null, "Este dados esta activos");
        }
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

    public Integer[] getCara() {
        return cara;
    }

    public void setCara(Integer[] cara) {
        this.cara = cara;
    }
    public void setCara_dado(int posicion, int cara) {
        this.cara[posicion] = cara;
    }

    public int getEstado(int dado) {
        return estado[dado];
    }

    public void setEstado(int dado, int estado) {
        this.estado[dado] = estado;
    }

    public String[] getEstado_string() {
        return Estado_string;
    }

    public void setEstado_string(String[] estado_string) {
        Estado_string = estado_string;
    }

    public void setDado(int posicion) {
        tirar_dados.setDado(posicion);
    }

    public Dado[] getDado() {
        return tirar_dados.getDado();
    }
}