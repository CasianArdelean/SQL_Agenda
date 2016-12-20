package com.example.sergio.prom_t3e33_sqliteagenda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.sergio.prom_t3e33_sqliteagenda.com.example.sergio.prom_t3e33_sqliteagenda.beans.Persona;
import com.example.sergio.prom_t3e33_sqliteagenda.com.example.sergio.prom_t3e33_sqliteagenda.db.AgendaSQLiteHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.list);

        //DB
        ArrayList<Persona> personas = new ArrayList<Persona>();
        AgendaSQLiteHelper agendaDB = new AgendaSQLiteHelper(this,"agendadb",null,2); //la versión 1 era la primera prueba
        SQLiteDatabase db = agendaDB.getReadableDatabase();
        if (db != null){ //hemos abierto bien la bbdd
            Cursor c = db.rawQuery("SELECT nombre, apellido, telefono FROM agenda",null);

            if (c.moveToNext()){
                do{
                    personas.add(new Persona(c.getString(0),c.getString(1),c.getString(2)));
                } while (c.moveToNext());
            }
            db.close();
        }
        /////////////////////
        Log.d("BD","Longitud Arraylist: "+personas.size());

        Persona[] datos = new Persona[personas.size()];
        int i=0;
        for (Persona p: personas) {
            datos[i++] = p;
        }
        AgendaAdapter agenda = new AgendaAdapter(this,datos);
        list.setAdapter(agenda);
    }
}
