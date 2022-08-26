package com.example.app_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnP1,btnP2,btnP3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        String Mistery="despues del ultimo no hay nadie";
        //Implementar Intent
        btnP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p1= new Intent(getApplicationContext(), Pantalla1.class);
                p1.putExtra("Mi_variable", Mistery);
                startActivity(p1);
            }
        });

        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p2= new Intent(getApplicationContext(), Pantalla2.class);
                startActivity(p2);
            }
        });

        btnP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p3= new Intent(getApplicationContext(), Pantalla3.class);
                startActivity(p3);
            }
        });
    }

    private void conectar() {
        btnP1 = findViewById(R.id.btnP1);
        btnP2 = findViewById(R.id.btnP2);
        btnP3 = findViewById(R.id.btnP3);
    }
}