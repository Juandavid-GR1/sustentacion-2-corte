package com.sustentacion.cerveza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cerveceria")
public class Cerveza{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Column(name ="nombre cerveceria")
private String nombre_cerveceria;

@Column(name="departamento")
private String departamento;

@Column(name = "municipio")
private String municipio;

@Column(name = "Direccion")
private String direccion;

@Column(name="marca")
private String marca;

@Column(name="cantidad en stock")
private String stock;

public Cerveza(String nombre_cerveceria, String departamento, String municipio, String direccion, String marca,
        String stock) {
    this.nombre_cerveceria = nombre_cerveceria;
    this.departamento = departamento;
    this.municipio = municipio;
    this.direccion = direccion;
    this.marca = marca;
    this.stock = stock;
}

public Cerveza(){

}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre_cerveceria() {
    return nombre_cerveceria;
}

public void setNombre_cerveceria(String nombre_cerveceria) {
    this.nombre_cerveceria = nombre_cerveceria;
}

public String getDepartamento() {
    return departamento;
}

public void setDepartamento(String departamento) {
    this.departamento = departamento;
}

public String getMunicipio() {
    return municipio;
}

public void setMunicipio(String municipio) {
    this.municipio = municipio;
}

public String getDireccion() {
    return direccion;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public String getMarca() {
    return marca;
}

public void setMarca(String marca) {
    this.marca = marca;
}

public String getStock() {
    return stock;
}

public void setStock(String stock) {
    this.stock = stock;
}

@Override
public String toString() {
    return "Cerveza [id=" + id + ", nombre_cerveceria=" + nombre_cerveceria + ", departamento=" + departamento
            + ", municipio=" + municipio + ", direccion=" + direccion + ", marca=" + marca + ", stock=" + stock + "]";
}

}