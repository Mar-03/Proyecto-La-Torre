CREATE DATABASE SupermercadoLaTorre;
USE SupermercadoLaTorre;

CREATE TABLE Producto (
    codigo VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(100),
    categoria VARCHAR(100),
    imagen LONGBLOB,
    precioNormal DECIMAL(10, 2),
    precioPromocion DECIMAL(10, 2)
);
 
CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    contacto VARCHAR(100),
    correo varchar(100),
    direccion varchar(200)
);

CREATE TABLE Inventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_codigo VARCHAR(50),
    cantidad INT,
    FOREIGN KEY (producto_codigo) REFERENCES Producto(codigo)
);

CREATE TABLE MovimientoInventario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_codigo VARCHAR(50),
    cantidad INT,
    usuario VARCHAR(100),
    fechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    motivo VARCHAR(255),
    FOREIGN KEY (producto_codigo) REFERENCES Producto(codigo)
);


CREATE TABLE Venta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    total DECIMAL(10, 2),
    formaPago ENUM('efectivo', 'tarjeta'),
    recargo DECIMAL(10, 2) DEFAULT 0,
    impuestos DECIMAL(10, 2),
    vendedor VARCHAR(100),
    fechaHora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE DetalleVenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    venta_id INT,
    producto_codigo VARCHAR(50),
    cantidad INT,
    precio DECIMAL(10, 2),
    FOREIGN KEY (venta_id) REFERENCES Venta(id),
    FOREIGN KEY (producto_codigo) REFERENCES Producto(codigo)
);

CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    rol ENUM('vendedor', 'supervisor') NOT NULL
);

INSERT INTO Usuario (nombre, username, password, rol) VALUES
('Admin User', 'admin', '1234', 'supervisor'),
('Vendedor User', 'vendedor', '1234', 'vendedor');

ALTER TABLE producto
ADD COLUMN direccion varchar(200);