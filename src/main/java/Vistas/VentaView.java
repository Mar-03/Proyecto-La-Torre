/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author nebra
 */

import Controller.ClienteController;
import Controller.DetalleVentaController;
import Controller.InventarioController;
import Controller.MovimientoInventarioController;
import Controller.ProductoController;
import Controller.VentaController;
import Model.Cliente;
import Model.DetalleVenta;
import Model.Inventario;
import Model.MovimientoInventario;
import Model.Producto;
import Model.Venta;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import utilidades.FacturaGenerator;

public class VentaView extends JFrame {
    private JTextField clienteIdField;
    private JTextField clienteNombreField;
    private JTextField clienteContactoField;
    private JTextField clienteCorreoField;
    private JTextField clienteDireccionField;
    private JTextField productoCodigoField;
    private JTextField productoNombreField;
    private JTextField productoCategoriaField;
    private JTextField productoPrecioField;
    private JTextField productoCantidadField;
    private JTextField productoIVAField;
    private JTextField productoTotalField;
    private JTextField totalField;
    private JTextField recargoField;
    private JRadioButton precioNormalRadio;
    private JRadioButton precioPromocionRadio;
    private JRadioButton efectivoRadio;
    private JRadioButton tarjetaRadio;
    private JButton buscarClienteButton;
    private JButton buscarProductoButton;
    private JButton agregarProductoButton;
    private JButton quitarProductoButton;
    private JButton finalizarVentaButton;
    private JButton backButton;
    private JTable productoTable;
    private DefaultTableModel tableModel;

    public VentaView() {
        setTitle("Gestión de Ventas La Torre");
        setSize(1400, 900);
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
        backgroundPanel.setBounds(0, 0, 1400, 900);
        add(backgroundPanel);

        // Título centrado
        JLabel tituloLabel = new JLabel("Gestión de Ventas La Torre", SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBackground(new Color(0, 0, 0, 150)); // Negro semitransparente
        tituloLabel.setOpaque(true);
        tituloLabel.setBounds(600, 0, 200, 50);
        backgroundPanel.add(tituloLabel);

        int labelX = 50;
        int labelWidth = 150;
        int fieldX = 250;
        int fieldWidth = 200;
        int yGap = 40;

                // Campos de Cliente
        JLabel clienteIdLabel = new JLabel("ID Cliente:");
        clienteIdLabel.setForeground(Color.WHITE);
        clienteIdLabel.setBackground(new Color(0, 0, 0, 150));
        clienteIdLabel.setOpaque(true);
        clienteIdLabel.setBounds(labelX, 70, labelWidth, 25);
        backgroundPanel.add(clienteIdLabel);

        clienteIdField = new JTextField(20);
        clienteIdField.setForeground(Color.BLACK);
        clienteIdField.setBounds(fieldX, 70, fieldWidth, 25);
        backgroundPanel.add(clienteIdField);

        buscarClienteButton = new JButton("Buscar");
        buscarClienteButton.setForeground(Color.WHITE);
        buscarClienteButton.setBackground(new Color(100, 100, 100, 150));
        buscarClienteButton.setOpaque(true);
        buscarClienteButton.setBorderPainted(false);
        buscarClienteButton.setBounds(fieldX + fieldWidth + 10, 70, 100, 25);
        backgroundPanel.add(buscarClienteButton);

        JLabel clienteNombreLabel = new JLabel("Nombre:");
        clienteNombreLabel.setForeground(Color.WHITE);
        clienteNombreLabel.setBackground(new Color(0, 0, 0, 150));
        clienteNombreLabel.setOpaque(true);
        clienteNombreLabel.setBounds(labelX, 70 + yGap, labelWidth, 25);
        backgroundPanel.add(clienteNombreLabel);

        clienteNombreField = new JTextField(20);
        clienteNombreField.setForeground(Color.BLACK);
        clienteNombreField.setBounds(fieldX, 70 + yGap, fieldWidth, 25);
        backgroundPanel.add(clienteNombreField);
        
        JLabel clienteContactoLabel = new JLabel("Contacto:");
        clienteContactoLabel.setForeground(Color.WHITE);
        clienteContactoLabel.setBackground(new Color(0, 0, 0, 150));
        clienteContactoLabel.setOpaque(true);
        clienteContactoLabel.setBounds(labelX, 70 + 2 * yGap, labelWidth, 25);
        backgroundPanel.add(clienteContactoLabel);

        clienteContactoField = new JTextField(20);
        clienteContactoField.setForeground(Color.BLACK);
        clienteContactoField.setBounds(fieldX, 70 + 2 * yGap, fieldWidth, 25);
        backgroundPanel.add(clienteContactoField);

        JLabel clienteCorreoLabel = new JLabel("Correo:");
        clienteCorreoLabel.setForeground(Color.WHITE);
        clienteCorreoLabel.setBackground(new Color(0, 0, 0, 150));
        clienteCorreoLabel.setOpaque(true);
        clienteCorreoLabel.setBounds(labelX, 70 + 3 * yGap, labelWidth, 25);
        backgroundPanel.add(clienteCorreoLabel);

        clienteCorreoField = new JTextField(20);
        clienteCorreoField.setForeground(Color.BLACK);
        clienteCorreoField.setBounds(fieldX, 70 + 3 * yGap, fieldWidth, 25);
        backgroundPanel.add(clienteCorreoField);

                JLabel clienteDireccionLabel = new JLabel("Dirección:");
        clienteDireccionLabel.setForeground(Color.WHITE);
        clienteDireccionLabel.setBackground(new Color(0, 0, 0, 150));
        clienteDireccionLabel.setOpaque(true);
        clienteDireccionLabel.setBounds(labelX, 70 + 4 * yGap, labelWidth, 25);
        backgroundPanel.add(clienteDireccionLabel);

        clienteDireccionField = new JTextField(20);
        clienteDireccionField.setForeground(Color.BLACK);
        clienteDireccionField.setBounds(fieldX, 70 + 4 * yGap, fieldWidth, 25);
        backgroundPanel.add(clienteDireccionField);

        buscarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });

