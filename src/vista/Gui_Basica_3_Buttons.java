package vista;

import modelo.Dado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Gui_Basica_3_Buttons extends JFrame {

    private DadoPoderoso dadoPoderoso;

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


        dado = new Dado();
        jButtons = new JButton[10];
        imagen_dado = new ImageIcon();
        dadoPoderoso = new DadoPoderoso();


        escucha = new Escucha();
        jBut_Poderoso = new JButton(" jButton1 ");
        jBut_Poderoso.setPreferredSize(new Dimension(46, 46));
        jButton2 = new JButton("jButton2");
        //jButton2.setPreferredSize(new Dimension(130,130));
        PLAY = new JButton(" PLAY ");
        //PLAY.setPreferredSize(new Dimension(130,130));
        jPanel1 = new JPanel();
        imageLabel = new JLabel();


        //=========================


        jPanel1 = new JPanel();
        int sabio = 999;

        DadoPoderoso[] dadoOrganizado ;

        dadoOrganizado= new DadoPoderoso[4];

        //jPanel1.setPreferredSize(new Dimension(4*100, 4*100));
        for (int i = 1; i <= 3; i++) {
            //for (int j=1; j<=5; j++) {
            dadoOrganizado[i] = new DadoPoderoso();

            int selector = dadoPoderoso.darlaCara();


            imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                            selector + ".png")));

            dadoOrganizado[i].setIcon(imagen_dado);
            dadoOrganizado[i].addMouseListener(escucha);
            dadoOrganizado[i].addActionListener(escucha);
            dadoOrganizado[i].addKeyListener(escucha);

            jPanel1.add(dadoOrganizado[i]);

            System.out.println(" asi quedaron los nombres " + selector);

            //dadoPoderoso = new DadoPoderoso();
            //dadoOrganizado[j] = new DadoPoderoso();

            repaint();
        }



        //===============================

//
//        jPanel1.add(jButton1,BorderLayout.SOUTH);
//        jPanel1.add(jButton2, BorderLayout.EAST);
//        jPanel1.add(PLAY, BorderLayout.WEST);



//
//        jButton1.addMouseListener(escucha);
//        jButton1.addKeyListener(escucha);
//        jButton2.addMouseListener(escucha);
//        jButton2.addKeyListener(escucha);
//        PLAY.addMouseListener(escucha);
//        PLAY.addKeyListener(escucha);
//        PLAY.addActionListener(escucha);




        //this refers a JFrame setup
        this.add(jPanel1);


    }

    /**
     * Este método construye un Jlabel[]
     * @return un JLabel[]
     */

    public void contruirArreglo(){

        jPanel1 = new JPanel();
        //jPanel1.setPreferredSize(new Dimension(700,300));
        //jPanel1.setVisible(true);

        dadoPoderoso = new DadoPoderoso();
        dadoPoderoso.setText(" no no no...no soy yo...");
        dadoPoderoso.setPreferredSize(new Dimension(46,46));


//        for (int i=1;i<=2;i++){
//
//
//
//                imagen_dado = new ImageIcon(getClass().getResource("/recursos/p" + dadoPoderoso.darlaCara() + ".png"));
//
//                dadoPoderoso.ponerImagen(imagen_dado);
//                dadoPoderoso.addActionListener(escucha);
//                dadoPoderoso.addMouseListener(escucha);
//                dadoPoderoso.addKeyListener(escucha);
//
//
//                jPanel1.add(dadoPoderoso, BorderLayout.EAST);
//            }
        imagen_dado = new ImageIcon(getClass().getResource("/recursos/"+dadoPoderoso.darlaCara()+".png"));

        //EJEMPLO


        // EJEMPLO

       // imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/3.png")));

        dadoPoderoso.ponerImagen(imagen_dado);




        jPanel1.add(dadoPoderoso, BorderLayout.CENTER);




        //return jPanel1;
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


        }

        public int darlaCara(){
            return dado.get_cara();
        }

        public JButton ponerImagen(ImageIcon im){
            jBut_Poderoso.setIcon(im);

            return jBut_Poderoso;

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

