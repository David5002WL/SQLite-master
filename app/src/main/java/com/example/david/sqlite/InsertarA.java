package com.example.david.sqlite;

import android.content.Intent;
import android.graphics.drawable.InsetDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertarA extends AppCompatActivity {


    private MyDBAdapter dbAdapter;
    private EditText nombrea, horasa;
    private Button botonAgregara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_a);

        nombrea = (EditText) findViewById(R.id.editNombrea);
        horasa = (EditText) findViewById(R.id.editHorasa);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        botonAgregara = (Button) findViewById(R.id.botonAgregara);


        botonAgregara.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                dbAdapter.insertarAsignaturas(nombrea.getText().toString() , horasa.getText().toString());

                Toast.makeText(getApplicationContext(),"Asignatura Añadida", Toast.LENGTH_SHORT).show();

                Intent intent =  new Intent(InsertarA.this, Principal.class);
                startActivity(intent);

            }
        });

    }
}
