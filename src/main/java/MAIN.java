import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MAIN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSoftware de Análisis Genómico y Organización de Datos:");
            System.out.println("1. Conteo de Genes");
            System.out.println("2. Cálculo de Combinaciones Genéticas");
            System.out.println("3. Gestión de Fechas");
            System.out.println("4. Búsqueda Binaria en Archivo");
            System.out.println("5. Listado de Números en un Rango");
            System.out.println("6. Sumatoria de Números Naturales");
            System.out.println("7. Demostración de Quicksort");
            System.out.println("8. Ordenar Líneas de un Archivo de Texto");
            System.out.println("9. Encontrar el Valor Máximo y su Posición en un Arreglo");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    contarGenesDemo();
                    break;
                case 2:
                    calcularCombinacionesGeneticasDemo();
                    break;
                case 3:
                    gestionarFechas();
                    break;
                case 4:
                    buscarEnArchivoDemo();
                    break;
                case 5:
                    listarNumerosEnRangoDemo();
                    break;
                case 6:
                    sumatoriaNumerosNaturalesDemo();
                    break;
                case 7:
                    demoQuicksort();
                    break;
                case 8:
                    ordenarLineasArchivo("/Users/adrianareyesmorera/Desktop/CASO5.txt");
                    break;
                case 9:
                    encontrarMaximoYPosicionDemo();
                    break;
                case 10:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private static void contarGenesDemo() {
        String cadenaADN = "ATGCGTAGATGCGATAG"; // Ejemplo de cadena de ADN
        int numeroGenes = contarGenes(cadenaADN);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);
    }

    private static int contarGenes(String cadenaADN) {
        int contadorGenes = 0;
        int inicio = 0;

        while (true) {
            int locInicio = cadenaADN.indexOf("ATG", inicio);
            if (locInicio == -1) {
                // No se encuentra más "ATG"
                break;
            }
            int locFin = encontrarFinGen(cadenaADN, locInicio + 3);
            if (locFin != -1) {
                contadorGenes++;
                inicio = locFin + 3;
            } else {
                // No se encontró una secuencia de parada válida después de este "ATG"
                inicio = locInicio + 3;
            }
        }

        return contadorGenes;
    }

    private static int encontrarFinGen(String cadenaADN, int inicio) {
        int locTAA = cadenaADN.indexOf("TAA", inicio);
        int locTAG = cadenaADN.indexOf("TAG", inicio);
        int locTGA = cadenaADN.indexOf("TGA", inicio);


        // Encuentra el índice más cercano
        int minLoc = Math.min(locTAA != -1 ? locTAA : cadenaADN.length(),
                Math.min(locTAG != -1 ? locTAG : cadenaADN.length(),
                        locTGA != -1 ? locTGA : cadenaADN.length()));

        return (minLoc == cadenaADN.length()) ? -1 : minLoc;
    }


    private static void calcularCombinacionesGeneticasDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de genes: ");
        int numeroGenes = scanner.nextInt();
        System.out.print("Ingrese el número de alelos por gen: ");
        int numeroAlelos = scanner.nextInt();

        int combinaciones = calcularCombinacionesGeneticas(numeroGenes, numeroAlelos);
        System.out.println("El número de combinaciones genéticas posibles es: " + combinaciones);
    }

    private static int calcularCombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
        return (int) Math.pow(numeroAlelos, numeroGenes);
    }

    private static void gestionarFechas() {
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

    private static void buscarEnArchivoDemo() {
        // Esta es una función de marcador de posición. Deberías reemplazarla con tu implementación real.
        System.out.println("Función de búsqueda binaria en archivo no implementada.");
    }

    private static void listarNumerosEnRangoDemo() {
        // Ejemplo de listar números en un rango
        int inicio = 1, fin = 10;
        System.out.print("Listado de números del " + inicio + " al " + fin + ": ");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sumatoriaNumerosNaturalesDemo() {
        // Ejemplo de cálculo de la sumatoria de números naturales
        int n = 5;
        long sumatoria = sumatoriaDeNumerosNaturales(n);
        System.out.println("La sumatoria de los primeros " + n + " números naturales es: " + sumatoria);
    }

    private static long sumatoriaDeNumerosNaturales(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n + sumatoriaDeNumerosNaturales(n - 1);
        }
    }

    private static void demoQuicksort() {
        // Esta es una función de marcador de posición. Deberías reemplazarla con tu implementación real de quicksort.
        System.out.println("Demostración de Quicksort no implementada.");
    }

    private static void ordenarLineasArchivo(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            Collections.sort(lineas);
            System.out.println("Líneas ordenadas del archivo:");
            for (String s : lineas) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encontrarMaximoYPosicionDemo() {
        int[] datos = {1, 2, 3, 4, 5, 6, 2, 1};
        int[] posiciones = new int[1]; // Arreglo para almacenar la posición del máximo
        int resultadoMaximo = maximo(datos, datos.length - 1, posiciones);
        System.out.println("El número máximo en el arreglo es: " + resultadoMaximo);
        System.out.println("La posición del número máximo en el arreglo es: " + posiciones[0]);
    }

    private static int maximo(int[] datos, int indice, int[] posiciones) {
        if (indice == 0) {
            posiciones[0] = 0;
            return datos[0];
        } else {
            int maximoAnterior = maximo(datos, indice - 1, posiciones);
            if (datos[indice] > maximoAnterior) {
                posiciones[0] = indice;
                return datos[indice];
            } else {
                return maximoAnterior;
            }
        }
    }
}









