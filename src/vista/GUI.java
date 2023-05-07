package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for ...
 * @autor Carlos Felipe Montoya carlos.felipe.montoya@correounivalle.edu.co
 * @version v.1.0.0 date:21/03/2023
 */
public class GUI extends JFrame {

    private Escucha escucha;

    private Header headerProject;
    private JPanel panelActivos,panelIncativos,panelPuntos,panelUsados;
    private JLabel dadosActivos,dadosIncativos,dadosPuntos,dadosUsados;
    private ImageIcon imagen_activos, imagen_inactivos, imagen_puntos, imagen_usados,imagen_dado;
    private GridBagConstraints constraints; // referencias del grid
    private JButton lanzar; // lanza los dados

    private JButton probador; // boton auxiliar para algunas pruebas en el desarrollo.

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek of master");
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
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object

        //Obtiene el contenedor por defecto de la ventana y le pongo el nuevo layout "GridBagLayout"
        this.getContentPane().setLayout(new GridBagLayout());
        //Se crea un objeto "constrain" para configurar el Grib layout
        constraints = new GridBagConstraints();

        //Set up JComponents
        lanzar = new JButton("LANZAR DADOS");

        probador = new JButton("PARA PRUEBAS");

        //Se pone un el texto de cabecera, se igrasan las coordenadas constrain, se añade a la ventana
        headerProject = new Header("The Geek Of Master", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=13; // combina 13 celdas para el titulo.
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(headerProject,constraints); //Change this line if you change JFrame Container's Layout

        //Zona dados usados
        panelUsados = new JPanel();
        imagen_usados = new ImageIcon(getClass().getResource("/recursos/zona.png"));
        dadosUsados = new JLabel(imagen_usados);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        panelUsados.add(dadosUsados);
        this.add(panelUsados,constraints); //Change this line if you change JFrame Container's Layout

        //Zona dedos inctivos
        panelIncativos = new JPanel();
        imagen_inactivos = new ImageIcon(getClass().getResource("/recursos/zona.png"));
        dadosIncativos = new JLabel(imagen_inactivos);
        constraints.gridx=8;
        constraints.gridy=1;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        panelIncativos.add(dadosIncativos);
        this.add(panelIncativos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona de dados puntos
        panelPuntos = new JPanel();
        imagen_puntos = new ImageIcon(getClass().getResource("/recursos/puntos.png"));
        dadosPuntos = new JLabel(imagen_puntos);
        constraints.gridx=1;
        constraints.gridy=5;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        panelPuntos.add(dadosPuntos);
        this.add(panelPuntos,constraints); //Change this line if you change JFrame Container's Layout

        //Zona dedos Activos
        panelActivos = new JPanel();
        imagen_activos = new ImageIcon(getClass().getResource("/recursos/zona.png"));
        dadosActivos = new JLabel(imagen_activos);
        constraints.gridx=8;
        constraints.gridy=5;
        constraints.gridwidth=4;
        constraints.gridheight=4;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;

        panelActivos.setLayout(new BorderLayout());//poner un layout al panel
        panelActivos.add(dadosActivos);
        this.add(panelActivos,constraints); //Change this line if you change JFrame Container's Layout

        //Agrgar boton lanzar
        constraints.gridx=8;
        constraints.gridy=10;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(lanzar,constraints); //Change this line if you change JFrame Container's Layout

        constraints.gridx=4;
        constraints.gridy=10;
        constraints.gridwidth=4;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;

        this.add(probador,constraints); //Change this line if you change JFrame Container's Layout

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

        }
    }
}
