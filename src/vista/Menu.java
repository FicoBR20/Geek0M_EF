package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{

    /**
     * Constructor of GUI class
     */
    public Menu(){
        iniMenu();

        //Default JFrame configuration
        this.setTitle("menu");
        this.setUndecorated(true);
        this.setBackground(new Color(255,255,255,0));
        this.pack();
        this.setSize(new Dimension(135,188));
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridBagLayout());
    }

    private void iniMenu() {

        FondoPanel fondoPanel = new FondoPanel();
        fondoPanel.set_ruta_Icon("/recursos/menu.png");
        this.setContentPane(fondoPanel);
    }

}


