package com.example.verihouse.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "propiedades")
public class Propiedad {
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    private String titulo;
    private String descripcion;
    private double precio;
    private String tipo; // VENTA, ALQUILER
    private int habitaciones;
    private int banos;
    private double metros;
    private String direccion;
    private String ciudad;
    private double latitud;
    private double longitud;
    private int propietarioId;
    private String[] imagenes;

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public int getHabitaciones() { return habitaciones; }
    public void setHabitaciones(int habitaciones) { this.habitaciones = habitaciones; }
    
    public int getBanos() { return banos; }
    public void setBanos(int banos) { this.banos = banos; }
    
    public double getMetros() { return metros; }
    public void setMetros(double metros) { this.metros = metros; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
    
    public int getPropietarioId() { return propietarioId; }
    public void setPropietarioId(int propietarioId) { this.propietarioId = propietarioId; }
    
    public String[] getImagenes() { return imagenes; }
    public void setImagenes(String[] imagenes) { this.imagenes = imagenes; }
} 