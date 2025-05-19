package examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.BiFunction;

public class Main3 {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehiclesCSV = "C:\\temp\\vehicles.csv";
        final double aumento = 10;

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

        System.out.println(vehicles);

        vehicles.stream().forEach((e) -> e.setPreu(e.getPreu() * ((aumento / 100) + 1)));

        System.out.println(vehicles);

    }
}
