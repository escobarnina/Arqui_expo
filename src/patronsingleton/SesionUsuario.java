/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
package patronsingleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta es la clase Singleton.
 * Representa la sesión única del usuario, que contiene el carrito de compras.
 * Sigue el diagrama: constructor privado, instancia estática y método getInstance().
 */
public class SesionUsuario {

    // El atributo estático y privado que almacena la única instancia.
    // Se usa 'volatile' para asegurar la visibilidad en entornos multihilo.
    private static volatile SesionUsuario instance;

    // Atributos propios de nuestro ejemplo: el carrito de compras.
    private List<String> productosEnCarrito;

    /**
     * El constructor es PRIVADO.
     * Esto impide que se creen instancias con 'new' desde fuera de la clase.
     */
    private SesionUsuario() {
        // Inicializamos los recursos de la instancia
        productosEnCarrito = new ArrayList<>();
        
        // Mensaje para demostrar que solo se llama UNA VEZ.
        System.out.println(">>> Instancia de SesionUsuario CREADA (Constructor llamado)");
    }

    /**
     * El método estático público para obtener la instancia.
     * Este es el corazón del patrón y coincide con tu diagrama.
     */
    public static SesionUsuario getInstance() {
        // ---------------------------------------------------------------
        // ESTA LÓGICA COINCIDE CON TU DIAGRAMA:
        //
        // if (instance == null) {
        if (instance == null) {
            
            // // Nota: ... colocar un bloqueo de hilo aquí.
            // Usamos 'synchronized' para el bloqueo de hilo.
            synchronized (SesionUsuario.class) {
                
                // Volvemos a comprobar por si otro hilo la creó mientras esperábamos el bloqueo
                if (instance == null) {
                    
                    // // instance = new Singleton()
                    instance = new SesionUsuario();
                }
            }
        }
        // return instance
        return instance;
        // ---------------------------------------------------------------
    }

    // --- Métodos "de negocio" de nuestro ejemplo ---

    public void agregarProducto(String producto) {
        productosEnCarrito.add(producto);
        System.out.println("'" + producto + "' añadido. Total: " + productosEnCarrito.size());
    }

    public List<String> getProductosEnCarrito() {
        return productosEnCarrito;
    }
}