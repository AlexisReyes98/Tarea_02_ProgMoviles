package com.example.tarea_02_progmoviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VerRegistro extends AppCompatActivity {

    private ListView lista;
    private ArrayList<RegistroDeportivo> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_registro);
        compInterfaz();
        myList = (ArrayList<RegistroDeportivo>) getIntent().getSerializableExtra("Lista");
        imprimeLista();
        regresaMain();
    }

    public void compInterfaz() {
        lista = (ListView) findViewById(R.id.lista);
    }

    public void imprimeLista() {
        // Para poder cargar los datos en el ListView se tiene que definir un objeto de tipo ArrayAdapter
        // El cual debe coincidir con el tipo de dato de la lista original, que es de tipo RegistroDeportivo
        // En los parentesis se coloca el contexto actual que es VerRegistro
        // Seguido por el tipo de lista que se va a presentar, en este caso una lista simple
        // y al final se pasa la lista original
        ArrayAdapter<RegistroDeportivo> adaptador = new ArrayAdapter<RegistroDeportivo>(VerRegistro.this, android.R.layout.simple_list_item_1, myList);
        // El adaptador es lo que permitira pasar el contenido al ListView
        lista.setAdapter(adaptador);
    }

    // Para digamos practicar, implemente una clase que referencia a la interfaz View.OnClickListener
    // Como se vio en clase para manejar Eventos
    public void regresaMain() {
        Button boton = (Button) findViewById(R.id.botonM);
        boton.setOnClickListener(new MiClick());
    }

    class MiClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        }
    }

}