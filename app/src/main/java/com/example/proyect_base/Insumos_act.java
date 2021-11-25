package com.example.proyect_base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity
{
    private Insumos in = new Insumos();
    private Spinner insumos;
    private TextView result;
    private RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);
        insumos = findViewById(R.id.spn1);
        result = findViewById(R.id.txtv2);
        rb = findViewById(R.id.rb);

        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();
        int precio = 0;
        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i]))
            {
                //precio = in.getPrecios()[i];
                precio = in.anadirAdicional(in.getPrecios()[i], 500);
                rb.setRating(i+1);
                break;
            }
        }
        result.setText("La opción es: " + opcion + "\nEl precio es: " + precio);
    }
}