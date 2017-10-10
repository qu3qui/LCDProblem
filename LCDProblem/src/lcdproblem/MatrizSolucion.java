package lcdproblem;

/**
 * Clase compuesta por una matriz de String como atributo para almacenar
 * de manera mas intuitiva las soluciones en representacion matricial de los 
 * digitos
 * @author jbuitrago
 */
public class MatrizSolucion {
    
    private String[][] solucion;

    public String[][] getSolucion() {
        return solucion;
    }
    public void setSolucion(String[][] solucion) {
        this.solucion = solucion;
    }   
}
