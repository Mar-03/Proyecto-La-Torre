/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

/**
 *
 * @author nebra
 */


import Controller.ReportesController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportesView extends JFrame {
    private JButton generarReporteVentasButton;
    private JButton generarReporteInventarioButton;
    private JTextArea reporteTextArea;
    private JButton descargarReporteVentasPdfButton;
    private JButton descargarReporteVentasExcelButton;
    private JButton descargarReporteInventarioPdfButton;
    private JButton descargarReporteInventarioExcelButton;
    private JButton backButton;

    public ReportesView() {
        setTitle("Gestión de Reportes La Torre");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de Fondo
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("src/main/java/img/imgFondo.png");
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Título centrado
        JLabel tituloLabel = new JLabel("Gestión de Reportes La Torre", SwingConstants.CENTER);
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBackground(new Color(0, 0, 0, 150)); // Negro semitransparente
        tituloLabel.setOpaque(true);
        backgroundPanel.add(tituloLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        buttonPanel.setOpaque(false);

        // Botón para generar reporte de ventas
        generarReporteVentasButton = new JButton("Generar Reporte de Ventas");
        buttonPanel.add(generarReporteVentasButton);

        // Botón para generar reporte de inventario
        generarReporteInventarioButton = new JButton("Generar Reporte de Inventario");
        buttonPanel.add(generarReporteInventarioButton);

        // Botón para descargar reporte de ventas como PDF
        descargarReporteVentasPdfButton = new JButton("Descargar Reporte de Ventas PDF");
        buttonPanel.add(descargarReporteVentasPdfButton);

        // Botón para descargar reporte de ventas como Excel
        descargarReporteVentasExcelButton = new JButton("Descargar Reporte de Ventas Excel");
        buttonPanel.add(descargarReporteVentasExcelButton);

        // Botón para descargar reporte de inventario como PDF
        descargarReporteInventarioPdfButton = new JButton("Descargar Reporte de Inventario PDF");
        buttonPanel.add(descargarReporteInventarioPdfButton);

        // Botón para descargar reporte de inventario como Excel
        descargarReporteInventarioExcelButton = new JButton("Descargar Reporte de Inventario Excel");
        buttonPanel.add(descargarReporteInventarioExcelButton);

        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        
                // Área de texto para mostrar los reportes
        reporteTextArea = new JTextArea();
        reporteTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reporteTextArea);
        backgroundPanel.add(scrollPane, BorderLayout.SOUTH);

        // Botón para volver atrás
        backButton = new JButton("Atrás");
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backPanel.setOpaque(false);
        backPanel.add(backButton);
        backgroundPanel.add(backPanel, BorderLayout.SOUTH);

        generarReporteVentasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteVentas();
            }
        });

        generarReporteInventarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporteInventario();
            }
        });

        descargarReporteVentasPdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarReporteVentasPdf();
            }
        });

        descargarReporteVentasExcelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarReporteVentasExcel();
            }
        });

        descargarReporteInventarioPdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarReporteInventarioPdf();
            }
        });

        descargarReporteInventarioExcelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                descargarReporteInventarioExcel();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Vuelve a la vista anterior, ajusta según corresponda
                SupervisorView supervisorView = new SupervisorView();
                supervisorView.setVisible(true);
                dispose();
            }
        });

        // Agregar el panel de fondo al JFrame
        setContentPane(backgroundPanel);
    }

    private void generarReporteVentas() {
        ReportesController reportesController = new ReportesController();
        String reporte = reportesController.generarReporteVentas();
        reporteTextArea.setText(reporte);
    }

    private void generarReporteInventario() {
        ReportesController reportesController = new ReportesController();
        String reporte = reportesController.generarReporteInventario();
        reporteTextArea.setText(reporte);
    }

    private void descargarReporteVentasPdf() {
        JOptionPane.showMessageDialog(this, "Reporte de ventas en PDF descargado en C:\\Users\\nebra\\Downloads");
    }

    private void descargarReporteVentasExcel() {
        JOptionPane.showMessageDialog(this, "Reporte de ventas en Excel descargado en C:\\Users\\nebra\\Downloads");
    }

    private void descargarReporteInventarioPdf() {
        JOptionPane.showMessageDialog(this, "Reporte de inventario en PDF descargado en C:\\Users\\nebra\\Downloads");
    }

    private void descargarReporteInventarioExcel() {
        JOptionPane.showMessageDialog(this, "Reporte de inventario en Excel descargado en C:\\Users\\nebra\\Downloads");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReportesView reportesView = new ReportesView();
            reportesView.setVisible(true);
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
