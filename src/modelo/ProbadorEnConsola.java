package modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProbadorEnConsola extends JFrame {

    private Juego_Geek juegoGeek;

    private Dado dado;
    private Escucha escucha;
    private JButton Probador_1, Probador_2;


    private JPanel containerButtons, containerImage;


    public ProbadorEnConsola() {// Jframe general setup; include initGUI method with initials values
        initGUI();
        this.setTitle("Probador en consola");
        this.setSize(300, 200);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method INITGUI -> ASSIGN INITIALS VALUES TO ALL ATTRIBUTES, RUN INTO CONSTRUCTOR
    private void initGUI() {

        juegoGeek = new Juego_Geek();
        dado = new Dado();


        escucha = new Escucha();
        Probador_1 = new JButton("Porbador 1");
        Probador_2 = new JButton("Probador 2");

        containerButtons = new JPanel();


        containerButtons.add(Probador_1);
        containerButtons.add(Probador_2);

        //containerButtons.setFocusable(true);

        Probador_1.addMouseListener(escucha);
        Probador_2.addMouseListener(escucha);
        Probador_1.addActionListener(escucha);
        Probador_2.addActionListener(escucha);


        this.add(containerButtons, BorderLayout.CENTER);


    }

    // MAIN --> FUNCTION TO LAUNCH THE APP.


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ProbadorEnConsola myGUI = new ProbadorEnConsola();
            }
        });
    }


    private class Escucha implements MouseListener, KeyListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()== Probador_1){

                System.out.println(" estoy activo ve");

               juegoGeek.tirada_DadosActivos();

            }

            else if (e.getSource()== Probador_2){

                int probar =0;

                probar=Integer.parseInt(JOptionPane.showInputDialog("ingresa un valor entre 1 y 6"));

               // System.out.println(" la suma es " + (8 + probar));

                juegoGeek.accion_SuperHeroe(probar);







            }



        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}

