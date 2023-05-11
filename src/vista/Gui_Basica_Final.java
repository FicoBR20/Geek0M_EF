package Principal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Gui_Basica_Final extends JFrame {
    private Escucha escucha;
    private JButton jButton1, jButton2, jButtonPlay;
    private JPanel jPanel1, jPanel2;

    private JLabel jLabel1;

    private JTextArea jTextArea;


    public Gui_Basica_Final() {// Jframe general setup; include initGUI method with initials values
        initGUI();
        this.setTitle("My Presentation");
        this.setSize(688, 488);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method INITGUI -> ASSIGN INITIALS VALUES TO ALL ATTRIBUTES, RUN INTO CONSTRUCTOR
    private void initGUI() {
        escucha = new Escucha();
        jButton1 = new JButton("jB-1");
        jButton2 = new JButton("jB-2");
        jButtonPlay = new JButton("JBPLAY ");
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        //listener = new Listener();
        jLabel1 = new JLabel();
        jTextArea = new JTextArea(10, 12);


        jPanel2.add(jLabel);


        jPanel2.add(jButton1);
        jPanel2.add(jButton1);
        //containerButtons.setFocusable(true);

        jButton1.addMouseListener(escucha);
        jButton1.addMouseListener(escucha);


        //this refers a JFrame setup
        this.add(jPanel2, BorderLayout.SOUTH);
        this.add(jPanel2, BorderLayout.CENTER);


    }

    // MAIN --> FUNCTION TO LAUNCH THE APP.


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Principal.Gui_Basica_Final myGUI = new Principal.Gui_Basica_Final();
            }
        });
    }


    private class Escucha implements MouseListener, KeyListener, ActionListener {


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


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}



}

