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

    private JPanel panelActivos,panelIncativos,panelPuntos,panelUsados, panelMenu, panelBoton,jP_misdados;
    private JLabel[] dado, puntos_dado;
    private ImageIcon imagen_dado;
    private GridBagConstraints constraints; // Referencias del grid
    private JButton boton_lanzar, boton_menu,boton_atras, boton_salir, boton_entrar, boton_salir1; // Declaracion de los botones del juego
    private Escucha escucha, segundaEscucha;
    private Menu menu;// Ventana que contiene el menu para salir del juego
    private Controlador control, control_2;

    private int uso_boton_lanzar;
    private GUI_INI guiIni;
    private Integer[] cara_dado;

    private int salio, entro;

    private Juego_Geek juegoGeek;



    /**
     * Constructor of GUI class
     */
    public GUI(){


        ventana_entrada();
        inicio_GUI();

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
     * create Listener and control Objects used for the GUI_INI class
     */
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

        juegoGeek = new Juego_Geek();

        dado_Probador = new Dado();
        segundaEscucha = new Escucha();
        mis_Dados = new Dado[10];
        jP_misdados = new JPanel();
        jP_misdados.setBorder(new TitledBorder(" mis dados iniciales"));

        uso_boton_lanzar = 0;// '0' = botón lanzar sin usar
        int dado_activo = 0;// '0' = botón no se puede usar
        cara_dado = null;//vector que guarda las cara de los dados
        Integer[] caras = null;

        dado = new JLabel[10];//Creacion de los dados
        JLabel[] puntos_dado = new JLabel[11];//Creacion de las carillas para los puntos

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

        //Set up JComponents
        //Configuración de los botones


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

//        for (int i = 0; i<=9; i++){
//            array_dados_usados[i] = dado[i];
//            panelActivos.add(array_dados_usados[i],BorderLayout.SOUTH);
//        }

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

//        for (int i = 0; i<=9; i++){
//            array_dados_inactivos[i] = dado[i];
//            panelActivos.add(array_dados_inactivos[i],BorderLayout.SOUTH);
//        }

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

        for (int i=0;i<=10-1;i++){
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

    public void mensaje_cambio_de_panel(){

//        JOptionPane.showMessageDialog(null, "Sigue en Usados"
//                +"\nCambia posicion\n"
//                +"\nCantidad de dados usados ="+panelUsados.getComponentCount()
//                +"\nCantidad de dados inactivo ="+panelIncativos.getComponentCount()
//                +"\nCantidad de dados en punto ="+panelPuntos.getComponentCount()
//                +"\nCantidad de dados activos ="+panelActivos.getComponentCount()
//                +"\n\nlinea 347");

//        for (int i2= 0;i2<9;i2++){
//            JOptionPane.showMessageDialog(null, "Ciclo ="+i2 );
//            if(panelUsados.getComponent(i2)==null){
//                JOptionPane.showMessageDialog(null, "nulo usados");
////                usados--;
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "suma usados");
//                usados++;
//            }
//            if(panelIncativos.getComponent(i2)==null){
//                JOptionPane.showMessageDialog(null, "nulo inactivos");
////                inactovos--;
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "suma inactivos");
//                inactovos++;
//            }
//            if(panelPuntos.getComponent(i2)==null){
//                JOptionPane.showMessageDialog(null, "nulo Punto");
////                puntos--;
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "suma Punto");
//                puntos++;
//            }
//            if(panelActivos.getComponent(i2)==null){
//                JOptionPane.showMessageDialog(null, "nulo activos");
////                activos--;
//            }
//            else{
//                JOptionPane.showMessageDialog(null, "suma activos");
//                activos++;
//            }
//        }
//        JOptionPane.showMessageDialog(null, "Pasa a dado Activos"
//                +"\n\nArray de dados usados ="+panelUsados.getComponentCount()
//                +"\nArray de dados inactivo ="+panelIncativos.getComponentCount()
//                +"\nArray de dados en punto ="+panelPuntos.getComponentCount()
//                +"\nArray de dados activos ="+panelActivos.getComponentCount()
//        );

    }

    public void activar_dados_usados(){
        for (int posicion = 0; posicion<=9; posicion++){
            if (control.get_estado_dado(posicion)==8){
                relanzar_dado(posicion);
                panelActivos.add(dado[posicion]);
                control.setEstado(posicion, 4);
                control.set_estado_dado(posicion,0);
//                mensaje_cambio_de_panel();
            }
        }
            JOptionPane.showMessageDialog(null, "Se han relansado los dados\n" +
                    "Inicia turno No. "+(uso_boton_lanzar+1));
    }

    public void cambiar_posicion_dado(int posicion ){

        switch (control.getEstado(posicion)) {
            case 1:
                panelUsados.add(dado[posicion]);
                control.set_estado_dado(posicion,8);
                break;
            case 2:
                panelActivos.add(dado[posicion]);
                control.setEstado(posicion, 4);
                control.set_estado_dado(posicion,0);
                break;
            case 3:
                panelPuntos.add(dado[posicion]);
                control.setEstado(posicion, 3);
                control.set_estado_dado(posicion,9);
                break;
            case 4:
                panelUsados.add(dado[posicion]);
                control.setEstado(posicion, 1);
                control.set_estado_dado(posicion,8);
                break;
            case 5:
                panelIncativos.add(dado[posicion]);
                control.setEstado(posicion, 2);
                control.set_estado_dado(posicion,7);
                break;
        }
    }

    public void relanzar_dado(int posicion){
        control_2.lanzar_inicio(10);
        control.setCara_dado(posicion,control_2.getCara()[posicion]);
            imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + control.getCara()[posicion] + ".png")));
            dado[posicion].setIcon(imagen_dado);

