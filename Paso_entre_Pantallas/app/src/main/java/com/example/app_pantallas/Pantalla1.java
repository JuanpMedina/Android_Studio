package com.example.app_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pantalla1 extends AppCompatActivity {
    private EditText txtnombre,txtcorreo,txtdireccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtcorreo = (EditText) findViewById(R.id.txtcorreo);
        txtdireccion = (EditText) findViewById(R.id.txtdireccion);
    }

    public void Enviar(View view){
        Intent i= new Intent(this, Pantalla2.class);
        i.putExtra("dato",txtnombre.getText().toString());
        startActivity(i);
    }
}