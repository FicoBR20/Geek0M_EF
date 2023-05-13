package vista;

import control.Control_01;
import modelo.Dado_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Gui_01 extends JFrame {
    /**
     * Icono de la cara del Dado
     */
    private ImageIcon imageIcon;

    private Dado_Profesional dadoProfesional;

  //  private Control_01 control01;

    private Dado_01 dado01;

    private Dimension dimension_Auxiliar;

    private Escuchas escuchas;

    private JButton jButton_BASICO, jButton1, jButton2, jButton3, jButton4;
    /**
     * Arreglo de datos tipo Dado_Profesional
     */
    private JButton[] arreglo_jButton;

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

        imageIcon = new ImageIcon();

        dado01 = new Dado_01();

      //  control01 = new Control_01();

       // dadoProfesional = new Dado_Profesional();

       // dimension_Auxiliar = control01.configuro_Dado();



        escuchas = new Escuchas();

       // jButton_BASICO = new JButton();



        jButton1 = new JButton("soy Jb 1");
        jButton2 = new JButton("soy JB 2");
        jButton3 = new JButton("soy JB 3");
        jButton4 = new JButton("soy JB 4");

        arreglo_jButton = new JButton[6];

        jLabel1 = new JLabel();
        jLabel1.setText("Soy JLabel 1");

//        jLabel2 = new JLabel();
//        jLabel3 = new JLabel();
//        jLabel4 = new JLabel();

        jPanel1 = new JPanel();
      //  jPanel1.setPreferredSize(new Dimension(control01.getAncho_del_Dado()*5, control01.getAlto_del_Dado()*2));

//        jPanel2 = new JPanel();
//        jPanel3 = new JPanel();
//        jPanel4 = new JPanel();

        jButton1.addActionListener(escuchas);
        jButton1.addKeyListener(escuchas);
        jButton1.addMouseListener(escuchas);

        //jPanel1.add(jButton1);

//        jPanel1.add(jButton2);
//        jPanel1.add(jButton3);
//        jPanel1.add(jButton4);

        for (int i = 0; i < arreglo_jButton.length; i++) {
            arreglo_jButton[i]=new JButton();
            arreglo_jButton[i].setPreferredSize(new Dimension(42,42));
            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    (i+1) + ".png")));
            arreglo_jButton[i].setIcon(imageIcon);
            arreglo_jButton[i].setText("estoy ya");

            arreglo_jButton[i].addActionListener(escuchas);
            arreglo_jButton[i].addMouseListener(escuchas);
            arreglo_jButton[i].addMouseListener(escuchas);
            jPanel1.add(arreglo_jButton[i]);

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

    /**
     * Esta Clase extiende JButton y por ser una clase privada de la Gui_01
     * accede a la clase Dado_01 (atributo privado)
     */

    private class Dado_Profesional extends JButton{

        private Dado_01 dado_Completo;

        private ImageIcon imageCaraDado;
        /**
         * Atributo entero que asocia secuencialmente
         * el icono de la cara del dado
         */
        private int sello;

        public int getSello() {
            return sello;
        }

        public void setSello(int sello) {
            this.sello = sello;
        }

        /**
         * Método constructor de Dado_Profesional
         */
        public Dado_Profesional(){



        }







    }

    private class Escuchas implements ActionListener, MouseListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==arreglo_jButton[0]){

                System.out.println(" soy el corazon");
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