//            JOptionPane.showMessageDialog(null, "relanza dado"
//                +"\n\nlinea 357");
    }
    public void voltear_dado(int posicion){
        control.voltear_dado(posicion);
        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + control.getCara()[posicion] + ".png")));
        dado[posicion].setIcon(imagen_dado);

//        JOptionPane.showMessageDialog(null, "voltea dado"
//                +"\n\nlinea 367");
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
     *             the program is execute by console.
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

            if (e.getActionCommand() == "MENU"){

                // Inicia una nueva ventanade menu
                menu = new Menu();

                // deshabilita el boton menu y el boton
                boton_menu.setEnabled(false);//Deshabilita el botón menu
                boton_lanzar.setEnabled(false); //Deshabilita el botón lanzar

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

                if (uso_boton_lanzar==0){
                    panelActivos.removeAll();
//                    JOptionPane.showMessageDialog(null,"He removido todo de activos");

                    for (int posicion=0;posicion<=2;posicion++){
                        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + cara_dado[posicion] + ".png")));
                        dado[posicion].setIcon(imagen_dado);
                        dado[posicion].addMouseListener(escucha);
                        panelIncativos.add(dado[posicion]);
                        control.setEstado(posicion,2);
                        control.set_estado_dado(posicion,7);
                    }
//                        mensaje_cambio_de_panel();

                    for (int posicion=3;posicion<=9;posicion++){
                        imagen_dado =new ImageIcon(Objects.requireNonNull(getClass().getResource("/recursos/" + cara_dado[posicion] + ".png")));
                        dado[posicion].setIcon(imagen_dado);
                        dado[posicion].addMouseListener(escucha);
                        panelActivos.add(dado[posicion]);
                        control.setEstado(posicion,4);
                        control.set_estado_dado(posicion,0);
                    }
//                        mensaje_cambio_de_panel();

                    for (int posicion=0;posicion<=9;posicion++){
                        System.out.println("Dado "+(posicion+1)+" cara= "+ cara_dado[posicion]+" linea 493");
                    }
                    uso_boton_lanzar=1; // Indica que el botón lanzar ya fue usado
//                    JOptionPane.showMessageDialog(null,"lanzar vale = "+uso_boton_lanzar);
               }

                else if (panelActivos.getComponentCount()==0){
//                    JOptionPane.showMessageDialog(null,"cambia de inactivos a activos"
//                    +"\n relanzar dados");
                    activar_dados_usados();
                    uso_boton_lanzar++;
                }
                else if (uso_boton_lanzar >= 1){

                        JOptionPane.showMessageDialog(null,
                                "Solo se puede volver a lanzar\n"+
                                "cunado se hayan usado\n todos los dados");
                }
                if (uso_boton_lanzar == 6){

                    JOptionPane.showMessageDialog(null,
                            "Findel juego\n"+
                                    "tu puntaje fue = "+puntuacion());
                }
            }



            if (e.getSource() == boton_entrar){
                guiIni.dispose();
                setVisible(true);
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
//            JOptionPane.showMessageDialog(null,"entro "+entro);

            if (entro == 1){
                entro = 0;
                salio = 0;
            }
            else {
                for (int posicion=0;posicion<=9;posicion++){
                    if(e.getComponent() == dado[posicion]){

//                        puntuacion();

//                        JOptionPane.showMessageDialog(null,
//
//                                "Boton # "+(posicion+1)+" Cara # "+cara_dado[posicion]+
//                                        "\nEstados: \n" +
//                                        "Es estado para mover el dado es = "+control.get_estado_dado(posicion)+
//                                        "\nEstados panel : \n" +
//                                        "Es dado esta en el panel = "+control.getEstado(posicion)+
//                                        "\n\nlinea 526");

                        switch (control.get_estado_dado(posicion)) {
                            case 0 -> {
//                                JOptionPane.showMessageDialog(null, "regla 0");
                                System.out.println("agarre el dado = " + (posicion + 1));
                                control.activar_dado(posicion, cara_dado[posicion]);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 1 -> {
//                                JOptionPane.showMessageDialog(null, "regla 1 corazon");
                                control.bloquear_corazon();
                                control.setEstado(posicion, 2);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 2 -> {
//                                JOptionPane.showMessageDialog(null, "regla 2 dragon");
                                control.bloquear_dragon();
                                salio = 1;
                            }
                            case 3 -> {
//                                JOptionPane.showMessageDialog(null, "regla 3 meeple");
                                control.bloquear_meeple();
                                control.setEstado(posicion, 4);
                                relanzar_dado(posicion);
                                salio = 1;
                            }
                            case 4 -> {
//                                JOptionPane.showMessageDialog(null, "regla 4 nave");
                                control.bloquear_nave();
                                control.setEstado(posicion, 5);
                                cambiar_posicion_dado(posicion);
                                salio = 1;
                            }
                            case 5 -> {
//                                JOptionPane.showMessageDialog(null, "regla 5 heroe");
                                control.bloquear_heroe();
                                voltear_dado(posicion);
                                salio = 1;
                            }
                            case 6 -> {
                                if (panelActivos.getComponentCount()==0){
//                                    JOptionPane.showMessageDialog(null, "regla 6 punto");
                                    control.bloquear_punto();
                                    control.setEstado(posicion, 3);
    //                                JOptionPane.showMessageDialog(null, "El dado esta en el panel = " + control.getEstado(posicion));
                                    cambiar_posicion_dado(posicion);
                                    salio = 1;
                                }
                                else {
                                    salio = 1;
                                }
                            }
                            case 7,8,9 -> {
//                                JOptionPane.showMessageDialog(null, "regla 7 punto");
                                salio = 1;
                            }
                        }
                    }
                }
                System.out.println("__________________");
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
