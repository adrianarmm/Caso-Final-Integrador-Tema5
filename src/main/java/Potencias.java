public class Potencias {
    public static long potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * potencia(base, exponente - 1);
        }
    }

    public static void main(String[] args) {
        int base = 2;
        int exponente = 3;
        long resultado = potencia(base, exponente);
        System.out.println(base + " elevado a la " + exponente + " es: " + resultado);
    }
}