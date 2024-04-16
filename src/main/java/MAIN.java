import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MAIN extends JFrame {

    public MAIN() {
        super("Software de Análisis Genómico y Organización de Datos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        String[] buttonLabels = {
                "1. Conteo de Genes",
                "2. Cálculo de Combinaciones Genéticas",
                "3. Gestión de Fechas",
                "4. Búsqueda Binaria en Archivo",
                "5. Listado de Números en un Rango",
                "6. Sumatoria de Números Naturales",
                "7. Demostración de Quicksort",
                "8. Ordenar Líneas de un Archivo de Texto",
                "9. Encontrar el Valor Máximo y su Posición en un Arreglo"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this::actionPerformed);
            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }

    private void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "1. Conteo de Genes":
                contarGenesDemo();
                break;
            case "2. Cálculo de Combinaciones Genéticas":
                calcularCombinacionesGeneticasDemo();
                break;
            case "3. Gestión de Fechas":
                gestionarFechasDemo();
                break;
            case "4. Búsqueda Binaria en Archivo":
                buscarEnArchivoDemo();
                break;
            case "5. Listado de Números en un Rango":
                listarNumerosEnRangoDemo();
                break;
            case "6. Sumatoria de Números Naturales":
                sumatoriaNumerosNaturalesDemo();
                break;
            case "7. Demostración de Quicksort":
                demoQuicksortDemo();
                break;
            case "8. Ordenar Líneas de un Archivo de Texto":
                ordenarLineasArchivoDemo();
                break;
            case "9. Encontrar el Valor Máximo y su Posición en un Arreglo":
                encontrarMaximoYPosicionDemo();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción no válida.");
        }
    }

    private void contarGenesDemo() {
        JOptionPane.showMessageDialog(this, "Función 'Conteo de Genes' seleccionada.");

        String cadenaADN = JOptionPane.showInputDialog(this, "Ingrese la cadena de ADN:");
        if (cadenaADN != null && !cadenaADN.trim().isEmpty()) {
            int numeroGenes = contarGenes(cadenaADN);
            JOptionPane.showMessageDialog(this, "El número de genes en la cadena de ADN es: " + numeroGenes);
        } else {
            JOptionPane.showMessageDialog(this, "No se ingresó una cadena de ADN válida.");
        }
    }

    private int contarGenes(String cadenaADN) {
        int contadorGenes = 0;
        int inicio = 0;

        while (true) {
            int locInicio = cadenaADN.indexOf("ATG", inicio);
            if (locInicio == -1) {
                break;
            }
            int locFin = encontrarFinGen(cadenaADN, locInicio + 3);
            if (locFin != -1) {
                contadorGenes++;
                inicio = locFin + 3;
            } else {
                inicio = locInicio + 3;
            }
        }

        return contadorGenes;
    }

    private int encontrarFinGen(String cadenaADN, int inicio) {
        int locTAA = cadenaADN.indexOf("TAA", inicio);
        int locTAG = cadenaADN.indexOf("TAG", inicio);
        int locTGA = cadenaADN.indexOf("TGA", inicio);

        // Encuentra el índice más cercano
        int minLoc = Math.min(locTAA != -1 ? locTAA : cadenaADN.length(),
                Math.min(locTAG != -1 ? locTAG : cadenaADN.length(),
                        locTGA != -1 ? locTGA : cadenaADN.length()));

        return (minLoc == cadenaADN.length()) ? -1 : minLoc;
    }


    private void calcularCombinacionesGeneticasDemo() {
        JOptionPane.showMessageDialog(this, "Función 'Cálculo de Combinaciones Genéticas' seleccionada.");

        JTextField genesField = new JTextField(5);
        JTextField alelosField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Número de genes:"));
        myPanel.add(genesField);
        myPanel.add(Box.createHorizontalStrut(15)); // Un espacio
        myPanel.add(new JLabel("Número de alelos:"));
        myPanel.add(alelosField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Por favor ingrese el número de genes y alelos", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            try {
                int numeroGenes = Integer.parseInt(genesField.getText());
                int numeroAlelos = Integer.parseInt(alelosField.getText());
                int combinaciones = calcularCombinacionesGeneticas(numeroGenes, numeroAlelos);
                JOptionPane.showMessageDialog(this, "El número de combinaciones genéticas posibles es: " + combinaciones);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese números válidos.");
            }
        }
    }

    private int calcularCombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
        return (int) Math.pow(numeroAlelos, numeroGenes);
    }

    private void gestionarFechasDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Gestión de Fechas' seleccionada.");
    }

    private void buscarEnArchivoDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Búsqueda Binaria en Archivo' seleccionada.");
    }

    private void listarNumerosEnRangoDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Listado de Números en un Rango' seleccionada.");
    }

    private void sumatoriaNumerosNaturalesDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Sumatoria de Números Naturales' seleccionada.");
    }

    private void demoQuicksortDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Demostración de Quicksort' seleccionada.");
    }

    private void ordenarLineasArchivoDemo() {
        // Implementación para leer, ordenar y mostrar líneas de un archivo
        JOptionPane.showMessageDialog(this, "Función 'Ordenar Líneas de un Archivo de Texto' seleccionada.");
    }

    private void encontrarMaximoYPosicionDemo() {
        // Implementación similar a la original, pero usando JOptionPane en lugar de System.out
        JOptionPane.showMessageDialog(this, "Función 'Encontrar el Valor Máximo y su Posición en un Arreglo' seleccionada.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MAIN::new);
    }
}
