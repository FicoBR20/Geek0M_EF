package vista;

import vista.FondoPanel;

import javax.swing.*;
import java.awt.*;

public class GUI_Ayuda extends JFrame{
    private ImageIcon imageIcon;
    private JLabel jLabel;
    private JPanel jPanel;
    private FondoPanel fondoPanel;

    public GUI_Ayuda(){

        inicio();

        //Default JFrame configuration
        this.setTitle("gui inicio");
        this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,0)); //Quita el fondo de la ventana tiene que estar despues de  setUndecorated y antes de para que funcione
        this.pack();
        this.setSize(new Dimension(450,340));
        this.setResizable(true);
        this.setVisible(false);
        this.setLocationRelativeTo(null);
//        this.setAlwaysOnTop(true); //Hace que esta ventana siempre este visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//
    private void inicio() {
        fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/ayuda.png");
        this.setContentPane(fondoPanel);
    }


}
