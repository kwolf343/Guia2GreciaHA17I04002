package com.example.guia2greciaha17i04002;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtUsuario = findViewById(R.id.txtUsuario);
        final EditText txtContrasena = findViewById(R.id.txtContrasena);
        txtUsuario.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Toast.makeText(MainActivity.this, "OnFocus", Toast.LENGTH_SHORT).show();
            }
        });
        Button btnEnviar = findViewById(R.id.btnIniciar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txtUsuario.getText().toString().trim();
                String Pass = txtContrasena.getText().toString().trim();
                boolean valido = true;
                if(user.equals("")){
                    txtUsuario.setError("Este campo es requerido");
                    valido = false;
                }
                if(Pass.equals("")){
                    txtContrasena.setError("Este campo es requerido");
                    valido = false;
                }
                if(valido){
                    enviarData();
                }
            }
        });


        btnEnviar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                String user = txtUsuario.getText().toString().trim();
                String Pass = txtContrasena.getText().toString().trim();
                boolean valido = true;
                if(user.equals("")){
                    txtUsuario.setError("Este campo es requerido");
                    valido = false;
                }
                if(Pass.equals("")){
                    txtContrasena.setError("Este campo es requerido");
                    valido = false;
                }
                Intent intent = new Intent(MainActivity.this,Preguntas.class);
                startActivity(intent);
                return true;

            }
        });

    }

    private void enviarData() {

    }
}