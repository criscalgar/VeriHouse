package com.example.verihouse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PerfilFragment extends Fragment {

    private ImageView profileImage;
    private EditText etName, etLastName, etUsername, etEmail, etGender, etLocation, etPhone, etBirthDate;
    private Button btnChangePhoto, btnSaveProfile, btnLogout, btnEditProfile;

    private boolean isEditing = false; // Para controlar el modo edición

    private final ActivityResultLauncher<Intent> imagePickerLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {
                        if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                            Uri selectedImageUri = result.getData().getData();
                            if (selectedImageUri != null) {
                                profileImage.setImageURI(selectedImageUri);
                            }
                        }
                    }
            );

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        profileImage = view.findViewById(R.id.profileImage);
        btnEditProfile = view.findViewById(R.id.btnEditProfile); // Nuevo botón de edición
        btnChangePhoto = view.findViewById(R.id.btnChangePhoto);
        etName = view.findViewById(R.id.etName);
        etLastName = view.findViewById(R.id.etLastName);
        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etGender = view.findViewById(R.id.etGender);
        etLocation = view.findViewById(R.id.etLocation);
        etPhone = view.findViewById(R.id.etPhone);
        etBirthDate = view.findViewById(R.id.etBirthDate);
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile);
        btnLogout = view.findViewById(R.id.btnLogout);

        // Deshabilitar campos al inicio
        setFieldsEditable(false);

        btnChangePhoto.setOnClickListener(v -> openGallery());
        btnSaveProfile.setOnClickListener(v -> saveProfile());
        btnLogout.setOnClickListener(v -> logout());
        btnEditProfile.setOnClickListener(v -> toggleEditMode());

        loadUserProfile();
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        imagePickerLauncher.launch(intent);
    }

    private void saveProfile() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name", etName.getText().toString());
        editor.putString("lastName", etLastName.getText().toString());
        editor.putString("username", etUsername.getText().toString());
        editor.putString("email", etEmail.getText().toString());
        editor.putString("gender", etGender.getText().toString());
        editor.putString("location", etLocation.getText().toString());
        editor.putString("phone", etPhone.getText().toString());
        editor.putString("birthDate", etBirthDate.getText().toString());

        editor.apply();

        Toast.makeText(getContext(), "Perfil guardado", Toast.LENGTH_SHORT).show();

        isEditing = false;
        setFieldsEditable(false);

        btnSaveProfile.setVisibility(View.GONE); // Ocultar botón Guardar Cambios
        btnEditProfile.setVisibility(View.VISIBLE); // Mostrar botón Editar Perfil
    }


    private void loadUserProfile() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Activity.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        etName.setText(sharedPreferences.getString("name", "Admin"));
        etLastName.setText(sharedPreferences.getString("lastName", "Admin"));
        etUsername.setText(sharedPreferences.getString("username", "admin"));
        etEmail.setText(sharedPreferences.getString("email", "admin@example.com"));
        etGender.setText(sharedPreferences.getString("gender", "Femenino"));
        etLocation.setText(sharedPreferences.getString("location", "Sevilla, España"));
        etPhone.setText(sharedPreferences.getString("phone", "+34 600 123 456"));
        etBirthDate.setText(sharedPreferences.getString("birthDate", "01/01/2000"));

        // Bloquear los campos al cargar datos
        setFieldsEditable(false);
    }

    private void logout() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserProfile", Activity.MODE_PRIVATE);
        sharedPreferences.edit().clear().apply();
        Toast.makeText(getContext(), "Sesión cerrada", Toast.LENGTH_SHORT).show();
    }

    private void toggleEditMode() {
        isEditing = !isEditing;
        setFieldsEditable(isEditing);

        if (isEditing) {
            btnSaveProfile.setVisibility(View.VISIBLE); // Mostrar botón de Guardar Cambios
            btnEditProfile.setVisibility(View.GONE);    // Ocultar botón de Editar Perfil
        } else {
            btnSaveProfile.setVisibility(View.GONE); // Ocultar botón de Guardar Cambios
            btnEditProfile.setVisibility(View.VISIBLE); // Mostrar botón de Editar Perfil
        }
    }


    private void setFieldsEditable(boolean editable) {
        etName.setEnabled(editable);
        etLastName.setEnabled(editable);
        etUsername.setEnabled(editable);
        etEmail.setEnabled(editable);
        etGender.setEnabled(editable);
        etLocation.setEnabled(editable);
        etPhone.setEnabled(editable);
    }
}
