/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
 */


import Model.MovimientoInventario;
import utilidades.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovimientoInventarioController {

    public void registrarMovimientoInventario(MovimientoInventario movimiento) {
        String sql = "INSERT INTO MovimientoInventario (producto_codigo, cantidad, usuario, fechaHora, motivo) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movimiento.getProductoCodigo());
            pstmt.setInt(2, movimiento.getCantidad());
            pstmt.setString(3, movimiento.getUsuario());
            pstmt.setString(4, movimiento.getMotivo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al registrar el movimiento de inventario: " + e.getMessage());
        }
    }

    public List<MovimientoInventario> obtenerMovimientosPorProductoCodigo(String productoCodigo) {
        String sql = "SELECT * FROM MovimientoInventario WHERE producto_codigo = ?";
        List<MovimientoInventario> movimientos = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productoCodigo);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                MovimientoInventario movimiento = new MovimientoInventario();
                movimiento.setId(rs.getInt("id"));
                movimiento.setProductoCodigo(rs.getString("producto_codigo"));
                movimiento.setCantidad(rs.getInt("cantidad"));
                movimiento.setUsuario(rs.getString("usuario"));
                movimiento.setFechaHora(rs.getTimestamp("fechaHora"));
                movimiento.setMotivo(rs.getString("motivo"));
                movimientos.add(movimiento);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los movimientos de inventario: " + e.getMessage());
        }
        return movimientos;
    }

    public void eliminarMovimientosPorProductoCodigo(String productoCodigo) {
        String sql = "DELETE FROM MovimientoInventario WHERE producto_codigo = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, productoCodigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar los movimientos de inventario: " + e.getMessage());
        }
    }
}
