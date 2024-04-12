import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MAIN {

    public static void main(String[] args) {
        // Conteo de genes en una cadena de ADN
        System.out.println("Conteo de Genes");
        String cadenaADN = "ATGCGTAGATGCGATAG";
        int numeroGenes = contarGenes(cadenaADN, 0);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);

        // Cálculo de combinaciones genéticas
        System.out.println("Combinaciones Genéticas");
        int numeroGenes2 = 2;
        int numeroAlelos = 4;
        int combinacionesGeneticas = combinacionesGeneticas(numeroGenes2, numeroAlelos);
        System.out.println("El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);

        // Gestión de fechas
        gestionarFechas();

        // Búsqueda binaria en un archivo de texto
        System.out.println("Búsqueda Binaria");
        String filePath = "/Users/adrianareyesmorera/Desktop/CASO5.txt"; // Asegúrate de que la ruta del archivo sea correcta
        String palabraBuscada = "ADN";
        busquedaBinaria(filePath, palabraBuscada);

        // Listado de números en un rango dado
        System.out.println("Listado de números en un rango");
        int inicio = 1;
        int fin = 10;
        System.out.print("Los números en el rango de " + inicio + " a " + fin + " son: ");
        listar(inicio, fin);
    }

    // Demostracion de quicksort
    int[] arreglo = {5, 2, 9, 1, 5, 6};
        System.out.println("\nArreglo original: " + Arrays.toString(arreglo));
        quicksort(arreglo, 0, arreglo.length - 1);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
}

// Método para realizar la partición del arreglo (parte del quicksort)
public static int partition(int[] arreglo, int inicio, int fin) {
    int pivote = arreglo[fin];
    int i = (inicio - 1);
    for (int j = inicio; j < fin; j++) {
        if (arreglo[j] <= pivote) {
            i++;
            int temp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = temp;
        }
    }
    int temp = arreglo[i + 1];
    arreglo[i + 1] = arreglo[fin];
    arreglo[fin] = temp;
    return i + 1;
}
}

public static void quicksort(int[] arreglo, int inicio, int fin) {
    if (inicio < fin) {
        int indiceParticion = OptimizedQuicksort.partition(arreglo, inicio, fin);
        quicksort(arreglo, inicio, indiceParticion - 1);
        quicksort(arreglo, indiceParticion + 1, fin);
    }
}

    // Método para contar genes en una cadena de ADN
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

    // Método para calcular combinaciones genéticas
    public static int combinacionesGeneticas(int numeroGenes, int numeroAlelos) {
        if (numeroGenes <= 0) {
            return 0;
        }
        if (numeroGenes == 1) {
            return numeroAlelos;
        }
        return numeroAlelos * combinacionesGeneticas(numeroGenes - 1, numeroAlelos);
    }

    // Método para listar números en un rango
    public static void listar(int inicio, int fin) {
        if (inicio <= fin) {
            System.out.print(inicio + " ");
            listar(inicio + 1, fin);
        } else {
            System.out.println();
        }
    }

    // Método para gestionar la entrada de fechas por parte del usuario
    public static void gestionarFechas() {
        System.out.println("Gestión de Fechas (escribe 'fin' para continuar con el programa)");
        Scanner scanner = new Scanner(System.in);
        List<LocalDate> fechas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Introduce una fecha (dd/MM/yyyy) o escribe 'fin' para terminar: ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                LocalDate fecha = LocalDate.parse(entrada, formatter);
                fechas.add(fecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, intenta nuevamente.");
            }
        }
        Collections.sort(fechas);
        System.out.println("Fechas ordenadas:");
        for (LocalDate fecha : fechas) {
            System.out.println(fecha.format(formatter));
        }
    }

    // Método para realizar una búsqueda binaria en un archivo de texto
    public static int busquedaBinaria(String filePath, String targetWord) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            List<String> listaLineas = new ArrayList<>();
            while ((linea = br.readLine()) != null) {
                listaLineas.add(linea);
            }
            String[] lineas = listaLineas.toArray(new String[0]);
            Arrays.sort(lineas);
            int posicion = Arrays.binarySearch(lineas, targetWord);
            if (posicion >= 0) {
                System.out.println("La palabra '" + targetWord + "' se encuentra en la posición " + posicion);
            } else {
                System.out.println("La palabra '" + targetWord + "' no se encuentra en el archivo");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;

}

public static int wait(int[] arreglo, int inicio, int fin) {
        int pivote = arreglo[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] < pivote) {
                i++;
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }


public void main() {
        int[] arreglo = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Arreglo original: " + Arrays.toString(arreglo));
        wait(arreglo, 0, arreglo.length - 1);
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
        
}









