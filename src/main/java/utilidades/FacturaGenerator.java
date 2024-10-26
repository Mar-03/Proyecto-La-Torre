/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author nebra
 */


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import Model.DetalleVenta;
import Model.Venta;

public class FacturaGenerator {

    public static void generarFactura(Venta venta, List<DetalleVenta> detallesVenta) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\nebra\\Downloads\\factura_" + venta.getId() + ".pdf"));
            document.open();
            document.add(new Paragraph("Factura de Venta\n\n"));
            document.add(new Paragraph("ID Venta: " + venta.getId()));
            document.add(new Paragraph("Cliente ID: " + venta.getClienteId()));
            document.add(new Paragraph("Total: " + venta.getTotal()));
            document.add(new Paragraph("Forma de Pago: " + venta.getFormaPago()));
            document.add(new Paragraph("Recargo: " + venta.getRecargo()));
            document.add(new Paragraph("Impuestos: " + venta.getImpuestos()));
            document.add(new Paragraph("Vendedor: " + venta.getVendedor()));
            document.add(new Paragraph("Fecha y Hora: " + venta.getFechaHora() + "\n\n"));

            document.add(new Paragraph("Detalles de la Venta:\n"));
            for (DetalleVenta detalle : detallesVenta) {
                document.add(new Paragraph("Producto Código: " + detalle.getProductoCodigo()));
                document.add(new Paragraph("Cantidad: " + detalle.getCantidad()));
                document.add(new Paragraph("Precio: " + detalle.getPrecio() + "\n"));
            }

            document.close();
        } catch (DocumentException | IOException e) {
            System.out.println("Error al generar la factura: " + e.getMessage());
        }
    }
}


