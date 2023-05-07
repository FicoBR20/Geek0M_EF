package vista;

import javax.swing.*;
import java.awt.*;

public class GUI_INI extends JFrame{
    private JButton menu;
    private GUI.Escucha escucha;

    public GUI_INI(){

//        inicio();

        //Default JFrame configuration
        this.setTitle("menu");
        this.setSize(new Dimension(500,500));
        this.setBackground(Color.BLACK);
//        this.setUndecorated(true);
//        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        this.setAlwaysOnTop(true); //Hace que esta ventana siempre este visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//
//    private void inicio() {
//
//    }

}
