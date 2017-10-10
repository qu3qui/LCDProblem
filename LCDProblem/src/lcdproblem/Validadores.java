package lcdproblem;

/**
 *Clase que contiene las validaciones necesarias en la aplicación
 * @author Sebastian
 */
public class Validadores {
    /**
     * Método que se encarga de validar si se puede convertir una cadena 
     * a un número entero
     * @param cadena
     * @return 
     */
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    /**
     * Método que utiliza la validacion isNumeric y también valida otras
     * caracteristicas de un cadena de texto
     * @param comando
     * @return 
     */
    public static int validadorNumerico(String comando) {
        int espacioDig;
        if (Validadores.isNumeric(comando)) {
            espacioDig = Integer.parseInt(comando);
            if (espacioDig < 0 || espacioDig > 5) {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }
        } else {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no es un entero");
        }
        return espacioDig;
    }
}
