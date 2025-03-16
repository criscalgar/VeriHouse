package com.example.verihouse.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.verihouse.data.entity.Propiedad;
import com.example.verihouse.data.entity.Usuario;
import com.example.verihouse.data.entity.Resena;
import com.example.verihouse.data.dao.PropiedadDao;
import com.example.verihouse.data.dao.UsuarioDao;
import com.example.verihouse.data.dao.ResenaDao;

@Database(
    entities = {Propiedad.class, Usuario.class, Resena.class}, 
    version = 2,
    exportSchema = false
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    
    public abstract PropiedadDao propiedadDao();
    public abstract UsuarioDao usuarioDao();
    public abstract ResenaDao resenaDao();
    
    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class,
                "verihouse_db")
                .fallbackToDestructiveMigration()
                .build();
        }
        return instance;
    }
} 