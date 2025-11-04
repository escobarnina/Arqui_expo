/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronsingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author Asus
 */

public class VentanaVerCarrito2 extends JFrame {

    private JTextArea areaProductos;

    public VentanaVerCarrito2() {
        setTitle("Cliente 2: Carrito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Solo cierra esta ventana
        setSize(300, 300);
        setLocation(600, 100); // La ponemos en otro lugar de la pantalla
        setLayout(new BorderLayout(10, 10));

        areaProductos = new JTextArea();
        areaProductos.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaProductos);

        JButton btnActualizar = new JButton("Actualizar Carrito");

        btnActualizar.addActionListener((ActionEvent e) -> {
            actualizarListaProductos();
        });

        add(btnActualizar, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Cargamos la lista al abrir
        actualizarListaProductos();
    }

    private void actualizarListaProductos() {
        // 1. Obtenemos la instancia ÚNICA
        SesionUsuario sesion = SesionUsuario.getInstance();
        
        // 2. Leemos sus datos
        List<String> productos = sesion.getProductosEnCarrito();
        
        StringBuilder sb = new StringBuilder("--- Productos en Carrito ---\n");
        if (productos.isEmpty()) {
            sb.append("(Carrito vacío)");
        } else {
            for (String p : productos) {
                sb.append("- ").append(p).append("\n");
            }
        }
        areaProductos.setText(sb.toString());
    }
}