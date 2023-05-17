package vista;

import control.Control_01;
import modelo.Dado_01;
import modelo.Modelo_01;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Vector;

/**
 * Clase que gestiona la interface gráfica de la aplicacíón
 */
public class Gui_02_Ind extends JFrame {


    private Modelo_01 modelo01;



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
     * Objeto de la Clase privada Escuchas
     * que implemnta los listeners.
     */
    private Escuchas escuchas;

    private JButton jButton_BASICO, jButton1, jButton2, jButton3, jButton4;


    private JLabel jLabel1, jLabel2, jLabel3, jLabel4;

    private JPanel jPanel_Dados_Activos, jPanel_Dados_Inactivos, jPanel_Dados_Utilizados, jPanel_Tabla_Puntuación;

    /**
     * Contenedor de mas alto nivel en
     * este proyecto
     */
    private Container containerPricipal;

    /**
     * Método constructor de la Gui
     */
    public Gui_02_Ind(){

        Inicio();

        this.setTitle("GOF");
        this.setSize( 1200,600);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public void Inicio(){


        modelo01 =  new Modelo_01();

        control01 = new Control_01();

        imageIcon = new ImageIcon();


        escuchas = new Escuchas();



        jButton1 = new JButton("soy Jb 1");
        jButton2 = new JButton("soy JB 2");
        jButton3 = new JButton("soy JB 3");
        jButton4 = new JButton("soy JB 4");



//        jLabel2 = new JLabel();
//        jLabel3 = new JLabel();
//        jLabel4 = new JLabel();

        BorderLayout borderLayout = new BorderLayout();

        containerPricipal = new Container();

        containerPricipal.setLayout(borderLayout);

        dadoProfesional = new Dado_Profesional();








/**
 * Se genera el panel de los dados activos
 */

        jPanel_Dados_Activos = new JPanel();

        for (int i = 0; i < 6; i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar = 0;

            auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    (auxiliar) + ".png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);

            dadoProfesional.addActionListener(escuchas);

            dadoProfesional.addMouseListener(escuchas);

            dadoProfesional.addKeyListener(escuchas);

            jPanel_Dados_Activos.add(dadoProfesional);

        }

/**
 * Se genera el panel de los dados Utilizados
 */

        jPanel_Dados_Utilizados = new JPanel();

        for (int i = 0; i < 10; i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar = 0;

            auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/Basico_utilizados.png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);

            dadoProfesional.addActionListener(escuchas);

            dadoProfesional.addMouseListener(escuchas);

            dadoProfesional.addKeyListener(escuchas);

            jPanel_Dados_Utilizados.add(dadoProfesional);

        }



            jPanel_Dados_Inactivos = new JPanel();


            for (int i = 0; i < 3; i++){


                dadoProfesional = new Dado_Profesional();

                int auxiliar = 0;

                auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

                imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                        (auxiliar) + ".png")));

                dadoProfesional.setIcon(imageIcon);

                dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);

                dadoProfesional.addActionListener(escuchas);

                dadoProfesional.addMouseListener(escuchas);

                dadoProfesional.addKeyListener(escuchas);

            }




            jButton1.addActionListener(escuchas);
        jButton1.addKeyListener(escuchas);
        jButton1.addMouseListener(escuchas);



        containerPricipal.add(jPanel_Dados_Activos, BorderLayout.CENTER);

        containerPricipal.add(jPanel_Dados_Inactivos, BorderLayout.EAST);

        containerPricipal.add(jPanel_Dados_Utilizados, BorderLayout.WEST);

        containerPricipal.add(jPanel_Tabla_Puntuación, BorderLayout.SOUTH);








    /**
     * Se genera el panel para la tabla de puntuacion
     */

        jPanel_Tabla_Puntuación = new JPanel();


        for (int i = 0; i < 10; i++) {


        dadoProfesional = new Dado_Profesional();

        //  int auxiliar =0;

        // auxiliar = dadoProfesional.busqueda_Profesional();

        imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/ta_" +
                (i ) + ".png")));

        dadoProfesional.setIcon(imageIcon);

        dadoProfesional.dado_Heredado.setSelector_Figura(i);
//
//            dadoProfesional.addActionListener(escuchas);
//
//            dadoProfesional.addMouseListener(escuchas);
//
//            dadoProfesional.addKeyListener(escuchas);





    }


        this.add(containerPricipal);

    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Gui_02_Ind myGUI = new Gui_02_Ind();
            }
        });
    }


    /**
     * Esta Clase extiende JButton y por ser una clase privada de la Gui_01
     * accede a la clase Dado_01 (atributo privado)
     */

    private class Dado_Profesional extends JButton{

        private Dado_01 dado_Heredado;


        /**
         * Método constructor de Dado_Profesional
         */
        public Dado_Profesional(){


            dado_Heredado = new Dado_01();


        }



    }



    private class Escuchas implements ActionListener, MouseListener, KeyListener {

        Dado_Profesional dadoProfesional = new Dado_Profesional();


        Modelo_01 modelo01 = new Modelo_01();










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
             * Se empiezan a desarrollar las acciones segun el valor entero
             * del atributo sello
             */

           // modelo01.pura_Accion(recepciona_Sello);


            //System.out.println(" ya al final el sello vale " + recepciona_Sello);
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
