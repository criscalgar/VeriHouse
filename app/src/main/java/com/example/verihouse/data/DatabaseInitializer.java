package com.example.verihouse.data;

import android.content.Context;
import android.os.AsyncTask;
import com.example.verihouse.data.entity.Propiedad;

public class DatabaseInitializer {
    public static void populateAsync(Context context) {
        AsyncTask.execute(() -> {
            AppDatabase db = AppDatabase.getInstance(context);
            if (db.propiedadDao().getAll().isEmpty()) {
                populatePropiedades(db);
            }
        });
    }

    private static void populatePropiedades(AppDatabase db) {
        Propiedad p1 = new Propiedad();
        p1.setTitulo("Ático de lujo en el centro");
        p1.setDescripcion("Espectacular ático con terraza panorámica, acabados de lujo, 3 habitaciones, 2 baños completos y cocina equipada.");
        p1.setPrecio(450000);
        p1.setTipo("VENTA");
        p1.setHabitaciones(3);
        p1.setBanos(2);
        p1.setMetros(120);
        p1.setCiudad("Madrid");
        p1.setDireccion("Calle Gran Vía, 50");

        Propiedad p2 = new Propiedad();
        p2.setTitulo("Apartamento moderno cerca del metro");
        p2.setDescripcion("Apartamento reformado, luminoso, 2 habitaciones, 1 baño, cocina americana y plaza de garaje.");
        p2.setPrecio(1200);
        p2.setTipo("ALQUILER");
        p2.setHabitaciones(2);
        p2.setBanos(1);
        p2.setMetros(75);
        p2.setCiudad("Barcelona");
        p2.setDireccion("Avenida Diagonal, 300");

        Propiedad p3 = new Propiedad();
        p3.setTitulo("Chalet con piscina");
        p3.setDescripcion("Impresionante chalet con jardín, piscina, 4 habitaciones, 3 baños, garaje para 2 coches y zona barbacoa.");
        p3.setPrecio(750000);
        p3.setTipo("VENTA");
        p3.setHabitaciones(4);
        p3.setBanos(3);
        p3.setMetros(300);
        p3.setCiudad("Valencia");
        p3.setDireccion("Calle del Mar, 123");

        Propiedad p4 = new Propiedad();
        p4.setTitulo("Estudio céntrico amueblado");
        p4.setDescripcion("Acogedor estudio totalmente amueblado, ideal para estudiantes, cocina equipada y baño completo.");
        p4.setPrecio(650);
        p4.setTipo("ALQUILER");
        p4.setHabitaciones(1);
        p4.setBanos(1);
        p4.setMetros(40);
        p4.setCiudad("Sevilla");
        p4.setDireccion("Plaza Nueva, 15");

        Propiedad p5 = new Propiedad();
        p5.setTitulo("Dúplex con vistas al mar");
        p5.setDescripcion("Espectacular dúplex en primera línea de playa, 3 habitaciones, 2 baños, terraza con vistas al mar.");
        p5.setPrecio(350000);
        p5.setTipo("VENTA");
        p5.setHabitaciones(3);
        p5.setBanos(2);
        p5.setMetros(150);
        p5.setCiudad("Málaga");
        p5.setDireccion("Paseo Marítimo, 78");

        db.propiedadDao().insert(p1);
        db.propiedadDao().insert(p2);
        db.propiedadDao().insert(p3);
        db.propiedadDao().insert(p4);
        db.propiedadDao().insert(p5);
    }
} 