package com.example.verihouse.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.verihouse.data.entity.Propiedad;
import java.util.List;

@Dao
public interface PropiedadDao {
    @Query("SELECT * FROM propiedades")
    List<Propiedad> getAll();
    
    @Query("SELECT * FROM propiedades WHERE tipo = :tipo")
    List<Propiedad> getAllByTipo(String tipo);
    
    @Insert
    void insert(Propiedad propiedad);
    
    @Update
    void update(Propiedad propiedad);
    
    @Delete
    void delete(Propiedad propiedad);
} 