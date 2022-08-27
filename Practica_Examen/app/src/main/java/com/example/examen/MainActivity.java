package com.example.examen;

import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnpuntos,btnoportunidades,btnganador;
    EditText txtnumero;
    TextView txtaleatorio;
    Random random = new Random();

    int ganar;
    int oportunidades = 10;
    int puntaje = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnganador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int aleatorio = random.nextInt(90)+10;
                ganar = aleatorio;
                txtaleatorio.setText(ganar + "");
                btnoportunidades.setText(oportunidades + "");
                reducirOportunidades();
                Integer nuevopunt = diferencia();
                btnpuntos.setText(nuevopunt+"");

            }
        });
    }
    public void reducirOportunidades() {
        if (oportunidades > 0) {
            oportunidades--;
            btnganador.setText("Generar Número");
        }else{
            btnganador.setBackgroundColor(RED);
            btnoportunidades.setBackgroundColor(RED);
        }
    }
    public int diferencia() {
        Integer numero = Integer.parseInt(txtnumero.getText().toString());
        Integer dato_aleatorio = Integer.parseInt(btnganador.getText().toString());

        int distancia;

        distancia = Math.abs(dato_aleatorio - numero);

        if (numero.equals(distancia)) {
            puntaje += 50;
        } else {
            if (distancia > 5 && distancia <= 10) {
                puntaje += 5;
            } else {
                if (distancia > 1 && distancia <= 5) {
                    puntaje += 10;
                } else {
                    if (distancia == 1) {
                        puntaje += 15;
                    }
                }
            }
        }
        return distancia;
    }
    private boolean vacio() {
        Integer numero = Integer.parseInt(txtnumero.getText().toString());
        if (numero.equals(null)) {
            return false;
        }else{
            return true;
        }
    }
    private void conectar() {
        btnpuntos = findViewById(R.id.btnpuntos);
        btnoportunidades = findViewById(R.id.btnoportunidades);
        btnganador = findViewById(R.id.btnganador);
        txtnumero = findViewById(R.id.txtnumero);
        txtaleatorio = findViewById(R.id.txtaleatorio);
    }
}