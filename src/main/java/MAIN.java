import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        System.out.println("Conteo de Genes");
        String cadenaADN = "ATGCGTAGATGCGATAG";
        int posicion = 0;
        int numeroGenes = contarGenes(cadenaADN, posicion);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);

        System.out.println("Combinaciones Genéticas");
        int numeroGenes2 = 2;
        int numeroAlelos = 4;
        int combinacionesGeneticas = CombinacionesGeneticas(numeroGenes, numeroAlelos);
        System.out.println("El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);

        System.out.println("Búsqueda Binaria");
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
            int posicion2 = Arrays.binarySearch(lineas, palabraBuscada);
            if (posicion2 >= 0) {
                System.out.println("La palabra '" + palabraBuscada + "' se encuentra en la posición " + posicion2);
            } else {
                System.out.println("La palabra '" + palabraBuscada + "' no se encuentra en el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Listado de números en un rango");
        int inicio = 1;
        int fin = 10;
        System.out.print("Los números en el rango de " + inicio + " a " + fin + " son: ");
        listar(inicio, fin);
    }

    public static int contarGenes(String cadenaADN, int posicion) {
        if (cadenaADN == null || cadenaADN.isEmpty()) {
            return 0;
        }
        if (!cadenaADN.contains("ATG")) {
            return 0;
        }
        int finGen = Math.max(cadenaADN.indexOf("TGA", posicion), cadenaADN.indexOf("TAG", posicion));

        if (finGen == -1) {
            return 0;
        }
        return 1 + contarGenes(cadenaADN.substring(finGen), finGen);
    }

    public static int CombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
        if (numeroGenes <= 0) {
            return 0;
        }
        if (numeroGenes == 1) {
            return numeroAlelos;
        }
        return numeroAlelos * CombinacionesGeneticas(numeroGenes -1, numeroAlelos);
    }

    public static void listar(int inicio, int fin) {
        if (inicio <= fin) {
            System.out.print(inicio + " ");
            listar(inicio + 1, fin);
        }
    }

}