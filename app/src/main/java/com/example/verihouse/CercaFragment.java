package com.example.verihouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import com.example.verihouse.data.AppDatabase;
import com.example.verihouse.data.entity.Propiedad;
import java.util.List;
import android.os.AsyncTask;

public class CercaFragment extends Fragment {
    private LinearLayout containerLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cerca, container, false);
        containerLayout = view.findViewById(R.id.container_propiedades);
        cargarPropiedades();
        return view;
    }

    private void cargarPropiedades() {
        AsyncTask.execute(() -> {
            AppDatabase db = AppDatabase.getInstance(requireContext());
            List<Propiedad> propiedades = db.propiedadDao().getAll();
            
            requireActivity().runOnUiThread(() -> {
                for (Propiedad propiedad : propiedades) {
                    agregarTarjetaPropiedad(propiedad);
                }
            });
        });
    }

    private void agregarTarjetaPropiedad(Propiedad propiedad) {
        View cardView = getLayoutInflater().inflate(R.layout.item_propiedad, containerLayout, false);
        
        TextView titulo = cardView.findViewById(R.id.texto_titulo);
        //TextView descripcion = cardView.findViewById(R.id.texto_descripcion);
        TextView precio = cardView.findViewById(R.id.texto_precio);
        TextView detalles = cardView.findViewById(R.id.texto_detalles);

        titulo.setText(propiedad.getTitulo());
        //descripcion.setText(propiedad.getDescripcion());
        precio.setText(String.format("%,d €", (int)propiedad.getPrecio()));
        detalles.setText(String.format("%d hab · %d baños · %d m²", 
            propiedad.getHabitaciones(), 
            propiedad.getBanos(), 
            (int)propiedad.getMetros()));

        containerLayout.addView(cardView);
    }
} 