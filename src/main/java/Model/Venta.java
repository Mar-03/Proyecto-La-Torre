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

public class Venta {
    private int id;
    private int clienteId;
    private double total;
    private String formaPago;
    private double recargo;
    private double impuestos;
    private String vendedor;
    private Timestamp fechaHora;

    // Constructor vacío
    public Venta() {}

    // Constructor con parámetros
    public Venta(int clienteId, double total, String formaPago, double impuestos, String vendedor) {
        this.clienteId = clienteId;
        this.total = total;
        this.formaPago = formaPago;
        this.impuestos = impuestos;
        this.vendedor = vendedor;
        this.fechaHora = new Timestamp(System.currentTimeMillis());

        if (formaPago.equals("tarjeta")) {
            this.recargo = total * 0.05;  // Suponiendo un recargo del 5%
            this.total += this.recargo;
        } else {
            this.recargo = 0;
        }
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getRecargo() {
        return recargo;
    }

    public void setRecargo(double recargo) {
        this.recargo = recargo;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
}

