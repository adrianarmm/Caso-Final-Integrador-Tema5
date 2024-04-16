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
                        countComponents();
                        break;
                    // Agrega casos para las demás opciones
                    case "10":
                        System.exit(0);
                        break;
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
        // Por ejemplo, aquí puedes usar JOptionPane para mostrar y recoger información
        String cadenaADN = JOptionPane.showInputDialog(this, "Ingrese la cadena de ADN:");
        // Llama a la lógica de tu aplicación
        int numeroGenes = contarGenes(cadenaADN);
        JOptionPane.showMessageDialog(this, "El número de genes en la cadena de ADN es: " + numeroGenes);
    }

    // Aquí deberías implementar los métodos de tu aplicación, por ejemplo:
    private int contarGenes(String cadenaADN) {
        // Tu lógica de contar genes aquí...
        return 0; // Esto es solo un placeholder
    }

    // Implementa los demás métodos de forma similar a contarGenesDemo()

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new MAIN().setVisible(true);
        });
    }
}







