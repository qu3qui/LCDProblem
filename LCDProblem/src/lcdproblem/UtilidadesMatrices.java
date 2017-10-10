package lcdproblem;

/**
 * Clase que provee un conjunto de funciones que facilitan el uso de matrices
 * en la solución
 * @author Sebastian
 */
public class UtilidadesMatrices {
    
    /**
     * Método que recibe una matriz para posteriormente imprimirla por consola
     * @param matriz 
     */
    public static void imprimirMatriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    /**
     * Método que crea una matriz de String a partir de parámteros y la inicializa 
     * con cadenas de espacios en cada posición
     * @param numeroFilas
     * @param numeroColumnas
     * @return 
     */
    public static String[][] llenarMatrizInicial(int numeroFilas , int numeroColumnas) {
        String[][] matrizInicial = new String [numeroFilas] [numeroColumnas];
        for (int i = 0; i < matrizInicial.length; i++) {
            for (int j = 0; j < matrizInicial[0].length; j++) {
                matrizInicial[i][j] = " ";
            }
        }
        return matrizInicial;
    }
    /**
     * Método que se encarga de añadir una matriz desde un punto de refrencia
     * a otra matriz que la contiene, esta matriz contenedora es la matriz de impresión
     * @param matrizImpresion
     * @param matrizAñadir
     * @param puntoReferencia
     * @return 
     */
    public static String[][] fusionMatrices(String[][] matrizImpresion, String[][] matrizAñadir, int puntoReferencia) {
        for (int i = 0; i < matrizAñadir.length; i++) {
            for (int j = 0; j < matrizAñadir[0].length; j++) {
                matrizImpresion[i][j + puntoReferencia] = matrizAñadir[i][j];
            }
        }
        return matrizImpresion;
    }
    
}
