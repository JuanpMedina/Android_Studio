package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etCorreo, etEstatura;
    Button btnAgregar;
    ListView lvContactos;

    ArrayList<String> Mis_Contactos = new ArrayList<>();
    ArrayAdapter adapter;
    String strNombre, strApellido, strCorreo;
    int intEstatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), i + "Fue seleccionado", Toast.LENGTH_SHORT).show();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strNombre = etNombre.getText().toString();
                strApellido = etApellido.getText().toString();
                strCorreo = etCorreo.getText().toString();
                intEstatura = Integer.valueOf(etEstatura.getText().toString());
                Contactos C = new Contactos(strNombre, strApellido, strCorreo, intEstatura);
                Mis_Contactos.add(C.toString());
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, Mis_Contactos);
                lvContactos.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Contacto Agregado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void conectar() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCorreo =  findViewById(R.id.etCorreo);
        etEstatura = findViewById(R.id.etEstatura);
        btnAgregar = findViewById(R.id.btnAgregar);
        lvContactos = findViewById(R.id.lvContactos);
    }
}