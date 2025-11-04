/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronsingleton;

/**
 *
 * @author Asus
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Cliente 1: La ventana de la tienda.
 * Puede añadir productos al carrito (la instancia Singleton).
 */
public class VentanaTienda extends JFrame {

    public VentanaTienda() {
        setTitle("Cliente 1: Tienda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnAddManzana = new JButton("Añadir Manzana");
        JButton btnAddPan = new JButton("Añadir Pan");
//        JButton btnAddJugo = new JButton("Añadir Jugo");
        JButton btnVerCarrito = new JButton("Ver Carrito");

        // Acción para añadir Manzana
        btnAddManzana.addActionListener((ActionEvent e) -> {
            // 1. Obtenemos la instancia ÚNICA
            SesionUsuario sesion = SesionUsuario.getInstance();
            // 2. Usamos la instancia
            sesion.agregarProducto("Manzana");
        });

        // Acción para añadir Pan
        btnAddPan.addActionListener((ActionEvent e) -> {
            // 1. Obtenemos la instancia ÚNICA
            SesionUsuario sesion = SesionUsuario.getInstance();
            // 2. Usamos la instancia
            sesion.agregarProducto("Pan");
        });
        
        // Acción para añadir Jugo
//        btnAddJugo.addActionListener((ActionEvent e) -> {
//            // 1. Obtenemos la instancia ÚNICA
//            SesionUsuario sesion = SesionUsuario.getInstance();
//            // 2. Usamos la instancia
//            sesion.agregarProducto("Jugo");
//        });

        // Acción para abrir la otra ventana
        btnVerCarrito.addActionListener((ActionEvent e) -> {
            VentanaVerCarrito2 ventanaCarrito = new VentanaVerCarrito2();
            ventanaCarrito.setVisible(true);
        });

        add(btnAddManzana);
        add(btnAddPan);
//        add(btnAddJugo);
        add(btnVerCarrito);
    }
}
