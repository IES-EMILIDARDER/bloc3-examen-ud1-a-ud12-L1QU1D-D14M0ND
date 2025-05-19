package examen;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main5 {

    public static void main(String[] args) {

        List<Vehicle> vehicles = Arrays.asList(
                new Vehicle("4321-JKL", "Ford", "Focus", 2019, 17000),
                new Vehicle("8765-MNO", "Hyundai", "Ioniq 5", 2023, 42000),
                new Vehicle("2109-PQR", "Peugeot", "308", 2016, 14000)
        );

        GestorBBDD bbdd = new GestorBBDD("C:\\temp\\mysql.con");

        vehicles.forEach((e) -> {
            try {
                bbdd.executaSQL(bbdd.getConnectionFromFile(), "INSERTO INTO vehicles (matricula, marca, model, any, preu) "
                        + "VALUES (" + e.getMarca() + "," + "," + "," + "," + ")", args);
            } catch (SQLException ex) {
                Logger.getLogger(Main5.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main5.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}
