package com.example.sergio.prom_t3e33_sqliteagenda.com.example.sergio.prom_t3e33_sqliteagenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sergio.prom_t3e33_sqliteagenda.com.example.sergio.prom_t3e33_sqliteagenda.beans.Persona;

/**
 * Created by Sergio on 20/12/2016.
 */

public class AgendaSQLiteHelper extends SQLiteOpenHelper {

    String sql = "CREATE TABLE agenda (" +
            "id INTEGER PRIMARY KEY," +
            "nombre TEXT," +
            "apellido TEXT," +
            "telefono TEXT" +
            ")";

    //constructor del padre
    public AgendaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
        addLines(sqLiteDatabase);
    }

    /**
     * Borra la base de datos y la vuelve a crear
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS agenda");
        onCreate(sqLiteDatabase);
    }

    /**
     * Método para añadir las tuplas iniciales a la base de datos
     * @param db
     */
    private void addLines(SQLiteDatabase db) {
        Persona[] personas ={
            new Persona("Sergio","Municio","611111111"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Iban","Chaparro","622222222"),
            new Persona("Ivan","Corcoles","633333333")
        };

        ContentValues content = null;
        for (int i = 0; i < personas.length ; i++) {
            content = new ContentValues();
            content.put("id",(i+1));
            content.put("nombre",personas[i].getNombre());
            content.put("apellido",personas[i].getApellido());
            content.put("telefono",personas[i].getTelefono());

            db.insert("agenda",null,content);
        }
    }
}
