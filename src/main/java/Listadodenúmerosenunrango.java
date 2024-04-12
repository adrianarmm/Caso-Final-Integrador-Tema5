public class Listadodenúmerosenunrango {

        public static void listar(int inicio, int fin) {
            if (inicio <= fin) {
                System.out.print(inicio + " ");
                listar(inicio + 1, fin);
            }
        }
    }

