/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author nebra
 * 
 **/


import Controller.InventarioController;
import Controller.MovimientoInventarioController;
import Controller.ProductoController;
import Model.Inventario;
import Model.MovimientoInventario;
import Model.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ProductoView extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField categoriaField;
    private JTextField precioNormalField;
    private JTextField precioPromocionField;
    private JTextField cantidadField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton backButton;
    private JLabel imagenLabel;
    private JButton cargarImagenButton;
    private File imagenFile;

    public ProductoView() {
        setTitle("Gestión de Productos La Torre");
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
        JLabel tituloLabel = new JLabel("Gestión de Productos La Torre", SwingConstants.CENTER);
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
        JLabel codigoLabel = new JLabel("Código:");
        codigoLabel.setForeground(Color.WHITE);
        codigoLabel.setBackground(new Color(0, 0, 0, 150));
        codigoLabel.setOpaque(true);
        codigoLabel.setBounds(labelX, 70, 100, 25);
        backgroundPanel.add(codigoLabel);

        codigoField = new JTextField(20);
        codigoField.setForeground(Color.BLACK);
        codigoField.setBounds(fieldX, 70, fieldWidth, 25);
        backgroundPanel.add(codigoField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBackground(new Color(0, 0, 0, 150));
        nombreLabel.setOpaque(true);
        nombreLabel.setBounds(labelX, 70 + yGap, 100, 25);
        backgroundPanel.add(nombreLabel);

        nombreField = new JTextField(20);
        nombreField.setForeground(Color.BLACK);
        nombreField.setBounds(fieldX, 70 + yGap, fieldWidth, 25);
        backgroundPanel.add(nombreField);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionLabel.setForeground(Color.WHITE);
        descripcionLabel.setBackground(new Color(0, 0, 0, 150));
        descripcionLabel.setOpaque(true);
        descripcionLabel.setBounds(labelX, 70 + 2 * yGap, 100, 25);
        backgroundPanel.add(descripcionLabel);

        descripcionField = new JTextField(20);
        descripcionField.setForeground(Color.BLACK);
        descripcionField.setBounds(fieldX, 70 + 2 * yGap, fieldWidth, 25);
        backgroundPanel.add(descripcionField);

        JLabel categoriaLabel = new JLabel("Categoría:");
        categoriaLabel.setForeground(Color.WHITE);
        categoriaLabel.setBackground(new Color(0, 0, 0, 150));
        categoriaLabel.setOpaque(true);
        categoriaLabel.setBounds(labelX, 70 + 3 * yGap, 100, 25);
        backgroundPanel.add(categoriaLabel);

        categoriaField = new JTextField(20);
        categoriaField.setForeground(Color.BLACK);
        categoriaField.setBounds(fieldX, 70 + 3 * yGap, fieldWidth, 25);
        backgroundPanel.add(categoriaField);

        JLabel precioNormalLabel = new JLabel("Precio Normal:");
        precioNormalLabel.setForeground(Color.WHITE);
        precioNormalLabel.setBackground(new Color(0, 0, 0, 150));
        precioNormalLabel.setOpaque(true);
        precioNormalLabel.setBounds(labelX, 70 + 4 * yGap, 100, 25);
        backgroundPanel.add(precioNormalLabel);

        precioNormalField = new JTextField(20);
        precioNormalField.setForeground(Color.BLACK);
        precioNormalField.setBounds(fieldX, 70 + 4 * yGap, fieldWidth, 25);
        backgroundPanel.add(precioNormalField);

        JLabel precioPromocionLabel = new JLabel("Precio Promoción:");
        precioPromocionLabel.setForeground(Color.WHITE);
        precioPromocionLabel.setBackground(new Color(0, 0, 0, 150));
        precioPromocionLabel.setOpaque(true);
        precioPromocionLabel.setBounds(labelX, 70 + 5 * yGap, 100, 25);
        backgroundPanel.add(precioPromocionLabel);

        precioPromocionField = new JTextField(20);
        precioPromocionField.setForeground(Color.BLACK);
        precioPromocionField.setBounds(fieldX, 70 + 5 * yGap, fieldWidth, 25);
        backgroundPanel.add(precioPromocionField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        cantidadLabel.setForeground(Color.WHITE);
        cantidadLabel.setBackground(new Color(0, 0, 0, 150));
        cantidadLabel.setOpaque(true);
        cantidadLabel.setBounds(labelX, 70 + 6 * yGap, 100, 25);
        backgroundPanel.add(cantidadLabel);

        cantidadField = new JTextField(20);
        cantidadField.setForeground(Color.BLACK);
        cantidadField.setBounds(fieldX, 70 + 6 * yGap, fieldWidth, 25);
        backgroundPanel.add(cantidadField);

                // Botón para cargar la imagen
        cargarImagenButton = new JButton("Cargar Imagen");
        cargarImagenButton.setForeground(Color.WHITE);
        cargarImagenButton.setBackground(new Color(100, 100, 100, 150));
        cargarImagenButton.setOpaque(true);
        cargarImagenButton.setBorderPainted(false);
        cargarImagenButton.setBounds(250, 70 + 7 * yGap, 200, 40);
        backgroundPanel.add(cargarImagenButton);

        // Label para mostrar la imagen
        imagenLabel = new JLabel();
        imagenLabel.setBounds(500, 70 + 7 * yGap, 150, 150);
        backgroundPanel.add(imagenLabel);

        saveButton = new JButton("Guardar");
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(new Color(100, 100, 100, 150));
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);
        saveButton.setBounds(100, 70 + 8 * yGap, 150, 40);
        backgroundPanel.add(saveButton);

        deleteButton = new JButton("Eliminar");
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(100, 100, 100, 150));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.setBounds(270, 70 + 8 * yGap, 150, 40);
        backgroundPanel.add(deleteButton);

        backButton = new JButton("Atrás");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(100, 100, 100, 150));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBounds(440, 70 + 8 * yGap, 150, 40);
        backgroundPanel.add(backButton);
        
        // Acción para cargar la imagen
        cargarImagenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    imagenFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(imagenFile.getPath());
                    Image image = imageIcon.getImage().getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
                    imagenLabel.setIcon(new ImageIcon(image));
                }
            }
        });
        // Acción para guardar el producto
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        // Acción para eliminar el producto
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        // Acción para volver atrás
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

    private void guardarProducto() {
        Producto producto = new Producto();
        producto.setCodigo(codigoField.getText());
        producto.setNombre(nombreField.getText());
        producto.setCategoria(categoriaField.getText());
        producto.setPrecioNormal(Double.parseDouble(precioNormalField.getText()));
        producto.setPrecioPromocion(Double.parseDouble(precioPromocionField.getText()));

        if (imagenFile != null) {
            try (FileInputStream fis = new FileInputStream(imagenFile)) {
                byte[] imagenBytes = fis.readAllBytes();
                producto.setImagen(imagenBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ProductoController productoController = new ProductoController();
        productoController.crearProducto(producto);
        
        // Actualizar inventario
        Inventario inventario = new Inventario();
        inventario.setProductoCodigo(producto.getCodigo());
        inventario.setCantidad(Integer.parseInt(cantidadField.getText()));
        InventarioController inventarioController = new InventarioController();
        inventarioController.crearInventario(inventario);

        // Registrar movimiento de inventario
        MovimientoInventario movimiento = new MovimientoInventario();
        movimiento.setProductoCodigo(producto.getCodigo());
        movimiento.setCantidad(Integer.parseInt(cantidadField.getText()));
        movimiento.setUsuario("admin"); // Ajustar el usuario según corresponda
        movimiento.setMotivo("Ingreso de producto");
        MovimientoInventarioController movimientoInventarioController = new MovimientoInventarioController();
        movimientoInventarioController.registrarMovimientoInventario(movimiento);

        JOptionPane.showMessageDialog(this, "Producto guardado correctamente!");
    }
    
        private void eliminarProducto() {
        String codigo = codigoField.getText();
        ProductoController productoController = new ProductoController();
        productoController.eliminarProducto(codigo);

        InventarioController inventarioController = new InventarioController();
        inventarioController.eliminarInventarioPorCodigoProducto(codigo);

        MovimientoInventarioController movimientoInventarioController = new MovimientoInventarioController();
        movimientoInventarioController.registrarMovimientoInventario(new MovimientoInventario(codigo, 0, "admin", "Eliminación de producto"));

        JOptionPane.showMessageDialog(this, "Producto eliminado correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductoView productoView = new ProductoView();
            productoView.setVisible(true);
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