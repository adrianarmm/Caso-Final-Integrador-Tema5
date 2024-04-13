
public class SumatoriaDeNumerosNaturales {

    public static long sumatoriaDeNumerosNaturales(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n + sumatoriaDeNumerosNaturales(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        long resultado = sumatoriaDeNumerosNaturales(n);
        System.out.println("La sumatoria de los primeros " + n + " números naturales es: " + resultado);
    }
}
