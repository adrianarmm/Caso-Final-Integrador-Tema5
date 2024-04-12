public class Maximo {
    public static int maximo(int[] datos, int indice) {
        if (indice == 0) {
            return datos[0];
        } else {
            int maximoAnterior = maximo(datos, indice - 1);
            return Math.max(datos[indice], maximoAnterior);
        }
    }
}