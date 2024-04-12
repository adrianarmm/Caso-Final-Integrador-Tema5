public class Listadodenumerosenunrango {

        public static void listar(int inicio, int fin) {
            if (inicio <= fin) {
                System.out.print(inicio + " ");
                listar(inicio + 1, fin);
            }
        }

        public static void main(String[] args) {
            int inicio = 1;
            int fin = 10;
            System.out.print("Los números en el rango de " + inicio + " a " + fin + " son: ");
            listar(inicio, fin);
        }
    }

