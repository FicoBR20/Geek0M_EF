package vista;

import javax.swing.*;
import java.awt.*;

public class GUI_INI extends JFrame{
<<<<<<< HEAD
    private ImageIcon imageIcon;
    private JLabel jLabel;
    private JPanel jPanel;

    public GUI_INI(){

        inicio();

        //Default JFrame configuration
        this.setTitle("menu");
=======
    private JButton menu;
    private GUI.Escucha escucha;

    public GUI_INI(){

//        inicio();

        //Default JFrame configuration
        this.setTitle("menu");
        this.setSize(new Dimension(500,500));
>>>>>>> c457a03f9bf2bf86a9973aee35abccd7c3675ea5
        this.setBackground(Color.BLACK);
        this.setUndecorated(true);
        this.pack();
        this.setSize(new Dimension(500,250));
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
//        this.setAlwaysOnTop(true); //Hace que esta ventana siempre este visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
//
<<<<<<< HEAD
    private void inicio() {
        imageIcon = new ImageIcon();
    }
=======
//    private void inicio() {
//
//    }
>>>>>>> c457a03f9bf2bf86a9973aee35abccd7c3675ea5

}
