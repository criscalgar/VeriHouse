package com.example.verihouse.data.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "resenas",
        indices = {
            @Index("propiedadId"),
            @Index("usuarioId")
        },
        foreignKeys = {
            @ForeignKey(entity = Propiedad.class,
                    parentColumns = "id",
                    childColumns = "propiedadId"),
            @ForeignKey(entity = Usuario.class,
                    parentColumns = "id",
                    childColumns = "usuarioId")
        })
public class Resena {
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    private int propiedadId;
    private int usuarioId;
    private String comentario;
    private float puntuacion;
    private long fecha;
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getPropiedadId() { return propiedadId; }
    public void setPropiedadId(int propiedadId) { this.propiedadId = propiedadId; }
    
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
    
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    
    public float getPuntuacion() { return puntuacion; }
    public void setPuntuacion(float puntuacion) { this.puntuacion = puntuacion; }
    
    public long getFecha() { return fecha; }
    public void setFecha(long fecha) { this.fecha = fecha; }
} 