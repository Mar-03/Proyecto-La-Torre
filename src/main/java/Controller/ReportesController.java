/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
 */



import utilidades.ConexionDB;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReportesController {

    public String generarReporteVentas() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Ventas\n\n");
        String sql = "SELECT * FROM Venta";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Reporte de Ventas");
            int rowIndex = 0;
            Row headerRow = sheet.createRow(rowIndex++);
            String[] headers = {"ID Venta", "Cliente ID", "Total", "Forma de Pago", "Recargo", "Impuestos", "Vendedor", "Fecha y Hora"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            while (rs.next()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rs.getInt("id"));
                row.createCell(1).setCellValue(rs.getInt("cliente_id"));
                row.createCell(2).setCellValue(rs.getDouble("total"));
                row.createCell(3).setCellValue(rs.getString("formaPago"));
                row.createCell(4).setCellValue(rs.getDouble("recargo"));
                row.createCell(5).setCellValue(rs.getDouble("impuestos"));
                row.createCell(6).setCellValue(rs.getString("vendedor"));
                row.createCell(7).setCellValue(rs.getTimestamp("fechaHora").toString());

                reporte.append("ID Venta: ").append(rs.getInt("id")).append("\n");
                reporte.append("Cliente ID: ").append(rs.getInt("cliente_id")).append("\n");
                reporte.append("Total: ").append(rs.getDouble("total")).append("\n");
                reporte.append("Forma de Pago: ").append(rs.getString("formaPago")).append("\n");
                reporte.append("Recargo: ").append(rs.getDouble("recargo")).append("\n");
                reporte.append("Impuestos: ").append(rs.getDouble("impuestos")).append("\n");
                reporte.append("Vendedor: ").append(rs.getString("vendedor")).append("\n");
                reporte.append("Fecha y Hora: ").append(rs.getTimestamp("fechaHora")).append("\n\n");
            }

            // Guardar el reporte como archivo de texto
            try (FileWriter fileWriter = new FileWriter("C:\\Users\\nebra\\Downloads\\reporte_ventas.txt")) {
                fileWriter.write(reporte.toString());
            }

            // Guardar el reporte como archivo PDF
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\nebra\\Downloads\\reporte_ventas.pdf"));
                document.open();
                document.add(new Paragraph(reporte.toString()));
            } catch (DocumentException e) {
                System.out.println("Error al generar el PDF: " + e.getMessage());
            } finally {
                document.close();
            }

            // Guardar el reporte como archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\nebra\\Downloads\\reporte_ventas.xlsx")) {
                workbook.write(fileOut);
            }
            workbook.close();
            
        } catch (SQLException | IOException e) {
            System.out.println("Error al generar el reporte de ventas: " + e.getMessage());
        }
        return reporte.toString();
    }
    
    public String generarReporteInventario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Inventario\n\n");
        String sql = "SELECT * FROM Inventario";
        
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Reporte de Inventario");
            int rowIndex = 0;
            Row headerRow = sheet.createRow(rowIndex++);
            String[] headers = {"ID Inventario", "Producto Código", "Cantidad"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            while (rs.next()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(rs.getInt("id"));
                row.createCell(1).setCellValue(rs.getString("producto_codigo"));
                row.createCell(2).setCellValue(rs.getInt("cantidad"));

                reporte.append("ID Inventario: ").append(rs.getInt("id")).append("\n");
                reporte.append("Producto Código: ").append(rs.getString("producto_codigo")).append("\n");
                reporte.append("Cantidad: ").append(rs.getInt("cantidad")).append("\n\n");
            }

            // Guardar el reporte como archivo de texto
            try (FileWriter fileWriter = new FileWriter("C:\\Users\\nebra\\Downloads\\reporte_inventario.txt")) {
                fileWriter.write(reporte.toString());
            }

            // Guardar el reporte como archivo PDF
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\nebra\\Downloads\\reporte_inventario.pdf"));
                document.open();
                document.add(new Paragraph(reporte.toString()));
            } catch (DocumentException e) {
                System.out.println("Error al generar el PDF: " + e.getMessage());
            } finally {
                document.close();
            }

            // Guardar el reporte como archivo Excel
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\nebra\\Downloads\\reporte_inventario.xlsx")) {
                workbook.write(fileOut);
            }
            workbook.close();
            
        } catch (SQLException | IOException e) {
            System.out.println("Error al generar el reporte de inventario: " + e.getMessage());
        }
        return reporte.toString();
    }
}




