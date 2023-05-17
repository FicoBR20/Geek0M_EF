package control;

<<<<<<< HEAD
import modelo.Tirar_dados;

import javax.swing.*;
=======
import modelo.*;

import javax.swing.*;
import java.util.Objects;
import java.util.Vector;
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
<<<<<<< HEAD
    private Integer[] cara;
    private final Integer[] estado;
    private final Integer[] estado_dado;

    public Controlador() {
        cara = new Integer[10];
        estado = new Integer[10];
        estado_dado = new Integer[10];
    }

    public void lanzar_inicio(int numero_de_dados){

        Tirar_dados tirar_dados = new Tirar_dados();//Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados

        //Aqui tiro el o los dados
        tirar_dados.iniciar(numero_de_dados);
        setCara(tirar_dados.getCaras());//Toma las caras que se generan en la clase tirar_dados y las guarda en esta clase
    }

    public void activar_dado(int i, int cara_dado){
        int contador_dado_42;
        int contador_otros_dado;
        int contador_dado_dragon;
        switch (cara_dado) {

            //Desbloquea la habilidad del corazón
            case 1 -> {
                desbloquear_corazon();
                bloquear_nave();
                bloquear_heroe();
                bloquear_meeple();
                estado[i] = 1;
                JOptionPane.showMessageDialog(null, "Activa un dado inactivo");
            }

            //Desbloquea la habilidad del dragon
            case 2 -> {
                bloquear_nave();
                bloquear_heroe();
                bloquear_corazon();
                bloquear_meeple();

                contador_dado_dragon = 0;
                contador_otros_dado = 0;
                contador_dado_42 = 0;
                for (int posicion=0; posicion<=9;posicion++){

                    if (get_estado_dado(posicion)==0 && cara[posicion] == 2){
                        contador_dado_dragon++;
                    }
                    if (get_estado_dado(posicion)==0 && cara[posicion] == 6){
                        contador_dado_42++;
                    }
                    else if (get_estado_dado(posicion)==0 && cara[posicion] != null&&cara[posicion] != 2){
                        contador_otros_dado++;
                    }
                }

                //Condición: Se pierden puntos si si dado 42 es mayor o igual a cero y n
                if(contador_dado_42 >= 0 && contador_otros_dado <=0){
                    JOptionPane.showMessageDialog(null, "Pierde puntos" +
                            "\n Se relanzan dados en punto");
                    estado[i] = 5;

                }
                //Si no se cumple la condición el dado no hace nada
                else{
                    JOptionPane.showMessageDialog(null, "No se puede activar" +
                            "\nhasta que sea el ultimo dado" +
                            "\no solo queden dados 42");
                    estado[i] = 4;
                }
            }

            //Desbloquea la habilidad del meeple
            case 3 -> {
                desbloquear_meeple();
                bloquear_nave();
                bloquear_heroe();
                bloquear_corazon();
                estado[i] = 1;
                JOptionPane.showMessageDialog(null, "Relanza un dado activo");
            }
            //Desbloquea la habilidad de la nave
            case 4 -> {
                desbloquear_nave();
                bloquear_heroe();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 1;
                JOptionPane.showMessageDialog(null, "Destruye un dado activo");
            }
            //Desbloque la habilidad del heroe
            case 5 -> {
                desbloquear_heroe();
                bloquear_nave();
                bloquear_corazon();
                bloquear_meeple();
                estado[i] = 1;
                JOptionPane.showMessageDialog(null, "Voltea un dado activo");
            }
            //Desbloquea la habilidad de los puntos
            case 6 -> {
                bloquear_nave();
                bloquear_heroe();
                bloquear_corazon();
                bloquear_meeple();

                contador_dado_42 = 0;
                contador_otros_dado = 0;
                for (int posicion=0; posicion<=9;posicion++){
                    if (get_estado_dado(posicion)==0 && cara[posicion] == 6){
                        contador_dado_42++;
                    }
                    else if (get_estado_dado(posicion)==0 && cara[posicion] != null){
                        contador_otros_dado++;
                    }
                }
                if(contador_otros_dado ==0&&contador_dado_42 >=1){
                    if (contador_dado_42 ==1){
                         JOptionPane.showMessageDialog(null, "El dado pasa a puntos");
                    }else {
                        JOptionPane.showMessageDialog(null, "Los dados pasan a puntos");
                    }
                    estado[i] = 6;
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se puede mover" +
                            "\nhasta que sea el ultimo dado");
//                    estado[i] = 4;
                }

=======
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
    private Model_prueba modelPrueba,modelPrueba_2;
    private Block_Unblock blockUnblock;

    public Controlador() {

        cara = new Integer[10];
        estado = new Integer[10];
        estado_dado = new Integer[10];
        cantidad_en_usados = 0;
        cantidad_en_inactivos = 0;
        cantidad_en_puntos = 0;
        cantidad_en_activo = 0;
        modelPrueba = new Model_prueba();
        modelPrueba_2 = new Model_prueba();
    }


    public int getCara(int posicion) {
        return modelPrueba.getCara(posicion);
    }

    public void setCara(int posicion,int cara) {
        modelPrueba.setCara(posicion, cara);
    }

    //______________________________________________________________

    public void lanzar_inicio(int cantidad_dados) {
        JOptionPane.showMessageDialog(null, "Entro a lanzar en control ");
        modelPrueba.lanzar_inicio(cantidad_dados);
    }

    public void reglas(int posicion){

        switch (get_estado_dado(posicion)) {
            case 0 -> {
                JOptionPane.showMessageDialog(null, "regla 0");
                System.out.println("agarre el dado = " + (posicion + 1));
                activar_dado(posicion, cara[posicion]);
                cambiar_posicion_dado(posicion);
                JOptionPane.showMessageDialog(null, "Estados del dado = "+posicion+
                        "\nNumero de cara = "+cara[posicion]);
            }
            case 1 -> {
                JOptionPane.showMessageDialog(null, "regla 1 corazon");
                System.out.println("agarre el dado = " + (posicion + 1));
                bloquear_corazon();
                setEstado(posicion, 2);
                cambiar_posicion_dado(posicion);
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null, "regla 2 dragon");
                bloquear_dragon();
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, "regla 3 meeple");
                System.out.println("agarre el dado = " + (posicion + 1));
                bloquear_meeple();
                setEstado(posicion, 4);
                relanzar_dado(posicion);
            }
            case 4 -> {
                JOptionPane.showMessageDialog(null, "regla 4 nave");
                bloquear_nave();
                setEstado(posicion, 4);
                cambiar_posicion_dado(posicion);
            }
            case 5 -> {
                JOptionPane.showMessageDialog(null, "regla 5 heroe");
                bloquear_heroe();
                voltear_dado(posicion);
            }
            case 6 -> {
                JOptionPane.showMessageDialog(null, "regla 6 punto");
                bloquear_punto();
                setEstado(posicion, 3);
                JOptionPane.showMessageDialog(null, "El dado esta en el panel = " + getEstado(posicion));
                cambiar_posicion_dado(posicion);
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
            }
        }
    }

