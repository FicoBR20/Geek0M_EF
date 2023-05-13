package modelo;

        import javax.swing.*;
        import java.awt.*;
        import java.util.Vector;



/**
 *   @archivo Model_Geek.jar
 *   @author federico.barbetti:  Codigo es 2181247-2724
 *   @email federico.barbetti@correounivalle.edu.co
 *   @author Jose Erley Murillo Torres:  Codigo es 2177964-2724
 *   @email jose.erley.murillo@correounivalle.edu.co
 *   @version v.1.0.0 date:21/03/2023
 *   @licencia GPL
 */

/**
 * Esta clase maneja la logica del juego.
 */
public class Model_prueba {

    /*

    refactorar

    estado : casos en los que se gana o pirde el juego
    validacion : bandera meneja los 5 turnos.
    tiro : ...s


     */


    private int  validacion_tiro, punto, tiro, cantidad_en_usados,cantidad_en_inactivos,cantidad_en_puntos, cantidad_en_activo;
    private Integer[] regla_del_dado,cara_dado, estado,dados_activos,dados_inactivos,dados_usados,dados_enPunto;
    private String[] estado_string;
    private Block_Unblock block_Unblock;
    private Tirar_dados tirar_dados;

    public Model_prueba() {
        cantidad_en_usados = 0;
        cantidad_en_inactivos = 0;
        cantidad_en_puntos = 0;
        cantidad_en_activo = 0;

        validacion_tiro = 0;
        punto = 0;
        tiro = 0;

        estado_string = new String[10];
        regla_del_dado = new Integer[10];
        estado = new Integer[10];
        cara_dado = new Integer[10];
        dados_inactivos = new Integer[10];
        dados_enPunto = new Integer[10];
        dados_usados = new Integer[10];
        dados_activos = new Integer[10];

        block_Unblock = new Block_Unblock();
        tirar_dados = new Tirar_dados();
    }

//    public void limpiar_dados(int cantida_dados) {
//        if (cara_dado.isEmpty()){
//            JOptionPane.showMessageDialog(null,
//                    "vector de caras vacio");
//        }
//        else{
//
//            for (int i=0; i<=cantida_dados-1;i++){
//                cara_dado.remove(i);
//                JOptionPane.showMessageDialog(null,
//                        "REMUEVO DADO = "+i+
//                                "\ncara"+tirar_dados.getCaras().get(i));
//            }
//        }
//    }

    public void lanzar_inicio(int cantida_dados){
        //Aqui tiro el o los dados
        tirar_dados.iniciar(cantida_dados);

        for (int i=0; i<=cantida_dados-1;i++){
            setCara(i,tirar_dados.getCaras()[i]);//Toma las caras que se generan en la clase tirar_dados y las guarda en esta clase
//            JOptionPane.showMessageDialog(null,
//                    "DADO = "+i+
//                            "\ncara"+tirar_dados.getCaras().get(i));
        }
//        JOptionPane.showMessageDialog(null, "sale de tirar dados en model ");
    }

    public void setCara(int posicion, int caras) {
        cara_dado[posicion] = caras;
    }
    public int getCara(int posicion) {
        return  cara_dado[posicion];
    }


    public void bloquear_corazon() {
        block_Unblock.bloquear_corazon();
    }

    public void bloquear_dragon() {
        block_Unblock.bloquear_dragon();
    }

    public void bloquear_meeple() {
        block_Unblock.bloquear_meeple();
    }

    public void bloquear_nave() {
        block_Unblock.bloquear_nave();
    }

    public void bloquear_heroe() {
        block_Unblock.bloquear_heroe();
    }

    public void bloquear_punto() {
        block_Unblock.bloquear_punto();
    }



