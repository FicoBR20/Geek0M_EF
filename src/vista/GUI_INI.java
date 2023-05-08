package vista;

import javax.swing.*;
import java.awt.*;

public class GUI_INI extends JFrame{
    private ImageIcon imageIcon;
    private JLabel jLabel;
    private JPanel jPanel;

    public GUI_INI(){

        inicio();

        //Default JFrame configuration
        this.setTitle("menu");
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
    private void inicio() {
        imageIcon = new ImageIcon();
    }


}