        // Campos de Producto
        JLabel productoCodigoLabel = new JLabel("Código Producto:");
        productoCodigoLabel.setForeground(Color.WHITE);
        productoCodigoLabel.setBackground(new Color(0, 0, 0, 150));
        productoCodigoLabel.setOpaque(true);
        productoCodigoLabel.setBounds(labelX, 300, labelWidth, 25);
        backgroundPanel.add(productoCodigoLabel);

        productoCodigoField = new JTextField(20);
        productoCodigoField.setForeground(Color.BLACK);
        productoCodigoField.setBounds(fieldX, 300, fieldWidth, 25);
        backgroundPanel.add(productoCodigoField);

        buscarProductoButton = new JButton("Buscar");
        buscarProductoButton.setForeground(Color.WHITE);
        buscarProductoButton.setBackground(new Color(100, 100, 100, 150));
        buscarProductoButton.setOpaque(true);
        buscarProductoButton.setBorderPainted(false);
        buscarProductoButton.setBounds(fieldX + fieldWidth + 10, 300, 100, 25);
        backgroundPanel.add(buscarProductoButton);

                JLabel productoNombreLabel = new JLabel("Nombre:");
        productoNombreLabel.setForeground(Color.WHITE);
        productoNombreLabel.setBackground(new Color(0, 0, 0, 150));
        productoNombreLabel.setOpaque(true);
        productoNombreLabel.setBounds(labelX, 300 + yGap, labelWidth, 25);
        backgroundPanel.add(productoNombreLabel);

        productoNombreField = new JTextField(20);
        productoNombreField.setForeground(Color.BLACK);
        productoNombreField.setBounds(fieldX, 300 + yGap, fieldWidth, 25);
        backgroundPanel.add(productoNombreField);

        JLabel productoCategoriaLabel = new JLabel("Categoría:");
        productoCategoriaLabel.setForeground(Color.WHITE);
        productoCategoriaLabel.setBackground(new Color(0, 0, 0, 150));
        productoCategoriaLabel.setOpaque(true);
        productoCategoriaLabel.setBounds(labelX, 300 + 2 * yGap, labelWidth, 25);
        backgroundPanel.add(productoCategoriaLabel);

