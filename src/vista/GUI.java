package vista;

import control.Controlador;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Header headerProject;
    private JPanel panelActivos,panelIncativos,panelPuntos,panelUsados, panelMenu;
    private JLabel dadosActivos,dadosIncativos,dadosPuntos,dadosUsados;
    private JLabel[] dado,dado_puntos;
    private ImageIcon imagen_activos, imagen_inactivos, imagen_puntos, imagen_usados,imagen_dado;
    private GridBagConstraints constraints; // referencias del grid
    private JButton lanzar, menu, atras, salir; // lanza los dados
    private Escucha escucha;
    private Menu menu1;
    private Container container;
    private JLayeredPane layeredPane;
    private Controlador control;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek of master");
//        this.setSize(new Dimension(800,500));
        this.setBackground(Color.BLACK);
        this.isOpaque();
//        this.setUndecorated(true);//Quita los trs botones de la ventana
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Creacion de los dados
         dado = new JLabel[10];
        dado_puntos = new JLabel[10];
        for (int i=0;i<=9;i++){
            imagen_dado =new ImageIcon(getClass().getResource("/recursos/comodin.png"));
            dado[i] = new JLabel(imagen_dado);
            imagen_dado =new ImageIcon(getClass().getResource("/recursos/p"+i+".png"));
            dado_puntos[i] = new JLabel(imagen_dado);
        }
        //Set up JFrame Container's Layout
        control = new Controlador();
        //Create Listener Object and Control Object
        escucha = new Escucha();
        menu1 = null;
        //Creo dados;

        //Obtiene el contenedor por defecto de la ventana y le pongo el nuevo layout "GridBagLayout"
        this.getContentPane().setLayout(new GridBagLayout());
        //Se crea un objeto "constrain" para configurar el Grib layout
        constraints = new GridBagConstraints();

        //Set up JComponents
        lanzar = new JButton("LANZAR DADOS");
        lanzar.addActionListener(escucha);

        atras = new JButton("ATRAS");
        atras.setPreferredSize(new Dimension(100,50));
        atras.addActionListener(escucha);

        salir = new JButton("SALIR");
        salir.setPreferredSize(new Dimension(100,50));
        salir.addActionListener(escucha);

        menu = new JButton("MENU");
        menu.addActionListener(escucha);

        //Se pone un el texto de cabecera, se igrasan las coordenadas constrain, se añade a la ventana
        headerProject = new Header("The Geek Of Master", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=13; // combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout

        //Boton de Menu
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=13; // combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(menu,constraints); //Change this line if you change JFrame Container's Layout


        //Zona_1 dados usados
        panelUsados = new JPanel();
        panelUsados.setPreferredSize(new Dimension(250,200));
        panelUsados.setBorder(BorderFactory.createTitledBorder(null, "Dados Usados", TitledBorder.CENTER,TitledBorder.CENTER,null,Color.WHITE));
        panelUsados.setBackground(new Color(44,56,84));
//        imagen_usados = new ImageIcon(getClass().getResource("/recursos/zona.png"));
//        dadosUsados = new JLabel(imagen_usados);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

//        panelUsados.add(dadosUsados);
        this.add(panelUsados,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_2 dedos inctivos
        panelIncativos = new JPanel();
        panelIncativos.setBorder(BorderFactory.createTitledBorder(null,"Dadso Inactivos", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        panelIncativos.setBackground(new Color(44,56,84));//preueba
//        imagen_inactivos = new ImageIcon(getClass().getResource("/recursos/zona.png"));
//        dadosIncativos = new JLabel(imagen_inactivos);

        constraints.gridx=8;
        constraints.gridy=1;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        for (int i=0;i<=3-1;i++){
            panelIncativos.add(dado[i]);
        }

//        panelIncativos.add(dadosIncativos);
        this.add(panelIncativos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_3 de dados puntos
        panelPuntos = new JPanel();
        panelPuntos.setPreferredSize(new Dimension(250,200));
        panelPuntos.setBorder(BorderFactory.createTitledBorder(null,"Puntuación",TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
        panelPuntos.setBackground(new Color(44,56,84));//preueba
//        imagen_puntos = new ImageIcon(getClass().getResource("/recursos/puntos.png"));
//        dadosPuntos = new JLabel(imagen_puntos);

        constraints.gridx=1;
        constraints.gridy=5;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        for (int i=0;i<=10-1;i++){
            panelPuntos.add(dado_puntos[i]);
        }

//        panelPuntos.add(dadosPuntos);
        this.add(panelPuntos,constraints); //Change this line if you change JFrame Container's Layout


        //Zona_4 dedos Activos
        panelActivos = new JPanel();
        panelActivos.setBackground(new Color(44,56,84));//preueba
        panelActivos.setPreferredSize(new Dimension(250,200));
        panelActivos.setBorder(BorderFactory.createTitledBorder(null,"Dados Activos", TitledBorder.CENTER,TitledBorder.DEFAULT_JUSTIFICATION,null,Color.WHITE));
//        imagen_activos = new ImageIcon(getClass().getResource("/recursos/zona.png"));
//        dadosActivos = new JLabel(imagen_activos);

        constraints.gridx=8;
        constraints.gridy=5;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        for (int i=4-1;i<=10-1;i++){
            panelActivos.add(dado[i]);
        }

        this.add(panelActivos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona_5 grgar boton lanzar
        constraints.gridx=8;
        constraints.gridy=10;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(lanzar,constraints); //Change this line if you change JFrame Container's Layout

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
    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand() == "MENU"){
                menu1 = new Menu();
                menu.setEnabled(false);//Deshabilita el botón menu
                panelMenu = new JPanel();
                panelMenu.add(atras,BorderLayout.CENTER);
                panelMenu.add(salir,BorderLayout.SOUTH);
                menu1.add(panelMenu);
//                menu1.pack();
//                JOptionPane.showMessageDialog(null,"Menu");
            }
            if (e.getActionCommand() == "ATRAS" && menu1 != null){
                menu1.dispose(); //Cierra la ventana de menu sin cerrar el programa
                menu.setEnabled(true);// Habilita el boton menu

            }
            if (e.getSource() == salir){
                int opcion = JOptionPane.showConfirmDialog(null, "¿Si oprime 'si' se cerrara el programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION){
                    System.out.println("salir");
                    System.exit(0);
                }
                else if(opcion == JOptionPane.NO_OPTION){
                    System.out.println("nada");
                    menu1.dispose();
                    menu.setEnabled(true);
                }
            }
            if (e.getSource() == lanzar){
                for (int i=0;i<=9;i++){
                    control.inicio(10);
                    Vector<Integer> face = control.getCara();
    //                JOptionPane.showMessageDialog(null,"Numero"+face.get(0));
                    imagen_dado =new ImageIcon(getClass().getResource("/recursos/"+face.get(0)+".png"));
                    dado[i].setIcon(imagen_dado);
                    System.out.println("test");
                }
//                lanzar.setEnabled(false);

//                mostrar_resultado.setText(control.getEstado_string().get(0));
//                mensaje_salida.setText(control.getEstado_string().get(1));

            }
        }
    }
}
