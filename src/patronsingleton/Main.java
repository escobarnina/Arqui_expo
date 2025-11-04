/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronsingleton;
import javax.swing.SwingUtilities;

/**
 *
 * @author Asus
 */


public class Main {

    public static void main(String[] args) {
        // Inicia la GUI en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            VentanaTienda tienda = new VentanaTienda();
            tienda.setVisible(true);
        });
    }
}