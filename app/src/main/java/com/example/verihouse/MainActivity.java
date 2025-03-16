package com.example.verihouse;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.verihouse.data.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar la base de datos con datos de ejemplo
        DatabaseInitializer.populateAsync(this);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.navigation_cerca) {
                selectedFragment = new CercaFragment();
            } else if (itemId == R.id.navigation_favoritos) {
                selectedFragment = new FavoritosFragment();
            } else if (itemId == R.id.navigation_busqueda) {
                selectedFragment = new BusquedaFragment();
            } else if (itemId == R.id.navigation_perfil) {
                selectedFragment = new PerfilFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();
            }
            return true;
        });

        // Establecer el fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new CercaFragment())
                .commit();
        }
    }
} 