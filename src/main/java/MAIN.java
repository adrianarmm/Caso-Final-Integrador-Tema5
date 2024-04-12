public class MAIN {

    public static void main(String[] args) {
        System.out.println("Conteo de Genes");
        String cadenaADN = "ATGCGTAGATGCGATAG";
        int posicion = 0;
        int numeroGenes = contarGenes(cadenaADN, posicion);
        System.out.println("El número de genes en la cadena de ADN es: " + numeroGenes);

    }


}
