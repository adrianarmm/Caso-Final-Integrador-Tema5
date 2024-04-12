public int ConteodeGenes(String cadenaADN, int posicion) {
    // Si la cadena de ADN es nula o vacía, no hay genes que contar
    if (cadenaADN == null || cadenaADN.isEmpty()) {
        return 0;
    }

    // Si la cadena de ADN no contiene la marca "ATG", no hay genes que contar
    if (!cadenaADN.contains("ATG")) {
        return 0;
    }

    // Si la cadena de ADN contiene la marca "ATG", buscamos la siguiente marca "TGA" o "TAG" para marcar el final del gen
    int finGen = Math.max(cadenaADN.indexOf("TGA", posicion), cadenaADN.indexOf("TAG", posicion));

    // Si no se encuentra ninguna marca "TGA" o "TAG", el gen no tiene final y no se cuenta
    if (finGen == -1) {
        return 0;
    }

    // Si se encuentra una marca "TGA" o "TAG", se cuenta el gen y se continúa buscando el siguiente gen
    return 1 + ConteodeGenes(cadenaADN.substring(finGen), finGen);
}

public void main() {

}
