package com.example.agalludo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnDado1, btnDado2, btnSuma, btnReset;
    Random r;
    int suma=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r = new Random();
                int dado1 = r.nextInt(5)+1;
                int dado2 = r.nextInt(5)+1;
                btnDado1.setText(dado1+"");
                btnDado2.setText(dado2+"");
                //btnSuma.setText(dado1+dado2+"");
                if(dado1==1 || dado2==1){
                    suma = 0;
                    btnSuma.setText("0");
                    Toast.makeText(getApplicationContext(),"Perdiste",Toast.LENGTH_LONG).show();
                    if(dado1==1)
                        btnDado1.setBackgroundColor(Color.RED);
                    if(dado2==1)
                        btnDado2.setBackgroundColor(Color.RED);
                }
                else{
                    suma += dado1+dado2;
                    btnSuma.setText(suma+"");
                    if(suma >= 50){
                        Toast.makeText(getApplicationContext(),"Ganaste",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDado1.setText("0");
                btnDado2.setText("0");
                btnSuma.setText("0");
                btnDado1.setBackgroundColor(Color.BLACK);
                btnDado2.setBackgroundColor(Color.BLACK);
            }
        });
    }

    private void conectar() {
        btnDado1 = findViewById(R.id.btnDado1);
        btnDado2 = findViewById(R.id.btnDado2);
        btnSuma = findViewById(R.id.btnSuma);
        btnReset = findViewById(R.id.btnReset);
    }
}