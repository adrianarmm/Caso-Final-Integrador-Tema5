import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusquedaBinaria {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/adrianareyesmorera/Desktop/CASO5.txt"))) {
            String linea;
            List<String> listaLineas = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                listaLineas.add(linea);
            }
            // Convierte la lista a un arreglo para poder usar búsqueda binaria
            String[] lineas = listaLineas.toArray(new String[0]);
            Arrays.sort(lineas); // Ahora es seguro ordenar el arreglo, ya que no contiene nulls
            String palabraBuscada = "ADN";
            int posicion = Arrays.binarySearch(lineas, palabraBuscada);
            if (posicion >= 0) {
                System.out.println("La palabra '" + palabraBuscada + "' se encuentra en la posición " + posicion);
            } else {
                System.out.println("La palabra '" + palabraBuscada + "' no se encuentra en el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
