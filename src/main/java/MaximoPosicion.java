public class MaximoPosicion {
    public static int maximo(int[] datos, int indice, int[] posiciones) {
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
