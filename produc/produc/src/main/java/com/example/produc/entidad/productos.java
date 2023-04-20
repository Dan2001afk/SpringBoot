package com.example.produc.entidad;

public class productos {
    private int codigo;
    private String nombre;
    private String categoria;
    private int precio;
    private double cantidad;

    public productos(int codigo, String nombre, String categoria, int precio, double cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = String.valueOf(categoria);
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getStock() {
        return 0;
    }
}
