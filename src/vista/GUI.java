package vista;

import control.Controlador;
import modelo.Dado;
import modelo.Juego_Geek;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import java.util.Vector;

/**
 *   @archivo GUI.jar
 *   @author federico.barbetti:  Codigo es 2181247-2724
 *   @email federico.barbetti@correounivalle.edu.co
 *   @author Jose Erley Murillo Torres:  Codigo es 2177964-2724
 *   @email jose.erley.murillo@correounivalle.edu.co
 *   @version v.1.0.0 date:21/03/2023
 *   @licencia GPL
*/

public class GUI extends JFrame {

    private modelo.Dado dado_Probador; // adiciono para probar "lanzar dados"

    private Dado[] mis_Dados;


    private Header headerProject;

    private JPanel panelNulo, panelActivos,panelIncativos,panelPuntos,panelUsados, panelMenu, panelBoton,jP_misdados;
    private JLabel[] dado, puntos_dado;
    private ImageIcon imagen_dado;
    private GridBagConstraints constraints; // Referencias del grid
    private JButton boton_lanzar, boton_menu,boton_atras, boton_salir, boton_entrar, boton_salir1, boton_ayuda, boton_cerrar; // Declaracion de los botones del juego
    private Escucha escucha, segundaEscucha;
    private Menu menu;// Ventana que contiene el menu para salir del juego
    private Controlador control, control_2;
    private int uso_boton_lanzar;
    private GUI_INI guiIni;
    private GUI_Ayuda ventana_ayuda;
    private Integer[] cara_dado;
    private int salio, entro;

