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
import Controller.UsuarioController;

public class LoginView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Login - Supermercado La Torre");
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
        JLabel tituloLabel = new JLabel("Login - Supermercado La Torre", SwingConstants.CENTER);
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
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBackground(new Color(0, 0, 0, 150));
        usernameLabel.setOpaque(true);
        usernameLabel.setBounds(labelX, 70, labelWidth, 25);
        backgroundPanel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setForeground(Color.BLACK);
        usernameField.setBounds(fieldX, 70, fieldWidth, 25);
        backgroundPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBackground(new Color(0, 0, 0, 150));
        passwordLabel.setOpaque(true);
        passwordLabel.setBounds(labelX, 70 + yGap, labelWidth, 25);
        backgroundPanel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setForeground(Color.BLACK);
        passwordField.setBounds(fieldX, 70 + yGap, fieldWidth, 25);
        backgroundPanel.add(passwordField);

                loginButton = new JButton("Ingresar");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(100, 100, 100, 150));
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false);
        loginButton.setBounds(fieldX, 70 + 2 * yGap, 100, 25);
        backgroundPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        UsuarioController usuarioController = new UsuarioController();

        if (usuarioController.login(username, password)) {
            String rol = usuarioController.obtenerRol(username);

            if (rol.equals("supervisor")) {
                SupervisorView supervisorView = new SupervisorView();
                supervisorView.setVisible(true);
                dispose();
            } else if (rol.equals("vendedor")) {
                VendedorView vendedorView = new VendedorView();
                vendedorView.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Rol desconocido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
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
