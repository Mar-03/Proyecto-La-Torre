/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author nebra
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupervisorView extends JFrame {
    private JButton productosButton;
    private JButton inventariosButton;
    private JButton reportesButton;  // Nuevo botón para Reportes
    private JButton logoutButton;

    public SupervisorView() {
        setTitle("Vista del Supervisor - Supermercado La Torre");
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
        JLabel tituloLabel = new JLabel("Vista del Supervisor - Supermercado La Torre", SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBackground(new Color(0, 0, 0, 150)); // Negro semitransparente
        tituloLabel.setOpaque(true);
        tituloLabel.setBounds(250, 0, 200, 50); // Ancho completo, altura ajustada
        backgroundPanel.add(tituloLabel);

        int labelX = 200;
        int labelWidth = 100;
        int fieldX = 300;
        int fieldWidth = 200;
        int yGap = 60;

        // Campos y Botones
        productosButton = new JButton("Gestión de Productos");
        productosButton.setForeground(Color.WHITE);
        productosButton.setBackground(new Color(100, 100, 100, 150));
        productosButton.setOpaque(true);
        productosButton.setBorderPainted(false);
        productosButton.setBounds(250, 70, 200, 40);
        backgroundPanel.add(productosButton);

        inventariosButton = new JButton("Gestión de Inventarios");
        inventariosButton.setForeground(Color.WHITE);
        inventariosButton.setBackground(new Color(100, 100, 100, 150));
        inventariosButton.setOpaque(true);
        inventariosButton.setBorderPainted(false);
        inventariosButton.setBounds(250, 140, 200, 40);
        backgroundPanel.add(inventariosButton);

                reportesButton = new JButton("Gestión de Reportes");  // Nuevo botón para Reportes
        reportesButton.setForeground(Color.WHITE);
        reportesButton.setBackground(new Color(100, 100, 100, 150));
        reportesButton.setOpaque(true);
        reportesButton.setBorderPainted(false);
        reportesButton.setBounds(250, 210, 200, 40);
        backgroundPanel.add(reportesButton);

        logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(100, 100, 100, 150));
        logoutButton.setOpaque(true);
        logoutButton.setBorderPainted(false);
        logoutButton.setBounds(250, 280, 200, 40);
        backgroundPanel.add(logoutButton);

        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductoView productoView = new ProductoView();
                productoView.setVisible(true);
                dispose();
            }
        });

        inventariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventarioView inventarioView = new InventarioView();
                inventarioView.setVisible(true);
                dispose();
            }
        });

        reportesButton.addActionListener(new ActionListener() {  // Acción para el botón de reportes
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportesView reportesView = new ReportesView();
                reportesView.setVisible(true);
                dispose();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SupervisorView supervisorView = new SupervisorView();
            supervisorView.setVisible(true);
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