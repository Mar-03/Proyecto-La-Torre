/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author nebra
 */



import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utilidades.ConexionDB;

public class ProductoController {

    public void crearProducto(Producto producto) {
        String sql = "INSERT INTO Producto (codigo, nombre, categoria, imagen, precioNormal, precioPromocion) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getCodigo());
            pstmt.setString(2, producto.getNombre());
            pstmt.setString(3, producto.getCategoria());
            pstmt.setBytes(4, producto.getImagen());
            pstmt.setDouble(5, producto.getPrecioNormal());
            pstmt.setDouble(6, producto.getPrecioPromocion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al crear el producto: " + e.getMessage());
        }
    }
    public Producto obtenerProductoPorCodigo(String codigo) {
        String sql = "SELECT * FROM Producto WHERE codigo = ?";
        Producto producto = null;
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setCodigo(rs.getString("codigo"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setImagen(rs.getBytes("imagen"));
                producto.setPrecioNormal(rs.getDouble("precioNormal"));
                producto.setPrecioPromocion(rs.getDouble("precioPromocion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e.getMessage());
        }
        return producto;
    }
    public void actualizarProducto(Producto producto) {
        String sql = "UPDATE Producto SET nombre = ?, categoria = ?, imagen = ?, precioNormal = ?, precioPromocion = ? WHERE codigo = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getCategoria());
            pstmt.setBytes(3, producto.getImagen());
            pstmt.setDouble(4, producto.getPrecioNormal());
            pstmt.setDouble(5, producto.getPrecioPromocion());
            pstmt.setString(6, producto.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e.getMessage());
        }
    }

    public void eliminarProducto(String codigo) {
        String sql = "DELETE FROM Producto WHERE codigo = ?";
        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }
    }
}


