package com.example.appcarros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup rgOpciones;
    CheckBox chkRines,chkSonido,chkPolarizado,chkAleron,chkLlanta;
    Button btnCobrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnCobrar.setOnClickListener(this);
        if (rgOpciones.getCheckedRadioButtonId()==R.id.chkAleron){

        }
    }

    private void conectar() {
        chkRines = findViewById(R.id.chkRines);
        chkSonido = findViewById(R.id.chkSonido);
        chkPolarizado = findViewById(R.id.chkPolarizado);
        chkAleron = findViewById(R.id.chkAleron);
        chkLlanta = findViewById(R.id.chkLlanta);
        rgOpciones = findViewById(R.id.rgOpciones);
        btnCobrar = findViewById(R.id.btnCobrar);
    }


    @Override
    public void onClick(View view) {
        metodo();
    }

    private void metodo() {
        Toast.makeText(getApplicationContext(),"otra forma", Toast.LENGTH_LONG).show();
    }
}