public static int CombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
    // Si el número de genes es menor o igual que 0, no hay combinaciones posibles
    if (numeroGenes <= 0) {
        return 0;
    }

    // Si el número de genes es 1, hay solo una combinación posible
    if (numeroGenes == 1) {
        return numeroAlelos;
    }

    // Se calcula la combinación de genes para el número de genes dado
    return numeroAlelos * CombinacionesGeneticas(numeroGenes - 1, numeroAlelos);
}

public static void main() {
    int numeroGenes = 3;
    int numeroAlelos = 2;
    int combinacionesGeneticas = CombinacionesGeneticas(numeroGenes, numeroAlelos);
    System.out.println("El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);
}