package com.example.notasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title;
    EditText description;
    Button cancel;
    Button save;
    int notaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Editar Nota");
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.editTextTituloUpdate);
        description = findViewById(R.id.editTextDescripcionUpdate);
        cancel = findViewById(R.id.btnCancelarUpdate);
        save = findViewById(R.id.btnGuardarUpdate);

        getData();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "No se ha editado la nota", Toast.LENGTH_SHORT).show();
                finish();

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarNota();
            }
        });

    }


    private void editarNota(){
        String titleNew = title.getText().toString();
        String descriptionNew = description.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("title",titleNew);
        intent.putExtra("descriptionNew", descriptionNew);
        if(notaId != -1){

            intent.putExtra("notsId", notaId);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void getData(){

        Intent i = getIntent();
        notaId = i.getIntExtra("id", -1);
        String noteTitle = i.getStringExtra("title");
        String noteDescription = i.getStringExtra("description");

        title.setText(noteTitle);
        description.setText(noteDescription);


    }
}