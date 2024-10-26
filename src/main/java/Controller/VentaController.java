/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
 */



import Model.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.ConexionDB;

public class VentaController {

    public int guardarVenta(Venta venta) {
        String sql = "INSERT INTO Venta (cliente_id, total, formaPago, recargo, impuestos, vendedor, fechaHora) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, venta.getClienteId());
            pstmt.setDouble(2, venta.getTotal());
            pstmt.setString(3, venta.getFormaPago());
            pstmt.setDouble(4, venta.getRecargo());
            pstmt.setDouble(5, venta.getImpuestos());
            pstmt.setString(6, venta.getVendedor());
            pstmt.setTimestamp(7, venta.getFechaHora());
            pstmt.executeUpdate();
            
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    venta.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la venta: " + e.getMessage());
        }
        return venta.getId();
    }

    public Venta obtenerVentaPorId(int id) {
        String sql = "SELECT * FROM Venta WHERE id = ?";
        Venta venta = null;
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt("id"));
                venta.setClienteId(rs.getInt("cliente_id"));
                venta.setTotal(rs.getDouble("total"));
                venta.setFormaPago(rs.getString("formaPago"));
                venta.setRecargo(rs.getDouble("recargo"));
                venta.setImpuestos(rs.getDouble("impuestos"));
                venta.setVendedor(rs.getString("vendedor"));
                venta.setFechaHora(rs.getTimestamp("fechaHora"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la venta: " + e.getMessage());
        }
        return venta;
    }
}



