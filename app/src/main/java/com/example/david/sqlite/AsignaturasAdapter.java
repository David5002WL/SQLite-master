package com.example.david.sqlite;

        import android.content.Context;
        import android.database.Cursor;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.CursorAdapter;
        import android.widget.TextView;

public class AsignaturasAdapter extends CursorAdapter {

    public AsignaturasAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // The newView method is used to inflate a new view and return it,
        // you don't bind any data to the view at this point.
        return LayoutInflater.from(context).inflate(R.layout.asignaturas, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Obtenemos los views
        TextView txtNombre = (TextView) view.findViewById(R.id.Nombrea);
        TextView txtHoras = (TextView) view.findViewById(R.id.Horasa);

        // Obtenemos la información del cursor
        String id = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
        String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombrea"));
        String horas = cursor.getString(cursor.getColumnIndexOrThrow("horasa"));

        // Rellenamos los views con la información obtenida del cursor
        txtNombre.setText(nombre);
        txtHoras.setText("Horas: " + horas);

    }
}