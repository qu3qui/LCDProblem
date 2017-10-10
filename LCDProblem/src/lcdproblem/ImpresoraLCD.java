package lcdproblem;

import static lcdproblem.UtilidadesMatrices.fusionMatrices;
import static lcdproblem.UtilidadesMatrices.imprimirMatriz;
import static lcdproblem.UtilidadesMatrices.llenarMatrizInicial;

/**
 *Clase que implementa los métodos necesarios para la lógica de la pantalla LCD
 *@author jbuitrago
 */
public class ImpresoraLCD {
    static MatrizSolucion[][] matrizSoluciones = new MatrizSolucion[11][11];

    /**
     * Método encargado de leer un enunciado y realizar la lógica para
     * la combinación de la matriz de impresaión y las matrices que la complementan
     * @param enunciado
     * @param espacioDig 
     */
    public void procesarEnunciado(String enunciado ,int espacioDig) {
        int puntoReferencia = 0;

        String[] partesEnunciado = enunciado.split(",");
        String sizeFormatoCadena = partesEnunciado[0];
        String numeroFormatoCadena = partesEnunciado[1];

        int size = Integer.parseInt(sizeFormatoCadena);

        String [][] matrizEspacios = llenarMatrizInicial(2 * size + 3, espacioDig);

        String[][] matrizImpresion = new String[2 * size + 3][(size + 2 + espacioDig) * numeroFormatoCadena.length()];

        for (int i = 0; i < numeroFormatoCadena.length(); i++) {
            int digito = Integer.parseInt(numeroFormatoCadena.substring(i, i + 1));
            String [][] matrizRespuesta = crearMatrizDigito(digito, size);
            matrizImpresion = fusionMatrices(matrizImpresion, matrizRespuesta, puntoReferencia);
            puntoReferencia = puntoReferencia + size + 2;

            if (espacioDig != 0) {
                matrizImpresion = fusionMatrices(matrizImpresion, matrizEspacios, puntoReferencia);
                puntoReferencia = puntoReferencia + espacioDig;
            }
        }
        imprimirMatriz(matrizImpresion);
    }

    /**
     * Método que a partir de un dígito y un tamaño se encarga de encontrar la solución
     * en matriz para dicho dígito.
     * @param digito
     * @param size
     * @return 
     */
    public  String[][] crearMatrizDigito(int digito, int size) {

        String[][] matrizRespuesta;
        if (matrizSoluciones[digito][size] != null) {
            matrizRespuesta = matrizSoluciones[digito][size].getSolucion();
        } else {
            if (size == 1) {
                matrizRespuesta = crearDigitoReferencia(Integer.toString(digito));
            } else {
                matrizRespuesta = transformarDigitoReferencia(digito, size);
            }
        }
        return matrizRespuesta;
    }

    /**
     * Método que utiliza un digito para crear su matriz, la cual servirá de referencia
     * para futuras transformaciones a otros tamaños
     * @param digito
     * @return 
     */
    public String[][] crearDigitoReferencia(String digito) {

        
        String[][] matriz = llenarMatrizInicial(5, 3);
        switch (digito) {
            case "0":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                
                break;
            case "1":
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                break;
            case "2":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
            case "3":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
            case "4":
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                break;
            case "5":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
            case "6":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
            case "7":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                break;
            case "8":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
            case "9":
                matriz[0][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[1][0] = Constantes.SIMBOLO_VERTICAL;
                matriz[1][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[2][1] = Constantes.SIMBOLO_HORIZONTAL;
                matriz[3][2] = Constantes.SIMBOLO_VERTICAL;
                matriz[4][1] = Constantes.SIMBOLO_HORIZONTAL;
                break;
        }
        return matriz;
    }
    /**
     * Método que utiliza la referencia de un dígito y su tamaño para transformar
     * y crear una nueva matriz que sirve como representación del digito en una escala dada
     * @param digito
     * @param size
     * @return 
     */
    public String[][] transformarDigitoReferencia(int digito, int size) {
        ImpresoraLCD pr = new ImpresoraLCD();
        if (matrizSoluciones[digito][0] == null) {
            MatrizSolucion matrizSolucion = new MatrizSolucion();
            matrizSolucion.setSolucion(pr.crearDigitoReferencia(Integer.toString(digito)));
            matrizSoluciones[digito][size] = matrizSolucion;
        }
        String[][] matrizReferencia = matrizSoluciones[digito][size].getSolucion();
        String[][] matrizResultado = llenarMatrizInicial(2 * size + 3, size + 2);
        if (matrizReferencia[0][1].equals(Constantes.SIMBOLO_HORIZONTAL)) {
            for (int i = 1; i < size + 1; i++) {
                matrizResultado[0][i] = Constantes.SIMBOLO_HORIZONTAL;
            }
        }
        if (matrizReferencia[1][0].equals(Constantes.SIMBOLO_VERTICAL)) {
            for (int i = 1; i < size + 1; i++) {
                matrizResultado[i][0] = Constantes.SIMBOLO_VERTICAL;
            }
        }
        if (matrizReferencia[1][2].equals(Constantes.SIMBOLO_VERTICAL)) {
            for (int i = 1; i < size + 1; i++) {
                matrizResultado[i][matrizResultado[0].length - 1] = Constantes.SIMBOLO_VERTICAL;
            }
        }
        if (matrizReferencia[2][1].equals(Constantes.SIMBOLO_HORIZONTAL)) {
            for (int i = 1; i < size + 1; i++) {
                matrizResultado[matrizResultado.length / 2][i] = Constantes.SIMBOLO_HORIZONTAL;
            }
        }
        if (matrizReferencia[3][0].equals(Constantes.SIMBOLO_VERTICAL)) {
            for (int i = matrizResultado.length / 2 + 1; i < size + matrizResultado.length / 2 + 1; i++) {
                matrizResultado[i][0] = Constantes.SIMBOLO_VERTICAL;

            }
        }
        if (matrizReferencia[3][2].equals(Constantes.SIMBOLO_VERTICAL)) {
            for (int i = matrizResultado.length / 2 + 1; i < size + matrizResultado.length / 2 + 1; i++) {
                matrizResultado[i][matrizResultado[0].length - 1] = Constantes.SIMBOLO_VERTICAL;

            }
        }
        if (matrizReferencia[4][1].equals(Constantes.SIMBOLO_HORIZONTAL)) {
            for (int i = 1; i < size + 1; i++) {
                matrizResultado[matrizResultado.length - 1][i] = Constantes.SIMBOLO_HORIZONTAL;
            }
        }
        matrizSoluciones[digito][size].setSolucion(matrizResultado);
        return matrizResultado;
    }
}
