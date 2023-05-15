package vista;

import control.Control_01;
import modelo.Dado_01;
import modelo.Modelo_01;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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

    private JPanel jPanel_Dados_Activos, jPanel_Dados_Inactivos, jPanel_Dados_Utilizados, jPanel_Tabla_Puntuación;

    /**
     * Contenedor de mas alto nivel en
     * este proyecto
     */
    private Container containerPricipal;

    /**
     * Método constructor de la Gui
     */
    public Gui_01 (){

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


        modelo01.tirada_DadosActivos();

        modelo01.tiradaInactivos();


        control01 = new Control_01();


        /**
         * Objeto Dimension para el tamaño de los dados
         */
        dimension_Auxiliar = new Dimension(50*5 ,50*2);

        carasLanzadas = new Vector<>();


        imageIcon = new ImageIcon();


        dadoProfesional = new Dado_Profesional();


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

        jPanel_Dados_Activos = new JPanel();


        jPanel_Dados_Inactivos = new JPanel();


        jPanel_Dados_Utilizados = new JPanel();


        jPanel_Tabla_Puntuación = new JPanel();



        jButton1.addActionListener(escuchas);
        jButton1.addKeyListener(escuchas);
        jButton1.addMouseListener(escuchas);



        generador_Vectores_Panel_Activos(7);
        containerPricipal.add(jPanel_Dados_Activos, BorderLayout.CENTER);

        generador_Vectores_Panel_Inactivos(3);
        containerPricipal.add(jPanel_Dados_Inactivos, BorderLayout.EAST);

        generador_Vectores_Panel_Utilizados(10);
        containerPricipal.add(jPanel_Dados_Utilizados, BorderLayout.WEST);

        generador_Vectores_Tabla_de_Puntuacion(10);
        containerPricipal.add(jPanel_Tabla_Puntuación, BorderLayout.SOUTH);









        this.add(containerPricipal);

    }


    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en  jPanel_Dados_Activos
     * @param campos representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Panel_Activos(int campos ){


        carasLanzadas = new Vector<>();
        carasLanzadas.setSize(campos);

        jPanel_Dados_Activos = new JPanel();




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

            jPanel_Dados_Activos.setPreferredSize(new Dimension(100,100));
            jPanel_Dados_Activos.setBackground(Color.BLUE);
            jPanel_Dados_Activos.setBorder(BorderFactory.createTitledBorder(null,"Dados Activos",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,24),Color.WHITE));
            jPanel_Dados_Activos.add(carasLanzadas.get(i));


        }


        return carasLanzadas;

    }


    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en el jPanel_Dados_Inactivos
     * @param campos representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Panel_Inactivos(int campos ){


        carasLanzadas = new Vector<>();
        carasLanzadas.setSize(campos);

        jPanel_Dados_Inactivos = new JPanel();




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

            jPanel_Dados_Inactivos.setPreferredSize(new Dimension(200,100));
            jPanel_Dados_Inactivos.setBackground(Color.ORANGE);
            jPanel_Dados_Inactivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Inactivos",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,16),Color.WHITE));
            jPanel_Dados_Inactivos.add(carasLanzadas.get(i));


        }


        return carasLanzadas;

    }

    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en el jPanel_Dados_Utilizados
     * @param campos Representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Panel_Utilizados(int campos ){


        carasLanzadas = new Vector<>();
        carasLanzadas.setSize(campos);

        jPanel_Dados_Utilizados = new JPanel();




        for (int i = 0; i < carasLanzadas.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.busqueda_Profesional();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/Basico_utilizados.png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.setSello(auxiliar);
//
//            dadoProfesional.addActionListener(escuchas);
//
//            dadoProfesional.addMouseListener(escuchas);
//
//            dadoProfesional.addKeyListener(escuchas);

            carasLanzadas.setElementAt(dadoProfesional, i);

            jPanel_Dados_Utilizados.setPreferredSize(new Dimension(200,100));
            jPanel_Dados_Utilizados.setBackground(Color.GRAY);
            jPanel_Dados_Utilizados.setBorder(BorderFactory.createTitledBorder(null,"Dados Utilizados",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,16),Color.WHITE));
            jPanel_Dados_Utilizados.add(carasLanzadas.get(i));


        }


        return carasLanzadas;

    }


    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en  jPanel_Tabla_Puntuación
     * @param campos representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Tabla_de_Puntuacion(int campos ){


        carasLanzadas = new Vector<>();
        carasLanzadas.setSize(campos);

        jPanel_Tabla_Puntuación = new JPanel();




        for (int i = 0; i < carasLanzadas.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.busqueda_Profesional();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/p" +
                    (auxiliar ) + ".png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.setSello(auxiliar);
//
//            dadoProfesional.addActionListener(escuchas);
//
//            dadoProfesional.addMouseListener(escuchas);
//
//            dadoProfesional.addKeyListener(escuchas);

            carasLanzadas.setElementAt(dadoProfesional, i);

            jPanel_Tabla_Puntuación.setPreferredSize(new Dimension(100,100));
            jPanel_Tabla_Puntuación.setBackground(Color.DARK_GRAY);
            jPanel_Tabla_Puntuación.setBorder(BorderFactory.createTitledBorder(null,"Tabla de Puntuación",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,24),Color.WHITE));
            jPanel_Tabla_Puntuación.add(carasLanzadas.get(i));


        }


        return carasLanzadas;

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
