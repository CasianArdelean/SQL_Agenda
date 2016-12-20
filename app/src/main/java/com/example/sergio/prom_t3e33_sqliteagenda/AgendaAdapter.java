package com.example.sergio.prom_t3e33_sqliteagenda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sergio.prom_t3e33_sqliteagenda.com.example.sergio.prom_t3e33_sqliteagenda.beans.Persona;

/**
 * Created by Sergio on 20/12/2016.
 */

public class AgendaAdapter extends ArrayAdapter<Persona>  {

    Persona[] personas;

    public AgendaAdapter(Context context, Persona[] personas) {
        super(context, R.layout.list_element,personas);
        this.personas = personas;
    }

    public View getView(int position,View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_element, null);

        TextView nombre = (TextView) item.findViewById(R.id.txt_nombre);
        TextView telefono = (TextView) item.findViewById(R.id.txt_telefono);

        nombre.setText(personas[position].getNombre()+" "+personas[position].getApellido());
        telefono.setText(personas[position].getTelefono());
        return(item);
    }
}
