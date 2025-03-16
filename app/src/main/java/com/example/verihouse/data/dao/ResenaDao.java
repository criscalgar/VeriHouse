package com.example.verihouse.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.verihouse.data.entity.Resena;
import java.util.List;

@Dao
public interface ResenaDao {
    @Query("SELECT * FROM resenas WHERE propiedadId = :propiedadId")
    List<Resena> getAllByPropiedad(int propiedadId);
    
    @Query("SELECT * FROM resenas WHERE usuarioId = :usuarioId")
    List<Resena> getAllByUsuario(int usuarioId);
    
    @Insert
    void insert(Resena resena);
    
    @Update
    void update(Resena resena);
    
    @Delete
    void delete(Resena resena);
} 