    public void cambiar_posicion_dado(int posicion ){
        switch (getEstado(posicion)) {
            case 1 -> {
                dados_usados[posicion] = cara_dado[posicion];
                regla_del_dado[posicion] = 8;
//                setEstado(i, 1);
//                cuenta_dados_usados();

                JOptionPane.showMessageDialog(null, "Sigue en Usados"
                        +"\nCantidad de dados usados ="+getCantidad_en_usados()
                        +"\nCantidad de dados inactivo ="+getCantidad_en_inactivos()
                        +"\nCantidad de dados en punto ="+getCantidad_en_puntos()
                        +"\nCantidad de dados activos ="+getCantidad_en_activo());
            }
            case 2 -> {
                dados_activos[posicion] = cara_dado[posicion];
                regla_del_dado[posicion] = 8;
                setEstado(posicion, 4);

                resta_dados_inactivos();
                cuenta_dados_activos();

                JOptionPane.showMessageDialog(null, "Pasa a dado Activos"
                        +"\nCantidad de dados usados ="+getCantidad_en_usados()
                        +"\nCantidad de dados inactivo ="+getCantidad_en_inactivos()
                        +"\nCantidad de dados en punto ="+getCantidad_en_puntos()
                        +"\nCantidad de dados activos ="+getCantidad_en_activo());
            }
            case 3 -> {
                dados_enPunto[posicion] = cara_dado[posicion];
                regla_del_dado[posicion] = 8;
                setEstado(posicion, 3);
                resta_dados_activos();
                cuenta_dados_enPunto();

                JOptionPane.showMessageDialog(null, "Pasa a dado Puntos"
                        +"\nCantidad de dados usados ="+getCantidad_en_usados()
                        +"\nCantidad de dados inactivo ="+getCantidad_en_inactivos()
                        +"\nCantidad de dados en punto ="+getCantidad_en_puntos()
                        +"\nCantidad de dados activos ="+getCantidad_en_activo());
            }
            case 4 -> {
                dados_usados[posicion] = cara_dado[posicion];
                regla_del_dado[posicion] = 8;
                setEstado(posicion, 1);

                resta_dados_activos();
                cuenta_dados_usados();



                JOptionPane.showMessageDialog(null, "Pasa a dado Usados"
                        +"\nCantidad de dados usados ="+getCantidad_en_usados()
                        +"\nCantidad de dados inactivo ="+getCantidad_en_inactivos()
                        +"\nCantidad de dados en punto ="+getCantidad_en_puntos()
                        +"\nCantidad de dados activos ="+getCantidad_en_activo());
            }
        }
    }

    public void activar_dado(int posicion, int cara_dado){
        switch (cara_dado) {
            case 1 -> {
                block_Unblock.desbloquear_corazon();
                block_Unblock.bloquear_nave();
                block_Unblock.bloquear_heroe();
                block_Unblock.bloquear_punto();
                block_Unblock.bloquear_dragon();
                block_Unblock.bloquear_meeple();
                setEstado(posicion, 4);
                JOptionPane.showMessageDialog(null, "Seleccionaste Corazon");
            }

            case 2 -> {
//                block_Unblock.desbloquear_dragon();
                block_Unblock.bloquear_nave();
                block_Unblock.bloquear_heroe();
                block_Unblock.bloquear_punto();
                block_Unblock.bloquear_corazon();
                block_Unblock.bloquear_meeple();
                setEstado(posicion, 4);
                JOptionPane.showMessageDialog(null, "Seleccionaste Dragon");
            }

            case 3 -> {
                block_Unblock.desbloquear_meeple();
                block_Unblock.bloquear_nave();
                block_Unblock.bloquear_heroe();
                block_Unblock.bloquear_punto();
                block_Unblock.bloquear_dragon();
                block_Unblock.bloquear_corazon();
                setEstado(posicion, 4);
                JOptionPane.showMessageDialog(null, "Seleccionaste Meeple");
            }

            case 4 -> {
                block_Unblock.desbloquear_nave();
                block_Unblock.bloquear_heroe();
                block_Unblock.bloquear_punto();
                block_Unblock.bloquear_dragon();
                block_Unblock.bloquear_corazon();
                block_Unblock.bloquear_meeple();
                setEstado(posicion, 4);
                JOptionPane.showMessageDialog(null, "Seleccionaste ship");
            }

            case 5 -> {

                block_Unblock.desbloquear_heroe();
                block_Unblock.bloquear_nave();
                block_Unblock.bloquear_punto();
                block_Unblock.bloquear_dragon();
                block_Unblock.bloquear_corazon();
                block_Unblock.bloquear_meeple();
                setEstado(posicion, 4);
                JOptionPane.showMessageDialog(null, "Seleccionaste Hero");
            }

            case 6 -> {

//                desbloquear_punto();
                block_Unblock.bloquear_nave();
                block_Unblock.bloquear_heroe();
                block_Unblock.bloquear_dragon();
                block_Unblock.bloquear_corazon();
                block_Unblock.bloquear_meeple();
                setEstado(posicion, 4);
//                juegoGeek.accion_Cuarenta_y_Dos(6);
                JOptionPane.showMessageDialog(null, "Seleccionaste point");
            }
        }
    }

