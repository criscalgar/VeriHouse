package com.example.verihouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.button.MaterialButton;

public class BusquedaFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busqueda, container, false);

        ChipGroup chipGroup = view.findViewById(R.id.chip_group);
        RangeSlider priceRangeSlider = view.findViewById(R.id.price_range_slider);
        MaterialButton btnHabitaciones = view.findViewById(R.id.btn_habitaciones);
        MaterialButton btnMasFiltros = view.findViewById(R.id.btn_mas_filtros);

        priceRangeSlider.addOnChangeListener((slider, value, fromUser) -> {
            // Manejar cambios en el rango de precios
        });

        btnHabitaciones.setOnClickListener(v -> {
            // Manejar clic en botón de habitaciones
        });

        btnMasFiltros.setOnClickListener(v -> {
            // Manejar clic en botón de más filtros
        });

        return view;
    }
} 