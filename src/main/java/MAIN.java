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

        System.out.println("Gestión de Fechas");
        Scanner scanner = new Scanner(System.in);
        List<LocalDate> fechas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print("Introduce una fecha (dd/MM/yyyy) o escribe 'fin' para terminar: ");
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            LocalDate fecha = LocalDate.parse(entrada, formatter);
            fechas.add(fecha);
        }
        Collections.sort(fechas);
        System.out.println("Fechas ordenadas:");
        for (LocalDate fecha : fechas) {
            System.out.println(fecha.format(formatter));
        }
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

}