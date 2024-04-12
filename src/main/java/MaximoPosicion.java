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

    public static void main(String[] args) {
        int[] datos = { 1, 2, 3, 4, 5 };
        int[] posiciones = { 0 };
        int indice = datos.length - 1;
        int resultado = maximo(datos, indice, posiciones);
        System.out.println("El número máximo en el arreglo es: " + resultado);
        System.out.println("La posición del número máximo en el arreglo es: " + posiciones[0]);
    }
}
