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

public class VendedorView extends JFrame {
    private JButton ventasButton;
    private JButton clientesButton;
    private JButton logoutButton;

    public VendedorView() {
        setTitle("Vista del Vendedor - Supermercado La Torre");
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
        JLabel tituloLabel = new JLabel("Vista del Vendedor - Supermercado La Torre", SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBackground(new Color(0, 0, 0, 150)); // Negro semitransparente
        tituloLabel.setOpaque(true);
        tituloLabel.setBounds(250, 0, 200, 50); // Ancho completo, altura ajustada
        backgroundPanel.add(tituloLabel);

        int buttonX = 250;
        int buttonWidth = 200;
        int yGap = 70;

        // Botones
        ventasButton = new JButton("Gestión de Ventas");
        ventasButton.setForeground(Color.WHITE);
        ventasButton.setBackground(new Color(100, 100, 100, 150));
        ventasButton.setOpaque(true);
        ventasButton.setBorderPainted(false);
        ventasButton.setBounds(buttonX, 70, buttonWidth, 40);
        backgroundPanel.add(ventasButton);

        clientesButton = new JButton("Gestión de Clientes");
        clientesButton.setForeground(Color.WHITE);
        clientesButton.setBackground(new Color(100, 100, 100, 150));
        clientesButton.setOpaque(true);
        clientesButton.setBorderPainted(false);
        clientesButton.setBounds(buttonX, 140, buttonWidth, 40);
        backgroundPanel.add(clientesButton);

                logoutButton = new JButton("Cerrar Sesión");
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(new Color(100, 100, 100, 150));
        logoutButton.setOpaque(true);
        logoutButton.setBorderPainted(false);
        logoutButton.setBounds(buttonX, 210, buttonWidth, 40);
        backgroundPanel.add(logoutButton);

        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentaView ventaView = new VentaView();
                ventaView.setVisible(true);
                dispose();
            }
        });

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteView clienteView = new ClienteView();
                clienteView.setVisible(true);
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
            VendedorView vendedorView = new VendedorView();
            vendedorView.setVisible(true);
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
