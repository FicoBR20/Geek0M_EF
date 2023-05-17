package modelo;

import javax.swing.*;
import java.util.Vector;

/**
 *   @archivo Block_Unblock.java
 *   @author federico.barbetti:  Codigo es 2181247-2724
 *   @email federico.barbetti@correounivalle.edu.co
 *   @author Jose Erley Murillo Torres:  Codigo es 2177964-2724
 *   @email jose.erley.murillo@correounivalle.edu.co
 *   @version v.1.0.0 date:21/03/2023
 *   @licencia GPL
 */

/**
 *Esta clase gurda en estado en el que los dodos pueden estar bloqueados o desbloqueados
 * Estado 0 no permite ninguna accion en los dados
 * Estado 1 activa los dados desactivados
 * Estado 2 si es el ultimo borra los puntos
 * Estado 3 los dados pueden relansarse
 * Estado 4 los dados pueden destruise
 * Estado 5 los dados pueden voltearse
 * Estado 6 el dado 42 puede pasar a puntos
 * Estado 7 los dados bloqueados no se pueden usar
 * Estado 8 corazon
 */

public class Block_Unblock {

    private  Vector<Integer> regla_del_dado;

    public Block_Unblock() {
        regla_del_dado = new Vector<>(10);
    }

    public void desbloquear_punto() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0){
                regla_del_dado.add(i,6);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden poner punto");
    }
    public void bloquear_punto() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0 || regla_del_dado.get(i)==6){
                regla_del_dado.add(i,0);

//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden poner punto");
    }



    public void desbloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0){
                regla_del_dado.add(i,5);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden votear");
    }
    public void bloquear_heroe() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0 || regla_del_dado.get(i)==5){
                regla_del_dado.add(i,0);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden voltear");
    }

    public void desbloquear_nave() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0){
                regla_del_dado.add(i,4);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden destruir");
    }
    public void bloquear_nave() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0 || regla_del_dado.get(i)==4){
                regla_del_dado.add(i,0);;
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden destruir");
    }

    public   void desbloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0){
                regla_del_dado.add(i,3);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden girar");
    }
    public   void bloquear_meeple(){
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0 || regla_del_dado.get(i)==3){
                regla_del_dado.add(i,0);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" no puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden girar");
    }

    public void desbloquear_dragon() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0){
                regla_del_dado.add(i,2);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados pueden quitar punto");
    }
    public void bloquear_dragon() {
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==0 || regla_del_dado.get(i)==2){
                regla_del_dado.add(i,0);
//                JOptionPane.showMessageDialog(null,"El dado "+(i+1)+" ya puede girar");
            }
        }
        JOptionPane.showMessageDialog(null,"Los dados no pueden quitar punto");
    }

    public void desbloquear_corazon(){
        for (int i=0; i<=9;i++){
            if (regla_del_dado.get(i)==7){
                regla_del_dado.add(i,1);
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
            if (regla_del_dado.get(i)==1){
                regla_del_dado.add(i,7);
                JOptionPane.showMessageDialog(null,"Se bloqueo el dado = "+(i+1));
            }
        }
    }
}
