package com.example.tarea_02_progmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;     // Se hace la importación necesaria para usar la clase ArrayList de la interface List

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RegistroDeportivo registro; // Cree un objeto de la clase RegistroDeportivo
    private EditText nombreEquipo, nombreCapitan, telefonoCapitan, uniformeColor;
    private RadioButton masculino, femenino;
    private Button boton1, boton2;
    private ArrayList<RegistroDeportivo> myList;    //Mi lista para guardar los objetos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = new ArrayList<RegistroDeportivo>();
        obtieneRegistroInterfaz();
        escuchaBotones();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton1:   // Agrega el registro a la lista
                cargaRegistro();
                break;
            case R.id.boton2:   // Envío la lista a la actividad VerRegistro
                Intent intent = new Intent(v.getContext(), VerRegistro.class);
                intent.putExtra("Lista", myList);
                startActivityForResult(intent, 0);
                break;
            default:
                break;
        }
    }

    public void escuchaBotones() {
        boton1 = (Button) findViewById(R.id.boton1);
        boton2 = (Button) findViewById(R.id.boton2);
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    public void obtieneRegistroInterfaz() {
        nombreEquipo = (EditText) findViewById(R.id.nombreEquipo);
        nombreCapitan = (EditText) findViewById(R.id.nombreCapitan);
        telefonoCapitan = (EditText) findViewById(R.id.telefonoCapitan);
        masculino = (RadioButton) findViewById(R.id.masculino);
        femenino = (RadioButton) findViewById(R.id.femenino);
        uniformeColor = (EditText) findViewById(R.id.uniformeColor);
    }

    public void cargaRegistro() {
        registro = new RegistroDeportivo();
        registro.setNombreEquipo(nombreEquipo.getText().toString());
        registro.setNombreCapitan(nombreCapitan.getText().toString());
        registro.setTelefonoCapitan(telefonoCapitan.getText().toString());
        if (masculino.isChecked()) {
            registro.setCategoria("Masculino");
        }
        else if (femenino.isChecked()) {
            registro.setCategoria("Femenino");
        }
        registro.setUniformeColor(uniformeColor.getText().toString());
        myList.add(registro);
        Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();
        nombreEquipo.setText("");
        nombreCapitan.setText("");
        telefonoCapitan.setText("");
        masculino.setChecked(false);
        femenino.setChecked(false);
        uniformeColor.setText("");
    }

}