import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
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

        setNimbusLookAndFeel();


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

        Color[] colors = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                Color.BLUE, new Color(75, 0, 130), // Índigo
                new Color(238, 130, 238), // Violeta
                Color.PINK, Color.LIGHT_GRAY
        };

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.setBackground(colors[i]);
            button.setOpaque(true); // Para Nimbus y otros look and feel que no muestran el color de fondo
            button.setBorderPainted(false); // También para Nimbus y similares
            button.addActionListener(this::actionPerformed);
            panel.add(button);
        }


        add(panel);
        JButton btnJuego = new JButton("Juego Tic-Tac-Toe");
        btnJuego.addActionListener(e -> abrirJuegoTicTacToe());
        panel.add(btnJuego);

        JButton btnAsistente = new JButton("Asistente Virtual");
        btnAsistente.addActionListener(e -> abrirAsistenteVirtual());
        panel.add(btnAsistente);

        JButton btnSonido = new JButton("Reproducir Sonido");
        btnSonido.addActionListener(e -> reproducirSonido("/Users/adrianareyesmorera/Desktop/menu-button-pack-190040.wav"));
        panel.add(btnSonido);


        setVisible(true);
    }

    private void abrirJuegoTicTacToe() {
        // Lógica para abrir tu juego Tic-Tac-Toe
        JFrame juegoFrame = new JFrame("Tic-Tac-Toe");
        juegoFrame.setSize(300, 300);
        juegoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        juegoFrame.setLocationRelativeTo(null);
        juegoFrame.setVisible(true);
    }

    private void reproducirSonido(String rutaSonido) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(rutaSonido)));
            clip.start();
        } catch (Exception e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }

    private void abrirAsistenteVirtual() {
        String pregunta = JOptionPane.showInputDialog(this, "¿Cómo puedo ayudarte?");
        // Lógica simple para responder a la pregunta. Amplía según sea necesario.
        JOptionPane.showMessageDialog(this, "Todavía estoy aprendiendo. No conozco la respuesta.");
    }


    private void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println("No se pudo establecer Nimbus LookAndFeel");
        }
    }


    private void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "1. Conteo de Genes":
                ConteoDeGenes();
                break;
            case "2. Cálculo de Combinaciones Genéticas":
                CombinacionesGeneticas();
                break;
            case "3. Gestión de Fechas":
                GestionFechas();
                break;
            case "4. Búsqueda Binaria en Archivo":
                BusquedaBinaria();
                break;
            case "5. Listado de Números en un Rango":
                Listadodenumerosenunrango();
                break;
            case "6. Sumatoria de Números Naturales":
                SumatoriaDeNumerosNaturales();
                break;
            case "7. Demostración de Quicksort":
                OptimizedQuicksort();
                break;
            case "8. Ordenar Líneas de un Archivo de Texto":
                OrdenarLineas();
                break;
            case "9. Encontrar el Valor Máximo y su Posición en un Arreglo":
                MaximoPosicion();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Opción no válida.");
        }
    }

    private void ConteoDeGenes() {
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


    private void CombinacionesGeneticas() {
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

    private void GestionFechas() {
        List<LocalDate> fechas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String entrada = JOptionPane.showInputDialog(this, "Introduzca una fecha (dd/MM/yyyy) o escriba 'fin' para terminar:");
            if (entrada == null || entrada.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                LocalDate fecha = LocalDate.parse(entrada, formatter);
                fechas.add(fecha);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Inténtalo de nuevo.");
            }
        }
        Collections.sort(fechas);
        StringBuilder sb = new StringBuilder("Fechas ordenadas:\n");
        for (LocalDate fecha : fechas) {
            sb.append(fecha.format(formatter)).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }


    private void BusquedaBinaria() {
        String filePath = JOptionPane.showInputDialog(this, "Ingrese la ruta del archivo:");
        String palabraBuscada = JOptionPane.showInputDialog(this, "Ingrese la palabra a buscar:");

        try {
            List<String> lineas = Files.readAllLines(Paths.get(filePath));
            Collections.sort(lineas); // Asegura que las líneas estén ordenadas para la búsqueda binaria
            int resultado = Collections.binarySearch(lineas, palabraBuscada);

            if (resultado >= 0) {
                JOptionPane.showMessageDialog(this, "La palabra '" + palabraBuscada + "' se encontró en la línea " + (resultado + 1));
            } else {
                JOptionPane.showMessageDialog(this, "La palabra '" + palabraBuscada + "' no se encontró en el archivo.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        }
    }


    private void Listadodenumerosenunrango() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el rango de números separados por un espacio (inicio fin):");
        if (input != null && !input.trim().isEmpty()) {
            String[] parts = input.split(" ");
            if (parts.length == 2) {
                try {
                    int inicio = Integer.parseInt(parts[0]);
                    int fin = Integer.parseInt(parts[1]);
                    StringBuilder numeros = new StringBuilder();
                    for (int i = inicio; i <= fin; i++) {
                        numeros.append(i).append(" ");
                    }
                    JOptionPane.showMessageDialog(this, "Números en el rango: " + numeros);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduzca números válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Formato de rango no válido. Por favor, introduzca dos números separados por un espacio.");
            }
        }
    }

    private void SumatoriaDeNumerosNaturales() {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para calcular la sumatoria de números naturales hasta él:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int n = Integer.parseInt(input);
                if (n < 1) {
                    JOptionPane.showMessageDialog(this, "Por favor, introduzca un número mayor o igual a 1.");
                } else {
                    long sumatoria = (long) n * (n + 1) / 2;
                    JOptionPane.showMessageDialog(this, "La sumatoria de los primeros " + n + " números naturales es: " + sumatoria);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca un número válido.");
            }
        }
    }

    private void OptimizedQuicksort() {
        int[] arreglo = {10, 7, 8, 9, 1, 5};
        JOptionPane.showMessageDialog(this, "Arreglo original: " + Arrays.toString(arreglo));
        quicksort(arreglo, 0, arreglo.length - 1);
        JOptionPane.showMessageDialog(this, "Arreglo ordenado: " + Arrays.toString(arreglo));
    }

    private void quicksort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int indiceParticion = partition(arreglo, inicio, fin);
            quicksort(arreglo, inicio, indiceParticion - 1);
            quicksort(arreglo, indiceParticion + 1, fin);
        }
    }

    private int partition(int[] arreglo, int inicio, int fin) {
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


    private void OrdenarLineas() {
        String filePath = JOptionPane.showInputDialog(this, "Ingrese la ruta del archivo:");
        if (filePath != null && !filePath.trim().isEmpty()) {
            try {
                List<String> lineas = Files.readAllLines(Paths.get(filePath));
                Collections.sort(lineas);
                JOptionPane.showMessageDialog(this, "Líneas ordenadas del archivo:\n" + String.join("\n", lineas));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage());
            }
        }
    }


    private void MaximoPosicion() {
        // Solicita al usuario ingresar una serie de números separados por comas
        String input = JOptionPane.showInputDialog(this, "Ingrese una serie de números separados por comas:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                // Convierte la entrada del usuario en un arreglo de números
                String[] partes = input.split(",");
                int[] numeros = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    numeros[i] = Integer.parseInt(partes[i].trim());
                }

                // Encuentra el valor máximo y su posición
                int[] resultado = encontrarMaximoYPosicion(numeros);
                int maximo = resultado[0];
                int posicion = resultado[1];

                // Muestra el resultado
                JOptionPane.showMessageDialog(this, "El valor máximo es: " + maximo + ", encontrado en la posición: " + posicion);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, introduzca una serie válida de números.");
            }
        }
    }

    /**
     * Encuentra el valor máximo en el arreglo y su posición.
     * @param numeros El arreglo de números a analizar.
     * @return Un arreglo donde la primera posición es el valor máximo y la segunda su posición.
     */
    private int[] encontrarMaximoYPosicion(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return new int[]{0, -1}; // Retorna un valor por defecto si el arreglo está vacío
        }
        int maximo = numeros[0];
        int posicion = 0;
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maximo) {
                maximo = numeros[i];
                posicion = i;
            }
        }
        return new int[]{maximo, posicion};
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MAIN::new);
    }
}
