public class Sumatoriadenúmerosnaturales {
        public static long sumatoria(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return n + sumatoria(n - 1);
            }
        }
    }

