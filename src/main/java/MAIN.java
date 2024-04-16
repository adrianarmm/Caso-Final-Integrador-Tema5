import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MAIN extends JFrame {
    public MAIN() {

        setTitle("Software de Análisis Genómico y Organización de Datos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem menuItem;

        // Listener genérico para los items del menú
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                switch (choice) {
                    case "1":
                        contarGenesDemo();
                        break;
                    case "2":
                        CombinacionesGeneticas();
                        break;
                    case "3":
                        BusquedaBinaria();
                        break;
                    case "4":
                        MaximoPosicion();
                        break;
                    case "5":
                        Maximo();
                        break;
                    case "6":
                        OptimizedQuickSort();
                        break;
                    case "7":
                        OrdenarLineas();
                        break;
                    case "8":
                        Potencias();
                        break;
                    case "9":
                        SumatoriadeNumerosNaturales();
                        break;
                    case "10":
                        Listadodenumerosenunrango();
                        break;
                        case "11":
                            System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }
            }
        };

        // Agregar items al menú
        for (int i = 1; i <= 10; i++) {
            menuItem = new JMenuItem("Opción " + i);
            menuItem.addActionListener(menuListener);
            menuItem.setActionCommand(String.valueOf(i));
            menu.add(menuItem);
        }
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void contarGenesDemo() {
        String cadenaADN = JOptionPane.showInputDialog(this, "Ingrese la cadena de ADN:");
        int numeroGenes = contarGenes(cadenaADN);
        JOptionPane.showMessageDialog(this, "El número de genes en la cadena de ADN es: " + numeroGenes);
    }

    public void CombinacionesGeneticas() {
        JTextField genesField = new JTextField(5);
        JTextField alelosField = new JTextField(5);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Número de genes:"));
        myPanel.add(genesField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Número de alelos:"));
        myPanel.add(alelosField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                 "Por favor ingrese el número de genes y alelos", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int numeroGenes = Integer.parseInt(genesField.getText());
            int numeroAlelos = Integer.parseInt(alelosField.getText());
            int combinacionesGeneticas = CombinacionesGeneticas(numeroGenes, numeroAlelos);
            JOptionPane.showMessageDialog(this, "El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido");
        }

    }

    public void BusquedaBinaria() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void MaximoPosicion() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void Maximo() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void OptimizedQuickSort() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void OrdenarLineas() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void Potencias() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void SumatoriadeNumerosNaturales() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }

    public void Listadodenumerosenunrango() {
        int count = getContentPane().getComponentCount();
        JOptionPane.showMessageDialog(this, "El número de componentes en el contenedor es: " + count);
    }





    private int contarGenes(String cadenaADN) {
        // Tu lógica de contar genes aquí...


        return 0; // Esto es solo un placeholder
    }

    public int CombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
       if (numeroGenes <= 0) {
            return 0;
        }

        if (numeroGenes == 1) {
            return numeroAlelos;
        }

        return numeroAlelos * CombinacionesGeneticas(numeroGenes - 1, numeroAlelos);

    }

    private int BusquedaBinaria(int[] datos, int dato) {
        // Tu lógica de búsqueda binaria aquí...

        return 0; // Esto es solo un placeholder
    }

    private int MaximoPosicion(int[] datos, int indice, int[] posiciones) {
        // Tu lógica de búsqueda del máximo y su posición aquí...

        return 0; // Esto es solo un placeholder
    }

    private int Maximo(int[] datos, int indice) {
        // Tu lógica de búsqueda del máximo aquí...

        return 0; // Esto es solo un placeholder
    }

    private int OptimizedQuickSort(int[] datos, int inicio, int fin) {
        // Tu lógica de ordenamiento QuickSort aquí...

        return 0; // Esto es solo un placeholder
    }

    private int OrdenarLineas(String[] lineas) {
        // Tu lógica de ordenamiento de líneas aquí...

        return 0; // Esto es solo un placeholder
    }

    private int Potencias(int base, int exponente) {
        // Tu lógica de cálculo de potencias aquí...

        return 0; // Esto es solo un placeholder
    }

    private int SumatoriadeNumerosNaturales(int n) {
        // Tu lógica de cálculo de sumatoria de números naturales aquí...

        return 0; // Esto es solo un placeholder
    }

    private int Listadodenumerosenunrango(int inicio, int fin) {
        // Tu lógica de listado de números en un rango aquí...

        return 0; // Esto es solo un placeholder
    }


    // Implementa los demás métodos de forma similar a contarGenesDemo()

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MAIN().setVisible(true);
        });
    }
}







