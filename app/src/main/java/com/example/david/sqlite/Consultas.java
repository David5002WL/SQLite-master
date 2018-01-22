package com.example.david.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Consultas extends AppCompatActivity {

    private Button verTodosAlumnos, verTodosProfesores, verCiclos, verTodasAsignaturas;
    private ListView listaConsultas;
    private MyDBAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        dbAdapter = new MyDBAdapter(this);
        dbAdapter.open();

        verTodosAlumnos = (Button) findViewById(R.id.botonConsultaTodosAlumnos);
        verTodosProfesores = (Button) findViewById(R.id.botonConsultaTodosProfesores);

        //Declaramos el boton
        verTodasAsignaturas = (Button) findViewById(R.id.botonConsultaAsignaturas);
        //verCiclos = (Button) findViewById(R.id.botonConsultaCiclos);

        listaConsultas = (ListView) findViewById(R.id.ListView);


        verTodosAlumnos.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                Cursor cursor1 = dbAdapter.recuperarTodoE();

                UserAdapter user = new UserAdapter(Consultas.this, cursor1);
                listaConsultas.setAdapter(user);


            }
        });

        verTodosProfesores.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                Cursor cursor2 = dbAdapter.recuperarTodoP();

                ProfesorAdapter profesor = new ProfesorAdapter(Consultas.this, cursor2);
                listaConsultas.setAdapter(profesor);


            }
        });

        /*verCiclos.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                Cursor cursor3 = dbAdapter.recuperarEstudiantesCiclo("Dam");

                UserAdapter user = new UserAdapter(Consultas.this, cursor3);

                listaConsultas.setAdapter(user);


            }
        });
        */

        //Consulta para ver todas las asignaturas
        verTodasAsignaturas.setOnClickListener(new View.OnClickListener(){

            public void onClick (View v){

                Cursor cursor1 = dbAdapter.recuperarTodoA();

                AsignaturasAdapter asignaturas = new AsignaturasAdapter(Consultas.this, cursor1);
                listaConsultas.setAdapter(asignaturas);

            }
        });
        //
    }
}
