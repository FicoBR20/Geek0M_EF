package vista;

import control.Controlador;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    private Header headerProject;
    private JPanel panelActivos,panelIncativos,panelPuntos,panelUsados, panelMenu, panelBoton;
    private JLabel[] dado, puntos_dado;
    private ImageIcon imagen_dado;
    private GridBagConstraints constraints; // Referencias del grid
    private JButton boton_lanzar, boton_menu = null, boton_atras, boton_salir, boton_entrar, boton_salir1; // Declaracion de los botones del juego
    private Escucha escucha;
    private Menu menu;// Ventana que contiene el menu para salir del juego
    private Controlador control;
    private int uso_boton_lanzar, dado_activo;
    private GUI_INI guiIni;
    private FondoPanel fondoPanel;
    private Vector<Integer> cara_dado;
    private Integer[] caras;


    /**
     * Constructor of GUI class
     */
    public GUI(){


//        ventana_entrada();
        inicio_GUI();

        //Default JFrame configuration
        this.setTitle("Geek of master");
        this.isOpaque();
        this.setUndecorated(true);//Quita los trs botones de la ventana
        this.setBackground(new Color(255,255,255,0)); //Quita el fondo de la ventana tiene que estar despues de  setUndecorated y antes de para que funcione
        this.pack();
        this.setSize(new Dimension(700,500));
        this.setResizable(true);
        this.setVisible(true);// Oculta la ventana del juego, espera un evento que lo active
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
        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/fondo2.png");
        this.setContentPane(fondoPanel);

        uso_boton_lanzar = 0;// '0' = botón lanzar sin usar
        dado_activo = 0;// '0' = botón no se puede usar
        cara_dado = null;//vector que guarda las cara de los dados
        caras = null;

        dado = new JLabel[10];//Creacion de los dados
        puntos_dado = new JLabel[11];//Creacion de las carillas para los puntos

        //Ciclo que instancia los dados y las casillas y les pone una imagen
        for (int i=0;i<=9;i++){
            imagen_dado =new ImageIcon(getClass().getResource("/recursos/comodin.png"));
            dado[i] = new JLabel(imagen_dado);


            imagen_dado =new ImageIcon(getClass().getResource("/recursos/p"+i+".png"));
            puntos_dado[i] = new JLabel(imagen_dado);
        }

        imagen_dado =new ImageIcon(getClass().getResource("/recursos/puntaje.png"));
        puntos_dado[10] = new JLabel(imagen_dado);

        //Set up JFrame Container's Layout
        control = new Controlador();

        //Create Listener Object and Control Object
        escucha = new Escucha();

        //Instancio el menú del juego para utilizarlo luego el metodo escucha
        menu = null;

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

        headerProject = new Header("The Geek Out! Master", null);
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

//        for (int i=0;i<=3-1;i++){
//            panelIncativos.add(dado[i]);
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

        for (int i=1-1;i<=10-1;i++){
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
    public void cambiar_posicion_dado(int _posicion, int estado ){
        switch (control.getEstado(_posicion)){
            case 1:
                control.deshabilitar_dado_inactivo(_posicion);
                control.deshabilitar_dado_usado(_posicion);
                panelUsados.add(dado[_posicion],BorderLayout.SOUTH);
                break;
            case 2:
                control.deshabilitar_dado_inactivo(_posicion);
                control.habilitar_dado_usado(_posicion);
                panelIncativos.add(dado[_posicion],BorderLayout.SOUTH);
                break;
            case 3:
                control.deshabilitar_dado_inactivo(_posicion);
                control.deshabilitar_dado_usado(_posicion);
                panelPuntos.add(dado[_posicion],BorderLayout.SOUTH);
                break;
            case 4:
                control.habilitar_dado_inactivo(_posicion);
                control.habilitar_dado_usado(_posicion);
                panelActivos.add(dado[_posicion],BorderLayout.SOUTH);
                break;
        }
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
            if (e.getActionCommand() == "ATRAS" && menu != null){
                menu.dispose(); //Cierra la ventana de menu sin cerrar el programa
                boton_menu.setEnabled(true);// Habilita el boton menu
                if (uso_boton_lanzar == 0){
                    boton_lanzar.setEnabled(true);
                }

            }
            if (e.getSource() == boton_salir){
                int opcion = JOptionPane.showConfirmDialog(null, "¿Desea volver al Inicio?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION){
                    System.out.println("salir");
//                    System.exit(0);

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
                    control.inicio(10);
                    cara_dado = control.getCara();// Obtiene la cara de un dada que genera la clase controladora y la guarda en un vectos
                for (int i=0;i<=2;i++){
                    imagen_dado =new ImageIcon(getClass().getResource("/recursos/"+ cara_dado.get(i)+".png"));
                    dado[i].setIcon(imagen_dado);
                    dado[i].addMouseListener(escucha);
                    panelIncativos.add(dado[i]);
                    control.deshabilitar_dado_inactivo(i);
                    control.habilitar_dado_usado(i);
                    control.setEstado(i,2);
                }
                for (int i=3;i<=9;i++){
                    imagen_dado =new ImageIcon(getClass().getResource("/recursos/"+ cara_dado.get(i)+".png"));
                    dado[i].setIcon(imagen_dado);
                    dado[i].addMouseListener(escucha);
                    panelActivos.add(dado[i]);
                    control.habilitar_dado_inactivo(i);
                    control.habilitar_dado_usado(i);
                    control.setEstado(i,4);
                }
                for (int i=0;i<=9;i++){
                    System.out.println("Dado "+(i+1)+" cara= "+ cara_dado.get(i));
                }
//                boton_lanzar.setEnabled(false); //Deshabilita el boton lanzar
                uso_boton_lanzar = 1; // Indica que el botón lanzar ya fue usado

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

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            for (int i=0;i<=9;i++){
                System.out.println("Dado "+(i+1)+" activo "+control.dado_activo(i)+" usado "+control.dado_usado(i));
                if(e.getSource()== dado[i]){
                    if (control.dado_activo(i) == 1 && control.dado_usado(i) == 1){
                        System.out.println("agarre el dado = "+(i+1));
                        control.recoger_dado(i,cara_dado.get(i));
//                        control.deshabilitar_dado_inactivo(i);
//                        control.deshabilitar_dado_usado(i);

                        switch (control.getEstado(i)){
                            case  1:
                                control.setEstado(i,1);
                                cambiar_posicion_dado(i,1);
                                break;
                            case  2:
                                control.setEstado(i,4);
//                                control.habilitar_dado_inactivo(i);
//                                control.habilitar_dado_usado(i);
                                cambiar_posicion_dado(i,4);
                                break;
                            case  3:
                                control.setEstado(i,3);
                                cambiar_posicion_dado(i,3);
                                break;
                            case  4:
                                control.setEstado(i,1);
                                cambiar_posicion_dado(i,1);
                                break;
                        }
                    }
                }
                 if(e.getSource()== dado[i]){
                    System.out.println("inside ");
                    if (control.dado_activo(i) == 1 && control.dado_usado(i) == 0){
                        System.out.println("agarre el dado = "+(i+1));
                        control.recoger_dado(i,cara_dado.get(i));
                        control.deshabilitar_dado_inactivo(i);
                        control.deshabilitar_dado_usado(i);
                        control.setEstado(i,4);

                        switch (control.getEstado(i)){
                            case  1:
                                control.setEstado(i,1);
                                cambiar_posicion_dado(i,1);
                                break;
                            case  2:
                                control.setEstado(i,4);
                                cambiar_posicion_dado(i,4);
                                break;
                            case  3:
                                control.setEstado(i,3);
                                cambiar_posicion_dado(i,3);
                                break;
                            case  4:
                                control.setEstado(i,1);
                                cambiar_posicion_dado(i,1);
                                break;
                        }
                    }
                }
            }
            System.out.println("__________________");
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