        productoCategoriaField = new JTextField(20);
        productoCategoriaField.setForeground(Color.BLACK);
        productoCategoriaField.setBounds(fieldX, 300 + 2 * yGap, fieldWidth, 25);
        backgroundPanel.add(productoCategoriaField);

        buscarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

                JLabel productoPrecioLabel = new JLabel("Precio:");
        productoPrecioLabel.setForeground(Color.WHITE);
        productoPrecioLabel.setBackground(new Color(0, 0, 0, 150));
        productoPrecioLabel.setOpaque(true);
        productoPrecioLabel.setBounds(labelX, 300 + 3 * yGap, labelWidth, 25);
        backgroundPanel.add(productoPrecioLabel);

        productoPrecioField = new JTextField(20);
        productoPrecioField.setForeground(Color.BLACK);
        productoPrecioField.setBounds(fieldX, 300 + 3 * yGap, fieldWidth, 25);
        backgroundPanel.add(productoPrecioField);

        precioNormalRadio = new JRadioButton("Precio Normal");
        precioPromocionRadio = new JRadioButton("Precio Promoción");
        ButtonGroup precioGroup = new ButtonGroup();
        precioGroup.add(precioNormalRadio);
        precioGroup.add(precioPromocionRadio);
        precioNormalRadio.setBounds(fieldX + fieldWidth + 10, 300 + 3 * yGap, 120, 25);
        precioPromocionRadio.setBounds(fieldX + fieldWidth + 140, 300 + 3 * yGap, 140, 25);
        backgroundPanel.add(precioNormalRadio);
        backgroundPanel.add(precioPromocionRadio);

        JLabel productoCantidadLabel = new JLabel("Cantidad:");
        productoCantidadLabel.setForeground(Color.WHITE);
        productoCantidadLabel.setBackground(new Color(0, 0, 0, 150));
        productoCantidadLabel.setOpaque(true);
        productoCantidadLabel.setBounds(labelX, 300 + 4 * yGap, labelWidth, 25);
        backgroundPanel.add(productoCantidadLabel);

        productoCantidadField = new JTextField(20);
        productoCantidadField.setForeground(Color.BLACK);
        productoCantidadField.setBounds(fieldX, 300 + 4 * yGap, fieldWidth, 25);
        backgroundPanel.add(productoCantidadField);

                JLabel productoIVALabel = new JLabel("IVA 12%:");
        productoIVALabel.setForeground(Color.WHITE);
        productoIVALabel.setBackground(new Color(0, 0, 0, 150));
        productoIVALabel.setOpaque(true);
        productoIVALabel.setBounds(labelX, 300 + 5 * yGap, labelWidth, 25);
        backgroundPanel.add(productoIVALabel);

        productoIVAField = new JTextField(20);
        productoIVAField.setForeground(Color.BLACK);
        productoIVAField.setBounds(fieldX, 300 + 5 * yGap, fieldWidth, 25);
        productoIVAField.setEditable(false);
        backgroundPanel.add(productoIVAField);

        JLabel productoTotalLabel = new JLabel("Total:");
        productoTotalLabel.setForeground(Color.WHITE);
        productoTotalLabel.setBackground(new Color(0, 0, 0, 150));
        productoTotalLabel.setOpaque(true);
        productoTotalLabel.setBounds(labelX, 300 + 6 * yGap, labelWidth, 25);
        backgroundPanel.add(productoTotalLabel);

        productoTotalField = new JTextField(20);
        productoTotalField.setForeground(Color.BLACK);
        productoTotalField.setBounds(fieldX, 300 + 6 * yGap, fieldWidth, 25);
        productoTotalField.setEditable(false);
        backgroundPanel.add(productoTotalField);

        agregarProductoButton = new JButton("Agregar Producto");
        agregarProductoButton.setForeground(Color.WHITE);
        agregarProductoButton.setBackground(new Color(100, 100, 100, 150));
        agregarProductoButton.setOpaque(true);
        agregarProductoButton.setBorderPainted(false);
        agregarProductoButton.setBounds(50, 300 + 7 * yGap, 150, 40);
        backgroundPanel.add(agregarProductoButton);

