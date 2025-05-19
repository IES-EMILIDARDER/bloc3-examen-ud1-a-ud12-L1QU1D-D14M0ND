package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String vehiclesCSV = "\"C:\\temp\\vehicles.csv\"";

        try (BufferedReader lector = new BufferedReader(new FileReader(vehiclesCSV));
                ) {
            String linea;
            
            while ((linea = lector.readLine()) != null) {
                if (!(linea.isEmpty() || linea.startsWith("#"))) {
                    
                    String[] detalles = linea.split(",",5);
                    
                    //vehicles.add(new Vehicle(detalles[0], detalles[1], detalles[2], (int) detalles[3], (double) detalles[4]));
                    
                }
            }
        } catch (IOException e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
        }

    }
}
