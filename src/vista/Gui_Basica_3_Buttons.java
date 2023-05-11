package vista;

import control.Controlador_v2;
import modelo.Dado;
import modelo.Juego_Geek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;


/**
 * Se genera esta clase para desarrollar una estrategia enfocada a un nuevo tipo de dato
 * denominado DadoPoderoso.
 *
 */
public class Gui_Basica_3_Buttons extends JFrame {

    private Controlador_v2 control_2;

    private Juego_Geek juegoGeek; // objeto de la clase modelo

    private DadoPoderoso dadoPoderoso1;
    private DadoPoderoso dadoPoderoso2;

    private DadoPoderoso dadoPoderoso3;

    private DadoPoderoso dadoPoderoso4;
    private DadoPoderoso dadoPoderoso5;

    private DadoPoderoso dadoPoderoso6;

    private DadoPoderoso dadoPoderoso7;
    private DadoPoderoso dadoPoderoso8;

    private DadoPoderoso dadoPoderoso9;

    private DadoPoderoso dadoPoderoso10;


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
        dadoPoderoso4 = new DadoPoderoso();
        dadoPoderoso5 = new DadoPoderoso();
        dadoPoderoso6 = new DadoPoderoso();
        dadoPoderoso7 = new DadoPoderoso();
        dadoPoderoso8 = new DadoPoderoso();
        dadoPoderoso9 = new DadoPoderoso();
        dadoPoderoso10 = new DadoPoderoso();


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

        DadoPoderoso[] dadoOrganizado; // arreglo

        dadoOrganizado = new DadoPoderoso[10];

        dadoOrganizado[0] = dadoPoderoso1;
        dadoOrganizado[1] = dadoPoderoso2;
        dadoOrganizado[2] = dadoPoderoso3;
        dadoOrganizado[3] = dadoPoderoso4;
        dadoOrganizado[4] = dadoPoderoso5;
        dadoOrganizado[5] = dadoPoderoso6;
        dadoOrganizado[6] = dadoPoderoso7;
        dadoOrganizado[7] = dadoPoderoso8;
        dadoOrganizado[8] = dadoPoderoso9;
        dadoOrganizado[9] = dadoPoderoso10;


        for (int i = 0; i < dadoOrganizado.length; i++) {

            // dadoOrganizado[i] = new DadoPoderoso();

            int selector = dadoPoderoso1.darlaCara_Poderosa();// genera un random

            imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    selector + ".png")));

            dadoOrganizado[i].setIcon(imagen_dado);
            dadoOrganizado[i].addMouseListener(escucha);
            dadoOrganizado[i].addActionListener(escucha);
            dadoOrganizado[i].addKeyListener(escucha);

            dadoOrganizado[i].setCara_Poderosa(selector);

            jPanel1.add(dadoOrganizado[i]);

            System.out.println(" asi quedaron los nombres " + selector + " representa la figura " + dadoOrganizado[i].darlaCara_Poderosa(selector - 1));

            repaint();
        }


        jPanel1.add(PLAY);


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

    /**
     *
     * Esta Clase herda de Dado y extiende JButton
     * Creo que esta estrategia es eficiente...seguiré en el intento.
     */

    private class DadoPoderoso extends JButton {

        public DadoPoderoso() {
            dado = new Dado();
            jBut_Poderoso = new JButton();
            //initGUI();

        }

        public int darlaCara_Poderosa() {
            return dado.get_cara();
        }

        public void setCara_Poderosa(int dd) {
            dado.setCara(dd);
        }

        public JButton ponerImagen(ImageIcon im) {
            jBut_Poderoso.setIcon(im);

            return jBut_Poderoso;

        }


        public String darlaCara_Poderosa(int x) { // 0 Corazon, 1 dragon, 2 meeple, 3 cohete, 4 superheroe, 5 el 42.

            return dado.get_Nombre_Cara(x);


        }


    }


    private class Escucha implements MouseListener, ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == PLAY) {

                initGUI();


            }

        }


            @Override
            public void mouseClicked (MouseEvent e){

               // dado = new Dado();


                if ((e.getSource() == dadoPoderoso1) || (e.getSource() == dadoPoderoso2) || (e.getSource() == dadoPoderoso3)
                        || (e.getSource() == dadoPoderoso4) || (e.getSource() == dadoPoderoso5) || (e.getSource() == dadoPoderoso6)
                        || (e.getSource() == dadoPoderoso7) || (e.getSource() == dadoPoderoso8) || (e.getSource() == dadoPoderoso9)
                        || (e.getSource() == dadoPoderoso10)) {

                    juegoGeek.pura_Accion(dadoPoderoso1.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso2.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso3.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso4.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso5.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso6.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso7.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso8.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso9.darlaCara_Poderosa());
                    juegoGeek.pura_Accion(dadoPoderoso10.darlaCara_Poderosa());




                    System.out.println(" funcionara" + dadoPoderoso1.darlaCara_Poderosa());
                    ;
                }


            }

            @Override
            public void mousePressed (MouseEvent e){

            }

            @Override
            public void mouseReleased (MouseEvent e){

            }

            @Override
            public void mouseEntered (MouseEvent e){

            }

            @Override
            public void mouseExited (MouseEvent e){

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
    }
}
