import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RuletaRusa {
    private List<Integer> tambor;
    private int bala;
    private int posicionActual;
    Random ra = new Random();

    public RuletaRusa() {
        tambor = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            tambor.add(i);
        }
        bala = ra.nextInt(6);
        posicionActual = 0;
    }

    public boolean disparar() {
        if (posicionActual == bala) {
            return true;
        } else {
            posicionActual++;
            return false;
        }
    }
    public void reiniciarJuego() {
        bala = ra.nextInt(6);
        posicionActual = 0;
    }

    public String toString() {
        return "RuletaRusa{" +
                "bala=" + bala +
                ", posicionActual=" + posicionActual;
    }

}
