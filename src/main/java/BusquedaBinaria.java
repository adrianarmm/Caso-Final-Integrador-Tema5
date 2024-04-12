import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BusquedaBinaria {
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
            String palabraBuscada = "ejemplo";
            int posicion = Arrays.binarySearch(lineas, palabraBuscada);
            if (posicion >= 0) {
                System.out.println("La palabra " + palabraBuscada + " se encuentra en la posición " + posicion);
            } else {
                System.out.println("La palabra " + palabraBuscada + " no se encuentra en el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}