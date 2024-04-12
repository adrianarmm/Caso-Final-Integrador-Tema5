import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarLineas {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            ArrayList<String> lineas = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                lineas.add(linea); // Añadir línea leída a la lista
            }
            Collections.sort(lineas); // Ordenar la lista
            for (String s : lineas) {
                System.out.println(s); // Imprimir líneas ordenadas
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