        public int getCantidad_en_usados() {
            return cantidad_en_usados;
        }

        public int getCantidad_en_inactivos() {
            return cantidad_en_inactivos;
        }

        public int getCantidad_en_puntos() {
            return cantidad_en_puntos;
        }

        public int getCantidad_en_activo() {
            return cantidad_en_activo;
        }



        public void cuenta_dados_usados() {
            cantidad_en_usados++;
        }
        public void cuenta_dados_inactivos() {

            cantidad_en_inactivos++;
        }
        public void cuenta_dados_enPunto() {

            cantidad_en_puntos++;
        }
        public void cuenta_dados_activos() {

            cantidad_en_activo++;
        }


        public void resta_dados_usados() {
            cantidad_en_usados--;
        }
        public void resta_dados_inactivos() {

            cantidad_en_inactivos--;
        }
        public void resta_dados_enPunto() {

            cantidad_en_puntos--;
        }
        public void resta_dados_activos() {

            cantidad_en_activo--;
        }


        public int getEstado(int i) {
            return estado[i];
        }

        public void setEstado(int posicion, int estado) {
            this.estado[posicion] = estado;



        }

        public void setEstado_string(int posicion, String texto) {
            estado_string[posicion] = texto;
        }

        public void setValidacion_tiro(int validacion_tiro) {
            this.validacion_tiro = validacion_tiro;
        }

        public int getValidacion_tiro() {
            return validacion_tiro;
        }




//
//    public Vector<String> getEstado_string() {
//        switch (getEstado()){
//            case 0:
//                setEstado_string("Tu tiro de salida fue ("+punto+")");
//                setEstado_string("Sique lansando hasta sacar \""+punto+"\"\n"
//                        +"Si sacas \"7\" antes que \""+punto+"\" perderás");
//                break;
//            case 1:
//                setEstado_string("Tiro de salida ("+tiro+")");
//                setEstado_string("|Haz sacado un natural !GANASTE¡|");
//                break;
//            case 2:
//                setEstado_string("Tu tiro de salida fue ("+tiro+")");
//                setEstado_string("Sacaste Craps, has perdido!!");
//                break;
//            case 3:
//                setEstado_string("Tu tiro fue ("+tiro+")"+"\nHiciste punto" );
//                setEstado_string("Estableaste Punto en \""+punto+"\" Debes seguir lanzando!!\n" +
//                        "Pero si sacas \"7\" antes que \""+punto+"\" perderás");
//                break;
//            case 4:
//                setEstado_string("Tu tiro de salida fue ("+punto+")");
//                setEstado_string("Volviste a sacar \""+punto+"\" haz ganado!!");
//                break;
//            case 5:
//                setEstado_string("Tu tiro fue ("+tiro+")");
//                setEstado_string("Sacaste \"7\" antes que "+punto+" haz perdido!!");
//                break;
//        }
//        return estado_string;
//    }

//    public int getPunto() {
//        return punto;
//    }
//
//    public void setPunto(int punto) {
//        this.punto = punto;
//    }
//
//    public int getTiro() {
//        return tiro;
//    }
//
//    public void setTiro(int tiro) {
//        this.tiro = tiro;
//    }
//
//    public void ronda_tiro(){
//        System.out.println("|Inicia la ronda tiro|");
//        int ronda = getValidacion_tiro();
//        if ( ronda== 0) {
//            if (getTiro() == 7 || getTiro() == 11) {
//                setEstado(1);
//                System.out.println("|!GANASTE¡|");
//            } else if (getTiro() == 3 || getTiro() == 2 || getTiro() == 12) {
//                setEstado(2);
//                System.out.println("|!¡CRAPS|");
//            }else {
//                setEstado(3);
//                setPunto(getTiro());
//                setValidacion_tiro(1);
//                System.out.println("|!PUNTO¡|"+getPunto());
//            }
//        }
//        else {
//            System.out.println("va ausar ronda punto|");
//            ronda_punto();
//        }
//    }
//    public void ronda_punto(){
//        System.out.println("|entro a ronda punto|");
//        if (getTiro() == getPunto()){
//            setEstado(4);
//            setValidacion_tiro(0);
//            System.out.println("|!GANASTE EN RONDA PUNTO¡|");
//        }
//        else if (getTiro() == 7){
//            setEstado(5);
//            setValidacion_tiro(0);
//            System.out.println("|CRAPS EN RONDA PUNTO|");
//        }
//        System.out.println("tiro "+getTiro()+ " punto " +punto);
//    }
//
}
