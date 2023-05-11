package modelo;
import java.util.ArrayList;
import java.util.Random;


public class GeekOutMaster {
    private ArrayList<Integer> activeDice;
    private ArrayList<Integer> inactiveDice;
    private Random random;

    public GeekOutMaster() {
        activeDice = new ArrayList<Integer>();
        inactiveDice = new ArrayList<Integer>();
        random = new Random();
        // inicializar los dados activos con 6 dados
        for (int i = 0; i < 6; i++) {
            activeDice.add(random.nextInt(5) + 1); // los dados tienen valores del 1 al 6
        }
    }

    public void Meeple() {
        // relanzar otro dado en juego
        int diceIndex = random.nextInt(activeDice.size());
        int newValue = random.nextInt(5) + 1;
        activeDice.set(diceIndex, newValue);
    }

    public void NaveEspacial() {
        // enviar un dado no usado de los activos a los inactivos
        int diceIndex = random.nextInt(activeDice.size());
        int diceValue = activeDice.remove(diceIndex);
        inactiveDice.add(diceValue);
    }

    public void Superheroe() {
        // voltear cualquier dado no usado de los activos y colocarlo en su cara opuesta
        int diceIndex = random.nextInt(activeDice.size());
        int diceValue = activeDice.get(diceIndex);
        int newValue = 7 - diceValue;
        activeDice.set(diceIndex, newValue);
    }

    public void Corazon() {
        // tomar un dado de los inactivos y lanzarlo para que sea un nuevo dado activo
        if (inactiveDice.size() > 0) {
            int diceIndex = random.nextInt(inactiveDice.size());
            int diceValue = inactiveDice.remove(diceIndex);
            activeDice.add(diceValue);
        }
    }

    public boolean Dragon() {
        // verificar si el último dado activo es el Dragón
        return activeDice.size() == 1 && activeDice.get(0) == 5;
    }

    public void CuarentaDos() {
        // no hace nada en este método, los puntos se sumarán al final de la ronda
    }

    public int Puntuacion() {
        // sumar los valores de los dados activos, excepto el Dragón si es el último
        int total = 0;
        for (int i = 0; i < activeDice.size(); i++) {
            int diceValue = activeDice.get(i);
            if (!(i == activeDice.size() - 1 && diceValue == 5)) {
                total += diceValue;
            }
        }
        // sumar 42 si está presente en los dados activos
        if (activeDice.contains(4) && activeDice.contains(2)) {
            total += 42;
        }
        return total;
    }
    public class Main {
        public static void main(String[] args) {
            GeekOutMaster game = new GeekOutMaster();
            System.out.println(game.toString());
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dados activos: ");
        for (int i = 0; i < activeDice.size(); i++) {
            sb.append(activeDice.get(i));
            if (i < activeDice.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\nDados inactivos: ");
        for (int i = 0; i < inactiveDice.size(); i++) {
            sb.append(inactiveDice.get(i));
            if (i < inactiveDice.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\nPuntuación: ");
        sb.append(Puntuacion());
        return sb.toString();
    }

}
