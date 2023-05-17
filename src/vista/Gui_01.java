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
     * Vector que almacena los dados Activos desde
     * el inicio del juego
     */
    private Vector<Dado_Profesional> caras_Dados_Activos;
    /**
     * Vector que almacena los dados Inactivos desde
     * el inicio del juego
     */
    private Vector<Dado_Profesional> caras_Dados_Inactivos;

    /**
     * Vector que almacena los dados Utilizados desde
     * el inicio del juego
     */
    private Vector<Dado_Profesional> caras_Dados_Utilizados;

    /**
     * Vectpr que almacena los dados que puntuan
     * desde el inicio del juego
     */
    private Vector<Dado_Profesional> caras_Tabla_de_Puntuacion;







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




        control01 = new Control_01();


        /**
         * Objeto Dimension para el tamaño de los dados
         */
        dimension_Auxiliar = new Dimension(50*5 ,50*2);



        caras_Dados_Activos = new Vector<>();
        caras_Dados_Inactivos = new Vector<>();
        caras_Dados_Utilizados = new Vector<>();
        caras_Tabla_de_Puntuacion = new Vector<>();







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





        caras_Dados_Activos = new Vector<>();
        caras_Dados_Activos.setSize(campos);

        jPanel_Dados_Activos = new JPanel();




        for (int i = 0; i < caras_Dados_Activos.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    (auxiliar ) + ".png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);

            dadoProfesional.addActionListener(escuchas);

            dadoProfesional.addMouseListener(escuchas);

            dadoProfesional.addKeyListener(escuchas);

            caras_Dados_Activos.setElementAt(dadoProfesional, i);

            jPanel_Dados_Activos.setPreferredSize(new Dimension(100,100));
            jPanel_Dados_Activos.setBackground(Color.BLACK);
            jPanel_Dados_Activos.setBorder(BorderFactory.createTitledBorder(null,"Dados Activos",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,24),Color.WHITE));
            jPanel_Dados_Activos.add(caras_Dados_Activos.get(i));


        }


        return caras_Dados_Activos;

    }


    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en el jPanel_Dados_Inactivos
     * @param campos representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Panel_Inactivos(int campos ){


        caras_Dados_Inactivos = new Vector<>();
        caras_Dados_Inactivos.setSize(campos);

        jPanel_Dados_Inactivos = new JPanel();




        for (int i = 0; i < caras_Dados_Inactivos.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" +
                    (auxiliar ) + ".png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);

            dadoProfesional.addActionListener(escuchas);

            dadoProfesional.addMouseListener(escuchas);

            dadoProfesional.addKeyListener(escuchas);

            caras_Dados_Inactivos.setElementAt(dadoProfesional, i);

            jPanel_Dados_Inactivos.setPreferredSize(new Dimension(200,100));
            jPanel_Dados_Inactivos.setBackground(Color.GRAY);
            jPanel_Dados_Inactivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Inactivos",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,16),Color.WHITE));
            jPanel_Dados_Inactivos.add(caras_Dados_Inactivos.get(i));


        }


        return caras_Dados_Inactivos;

    }

    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en el jPanel_Dados_Utilizados
     * @param campos Representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Panel_Utilizados(int campos ){


        caras_Dados_Utilizados = new Vector<>();
        caras_Dados_Utilizados.setSize(campos);

        jPanel_Dados_Utilizados = new JPanel();




        for (int i = 0; i < caras_Dados_Utilizados.size(); i++) {


            dadoProfesional = new Dado_Profesional();

            int auxiliar =0;

            auxiliar = dadoProfesional.dado_Heredado.busqueda_Aleatoria();

            imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/Basico_utilizados.png")));

            dadoProfesional.setIcon(imageIcon);

            dadoProfesional.dado_Heredado.setSelector_Figura(auxiliar);
//
//            dadoProfesional.addActionListener(escuchas);
//
//            dadoProfesional.addMouseListener(escuchas);
//
//            dadoProfesional.addKeyListener(escuchas);

            caras_Dados_Utilizados.setElementAt(dadoProfesional, i);

            jPanel_Dados_Utilizados.setPreferredSize(new Dimension(200,100));
            jPanel_Dados_Utilizados.setBackground(Color.GRAY);
            jPanel_Dados_Utilizados.setBorder(BorderFactory.createTitledBorder(null,"Dados Utilizados",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,16),Color.WHITE));
            jPanel_Dados_Utilizados.add(caras_Dados_Utilizados.get(i));


        }


        return caras_Dados_Utilizados;

    }


    /**
     * Método que genera un Vector de tipo de dato Dado_Profesional
     * en  jPanel_Tabla_Puntuación
     * @param campos representa el tamaño del arreglo
     * @return Vector<Dado_Profesional></Dado_Profesional>
     */
    public Vector<Dado_Profesional> generador_Vectores_Tabla_de_Puntuacion(int campos ){


        caras_Tabla_de_Puntuacion = new Vector<>();
        caras_Tabla_de_Puntuacion.setSize(campos);

        jPanel_Tabla_Puntuación = new JPanel();




        for (int i = 0; i < caras_Tabla_de_Puntuacion.size(); i++) {


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

            caras_Tabla_de_Puntuacion.setElementAt(dadoProfesional, i);

            jPanel_Tabla_Puntuación.setPreferredSize(new Dimension(100,100));
            jPanel_Tabla_Puntuación.setBackground(Color.DARK_GRAY);
            jPanel_Tabla_Puntuación.setBorder(BorderFactory.createTitledBorder(null,"Tabla de Puntuación",TitledBorder.CENTER,
                    TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.BOLD,24),Color.WHITE));
            jPanel_Tabla_Puntuación.add(caras_Tabla_de_Puntuacion.get(i));


        }


        return caras_Tabla_de_Puntuacion;

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

        private Dado_01 dado_Heredado;

        /**
         * activo true -> disponible para jugar
         *          false -> indisponible para jugar.
         */
        private boolean disponible;
        /**
         * Representan los JPanel a donde se pueden
         * desplazar
         */
        private int jpAct, jpUti, jpInac, jpTaPuntos;


        /**
         * Representa
         */
        private boolean emigra;






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
             * Variable auxiliar que recepciona el atributo Sello
             * de un objeto de la Clase Dado_Profesional
             */
            int recepciona_Sello =0;

            for (int i = 0; i < caras_Dados_Activos.size(); i++) {
                if (e.getSource().equals(caras_Dados_Activos.elementAt(i))){
                    recepciona_Sello = caras_Dados_Activos.get(i).dado_Heredado.getSelector_Figura();
                    System.out.println("\nimprimo el sello del Dado Profesional " + recepciona_Sello);
                }

            }


            /**
             * Se empiezan a desarrollar las acciones segun el valor entero
             * del atributo sello
             */

            modelo01.pura_Accion(recepciona_Sello);


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
