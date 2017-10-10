/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static lcdproblem.Validadores.validadorNumerico;

/**
 * Clase que inicia la ejecución de la aplicación y se encarga del manejo de la 
 * entrada de datos
 * @author jbuitrago
 */
public class LCDProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ImpresoraLCD impresoraLCD = new ImpresoraLCD();
        List<String> listaComando = new ArrayList<>();
        String comando;
        Scanner lector = new Scanner(System.in);
        System.out.print("Espacio entre Digitos (0 a 5): ");
        comando = lector.next();
        try {
            int espacioDig = validadorNumerico(comando);
            do {
                System.out.print("Entrada: ");
                comando = lector.next();
                if (!comando.equalsIgnoreCase(Constantes.CADENA_FINAL)) {
                    listaComando.add(comando);
                }
            } while (!comando.equalsIgnoreCase(Constantes.CADENA_FINAL));

            for (String enunciado : listaComando) {
                impresoraLCD.procesarEnunciado(enunciado, espacioDig);
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
