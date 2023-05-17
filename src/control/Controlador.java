package control;


import modelo.Tirar_dados;

import javax.swing.*;



/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
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


            }
        }
    }


    public void voltear_dado(int posicion){
            switch (cara[posicion]) {
                case 1 -> cara[posicion]=6;
                case 2 -> cara[posicion]=5;
                case 3 -> cara[posicion]=4;
                case 4 -> cara[posicion]=3;
                case 5 -> cara[posicion]=2;
                case 6 -> cara[posicion]=1;

            }
    }
    //________________________________________________________________________


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

    public void  set_estado_dado(int posicion, int _estado_dado){
        estado_dado[posicion] = _estado_dado;
    }
    public int  get_estado_dado(int posicion){
        return estado_dado[posicion];
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

}