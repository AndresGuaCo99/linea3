package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class cabinaTelefonica {
    public String id;
    public int numeroLlamadas;
    public int duracionTotal;
    public int costoTotal;

    public double tarifaLocal = 50;
    public double tarifaLargaDistancia = 350;
    public double tarifaCelular = 150;

    public String getId() {
        return id;
    }

    public int getNumeroLlamadas() {
        return numeroLlamadas;
    }

    public int getDuracionTotal() {
        return duracionTotal;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public cabinaTelefonica(String id) {
        this.id = id;
        this.numeroLlamadas = 0;
        this.duracionTotal = 0;
        this.costoTotal = 0;
    }

    public void registarLlamada(String tipo, int duracion) {
        numeroLlamadas++;
        duracionTotal += duracion;

        switch (tipo.toLowerCase()) {
            case "local":
                costoTotal += duracion * tarifaLocal;
                break;
            case "larga distancia":
                costoTotal += duracion * tarifaLargaDistancia;
                break;
            case "celular":
                costoTotal += duracion * tarifaCelular;
                break;
            default:
                System.out.println("Tipo de llamada no válido.");
        }
    }

    public void reiniciar() {
        numeroLlamadas = 0;
        duracionTotal = 0;
        costoTotal = 0;
    }

    private List<cabinaTelefonica> cabinas = new ArrayList<>();

    public cabinaTelefonica() {
        cabinas = new ArrayList<>(); // Inicializar la lista aquí
    }

    public void agregarCabina(String id) {
        cabinas.add(new cabinaTelefonica(id));
    }

    public cabinaTelefonica seleccionarCabina(String id) {
        for (cabinaTelefonica cabina : cabinas) {
            if (cabina.getId().equals(id)) {
                return cabina;
            }
        }
        return null;
    }

    public void mostrarHistorialCabinas() {
        for (cabinaTelefonica cabina : cabinas) {
            System.out.println(cabina);
        }
    }

    public void mostrarResumen() {
        int totalLlamadas = 0;
        int totalDuracion = 0;
        int totalCosto = 0;

        for (cabinaTelefonica cabina : cabinas) {
            totalLlamadas += cabina.getNumeroLlamadas();
            totalDuracion += cabina.getDuracionTotal();
            totalCosto += cabina.getCostoTotal();
        }
        System.out.println("Historial de llamadas: \n" +
                "Llamadas: " + totalLlamadas + ", " + "\n" +
                "Duración total: " + totalDuracion + " min." + "\n" +
                "Costo Total: $" + totalCosto);
    }

    @Override
    public String toString() {
        return "Cabina ID: " + id + ", Llamadas: " + numeroLlamadas + ", Duración: " + duracionTotal + " min, Costo: $" + costoTotal;
    }
}
