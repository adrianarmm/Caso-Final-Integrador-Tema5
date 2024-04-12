import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIN {

    public static void main(String[] args) {
        System.out.println("Conteo de Genes");
        String cadenaADN = "ATGCGTAGATGCGATAG";
        int numeroGenes = contarGenes(cadenaADN, 0);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);

        System.out.println("Combinaciones Genéticas");
        int numeroGenes2 = 2;
        int numeroAlelos = 4;
        int combinacionesGeneticas = combinacionesGeneticas(numeroGenes2, numeroAlelos);
        System.out.println("El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);

        System.out.println("Búsqueda Binaria");
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/adrianareyesmorera/Desktop/CASO5.txt"))) {
            String linea;
            List<String> listaLineas = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                listaLineas.add(linea);
            }
            String[] lineas = listaLineas.toArray(new String[0]);
            Arrays.sort(lineas);
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
        if (cadenaADN == null || cadenaADN.isEmpty() || posicion >= cadenaADN.length()) {
            return 0;
        }
        int inicioGen = cadenaADN.indexOf("ATG", posicion);
        if (inicioGen == -1) {
            return 0;
        }
        int finGenTGA = cadenaADN.indexOf("TGA", inicioGen + 3);
        int finGenTAG = cadenaADN.indexOf("TAG", inicioGen + 3);
        int finGen = Math.min(finGenTGA != -1 ? finGenTGA + 3 : Integer.MAX_VALUE,
                finGenTAG != -1 ? finGenTAG + 3 : Integer.MAX_VALUE);
        if (finGen == Integer.MAX_VALUE) {
            return 0;
        }
        return 1 + contarGenes(cadenaADN, finGen);
    }

    public static int combinacionesGeneticas(int numeroGenes, int numeroAlelos) {
        if (numeroGenes <= 0) {
            return 0;
        }
        if (numeroGenes == 1) {
            return numeroAlelos;
        }
        return numeroAlelos * combinacionesGeneticas(numeroGenes - 1, numeroAlelos);
    }

    public static void listar(int inicio, int fin) {
        if (inicio <= fin) {
            System.out.print(inicio + " ");
            listar(inicio + 1, fin);
        } else {
            System.out.println();
        }
    }

}
