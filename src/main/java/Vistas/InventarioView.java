/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author nebra
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.ProductoController;
import Controller.InventarioController;
import Controller.MovimientoInventarioController;
import Model.Inventario;
import Model.MovimientoInventario;
import Model.Producto;


public class InventarioView extends JFrame {
    private JTextField productoCodigoField;
    private JTextField productoNombreField;
    private JTextField cantidadActualField;
    private JTextField cantidadModificarField;
    private JButton buscarProductoButton;
    private JButton añadirButton;
    private JButton quitarButton;
    private JButton eliminarButton;
    private JTextField usuarioField;
    private JTextField motivoField;

    public InventarioView() {
        setTitle("Gestión de Inventario La Torre");
        setSize(700, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Panel de Fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/main/java/img/imgFondo.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 700, 600);
        add(backgroundPanel);

        // Título centrado
        JLabel tituloLabel = new JLabel("Gestión de Inventario La Torre", SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBackground(new Color(0, 0, 0, 150)); // Negro semitransparente
        tituloLabel.setOpaque(true);
        tituloLabel.setBounds(250, 0, 200, 50); // Ancho completo, altura ajustada
        backgroundPanel.add(tituloLabel);
        int labelX = 50;
        int labelWidth = 200;
        int fieldX = 250;
        int fieldWidth = 400;
        int yGap = 60;

        // Campos y Botones
        JLabel productoCodigoLabel = new JLabel("Código del Producto:");
        productoCodigoLabel.setForeground(Color.WHITE);
        productoCodigoLabel.setBackground(new Color(0, 0, 0, 150));
        productoCodigoLabel.setOpaque(true);
        productoCodigoLabel.setBounds(labelX, 70, 150, 25);
        backgroundPanel.add(productoCodigoLabel);

        productoCodigoField = new JTextField(20);
        productoCodigoField.setForeground(Color.BLACK);
        productoCodigoField.setBounds(fieldX, 70, fieldWidth, 25);
        backgroundPanel.add(productoCodigoField);

        buscarProductoButton = new JButton("Buscar Producto");
        buscarProductoButton.setForeground(Color.WHITE);
        buscarProductoButton.setBackground(new Color(100, 100, 100, 150));
        buscarProductoButton.setOpaque(true);
        buscarProductoButton.setBorderPainted(false);
        buscarProductoButton.setBounds(250, 70 + yGap, 150, 40);
        backgroundPanel.add(buscarProductoButton);

        JLabel productoNombreLabel = new JLabel("Nombre del Producto:");
        productoNombreLabel.setForeground(Color.WHITE);
        productoNombreLabel.setBackground(new Color(0, 0, 0, 150));
        productoNombreLabel.setOpaque(true);
        productoNombreLabel.setBounds(labelX, 70 + 2 * yGap, 150, 25);
        backgroundPanel.add(productoNombreLabel);

        productoNombreField = new JTextField(20);
        productoNombreField.setForeground(Color.BLACK);
        productoNombreField.setBounds(fieldX, 70 + 2 * yGap, fieldWidth, 25);
        productoNombreField.setEditable(false);
        backgroundPanel.add(productoNombreField);

        JLabel cantidadActualLabel = new JLabel("Cantidad Actual:");
        cantidadActualLabel.setForeground(Color.WHITE);
        cantidadActualLabel.setBackground(new Color(0, 0, 0, 150));
        cantidadActualLabel.setOpaque(true);
        cantidadActualLabel.setBounds(labelX, 70 + 3 * yGap, 150, 25);
        backgroundPanel.add(cantidadActualLabel);

        cantidadActualField = new JTextField(20);
        cantidadActualField.setForeground(Color.BLACK);
        cantidadActualField.setBounds(fieldX, 70 + 3 * yGap, fieldWidth, 25);
        cantidadActualField.setEditable(false);
        backgroundPanel.add(cantidadActualField);

                JLabel cantidadModificarLabel = new JLabel("Cantidad a Modificar:");
        cantidadModificarLabel.setForeground(Color.WHITE);
        cantidadModificarLabel.setBackground(new Color(0, 0, 0, 150));
        cantidadModificarLabel.setOpaque(true);
        cantidadModificarLabel.setBounds(labelX, 70 + 4 * yGap, 150, 25);
        backgroundPanel.add(cantidadModificarLabel);

        cantidadModificarField = new JTextField(20);
        cantidadModificarField.setForeground(Color.BLACK);
        cantidadModificarField.setBounds(fieldX, 70 + 4 * yGap, fieldWidth, 25);
        backgroundPanel.add(cantidadModificarField);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setForeground(Color.WHITE);
        usuarioLabel.setBackground(new Color(0, 0, 0, 150));
        usuarioLabel.setOpaque(true);
        usuarioLabel.setBounds(labelX, 70 + 5 * yGap, 150, 25);
        backgroundPanel.add(usuarioLabel);

        usuarioField = new JTextField(20);
        usuarioField.setForeground(Color.BLACK);
        usuarioField.setBounds(fieldX, 70 + 5 * yGap, fieldWidth, 25);
        backgroundPanel.add(usuarioField);

        JLabel motivoLabel = new JLabel("Motivo:");
        motivoLabel.setForeground(Color.WHITE);
        motivoLabel.setBackground(new Color(0, 0, 0, 150));
        motivoLabel.setOpaque(true);
        motivoLabel.setBounds(labelX, 70 + 6 * yGap, 150, 25);
        backgroundPanel.add(motivoLabel);

        motivoField = new JTextField(20);
        motivoField.setForeground(Color.BLACK);
        motivoField.setBounds(fieldX, 70 + 6 * yGap, fieldWidth, 25);
        backgroundPanel.add(motivoField);
        
        añadirButton = new JButton("Añadir Existencias");
        añadirButton.setForeground(Color.WHITE);
        añadirButton.setBackground(new Color(100, 100, 100, 150));
        añadirButton.setOpaque(true);
        añadirButton.setBorderPainted(false);
        añadirButton.setBounds(100, 70 + 7 * yGap, 150, 40);
        backgroundPanel.add(añadirButton);

        quitarButton = new JButton("Quitar Existencias");
        quitarButton.setForeground(Color.WHITE);
        quitarButton.setBackground(new Color(100, 100, 100, 150));
        quitarButton.setOpaque(true);
        quitarButton.setBorderPainted(false);
        quitarButton.setBounds(270, 70 + 7 * yGap, 150, 40);
        backgroundPanel.add(quitarButton);

        eliminarButton = new JButton("Eliminar Producto");
        eliminarButton.setForeground(Color.WHITE);
        eliminarButton.setBackground(new Color(100, 100, 100, 150));
        eliminarButton.setOpaque(true);
        eliminarButton.setBorderPainted(false);
        eliminarButton.setBounds(440, 70 + 7 * yGap, 150, 40);
        backgroundPanel.add(eliminarButton);
        
        JButton backButton = new JButton("Atrás");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(100, 100, 100, 150));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBounds(270, 70 + 8 * yGap, 150, 40);
        backgroundPanel.add(backButton);

        // Acciones de los botones
        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarExistencias(true);
            }
        });

        quitarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarExistencias(false);
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
        
          backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SupervisorView supervisorView = new SupervisorView();
                supervisorView.setVisible(true);
                dispose();
            }
        });

        // Agregar el panel de fondo al JFrame
        setContentPane(backgroundPanel);
    }

        private void buscarProducto() {
        String codigo = productoCodigoField.getText();
        ProductoController productoController = new ProductoController();
        Producto producto = productoController.obtenerProductoPorCodigo(codigo);
        if (producto != null) {
            productoNombreField.setText(producto.getNombre());
            InventarioController inventarioController = new InventarioController();
            Inventario inventario = inventarioController.obtenerInventarioPorCodigoProducto(codigo);
            if (inventario != null) {
                cantidadActualField.setText(String.valueOf(inventario.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(this, "Inventario no encontrado para este producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarExistencias(boolean esAñadir) {
        try {
            String codigo = productoCodigoField.getText();
            int cantidadModificar = Integer.parseInt(cantidadModificarField.getText());
            InventarioController inventarioController = new InventarioController();
            Inventario inventario = inventarioController.obtenerInventarioPorCodigoProducto(codigo);

            if (inventario != null) {
                int nuevaCantidad = esAñadir ? inventario.getCantidad() + cantidadModificar : inventario.getCantidad() - cantidadModificar;
                inventario.setCantidad(nuevaCantidad);
                inventarioController.actualizarInventario(inventario);

                MovimientoInventarioController movimientoController = new MovimientoInventarioController();
                MovimientoInventario movimiento = new MovimientoInventario();
                movimiento.setProductoCodigo(codigo);
                movimiento.setCantidad(esAñadir ? cantidadModificar : -cantidadModificar);
                movimiento.setUsuario(usuarioField.getText());
                movimiento.setMotivo(motivoField.getText());
                movimientoController.registrarMovimientoInventario(movimiento);

                cantidadActualField.setText(String.valueOf(nuevaCantidad));
                JOptionPane.showMessageDialog(this, "Inventario actualizado correctamente!");
            } else {
                JOptionPane.showMessageDialog(this, "Inventario no encontrado para este producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

        private void eliminarProducto() {
        String codigo = productoCodigoField.getText();
        ProductoController productoController = new ProductoController();
        productoController.eliminarProducto(codigo);

        InventarioController inventarioController = new InventarioController();
        inventarioController.eliminarInventarioPorCodigoProducto(codigo);

        MovimientoInventarioController movimientoController = new MovimientoInventarioController();
        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setProductoCodigo(codigo);
        movimiento.setCantidad(0); // Ajustar la cantidad según lo que necesites
        movimiento.setUsuario(usuarioField.getText());
        movimiento.setMotivo(motivoField.getText());
        movimientoController.registrarMovimientoInventario(movimiento);

        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente!");

        // Limpiar campos después de eliminar el producto
        productoCodigoField.setText("");
        productoNombreField.setText("");
        cantidadActualField.setText("");
        cantidadModificarField.setText("");
        usuarioField.setText("");
        motivoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventarioView inventarioView = new InventarioView();
            inventarioView.setVisible(true);
        });
    }
}



/*
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
*/
