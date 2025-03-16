package com.example.verihouse.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.verihouse.data.entity.Usuario;
import java.util.List;

@Dao
public interface UsuarioDao {
    @Query("SELECT * FROM usuarios")
    List<Usuario> getAll();
    
    @Query("SELECT * FROM usuarios WHERE email = :email")
    Usuario findByEmail(String email);
    
    @Insert
    void insert(Usuario usuario);
    
    @Update
    void update(Usuario usuario);
    
    @Delete
    void delete(Usuario usuario);
} 