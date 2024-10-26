/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nebra
 */


import java.sql.Timestamp;

public class MovimientoInventario {
    private int id;
    private String productoCodigo;
    private int cantidad;
    private String usuario;
    private Timestamp fechaHora;
    private String motivo;

    // Constructor vacío
    public MovimientoInventario() {}

    // Constructor con parámetros
    public MovimientoInventario(String productoCodigo, int cantidad, String usuario, String motivo) {
        this.productoCodigo = productoCodigo;
        this.cantidad = cantidad;
        this.usuario = usuario;
        this.motivo = motivo;
        this.fechaHora = new Timestamp(System.currentTimeMillis());
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductoCodigo() {
        return productoCodigo;
    }

    public void setProductoCodigo(String productoCodigo) {
        this.productoCodigo = productoCodigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

