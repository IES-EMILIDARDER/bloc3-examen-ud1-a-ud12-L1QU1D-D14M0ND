package examen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main4 {

    public static void main(String[] args) throws SQLException {

        GestorBBDD bbdd = new GestorBBDD("C:\\temp\\mysql.con");

        try {
            System.out.println(bbdd.executaQuerySQL(bbdd.getConnectionFromFile(), "SELECT * FROM vehicles WHERE any > 2019", args));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
