public int calcularCombinacionesGeneticas(int numeroGenes, int numeroAlelos) {
    // Si el número de genes es menor o igual que 0, no hay combinaciones posibles
    if (numeroGenes <= 0) {
        return 0;
    }

    // Si el número de genes es 1, hay solo una combinación posible
    if (numeroGenes == 1) {
        return numeroAlelos;
    }

    // Se calcula la combinación de genes para el número de genes dado
    return numeroAlelos * calcularCombinacionesGeneticas(numeroGenes - 1, numeroAlelos);
}

public void main() {
}