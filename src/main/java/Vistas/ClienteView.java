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
import Model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClienteView extends JFrame {
    private JTextField nombreField;
    private JTextField contactoField;
    private JTextField correoField;
    private JTextField direccionField;
    private JTextField idField;
    private JButton saveButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton backButton;

    public ClienteView() {
        setTitle("Gestión de Clientes La Torre");
        setSize(700, 600);
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
        JLabel tituloLabel = new JLabel("Gestión de Clientes La Torre", SwingConstants.CENTER);
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
        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBackground(new Color(0, 0, 0, 150));
        nombreLabel.setOpaque(true);
        nombreLabel.setBounds(labelX, 70, 100, 25);
        backgroundPanel.add(nombreLabel);

        nombreField = new JTextField(20);
        nombreField.setForeground(Color.BLACK);
        nombreField.setBounds(fieldX, 70, fieldWidth, 25);
        backgroundPanel.add(nombreField);

        JLabel contactoLabel = new JLabel("Contacto:");
        contactoLabel.setForeground(Color.WHITE);
        contactoLabel.setBackground(new Color(0, 0, 0, 150));
        contactoLabel.setOpaque(true);
        contactoLabel.setBounds(labelX, 70 + yGap, 100, 25);
        backgroundPanel.add(contactoLabel);

        contactoField = new JTextField(20);
        contactoField.setForeground(Color.BLACK);
        contactoField.setBounds(fieldX, 70 + yGap, fieldWidth, 25);
        backgroundPanel.add(contactoField);

        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setForeground(Color.WHITE);
        correoLabel.setBackground(new Color(0, 0, 0, 150));
        correoLabel.setOpaque(true);
        correoLabel.setBounds(labelX, 70 + 2 * yGap, 100, 25);
        backgroundPanel.add(correoLabel);

        correoField = new JTextField(20);
        correoField.setForeground(Color.BLACK);
        correoField.setBounds(fieldX, 70 + 2 * yGap, fieldWidth, 25);
        backgroundPanel.add(correoField);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setForeground(Color.WHITE);
        direccionLabel.setBackground(new Color(0, 0, 0, 150));
        direccionLabel.setOpaque(true);
        direccionLabel.setBounds(labelX, 70 + 3 * yGap, 100, 25);
        backgroundPanel.add(direccionLabel);

        direccionField = new JTextField(20);
        direccionField.setForeground(Color.BLACK);
        direccionField.setBounds(fieldX, 70 + 3 * yGap, fieldWidth, 25);
        backgroundPanel.add(direccionField);

                JLabel idLabel = new JLabel("ID (para actualizar/eliminar):");
        idLabel.setForeground(Color.WHITE);
        idLabel.setBackground(new Color(0, 0, 0, 150));
        idLabel.setOpaque(true);
        idLabel.setBounds(labelX, 70 + 4 * yGap, 200, 25);
        backgroundPanel.add(idLabel);

        idField = new JTextField(20);
        idField.setForeground(Color.BLACK);
        idField.setBounds(fieldX, 70 + 4 * yGap, fieldWidth, 25);
        backgroundPanel.add(idField);

        saveButton = new JButton("Guardar");
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(new Color(100, 100, 100, 150));
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);
        saveButton.setBounds(100, 70 + 5 * yGap, 150, 40);
        backgroundPanel.add(saveButton);

        updateButton = new JButton("Actualizar");
        updateButton.setForeground(Color.WHITE);
        updateButton.setBackground(new Color(100, 100, 100, 150));
        updateButton.setOpaque(true);
        updateButton.setBorderPainted(false);
        updateButton.setBounds(270, 70 + 5 * yGap, 150, 40);
        backgroundPanel.add(updateButton);

        deleteButton = new JButton("Eliminar");
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(100, 100, 100, 150));
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.setBounds(440, 70 + 5 * yGap, 150, 40);
        backgroundPanel.add(deleteButton);
        
                backButton = new JButton("Atrás");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(100, 100, 100, 150));
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBounds(270, 70 + 6 * yGap, 150, 40);
        backgroundPanel.add(backButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCliente();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
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
    
        private void guardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre(nombreField.getText());
        cliente.setContacto(contactoField.getText());
        cliente.setCorreo(correoField.getText());
        cliente.setDireccion(direccionField.getText());

        ClienteController clienteController = new ClienteController();
        clienteController.crearCliente(cliente);

        JOptionPane.showMessageDialog(this, "Cliente guardado correctamente!");
    }

    private void actualizarCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(Integer.parseInt(idField.getText()));
        cliente.setNombre(nombreField.getText());
        cliente.setContacto(contactoField.getText());
        cliente.setCorreo(correoField.getText());
        cliente.setDireccion(direccionField.getText());

        ClienteController clienteController = new ClienteController();
        clienteController.actualizarCliente(cliente);

        JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente!");
    }

        private void eliminarCliente() {
        int id = Integer.parseInt(idField.getText());
        ClienteController clienteController = new ClienteController();
        clienteController.eliminarCliente(id);

        JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteView clienteView = new ClienteView();
            clienteView.setVisible(true);
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
