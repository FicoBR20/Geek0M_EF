package vista;

import javax.swing.*;
import java.awt.*;

public class Boton_Skim extends JLabel {

    public Boton_Skim( String titulo, String ruta_imagen) {
        super(new ImageIcon(ruta_imagen));

        // Establecemos algunos estilos adicionales para mejorar la apariencia
        this.setBackground(new Color(51, 153, 255,0));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setText(titulo);
        this.setPreferredSize(new Dimension(100,50));
    }

    public void set_Icon(String icon) {
//        icon_direccion = icon;
    }
    public void  get_Icon(){
//        return  icon_direccion;
    }

}

