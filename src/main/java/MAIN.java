import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MAIN extends JFrame {

    public MAIN() {
        super("Software de Análisis Genómico y Organización de Datos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));  // Ajusta la distribución según necesidades

        // Añadir botones para cada función
        JButton btnConteoGenes = new JButton("1. Conteo de Genes");
        JButton btnCalcCombinaciones = new JButton("2. Cálculo de Combinaciones Genéticas");
        JButton btnGestionFechas = new JButton("3. Gestión de Fechas");
        JButton btnBuscarArchivo = new JButton("4. Búsqueda Binaria en Archivo");
        JButton btnListarNumeros = new JButton("5. Listado de Números en un Rango");
        JButton btnSumatoriaNaturales = new JButton("6. Sumatoria de Números Naturales");
        JButton btnDemoQuicksort = new JButton("7. Demostración de Quicksort");
        JButton btnOrdenarLineasArchivo = new JButton("8. Ordenar Líneas de un Archivo de Texto");
        JButton btnEncontrarMaximo = new JButton("9. Encontrar el Valor Máximo y su Posición en un Arreglo");

        // Agregar action listeners a los botones
        btnConteoGenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cadenaADN = JOptionPane.showInputDialog(MainGUI.this, "Ingrese la cadena de ADN:");
                if (cadenaADN != null) {
                    int numeroGenes = contarGenes(cadenaADN);
                    JOptionPane.showMessageDialog(MainGUI.this, "El número de genes en la cadena de ADN es: " + numeroGenes);
                }
            }
        });

        btnCalcCombinaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                        JOptionPane.showMessageDialog(MAIN.this, "El número de combinaciones genéticas posibles es: " + combinaciones);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MAIN.this, "Por favor ingrese un número válido");
                    }
                }
            }
        });

        btnGestionFechas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField fechaField = new JTextField(10);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("Introduzca una fecha (dd/MM/yyyy) o escriba 'fin' para terminar:"));
                myPanel.add(fechaField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "Gestión de Fechas", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    List<LocalDate> fechas = new ArrayList<>();
                    String entrada = fechaField.getText();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    while (!entrada.equalsIgnoreCase("fin")) {
                        try {
                            LocalDate fecha = LocalDate.parse(entrada, formatter);
                            fechas.add(fecha);
                        } catch (DateTimeParseException ex) {
                            JOptionPane.showMessageDialog(MAIN.this, "Formato de fecha inválido. Inténtalo de nuevo.");
                            break;
                        }
                        entrada = JOptionPane.showInputDialog(MAIN.this, "Introduzca una fecha (dd/MM/yyyy) o escriba 'fin' para terminar:");
                    }

                    Collections.sort(fechas);
                    StringBuilder sb = new StringBuilder();
                    for (LocalDate fecha : fechas) {
                        sb.append(fecha.format(formatter)).append("\n");
                    }

                    JOptionPane.showMessageDialog(MAIN.this, "Fechas ordenadas:\n" + sb.toString());
                }
            }
        });

        btnBuscarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = "/Users/adrianareyesmorera/Desktop/CASO5.txt";
                String palabraBuscada = "ADN";

                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    List<String> lineas = new ArrayList<>();
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        lineas.add(linea);
                    }

                    String[] arregloLineas = lineas.toArray(new String[0]);
                    int resultado = Arrays.binarySearch(arregloLineas, palabraBuscada);

                    if (resultado >= 0) {
                        JOptionPane.showMessageDialog(MAIN.this, "La palabra '" + palabraBuscada + "' se encontró en la línea " + (resultado + 1));
                    } else {
                        JOptionPane.showMessageDialog(MAIN.this, "La palabra '" + palabraBuscada + "' no se encontró en el archivo.");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(MAIN.this, "Ocurrió un error al leer el archivo: " + ex.getMessage());
                }
            }
        });

        btnListarNumeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(MAIN.this, "Ingrese el rango de números separados por un espacio (inicio fin):");
                String[] parts = input.split(" ");
                int inicio, fin;
                try {
                    inicio = Integer.parseInt(parts[0]);
                    fin = Integer.parseInt(parts[1]);

                    System.out.print("Listado de números del " + inicio + " al " + fin + ": ");
                    for (int i = inicio; i <= fin; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MAIN.this, "Por favor ingrese un rango de números válido.");
                }
            }
        });

        btnSumatoriaNaturales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(MAIN.this, "Ingrese un número natural:");
                int n;
                try {
                    n = Integer.parseInt(input);
                    if (n < 1) {
                        throw new NumberFormatException();
                    }

                    long sumatoria = sumatoriaDeNumerosNaturales(n);
                    JOptionPane.showMessageDialog(MAIN.this, "La sumatoria de los primeros " + n + " números naturales es: " + sumatoria);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MAIN.this, "Por favor ingrese un número natural válido.");
                }
            }
        });

        btnDemoQuicksort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] arreglo = {10, 7, 8, 9, 1, 5};
                quicksort(arreglo, 0, arreglo.length - 1);
                JOptionPane.showMessageDialog(MAIN.this, "Arreglo ordenado mediante Quicksort: " + Arrays.toString(arreglo));
            }
        });

        btnOrdenarLineasArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = JOptionPane.showInputDialog(MAIN.this, "Ingrese la ruta del archivo:");
                ordenarLineasArchivo(filePath);
            }
        });