<<<<<<< HEAD
    public void voltear_dado(int posicion){
            switch (cara[posicion]) {
                case 1 -> cara[posicion]=6;
                case 2 -> cara[posicion]=5;
                case 3 -> cara[posicion]=4;
                case 4 -> cara[posicion]=3;
                case 5 -> cara[posicion]=2;
                case 6 -> cara[posicion]=1;
=======

    public void relanzar_dado(int i){
        modelPrueba_2.lanzar_inicio(10);
        modelPrueba.setCara(i,modelPrueba_2.getCara(i));
//        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + control.getCara().get(i) + ".png")));
//        dado[i].setIcon(imagen_dado);
    }
//    public void voltear_dado(int i){
//        voltear_dado(i);
//        imagen_dado =new ImageIcon((getClass().getResource("/recursos/" + getCara().get(i) + ".png")));
//        dado[i].setIcon(imagen_dado);
//    }


    public void cambiar_posicion_dado(int posicion) {
        modelPrueba.cambiar_posicion_dado(posicion);
    }


    public void bloquear_corazon() {
        modelPrueba.bloquear_corazon();
    }

    public void bloquear_dragon() {
        modelPrueba.bloquear_dragon();
    }

    public void bloquear_meeple() {
        modelPrueba.bloquear_meeple();
    }

    public void bloquear_nave() {
        modelPrueba.bloquear_nave();
    }

    public void bloquear_heroe() {
        modelPrueba.bloquear_heroe();
    }

    public void bloquear_punto() {
        modelPrueba.bloquear_punto();
    }



    public void activar_dado(int posicion, Integer cara) {
        modelPrueba.activar_dado(posicion, cara);
    }

    public void cuenta_dados_inactivos(){
        modelPrueba.cuenta_dados_inactivos();
    }

    public void cuenta_dados_activos() {
        modelPrueba.cuenta_dados_activos();
    }

 //    public void activar_dado(int i, int cara_dado){
//        switch (cara_dado) {
//            case 1 -> {
//                desbloquear_corazon();
//                bloquear_nave();
//                bloquear_heroe();
//                bloquear_punto();
//                bloquear_dragon();
//                bloquear_meeple();
//                estado[i] = 4;
//                JOptionPane.showMessageDialog(null, "Seleccionaste Corazon");
//            }
//
//            case 2 -> {
////                desbloquear_dragon();
//                bloquear_nave();
//                bloquear_heroe();
//                bloquear_punto();
//                bloquear_corazon();
//                bloquear_meeple();
//                estado[i] = 4;
//                JOptionPane.showMessageDialog(null, "Seleccionaste Dragon");
//            }
//
//            case 3 -> {
//                desbloquear_meeple();
//                bloquear_nave();
//                bloquear_heroe();
//                bloquear_punto();
//                bloquear_dragon();
//                bloquear_corazon();
//                estado[i] = 4;
//                JOptionPane.showMessageDialog(null, "Seleccionaste Meeple");
//            }
//
//            case 4 -> {
//                desbloquear_nave();
//                bloquear_heroe();
//                bloquear_punto();
//                bloquear_dragon();
//                bloquear_corazon();
//                bloquear_meeple();
//                estado[i] = 4;
//                JOptionPane.showMessageDialog(null, "Seleccionaste ship");
//            }
//
//            case 5 -> {
//
//                desbloquear_heroe();
//                bloquear_nave();
//                bloquear_punto();
//                bloquear_dragon();
//                bloquear_corazon();
//                bloquear_meeple();
//                estado[i] = 4;
//                JOptionPane.showMessageDialog(null, "Seleccionaste Hero");
//            }
//
//            case 6 -> {
//
////                desbloquear_punto();
//                bloquear_nave();
//                bloquear_heroe();
//                bloquear_dragon();
//                bloquear_corazon();
//                bloquear_meeple();
//                estado[i] = 3;
////                juegoGeek.accion_Cuarenta_y_Dos(6);
//                JOptionPane.showMessageDialog(null, "Seleccionaste point");
//            }
//        }
//    }

//    public int getCantidad_en_usados() {
//        return cantidad_en_usados;
//    }
//
//    public int getCantidad_en_inactivos() {
//        return cantidad_en_inactivos;
//    }
//
//    public int getCantidad_en_puntos() {
//        return cantidad_en_puntos;
//    }
//
//    public int getCantidad_en_activo() {
//        return cantidad_en_activo;
//    }
//
//
//
//    public void cuenta_dados_usados() {
//        cantidad_en_usados++;
//    }
//    public void cuenta_dados_inactivos() {
//
//        cantidad_en_inactivos++;
//    }
//    public void cuenta_dados_enPunto() {
//
//        cantidad_en_puntos++;
//    }
//    public void cuenta_dados_activos() {
//
//        cantidad_en_activo++;
//    }

//
//    public void resta_dados_usados() {
//        cantidad_en_usados--;
//    }
//    public void resta_dados_inactivos() {
//
//        cantidad_en_inactivos--;
//    }
//    public void resta_dados_enPunto() {
//
//        cantidad_en_puntos--;
//    }
//    public void resta_dados_activos() {
//
//        cantidad_en_activo--;
//    }

    public int getPunto() {

        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public void voltear_dado(int i){
//        for (int i=0; i<=9;i++){
            switch (cara[i]) {
                case 1 -> cara[i] = 6;
                case 2 -> cara[i] = 5;
                case 3 -> cara[i] = 4;
                case 4 -> cara[i] = 3;
                case 5 -> cara[i] = 2;
                case 6 -> cara[i] = 1;
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
            }
    }
    //________________________________________________________________________

<<<<<<< HEAD

    public void desbloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=5;
            }
        }
    }
    public void bloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==5){
                estado_dado[i]=0;
            }
        }
    }

    public void desbloquear_nave() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=4;
            }
        }
    }
    public void bloquear_nave() {
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==4){
                estado_dado[i]=0;
            }
        }
    }

    public   void desbloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0){
                estado_dado[i]=3;
            }
        }
    }

    public   void bloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==0 || estado_dado[i]==3){
                estado_dado[i]=0;;
            }
        }
    }

    public void desbloquear_corazon(){
        int contador_otros_dado=0;
        for (int posicion=0; posicion<=9;posicion++){
            if (get_estado_dado(posicion)==7 && cara[posicion] != null){
                contador_otros_dado++;
            }
        }
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==7) {
                estado_dado[i] = 1;
            }
            if (contador_otros_dado==0) {
                estado_dado[i] = 0;
            }
            else if (estado_dado[i]==0){
                estado_dado[i] = 6;
            }
        }
    }

    public void bloquear_corazon(){
        for (int i=0; i<=9;i++){
            if (estado_dado[i]==1){
                estado_dado[i] = 7;
            }
            if (estado_dado[i]==6){
                estado_dado[i] = 0;
            }
        }
    }
