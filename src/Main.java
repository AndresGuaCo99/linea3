package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        cabinaTelefonica control = new cabinaTelefonica();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random(); // Crear un objeto Random
        String opcion;

        do {
            System.out.println("1. Agregar cabina");
            System.out.println("2. Registrar llamadas");
            System.out.println("3. Mostrar información de cabinas");
            System.out.println("4. Mostrar información total");
            System.out.println("5. Reiniciar cabinas");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese ID de la cabina: ");
                    String idCabina = scanner.nextLine();
                    control.agregarCabina(idCabina);
                    System.out.println("Cabina creada exitosamente");
                    break;

                case "2":
                    System.out.print("Ingrese ID de la cabina: ");
                    String id = scanner.nextLine();
                    cabinaTelefonica cabina = control.seleccionarCabina(id);
                    if (cabina != null) {
                        System.out.println("Tipo de llamada:");
                        System.out.println("1. Local");
                        System.out.println("2. Larga distancia");
                        System.out.println("3. Celular");
                        System.out.print("Seleccione el tipo de llamada: ");
                        int tipoLlamada = Integer.parseInt(scanner.nextLine());

                        String tipo;
                        switch (tipoLlamada) {
                            case 1:
                                tipo = "local";
                                break;
                            case 2:
                                tipo = "larga distancia";
                                break;
                            case 3:
                                tipo = "celular";
                                break;
                            default:
                                System.out.println("Opción no válida.");
                                continue;
                        }
                        int duracion = random.nextInt(10) + 1;
                        System.out.println("Duración de la llamada: " + duracion + " minutos.");

                        cabina.registarLlamada(tipo, duracion);
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                    break;

                case "3":
                    System.out.println("\n -------INFORMACIÓN DE  CABINAS ----------");
                    control.mostrarHistorialCabinas();
                    break;

                case "4":
                    System.out.println("\n -------INFORMACIÓN GENERAL ----------");
                    control.mostrarResumen();
                    break;

                case "5":
                    System.out.print("Ingrese ID de la cabina a reiniciar: ");
                    String idReiniciar = scanner.nextLine();
                    cabinaTelefonica cabinaReiniciar = control.seleccionarCabina(idReiniciar);
                    if (cabinaReiniciar != null) {
                        cabinaReiniciar.reiniciar();
                        System.out.println("Cabina reiniciada.");
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                    break;

                case "0":
                    System.out.println("Saliendo");
                    break;
            }
        } while (!opcion.equals("0"));
    }
}
