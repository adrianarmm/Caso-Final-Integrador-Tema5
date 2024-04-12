public class MAIN {

    public static void main(String[] args) {
        System.out.println("Conteo de Genes");
        String cadenaADN = "ATGCGTAGATGCGATAG";
        int posicion = 0;
        int numeroGenes = contarGenes(cadenaADN, posicion);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);

   System.out.println("Combinaciones Genéticas");
        int numeroGenes = 2;
        int numeroAlelos = 4;
        int combinacionesGeneticas = CombinacionesGeneticas(numeroGenes, numeroAlelos);
        System.out.println("El número de combinaciones genéticas posibles es: " + combinacionesGeneticas);
    }
    public static int contarGenes(String cadenaADN, int posicion) {
        if (cadenaADN == null || cadenaADN.isEmpty()) {
            return 0;
        }
    if (!cadenaADN.contains("ATG")) {
            return 0;
        }
        int finGen = Math.max(cadenaADN.indexOf("TGA", posicion), cadenaADN.indexOf("TAG", posicion));

}
