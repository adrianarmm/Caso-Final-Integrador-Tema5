public class Maximo {
    public static int maximo(int[] datos, int indice) {
        if (indice == 0) {
            return datos[0];
        } else {
            int maximoAnterior = maximo(datos, indice - 1);
            return Math.max(datos[indice], maximoAnterior);
        }
    }

    public static void main(String[] args) {
        int[] datos = { 1, 2, 3, 4, 5 };
        int indice = datos.length - 1;
        int resultado = maximo(datos, indice);
        System.out.println("El número máximo en el arreglo es: " + resultado);
    }
}