    /**
     * Constructor of GUI class
     */
    public GUI(){


        ventana_entrada();
        inicio_GUI();
        gui_ayuda();

        //Default JFrame configuration
        this.setTitle("Geek of master");
        this.isOpaque();

        this.setUndecorated(true);//Quita los trs botones de la ventana
        this.setBackground(new Color(255,255,255,0)); //Quita el fondo de la ventana tiene que estar despues de  setUndecorated y antes de para que funcione
        this.pack();
        this.setSize(new Dimension(700,500));
        this.setResizable(true);
        this.setVisible(false);// Oculta la ventana del juego, espera un evento que lo active
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI_Ayuda class
     */
    public void gui_ayuda(){

        escucha = new GUI.Escucha();
        ventana_ayuda = new GUI_Ayuda();
        ventana_ayuda.getContentPane().setLayout(new GridBagLayout());//Obtiene el contenedor por defecto de la ventana y pone un layout del tipo "GridBagLayout"
        constraints = new GridBagConstraints();//Se crea un objeto "constrain" para configurar el "GridBagLayout" cuando se esten ubicando los componetes de la ventana

        //Añado Boton a la ventana
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.FIRST_LINE_END;
        constraints.insets = new Insets(0,300,290,0);

        boton_cerrar = new JButton("CERRAR");
        boton_cerrar.addActionListener(escucha);
        ventana_ayuda.add(boton_cerrar,constraints);

    }

    public void ventana_entrada(){

        escucha = new GUI.Escucha();
        guiIni = new GUI_INI();
        guiIni.getContentPane().setLayout(new GridBagLayout());//Obtiene el contenedor por defecto de la ventana y pone un layout del tipo "GridBagLayout"
        constraints = new GridBagConstraints();//Se crea un objeto "constrain" para configurar el "GridBagLayout" cuando se esten ubicando los componetes de la ventana

        //Añado Boton a la ventana
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=1;
        constraints.gridheight=1;// combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        constraints.insets = new Insets(100,0,0,0);

        boton_entrar = new JButton("ENTRAR");
        boton_entrar.addActionListener(escucha);
        guiIni.add(boton_entrar,constraints);

        //Añado Boton a la ventana
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.gridheight=1;// combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        constraints.insets = new Insets(10,0,0,0);

        boton_salir1 = new JButton("SALIR");
        boton_salir1.addActionListener(escucha);
        guiIni.add(boton_salir1,constraints);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void inicio_GUI() {
        FondoPanel fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/fondo2.png");
        this.setContentPane(fondoPanel);

        dado_Probador = new Dado();
        segundaEscucha = new Escucha();
        mis_Dados = new Dado[10];
        jP_misdados = new JPanel();
        jP_misdados.setBorder(new TitledBorder(" mis dados iniciales"));
        panelNulo = new JPanel();

        uso_boton_lanzar = 0;// '0' = botón lanzar sin usar
        int dado_activo = 0;// '0' = botón no se puede usar
        cara_dado = null;//vector que guarda las cara de los dados
        Integer[] caras = null;

        dado = new JLabel[10];//Creacion de los dados
        puntos_dado = new JLabel[11];//Creacion de las carillas para los puntos

        //Ciclo que instancia los dados y las casillas y les pone una imagen
        for (int i=0;i<=9;i++){
            imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/comodin.png")));
            dado[i] = new JLabel(imagen_dado);

            imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/p" + i + ".png")));
            puntos_dado[i] = new JLabel(imagen_dado);
            dado[i].addMouseListener((MouseListener) escucha);
        }

        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/puntaje.png")));
        puntos_dado[10] = new JLabel(imagen_dado);

        //Set up JFrame Container's Layout
        control = new Controlador();
        control_2  = new Controlador();

        //Create Listener Object and Control Object
        escucha = new Escucha();

        //Instancio el menú del juego para utilizarlo luego el metodo escucha
        boton_menu = null;

        //Obtiene el contenedor por defecto de la ventana y pone un layout del tipo "GridBagLayout"
        this.getContentPane().setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();//Se crea un objeto "constrain" para configurar el "GridBagLayout" cuando se esten ubicando los componetes de la ventana
        constraints.insets = new Insets(10,30,10,30);// Inserta margenes en los componentes insertados en la ventana

        boton_atras = new JButton("ATRAS");
        boton_atras.setPreferredSize(new Dimension(100,50));
        boton_atras.addActionListener(escucha);

        boton_salir = new JButton("SALIR");
        boton_salir.setPreferredSize(new Dimension(100,50));
        boton_salir.addActionListener(escucha);

        //Texto de cabecera y coordenadas constrain para añadirlo a la ventana
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2; // combina 2 celdas para el titulo.
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        Header headerProject = new Header("The Geek Out! Master", null);
        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout

        //Añado botón de Menú
        constraints.gridx=0;
        constraints.gridy=0;

        constraints.gridwidth=2; // combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;

        boton_menu = new JButton("MENU");
        boton_menu.addActionListener(escucha);
        this.add(boton_menu,constraints); //Change this line if you change JFrame Container's Layout

        //Añado botón de ayuda
        constraints.gridx=0;
        constraints.gridy=0;

        constraints.gridwidth=2; // combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;

        boton_ayuda = new JButton("AYUDA");
        boton_ayuda.addActionListener(escucha);
        this.add(boton_ayuda,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_1: Dados usados
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        panelUsados = new JPanel();
        panelUsados.setPreferredSize(new Dimension(250,180));
        panelUsados.setBorder(BorderFactory.createTitledBorder(null, "Dados Usados", TitledBorder.CENTER,TitledBorder.CENTER,null,Color.WHITE));
        panelUsados.setBackground(new Color(13, 64, 123, 128));

        this.add(panelUsados,constraints); //Change this line if you change JFrame Container's Layout


        //Zona_2: Dados inctivos
        panelIncativos = new JPanel();
        panelIncativos.setPreferredSize(new Dimension(250,180));

        panelIncativos.setBorder(BorderFactory.createTitledBorder(null,"Dadso Inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        panelIncativos.setBackground(new Color(13, 64, 123, 128));
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(panelIncativos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_3: Dados puntos
        panelPuntos = new JPanel();
        panelPuntos.setPreferredSize(new Dimension(250,180));
        panelPuntos.setBorder(BorderFactory.createTitledBorder(null,"Puntuación",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        panelPuntos.setBackground(new Color(13, 64, 123, 128));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        panelPuntos.add(puntos_dado[10]);

        for (int i=0;i<=9;i++){
            panelPuntos.add(puntos_dado[i]);
        }


        this.add(panelPuntos,constraints); //Change this line if you change JFrame Container's Layout


        //Zona_4 dedos Activos
        panelActivos = new JPanel();
        panelActivos.setPreferredSize(new Dimension(250,180));
        panelActivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Activos", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        panelActivos.setBackground(new Color(13, 64, 123, 128));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        for (int i = 0; i<=9; i++){
            panelActivos.add(dado[i],BorderLayout.SOUTH);
        }

        this.add(panelActivos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_5 grgar boton lanzar
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        boton_lanzar = new JButton("LANZAR DADOS");
        boton_lanzar.addActionListener(escucha);
        this.add(boton_lanzar,constraints); //Change this line if you change JFrame Container's Layout

    }

    public void activar_dados_usados(){
        for (int posicion2 = 0; posicion2<=9; posicion2++){
            if (control.get_estado_dado(posicion2)==8){
                relanzar_dado(posicion2);
                panelActivos.add(dado[posicion2]);
                control.setEstado(posicion2, 4);
                control.set_estado_dado(posicion2,0);
            }
        }
    }

    public void cambiar_posicion_dado(int posicion ){

        switch (control.getEstado(posicion)) {
            case 1:
                panelUsados.add(dado[posicion]);
                control.setEstado(posicion, 1);
                control.set_estado_dado(posicion,8);
                break;
            case 2:
                panelIncativos.add(dado[posicion]);
                control.setEstado(posicion, 2);
                control.set_estado_dado(posicion,7);
                break;
            case 3:
                panelPuntos.add(dado[posicion]);
                control.setEstado(posicion, 3);
                control.set_estado_dado(posicion,9);
                break;
            case 4:
                panelActivos.add(dado[posicion]);
                control.setEstado(posicion, 4);
                control.set_estado_dado(posicion,0);
                break;
            case 5:
                int cont = 0;
                for (int posicion2 = 0; posicion2<=9; posicion2++){
                    if (control.get_estado_dado(posicion2)==0){
                        relanzar_dado(posicion2);
                        panelActivos.add(dado[posicion2]);
                        control.setEstado(posicion2, 4);
                        control.set_estado_dado(posicion2,0);
                    }
                }
                for (int posicion2 = 0; posicion2<=9; posicion2++){
                    if (control.get_estado_dado(posicion2)==9){
                        relanzar_dado(posicion2);
                        panelActivos.add(dado[posicion2]);
                        control.setEstado(posicion2, 4);
                        control.set_estado_dado(posicion2,0);
                    }
                }

                for (int posicion3=0;posicion3<9;posicion3++){
                    imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/p"+posicion3+".png")));
                    puntos_dado[posicion3].setIcon(imagen_dado);
                }
                // Ciclo que toma la cantidad de dados en punto y cambia el icono
                for (int posicion4=0;posicion4<cont;posicion4++){
                    imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/6.png")));
                    puntos_dado[posicion4].setIcon(imagen_dado);
                }
                break;
            case 6:
                cont = 0;// Cuenta cuantos dados (42) quedan en el panel activos
                for (int posicion2 = 0; posicion2<=9; posicion2++){
                    if (control.get_estado_dado(posicion2)==0){
                        panelNulo.add(dado[posicion2]);
                        control.setEstado(posicion2, 3);
                        control.set_estado_dado(posicion2,9);
                    }
                }
//                 Cuenta cuantos dados (42) hay en el panel de puntos
                for (int posicion2 = 0; posicion2<=9; posicion2++){
                    if (control.get_estado_dado(posicion2)==9){
                        cont++;
                    }
                }
                for (int posicion3=0;posicion3<9;posicion3++){
                    imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/p"+posicion3+".png")));
                    puntos_dado[posicion3].setIcon(imagen_dado);
                }
                JOptionPane.showMessageDialog(null, "limpia cantidad = "+cont);
                // Ciclo que toma la cantidad de dados en punto y cambia el icono
                for (int posicion4=0;posicion4<cont;posicion4++){
                    imagen_dado = new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/6.png")));
                    puntos_dado[posicion4].setIcon(imagen_dado);
                }
                break;
        }
    }

    public void relanzar_dado(int posicion){
        control_2.lanzar_inicio(10);
        control.setCara_dado(posicion,control_2.getCara()[posicion]);
            imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + control.getCara()[posicion] + ".png")));
            dado[posicion].setIcon(imagen_dado);
    }

    public void voltear_dado(int posicion){
        control.voltear_dado(posicion);
        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + control.getCara()[posicion] + ".png")));
        dado[posicion].setIcon(imagen_dado);
    }

    private int  puntuacion() {
        int cantidad = 0;
        for (int posicion = 0; posicion<=9; posicion++){
            if (control.get_estado_dado(posicion)==9){
                cantidad++;
            }
        }
        int punto = 0;
        if (cantidad>=1){
            for (int i=1; i<=cantidad;i++){
                punto = i + punto;
            }

        }
        return punto;
    }



    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is executed by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }


    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    public class Escucha implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand() == "AYUDA"){

                // Inicia una nueva ventanade menu
                ventana_ayuda.setVisible(true);

                // deshabilita el boton menu y el boton
                boton_ayuda.setEnabled(false);//Deshabilita el botón menu
                boton_lanzar.setEnabled(false); //Deshabilita el botón lanzar
                boton_menu.setEnabled(false);
            }
            if (Objects.equals(e.getActionCommand(), "CERRAR") && boton_menu != null){
                ventana_ayuda.dispose(); //Cierra la ventana de menu sin cerrar el programa
                boton_ayuda.setEnabled(true);// Habilita el boton menu
                boton_lanzar.setEnabled(true);
                boton_menu.setEnabled(true);
            }

