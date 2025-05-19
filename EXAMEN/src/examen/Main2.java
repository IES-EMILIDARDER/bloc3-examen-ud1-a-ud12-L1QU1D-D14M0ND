package examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
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

        //vehicles.forEach((e) -> System.out.println(e.toString()));
        System.out.println("Vehicles amb preu major de 15000 EUR: " + vehicles.stream().filter((e) -> e.getPreu() > 15000).count());
        System.out.println("Preu mitjà: " + vehicles.stream());
        System.out.println("Més car: " + vehicles.stream().max((Vehicle e1, Vehicle e2) -> e1.getPreu().equals(e2.getPreu())));
        System.out.println("Més car: " + vehicles.stream().min((Vehicle e1, Vehicle e2) -> e1.getPreu().equals(e2.getPreu())));

    }
}
