import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
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

    public static void main(String[] args) {
        int[] datos = { 1, 2, 3, 4, 5 };
        int[] posiciones = { 0 };
        int indice = datos.length - 1;
        int resultado = MaximoPosicion.maximo(datos, indice, posiciones);
        System.out.println("El número máximo en el arreglo es: " + resultado);
        System.out.println("La posición del número máximo en el arreglo es: " + posiciones[0]);
    }
}