        quitarProductoButton = new JButton("Quitar Producto");
        quitarProductoButton.setForeground(Color.WHITE);
        quitarProductoButton.setBackground(new Color(100, 100, 100, 150));
        quitarProductoButton.setOpaque(true);
        quitarProductoButton.setBorderPainted(false);
        quitarProductoButton.setBounds(220, 300 + 7 * yGap, 150, 40);
        backgroundPanel.add(quitarProductoButton);

                // Tabla de productos
        String[] columnNames = {"Código", "Nombre", "Categoría", "Precio Unitario", "Cantidad", "IVA", "Total"};
        tableModel = new DefaultTableModel(columnNames, 0);
        productoTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productoTable);
        scrollPane.setBounds(500, 70, 650, 400);
        backgroundPanel.add(scrollPane);

        JLabel totalLabel = new JLabel("Total Venta:");
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setBackground(new Color(0, 0, 0, 150));
        totalLabel.setOpaque(true);
        totalLabel.setBounds(500, 480, labelWidth, 25);
        backgroundPanel.add(totalLabel);

        totalField = new JTextField(20);
        totalField.setForeground(Color.BLACK);
        totalField.setBounds(650, 480, fieldWidth, 25);
        totalField.setEditable(false);
        backgroundPanel.add(totalField);

        JLabel recargoLabel = new JLabel("Recargo:");
        recargoLabel.setForeground(Color.WHITE);
        recargoLabel.setBackground(new Color(0, 0, 0, 150));
        recargoLabel.setOpaque(true);
        recargoLabel.setBounds(500, 520, labelWidth, 25);
        backgroundPanel.add(recargoLabel);

        recargoField = new JTextField(20);
        recargoField.setForeground(Color.BLACK);
        recargoField.setBounds(650, 520, fieldWidth, 25);
        recargoField.setEditable(false);
        backgroundPanel.add(recargoField);

        JLabel pagoLabel = new JLabel("Método de Pago:");
        pagoLabel.setForeground(Color.WHITE);
        pagoLabel.setBackground(new Color(0, 0, 0, 150));
        pagoLabel.setOpaque(true);
        pagoLabel.setBounds(500, 560, labelWidth, 25);
        backgroundPanel.add(pagoLabel);

        efectivoRadio = new JRadioButton("Efectivo");
        tarjetaRadio = new JRadioButton("Tarjeta");
        ButtonGroup pagoGroup = new ButtonGroup();
        pagoGroup.add(efectivoRadio);
        pagoGroup.add(tarjetaRadio);
        efectivoRadio.setBounds(650, 560, 100, 25);
        tarjetaRadio.setBounds(760, 560, 100, 25);
        backgroundPanel.add(efectivoRadio);
        backgroundPanel.add(tarjetaRadio);

                tarjetaRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotalVenta();
            }
        });

        efectivoRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTotalVenta();
            }
        });

        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        quitarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitarProducto();
            }
        });

        finalizarVentaButton = new JButton("Finalizar Venta");
        finalizarVentaButton.setForeground(Color.WHITE);
        finalizarVentaButton.setBackground(new Color(100, 100, 100, 150));
        finalizarVentaButton.setOpaque(true);
        finalizarVentaButton.setBorderPainted(false);
        finalizarVentaButton.setBounds(500, 600, 150, 40);
        backgroundPanel.add(finalizarVentaButton);

        backButton = new JButton("Atrás");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(100, 100, 100, 150));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBounds(670, 600, 100, 40);
        backgroundPanel.add(backButton);

        finalizarVentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarVenta();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VendedorView vendedorView = new VendedorView();
                vendedorView.setVisible(true);
                dispose();
            }
        });

        // Agregar el panel de fondo al JFrame
        setContentPane(backgroundPanel);
    }

        private void buscarCliente() {
        int clienteId = Integer.parseInt(clienteIdField.getText());
        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.obtenerClientePorId(clienteId);
        
        if (cliente != null) {
            clienteNombreField.setText(cliente.getNombre());
            clienteContactoField.setText(cliente.getContacto());
            clienteCorreoField.setText(cliente.getCorreo());
            clienteDireccionField.setText(cliente.getDireccion());
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarProducto() {
        String codigo = productoCodigoField.getText();
        ProductoController productoController = new ProductoController();
        Producto producto = productoController.obtenerProductoPorCodigo(codigo);
        
        if (producto != null) {
            productoNombreField.setText(producto.getNombre());
            productoCategoriaField.setText(producto.getCategoria());
            productoPrecioField.setText(String.valueOf(producto.getPrecioNormal()));
            
            precioNormalRadio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    productoPrecioField.setText(String.valueOf(producto.getPrecioNormal()));
                }
            });

            precioPromocionRadio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    productoPrecioField.setText(String.valueOf(producto.getPrecioPromocion()));
                }
            });
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

            private void agregarProducto() {
        String codigo = productoCodigoField.getText();
        String nombre = productoNombreField.getText();
        String categoria = productoCategoriaField.getText();
        double precioUnitario = Double.parseDouble(productoPrecioField.getText());
        int cantidad = Integer.parseInt(productoCantidadField.getText());
        double iva = precioUnitario * 0.12;
        double total = (precioUnitario + iva) * cantidad;

        productoIVAField.setText(String.valueOf(iva));
        productoTotalField.setText(String.valueOf(total));

        Object[] rowData = {codigo, nombre, categoria, precioUnitario, cantidad, iva, total};
        tableModel.addRow(rowData);
        calcularTotalVenta();
    }

    private void quitarProducto() {
        int selectedRow = productoTable.getSelectedRow();
        if (selectedRow >= 0) {
            tableModel.removeRow(selectedRow);
            calcularTotalVenta();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para quitar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularTotalVenta() {
        double totalVenta = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            totalVenta += (double) tableModel.getValueAt(i, 6);
        }
        double recargo = calcularRecargo(totalVenta);
        totalField.setText(String.valueOf(totalVenta + recargo));
    }

    private double calcularRecargo(double totalVenta) {
        double recargo = 0.0;
        if (tarjetaRadio.isSelected()) {
            recargo = totalVenta * 0.05;
            recargoField.setText(String.valueOf(recargo));
        } else {
            recargoField.setText("0");
        }
        return recargo;
    }

    private void finalizarVenta() {
        int clienteId = Integer.parseInt(clienteIdField.getText());
        String vendedor = "vendedor"; // Ajustar según corresponda
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEmision = sdf.format(fecha);

        double totalVenta = Double.parseDouble(totalField.getText());
        double recargo = Double.parseDouble(recargoField.getText());
        double impuestos = totalVenta * 0.12;

        Venta venta = new Venta(clienteId, totalVenta - recargo, tarjetaRadio.isSelected() ? "tarjeta" : "efectivo", impuestos, vendedor);
        VentaController ventaController = new VentaController();
        int ventaId = ventaController.guardarVenta(venta);

        List<DetalleVenta> detallesVenta = new ArrayList<>();

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String codigoProducto = (String) tableModel.getValueAt(i, 0);
            int cantidad = (int) tableModel.getValueAt(i, 4);
            double precio = (double) tableModel.getValueAt(i, 3);

            // Registrar detalle de venta
            DetalleVenta detalleVenta = new DetalleVenta(ventaId, codigoProducto, cantidad, precio);
            DetalleVentaController detalleVentaController = new DetalleVentaController();
            detalleVentaController.guardarDetalleVenta(detalleVenta);
            detallesVenta.add(detalleVenta);

            // Registrar movimiento de inventario
            MovimientoInventario movimiento = new MovimientoInventario();
            movimiento.setProductoCodigo(codigoProducto);
            movimiento.setCantidad(-cantidad);
            movimiento.setUsuario(vendedor);
            movimiento.setMotivo("Venta de producto");
            MovimientoInventarioController movimientoInventarioController = new MovimientoInventarioController();
            movimientoInventarioController.registrarMovimientoInventario(movimiento);

            // Actualizar inventario
            InventarioController inventarioController = new InventarioController();
            Inventario inventario = inventarioController.obtenerInventarioPorCodigoProducto(codigoProducto);
            inventario.setCantidad(inventario.getCantidad() - cantidad);
            inventarioController.actualizarInventario(inventario);
        }

        JOptionPane.showMessageDialog(this, "Venta finalizada correctamente!");
        FacturaGenerator.generarFactura(venta, detallesVenta); // Generar factura al finalizar la venta
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentaView ventaView = new VentaView();
            ventaView.setVisible(true);
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
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
*/
