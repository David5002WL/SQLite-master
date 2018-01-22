package com.example.david.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class ProfesorAdapter extends CursorAdapter {

    public ProfesorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        return LayoutInflater.from(context).inflate(R.layout.profesor, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Obtenemos los views
        TextView txtNombre = (TextView) view.findViewById(R.id.Nombre);
        TextView txtEdad = (TextView) view.findViewById(R.id.Edad);
        TextView txtCiclo = (TextView) view.findViewById(R.id.Ciclo);
        TextView txtCurso = (TextView) view.findViewById(R.id.Curso);
        TextView txtNota = (TextView) view.findViewById(R.id.NotaMedia);

        // Obtenemos la información del cursor
        String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombrep"));
        String edad = cursor.getString(cursor.getColumnIndexOrThrow("edadp"));
        String ciclo = cursor.getString(cursor.getColumnIndexOrThrow("ciclop"));
        String curso = cursor.getString(cursor.getColumnIndexOrThrow("cursop"));
        String despacho = cursor.getString(cursor.getColumnIndexOrThrow("despachop"));

        // Rellenamos los views con la información obtenida del cursor
        txtNombre.setText(nombre);
        txtEdad.setText(edad + " años");
        txtCiclo.setText("Ciclo: " + ciclo);
        txtCurso.setText("Curso: " + curso);
        txtNota.setText("Despacho: " + despacho);

    }
}