            if (e.getActionCommand() == "MENU"){

                // Inicia una nueva ventanade menu
                menu = new Menu();

                // deshabilita el boton menu y el boton
                boton_menu.setEnabled(false);//Deshabilita el botón menu
                boton_lanzar.setEnabled(false); //Deshabilita el botón lanzar
                boton_ayuda.setEnabled(false); //Deshabilita el botón lanzar

                // Añade el boton atras al menu
                constraints.gridx=0;
                constraints.gridy=0;
                constraints.gridwidth=1;
                constraints.fill=GridBagConstraints.NONE;
                constraints.anchor=GridBagConstraints.CENTER;
                constraints.insets = new Insets(50,0,0,0);
                menu.add(boton_atras,constraints);

                // Añade el boton salir al menu
                constraints.gridx=0;
                constraints.gridy=1;
                constraints.gridwidth=1;
                constraints.fill=GridBagConstraints.NONE;
                constraints.anchor=GridBagConstraints.CENTER;
                constraints.insets = new Insets(5,0,0,0);
                menu.add(boton_salir,constraints);
            }
            if (Objects.equals(e.getActionCommand(), "ATRAS") && boton_menu != null){
                menu.dispose(); //Cierra la ventana de menu sin cerrar el programa
                boton_menu.setEnabled(true);// Habilita el boton menu
                boton_lanzar.setEnabled(true);
                boton_ayuda.setEnabled(true);
            }
            if (e.getSource() == boton_salir){
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea volver al Inicio?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION){
                    System.out.println("salir");

                    boton_menu.setEnabled(true);
                    boton_lanzar.setEnabled(true);
                    dispose();
                    ventana_entrada();
                    menu.dispose();

                }
                else if(opcion == JOptionPane.NO_OPTION){
                    System.out.println("nada");
                    menu.dispose();
                    boton_menu.setEnabled(true);
                }
            }

            if (e.getSource() == boton_lanzar){
                    control.lanzar_inicio(10);
                    cara_dado = control.getCara();// Obtiene la cara de un dada que genera la clase controladora y la guarda en un vectos

                if (uso_boton_lanzar >= 5){

                    JOptionPane.showMessageDialog(null,
                            "FIN DEL JUEGO\n"+
                                    "TU PUNTAJE FUE = "+puntuacion());
                    gui_ayuda();
                }
                else if (uso_boton_lanzar==0){
                    panelActivos.removeAll();

                    JOptionPane.showMessageDialog(null,"INICIA RONDA 1");
                    for (int posicion=0;posicion<=2;posicion++){
                        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + cara_dado[posicion] + ".png")));
                        dado[posicion].setIcon(imagen_dado);
                        dado[posicion].addMouseListener(escucha);
                        panelIncativos.add(dado[posicion]);
                        control.setEstado(posicion,2);
                        control.set_estado_dado(posicion,7);
                    }

                    for (int posicion=3;posicion<=9;posicion++){
                        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + cara_dado[posicion] + ".png")));
                        dado[posicion].setIcon(imagen_dado);
                        dado[posicion].addMouseListener(escucha);
                        panelActivos.add(dado[posicion]);
                        control.setEstado(posicion,4);
                        control.set_estado_dado(posicion,0);
                    }
                    uso_boton_lanzar=1; // Indica que el botón lanzar ya fue usado
               }

                else if (panelActivos.getComponentCount()<=0){
                    JOptionPane.showMessageDialog(null,
                            "INICIA RONDA "+(uso_boton_lanzar+1)+
                            "\nActivacion de dados usados"
                    +"\n se relanzan los dados usados");
                    activar_dados_usados();
                    uso_boton_lanzar++;
                }
                else if (uso_boton_lanzar >= 1 && uso_boton_lanzar <= 4){
                        JOptionPane.showMessageDialog(null,
                                "Solo se puede volver a lanzar\n"+
                                "cunado se hayan usado\n todos los dados");
                }
            }



            if (e.getSource() == boton_entrar){
                guiIni.dispose();
                setVisible(true);
                boton_ayuda.setEnabled(true);
            }

            if (e.getSource() == boton_salir1){
                System.exit(0);
            }

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource()==dado[2]){

                System.out.println("estoy en el dado [0]");
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            entro = salio + entro;

            if (entro == 1){
                entro = 0;
                salio = 0;
            }
            else {
                for (int posicion=0;posicion<=9;posicion++){
                    if(e.getComponent() == dado[posicion]){

                        switch (control.get_estado_dado(posicion)) {
                            case 0 -> {
                                System.out.println("agarre el dado = " + (posicion + 1));
                                control.activar_dado(posicion, cara_dado[posicion]);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 1 -> {
                                control.bloquear_corazon();
                                control.setEstado(posicion, 4);
                                relanzar_dado(posicion);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 2 -> {
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 3 -> {
                                control.bloquear_meeple();
                                control.setEstado(posicion, 4);
                                relanzar_dado(posicion);
                                salio = 1;
                            }
                            case 4 -> {
                                control.bloquear_nave();
                                control.setEstado(posicion, 2);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 5 -> {
                                control.bloquear_heroe();
                                control.setEstado(posicion, 4);
                                voltear_dado(posicion);
                                salio = 1;
                            }
                            case 6,7,8,9 -> {
                                salio = 1;
                            }
                            case 10-> {
                                JOptionPane.showMessageDialog(null,"Debes usar un dado incactivo ");
                                salio = 1;
                            }
                        }
                    }
                }
            }


        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    public void activarDados(){

        dado = new JLabel[10];

        for (int i=0;i<=9;i++){
            dado[i].addMouseMotionListener((MouseMotionListener) escucha);
            System.out.println("activados");
        }

    }
}
