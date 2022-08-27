package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btngenerar,btnintentos,btnpuntos,btnreset;
    EditText txtnumero;
    TextView txtintentos,txtpuntos;

    int Intentos = 0;
    int puntaje = 0;
    int canNumeros = 5;
    ArrayList <Integer> numeros = new ArrayList();
    ArrayList <Integer> aux = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnintentos.setText(Intentos + "");
                reducirOportunidades();
                generarAletorios();
                txtnumero.setText(numeros.toString());
                puntuacion();
                btnpuntos.setText(puntaje+ "");
                numeros.clear();
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intentos = 0;
                btnintentos.setText(Intentos + "");
                txtnumero.setText("");
                puntaje = 0;
                btnpuntos.setText(puntaje + "");

            }
        });
    }

    public void generarAletorios() {
        for (int i=0;i<canNumeros;i++){
            numeros.add(new Random().nextInt(900) + 100);;
        }
    }

    public void puntuacion() {
        int auxiliar;
        int P_auxiliar = 0;
        for (int i = 0; i < numeros.size(); i++) {
            auxiliar = numeros.get(i);

            while (auxiliar > 0) {
                aux.add(new Integer(auxiliar % 10));
                auxiliar = auxiliar/10;
            }
            if (aux.get(0) == aux.get(aux.size() - 1)) {
                puntaje += 3;
            }

            for (int j = 0; j < aux.size(); j++) {
                if (aux.get(j) == 5) {
                    puntaje +=  1;
                }
                P_auxiliar += (aux.get(j));
            }
            if (P_auxiliar > 12) {
                puntaje += 5;
            }
        }
        aux.clear();
        if (puntaje > 20){
            Toast.makeText(getApplicationContext(), "GANASTE", Toast.LENGTH_LONG).show();
        }
    }

    public void reducirOportunidades() {
        if (btngenerar.hasOnClickListeners()) {
            if (Intentos >= 0) {
                Intentos++;
            }
            if(btngenerar.isEnabled()) {
                if (Intentos < 0) {
                    btngenerar.setEnabled(false);
                }
            }
        }
    }

    private void conectar() {
        btngenerar =findViewById(R.id.btngenerar);
        btnintentos = findViewById(R.id.btnintentos);
        btnpuntos = findViewById(R.id.btnpuntos);
        txtnumero= findViewById(R.id.txtnumero);
        txtintentos = findViewById(R.id.btnintentos);
        txtpuntos = findViewById(R.id.txtpuntos);
        btnreset = findViewById(R.id.btnreset);
    }
}

