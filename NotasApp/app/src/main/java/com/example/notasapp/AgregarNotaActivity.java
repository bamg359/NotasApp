package com.example.notasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarNotaActivity extends AppCompatActivity {

    EditText title;
    EditText description;
    Button cancel;
    Button save;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        title = findViewById(R.id.editTextTitulo);
        description = findViewById(R.id.editTextDescripcion);
        cancel = findViewById(R.id.btnCancelar);
        save = findViewById(R.id.btnGuardar);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No se ha guardado la nota", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guardarNota();

            }
        });


    }

    public void guardarNota(){

        String tituloNota = title.getText().toString();
        String descriptionNota = description.getText().toString();


        Intent i = new Intent();
        i.putExtra("tituloNota", tituloNota);
        i.putExtra("descripcionNota", descriptionNota);
        setResult(RESULT_OK, i);
        finish();



    }

}






