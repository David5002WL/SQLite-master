package com.example.david.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "dbcolegio.db";
    private static final String DATABASE_TABLEe = "estudiantes";
    private static final String DATABASE_TABLEp = "profesores";

    //Le damos nombre a la tabla asignaturas
    private static final String DATABASE_TABLEa = "asignaturas";
    //
    private static final int DATABASE_VERSION = 1;

    private static final String ID = "_id";

    private static final String NOMBREe = "nombree";
    private static final String EDADe = "edade";
    private static final String CICLOe = "cicloe";
    private static final String CURSOe = "cursoe";
    private static final String NOTAMEDIAe = "notamediae";

    private static final String NOMBREp = "nombrep";
    private static final String EDADp = "edadp";
    private static final String CICLOp = "ciclop";
    private static final String CURSOp = "cursop";
    private static final String DESPACHOp = "despachop";

    //Creamos los componentes de la tabla
    private static final String NOMBREa = "nombrea";
    private static final String HORASa = "horasa";
    //

    private static final String DATABASE_CREATEe = "CREATE TABLE "+DATABASE_TABLEe+" (_id integer primary key autoincrement, nombree text, edade text, cicloe text, cursoe text, notamediae text);";
    private static final String DATABASE_DROPe = "DROP TABLE IF EXISTS "+DATABASE_TABLEe+";";

    private static final String DATABASE_CREATEp = "CREATE TABLE "+DATABASE_TABLEp+" (_id integer primary key autoincrement, nombrep text, edadp text, ciclop text, cursop text, despachop integer);";
    private static final String DATABASE_DROPp = "DROP TABLE IF EXISTS "+DATABASE_TABLEp+";";

    //Creamos la tabla asignaturas
    private static final String DATABASE_CREATEa = "CREATE TABLE "+DATABASE_TABLEa+" (_id integer primary key autoincrement, nombrea text, horasa text);";
    private static final String DATABASE_DROPa = "DROP TABLE IF EXISTS "+DATABASE_TABLEa+";";
    //

    // Queries
    private static String[] camposTabla;
    private static String where;
    private static String[] argsWhere;
    private static String groupBy;
    private static String having;
    private static String orderBy;

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        //OJO open();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    /*public void cargarDatosPrueba() {
        // Cargamos alumnos
        db.execSQL("INSERT INTO "+DATABASE_TABLEe+" (nombree,edade,cicloe,cursoe,notamediae) VALUES " +
                "('Borrull','20','DAM','1','7')");

        // Cargamos profesores
        db.execSQL("INSERT INTO "+DATABASE_TABLEp+" (nombrep,edadp,ciclop,cursop,despachop) VALUES " +
                "('Belen','20','DAM','1','1A')");
    }*/

    public void insertarEstudiante(String nombree, String edade, String cicloe, String cursoe, String notamediae){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBREe,nombree);
        newValues.put(EDADe,edade);
        newValues.put(CICLOe,cicloe);
        newValues.put(CURSOe,cursoe);
        newValues.put(NOTAMEDIAe,notamediae);
        db.insert(DATABASE_TABLEe,null,newValues);
    }

    public void insertarProfesor(String nombrep, String edadp, String ciclop, String cursop, String despachop){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBREp,nombrep);
        newValues.put(EDADp,edadp);
        newValues.put(CICLOp,ciclop);
        newValues.put(CURSOp,cursop);
        newValues.put(DESPACHOp,despachop);
        db.insert(DATABASE_TABLEp,null,newValues);
    }

    //Metodo para insertar asignaturas
    public void insertarAsignaturas(String nombrea, String horasa){
        //Creamos un nuevo registro de valores a insertar
        ContentValues newValues = new ContentValues();
        //Asignamos los valores de cada campo
        newValues.put(NOMBREa,nombrea);
        newValues.put(HORASa,horasa);
        db.insert(DATABASE_TABLEa,null,newValues);
    }
    //

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATEe);
            db.execSQL(DATABASE_CREATEp);
            db.execSQL(DATABASE_CREATEa);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROPe);
            db.execSQL(DATABASE_DROPp);
            db.execSQL(DATABASE_DROPa);
            onCreate(db);
        }

    }

    public void borrarDB() {
        dbHelper.onUpgrade(db, DATABASE_VERSION, DATABASE_VERSION);
    }

    public void eliminarEstudiante(String row) {

        /*String[] args = new String[]{row};
        db.execSQL("DELETE FROM estudiantes WHERE nombree=?", args);*/
        //db.delete(DATABASE_TABLEe, where, args);

        where = "nombree=?";
        argsWhere = new String[]{String.valueOf(row) };
        db.delete(DATABASE_TABLEe, where, argsWhere);
    }

    public void eliminarProfesor(int row) {
        where = "nombrep=?";
        argsWhere = new String[]{String.valueOf(row) };
        db.delete(DATABASE_TABLEp, where, argsWhere);
    }


    public Cursor recuperarTodoE(){

        //Recuperamos en un cursor la consulta realizada
        Cursor cursor1 = db.query(DATABASE_TABLEe,null,null,null,null,null,null);


        return cursor1;
    }

    public Cursor recuperarTodoP(){

        //Recuperamos en un cursor la consulta realizada
        Cursor cursor2 = db.query(DATABASE_TABLEp,null,null,null,null,null,null);


        return cursor2;
    }


    public Cursor recuperarEstudiantesCiclo(String ciclo) {
        camposTabla = null;
        where = CICLOe+"=?";
        argsWhere = new String[]{ciclo};
        groupBy = null;
        having = null;
        orderBy = "nombree ASC";

        Cursor cursor = db.query(DATABASE_TABLEe, camposTabla, where, argsWhere, groupBy, having, orderBy);
        return cursor;
    }

    //Metodo para buscar todas las asignaturas
    public Cursor recuperarTodoA(){

        //Recuperamos en un cursor la consulta realizada
        Cursor cursor = db.query(DATABASE_TABLEa,null,null,null,null,null,null);

        return cursor;
    }
    //
}