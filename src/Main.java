import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numJugadores;

        System.out.print("Ingrese el número de jugadores: ");
        numJugadores = scanner.nextInt();
        scanner.nextLine();

        RuletaRusa ruletas = new RuletaRusa();

        int jugadorActual = random.nextInt(numJugadores) + 1;

        System.out.println("¡Bienvenido a la Ruleta Rusa!");
        System.out.println("El juego comenzará con el Jugador " + jugadorActual);

        while (true) {
            boolean rondaTerminada = false;

            while (!rondaTerminada) {
                System.out.println("\nTurno del Jugador " + jugadorActual);
                System.out.print("¿Disparar? (s/n): ");
                String respuesta = scanner.nextLine();

                if (respuesta.equalsIgnoreCase("s")) {
                    if (ruletas.disparar()) {
                        System.out.println(" El Jugador " + jugadorActual + " ha perdido.");
                        System.out.println(ruletas);
                        System.out.println();
                        rondaTerminada = true;
                    } else {
                        System.out.println(" El Jugador " + jugadorActual + " ha sobrevivido.");
                        System.out.println(ruletas);
                        jugadorActual++;
                        if (jugadorActual > numJugadores) {
                            jugadorActual = 1;
                        }
                    }
                } else if (respuesta.equalsIgnoreCase("n")) {
                    rondaTerminada = true;
                    System.out.println("El juego ha terminado.");
                } else {
                    System.out.println("Entrada no válida. Intenta de nuevo.");
                }
            }

            System.out.print("¿Jugar de nuevo? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                ruletas.reiniciarJuego();
                jugadorActual = random.nextInt(numJugadores) + 1;
                System.out.println("Nuevo Juego Iniciado. Comienza el Jugador " + jugadorActual);
            } else {
                System.out.println("Gracias por jugar.");
                break;
            }
        }
        scanner.close();
    }
}
