import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class OrdenarLineas {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            String linea;
            int contador = 0;
            String[] lineas = new String[100];
            while ((linea = br.readLine()) != null) {
                lineas[contador] = linea;
                contador++;
            }
            Arrays.sort(lineas);
            for (String s : lineas) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}