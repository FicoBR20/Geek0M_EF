package vista;

import control.Control_01;
import modelo.Dado_01;
import modelo.Modelo_01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Random;
import java.util.Vector;

/**
 * Clase que gestiona la interface gráfica de la aplicacíón
 */
public class Gui_01 extends JFrame {

    // variables temporales...DEBEN QUITARSE...

    private Modelo_01 modelo01;






    // variables temporales...DEBEN QUITARSE...





    /**
     * Atributo privado de la clase Control_01
     */
    private Control_01 control01;
    /**
     * Imagen gráfica de la cara del dado
     */
    private ImageIcon imageIcon;
    /**
     * Objeto de la clase privada Dado_Profesional
     */
    private Dado_Profesional dadoProfesional;
    /**
     * Atributo que representa la dimensión
     * del dado
     */
    private Dimension dimension_Auxiliar;
    /**
     * Objeto de la Clase privada Escuchas
     * que implemnta los listeners.
     */
    private Escuchas escuchas;

    private JButton jButton_BASICO, jButton1, jButton2, jButton3, jButton4;
    /**
     * Arreglo de datos tipo Dado_Profesional
     */

    private Vector<Dado_Profesional> carasLanzadas;





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

        // Varibles temporales deben quitarse

        modelo01 =  new Modelo_01();

        modelo01.tirada_DadosActivos();

        modelo01.tiradaInactivos();






        // Varibles temporales deben quitarse




        control01 = new Control_01();

        carasLanzadas = new Vector<>();
        carasLanzadas.setSize(10);



        imageIcon = new ImageIcon();


       dadoProfesional = new Dado_Profesional();


        escuchas = new Escuchas();




        jButton1 = new JButton("soy Jb 1");
        jButton2 = new JButton("soy JB 2");
        jButton3 = new JButton("soy JB 3");
        jButton4 = new JButton("soy JB 4");


        jLabel1 = new JLabel();
        jLabel1.setText("Soy JLabel 1");

//        jLabel2 = new JLabel();
//        jLabel3 = new JLabel();
//        jLabel4 = new JLabel();

        jPanel1 = new JPanel();
      //  jPanel1.setPreferredSize(new Dimension(control01.getAncho_del_Dado()*5, control01.getAlto_del_Dado()*2));

        jPanel2 = new JPanel();

        BorderLayout borderLayout = new BorderLayout();

        jPanel3 = new JPanel();

        jPanel3.setLayout(borderLayout);


//        jPanel4 = new JPanel();


        jButton1.addActionListener(escuchas);
        jButton1.addKeyListener(escuchas);
        jButton1.addMouseListener(escuchas);

        //jPanel1.add(jButton1);

//        jPanel2.add(jButton2);
//        jPanel2.add(jButton3);
//        jPanel2.add(jButton4);



        for (int i = 0; i < carasLanzadas.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.busqueda_Profesional();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    (auxiliar ) + ".png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.setSello(auxiliar);

            dadoProfesional.addActionListener(escuchas);

            dadoProfesional.addMouseListener(escuchas);

            dadoProfesional.addKeyListener(escuchas);

            carasLanzadas.setElementAt(dadoProfesional, i);

            jPanel1.add(carasLanzadas.get(i));


        }






//        jPanel3.add(jPanel1, BorderLayout.NORTH);
//        jPanel3.add(jPanel2, BorderLayout.SOUTH);





        this.add(jPanel1);
       // this.add(jPanel2);

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
         * Método que entrega valores entre 1 y 6
         * @return captura.
         */
        public int busqueda_Profesional(){

            int captura = 999; // inicializacion
            Random aleatorio = new Random();
            captura = aleatorio.nextInt(6)+1;
            return captura;


        }

        /**
         * Método constructor de Dado_Profesional
         */
        public Dado_Profesional(){

            sello=999; // inicialización



        }







    }

    private class Escuchas implements ActionListener, MouseListener, KeyListener {







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



            /**
             * Variable auxiliar que recepciona el atributo Sello
             * de un objeto de la Clase Dado_Profesional
             */
            int receptorSello=0;

            if (e.getSource().equals(carasLanzadas.elementAt(0))){
                receptorSello = carasLanzadas.get(0).getSello();
                System.out.println(" imprimo el sello " + receptorSello);
            }
            else {

                for (int i = 0; i < carasLanzadas.size(); i++) {
                    receptorSello = carasLanzadas.elementAt(i).getSello();

                    /**
                     * en adelante se ejecutaran las acciones según el valor
                     * rececionado en la variable receptorSello.
                     */


                    System.out.println(" secuencia de sello es " + receptorSello);
                }
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
