/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
*/


import Model.Inventario;
import utilidades.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioController {

    public void crearInventario(Inventario inventario) {
        String sql = "INSERT INTO Inventario (producto_codigo, cantidad) VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, inventario.getProductoCodigo());
            pstmt.setInt(2, inventario.getCantidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al crear el inventario: " + e.getMessage());
        }
    }
    public Inventario obtenerInventarioPorCodigoProducto(String productoCodigo) {
        String sql = "SELECT * FROM Inventario WHERE producto_codigo = ?";
        Inventario inventario = null;
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productoCodigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                inventario = new Inventario();
                inventario.setId(rs.getInt("id"));
                inventario.setProductoCodigo(rs.getString("producto_codigo"));
                inventario.setCantidad(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el inventario: " + e.getMessage());
        }
        return inventario;
    }
    public void actualizarInventario(Inventario inventario) {
        String sql = "UPDATE Inventario SET cantidad = ? WHERE producto_codigo = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, inventario.getCantidad());
            pstmt.setString(2, inventario.getProductoCodigo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el inventario: " + e.getMessage());
        }
    }

    public void eliminarInventarioPorCodigoProducto(String productoCodigo) {
        String sql = "DELETE FROM Inventario WHERE producto_codigo = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productoCodigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el inventario: " + e.getMessage());
        }
    }
}



