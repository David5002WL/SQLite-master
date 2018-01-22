package com.example.david.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class UserAdapter extends CursorAdapter {

    public UserAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        return LayoutInflater.from(context).inflate(R.layout.user, parent, false);
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
        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombree"));
        String edad = cursor.getString(cursor.getColumnIndexOrThrow("edade"));
        String ciclo = cursor.getString(cursor.getColumnIndexOrThrow("cicloe"));
        String curso = cursor.getString(cursor.getColumnIndexOrThrow("cursoe"));
        String nota = cursor.getString(cursor.getColumnIndexOrThrow("notamediae"));

        // Rellenamos los views con la información obtenida del cursor
        txtNombre.setText(nombre);
        txtEdad.setText(edad + " años");
        txtCiclo.setText("Ciclo: " + ciclo);
        txtCurso.setText("Curso: " + curso);
        txtNota.setText("Nota media: " + nota);

    }
}