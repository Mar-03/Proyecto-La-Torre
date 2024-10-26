/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
 */



import Model.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.ConexionDB;

public class DetalleVentaController {

    public void guardarDetalleVenta(DetalleVenta detalleVenta) {
        String sql = "INSERT INTO DetalleVenta (venta_id, producto_codigo, cantidad, precio) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detalleVenta.getVentaId());
            pstmt.setString(2, detalleVenta.getProductoCodigo());
            pstmt.setInt(3, detalleVenta.getCantidad());
            pstmt.setDouble(4, detalleVenta.getPrecio());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al guardar el detalle de venta: " + e.getMessage());
        }
    }

    public DetalleVenta obtenerDetalleVentaPorId(int id) {
        String sql = "SELECT * FROM DetalleVenta WHERE id = ?";
        DetalleVenta detalleVenta = null;
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                detalleVenta = new DetalleVenta();
                detalleVenta.setId(rs.getInt("id"));
                detalleVenta.setVentaId(rs.getInt("venta_id"));
                detalleVenta.setProductoCodigo(rs.getString("producto_codigo"));
                detalleVenta.setCantidad(rs.getInt("cantidad"));
                detalleVenta.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el detalle de venta: " + e.getMessage());
        }
        return detalleVenta;
    }
}