=======
//    public void desbloquear_punto() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0){
//                estado_dado[i]=6;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados pueden poner punto");
//    }
//    public void bloquear_punto() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0 || estado_dado[i]==6){
//                estado_dado[i]=0;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados no pueden poner punto");
//    }
//
//    public void desbloquear_heroe() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0){
//                estado_dado[i]=5;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados pueden votear");
//    }
//    public void bloquear_heroe() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0 || estado_dado[i]==5){
//                estado_dado[i]=0;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados no pueden voltear");
//    }
//
//    public void desbloquear_nave() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0){
//                estado_dado[i]=4;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados pueden destruir");
//    }
//    public void bloquear_nave() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0 || estado_dado[i]==4){
//                estado_dado[i]=0;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados no pueden destruir");
//    }
//
//    public   void desbloquear_meeple(){
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0){
//                estado_dado[i]=3;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados pueden girar");
//    }
//    public   void bloquear_meeple(){
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0 || estado_dado[i]==3){
//                estado_dado[i]=0;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" no puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados no pueden girar");
//    }
//
//    public void desbloquear_dragon() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0){
//                estado_dado[i]=2;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados pueden quitar punto");
//    }
//    public void bloquear_dragon() {
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==0 || estado_dado[i]==2){
//                estado_dado[i]=0;
////                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
//            }
//        }
//        JOptionPane.showMessageDialog(null,"Los dados no pueden quitar punto");
//    }
//
//    public void desbloquear_corazon(){
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==7) {
//                estado_dado[i] = 1;
////                setEstado(i,2);
//                JOptionPane.showMessageDialog(null,"Se desbloqueo el dado = "+(i+1));
////                JOptionPane.showMessageDialog(null,
////                        "inactivo "+habilitar_dado_inactivo[i]+"usado "+habilitar_dado_usado[i]+"relance "+habiltar_relance_dado[i]);
////
//            }
//        }
//    }
//    public void bloquear_corazon(){
//        for (int i=0; i<=9;i++){
//            if (estado_dado[i]==1){
////                habilitar_dado_inactivo[i] = 0;
////                habilitar_dado_usado[i] = 1;
//                estado_dado[i] = 7;
//                JOptionPane.showMessageDialog(null,"Se bloqueo el dado = "+(i+1));
//            }
//        }
//    }
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c

    public void  set_estado_dado(int posicion, int _estado_dado){
        estado_dado[posicion] = _estado_dado;
    }
    public int  get_estado_dado(int posicion){
        return estado_dado[posicion];
    }

<<<<<<< HEAD
    public Integer[] getCara() {
        return cara;
    }

    public void setCara(Integer[] cara) {
        this.cara = cara;
    }
=======
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


>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
    public void setCara_dado(int posicion, int cara) {
        this.cara[posicion] = cara;
    }

    public int getEstado(int dado) {
        return estado[dado];
    }

    public void setEstado(int dado, int estado) {
        this.estado[dado] = estado;
    }

<<<<<<< HEAD
=======
//    public Vector<String> getEstado_string() {
//        return Estado_string;
//    }

//    public void setEstado_string(Vector<String> estado_string) {
//        Estado_string = estado_string;
//    }

    public void setDado(int i, Dado dado) {
        tirar_dados.setDado(i, dado);
    }

    public Integer[] getDado() {
        return tirar_dados.getDado();
    }


    public void limpiar_dados(int cantida_dados) {
//        modelPrueba.limpiar_dados(cantida_dados);
    }
>>>>>>> 21754bd0c0f7fd9b7a93ea42189d39839186382c
}