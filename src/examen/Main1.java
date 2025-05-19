package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<String> filtrat = new ArrayList<>();
        String vehiclesCSV = "C:\\temp\\vehicles.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(vehiclesCSV));) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!(linea.isEmpty() || linea.startsWith("#"))) {

                    String[] detalles = linea.split(",", 5);

                    vehicles.add(new Vehicle(detalles[0].trim(), detalles[1].trim(), detalles[2].trim(), Integer.valueOf(detalles[3].trim()), Double.valueOf(detalles[4].trim())));

                }
            }
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        }

        vehicles.forEach((e) -> {
            if (e.getAny() > 2014) {
                if (!filtrat.contains(e.getMarca())) {
                    filtrat.add(e.getMarca());
                }
            }
        });

        System.out.println(filtrat.stream().sorted().toList());

    }
}
