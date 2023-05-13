package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui_01 extends JFrame {

    private Escuchas escuchas;

    private JButton jButton1, jButton2, jButton3, jButton4;

    private JButton[] arreglo;

    private JLabel jLabel1, jLabel2, jLabel3, jLabel4;

    private JPanel jPanel1, jPanel2, jPanel3, jPanel4;

    public Gui_01 (){

        Inicio();

        this.setSize( 600,300);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);





    }

    public void Inicio(){

        escuchas = new Escuchas();

        jButton1 = new JButton("soy Jb 1");
        jButton2 = new JButton("soy JB 2");
        jButton3 = new JButton("soy JB 3");
        jButton4 = new JButton("soy JB 4");

        arreglo = new JButton[10];

        jLabel1 = new JLabel();
        jLabel1.setText("Soy JLabel 1");
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();

        jPanel1 = new JPanel();
        jPanel1.setVisible(true); // Ubicar booleana referenciada.
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jPanel4 = new JPanel();

        jButton1.addActionListener(escuchas);
        jButton1.addKeyListener(escuchas);
        jButton1.addMouseListener(escuchas);

        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);
        jPanel1.add(jButton4);

        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i]=new JButton();
            arreglo[i].addActionListener(escuchas);
            arreglo[i].addMouseListener(escuchas);
            arreglo[i].addMouseListener(escuchas);
            jPanel1.add(arreglo[i]);

        }

        this.add(jPanel1);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui_01 myGUI = new Gui_01();
            }
        });
    }

    private class Escuchas implements ActionListener, MouseListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==jButton1){

                System.out.println(" soy el JB 1");
                JOptionPane.showMessageDialog(null, " soy el JB 1");
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
