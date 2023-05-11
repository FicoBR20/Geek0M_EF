package vista;

import control.Controlador_v2;
import modelo.Dado;
import modelo.Juego_Geek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Gui_Basica_3_Buttons extends JFrame {

    private Controlador_v2 control_2;

    private Juego_Geek juegoGeek; // objeto de la clase modelo

    private DadoPoderoso dadoPoderoso1;
    private DadoPoderoso dadoPoderoso2;

    private DadoPoderoso dadoPoderoso3;


    private Dado dado;

    private ImageIcon imagen_dado;
    private Escucha escucha;
    private JButton jBut_Poderoso, jButton2, PLAY;

    private JButton[] jButtons;

    private JPanel jPanel1;

    private JLabel imageLabel;


    public Gui_Basica_3_Buttons() {// Jframe general setup; include initGUI method with initials values
        initGUI();
        this.setTitle(" GUI BASICA");
        this.setSize(800, 400);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method INITGUI -> ASSIGN INITIALS VALUES TO ALL ATTRIBUTES, RUN INTO CONSTRUCTOR
    private void initGUI() {

        juegoGeek = new Juego_Geek();

        control_2 = new Controlador_v2();


        dado = new Dado();
        jButtons = new JButton[10];
        imagen_dado = new ImageIcon();
        dadoPoderoso1 = new DadoPoderoso();
        dadoPoderoso2 = new DadoPoderoso();
        dadoPoderoso3 = new DadoPoderoso();


        escucha = new Escucha();
        jBut_Poderoso = new JButton(" jButton1 ");
        jBut_Poderoso.setPreferredSize(new Dimension(46, 46));
        jButton2 = new JButton("jButton2");
        //jButton2.setPreferredSize(new Dimension(130,130));
        PLAY = new JButton(" PLAY ");
        //PLAY.setPreferredSize(new Dimension(130,130));
        jPanel1 = new JPanel();
        imageLabel = new JLabel();




            jPanel1 = new JPanel();
            int sabio = 999;

            DadoPoderoso[] dadoOrganizado ; // arreglo

            dadoOrganizado= new DadoPoderoso[3];

            dadoOrganizado[0]=dadoPoderoso1;
            dadoOrganizado[1]=dadoPoderoso2;
            dadoOrganizado[2]=dadoPoderoso3;





            for (int i = 0; i < dadoOrganizado.length; i++) {

                // dadoOrganizado[i] = new DadoPoderoso();

                int selector = dadoPoderoso1.darlaCara();// genera un random

                imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                        selector + ".png")));

                dadoOrganizado[i].setIcon(imagen_dado);
                dadoOrganizado[i].addMouseListener(escucha);
                dadoOrganizado[i].addActionListener(escucha);
                dadoOrganizado[i].addKeyListener(escucha);
                dadoOrganizado[i].setCara(selector);

                jPanel1.add(dadoOrganizado[i]);

                System.out.println(" asi quedaron los nombres " + selector);

                repaint();
            }





        //=========================




        //===============================

//
//        jPanel1.add(jButton1,BorderLayout.SOUTH);
//        jPanel1.add(jButton2, BorderLayout.EAST);
           jPanel1.add(PLAY);



//
//        jButton1.addMouseListener(escucha);
//        jButton1.addKeyListener(escucha);
//        jButton2.addMouseListener(escucha);
//        jButton2.addKeyListener(escucha);
        PLAY.addMouseListener(escucha);
        PLAY.addKeyListener(escucha);
        PLAY.addActionListener(escucha);




        //this refers a JFrame setup
        this.add(jPanel1);


    }




    // MAIN --> FUNCTION TO LAUNCH THE APP.


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui_Basica_3_Buttons myGUI = new Gui_Basica_3_Buttons();
            }
        });
    }

    private class DadoPoderoso extends JButton{

        public DadoPoderoso(){
            dado = new Dado();
            jBut_Poderoso = new JButton();
            //initGUI();

        }

        public int darlaCara(){
            return dado.get_cara();
        }

        public void setCara(int dd){
            dado.setCara(dd);
        }

        public JButton ponerImagen(ImageIcon im){
            jBut_Poderoso.setIcon(im);

            return jBut_Poderoso;

        }



        public String darlaCara(int x){ // 0 Corazon, 1 dragon, 2 meeple, 3 cohete, 4 superheroe, 5 el 42.

           return dado.get_Nombre_Cara(x);


        }


    }


    private class Escucha implements MouseListener, KeyListener, ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {




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

            dado = new Dado();


            if  ((e.getSource()==dadoPoderoso1) || (e.getSource()==dadoPoderoso2) || (e.getSource()==dadoPoderoso3) ) {

                juegoGeek.pura_Accion(dadoPoderoso1.darlaCara());
                juegoGeek.pura_Accion(dadoPoderoso2.darlaCara());
                juegoGeek.pura_Accion(dadoPoderoso3.darlaCara());





                System.out.println(" funcionara");
            }






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
