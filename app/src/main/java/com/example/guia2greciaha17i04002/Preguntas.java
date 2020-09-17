package com.example.guia2greciaha17i04002;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Preguntas extends AppCompatActivity {
    private String FRUTA = "";
    private String ANIMAL = "";
    private String LENGUAJE = "";
    private ProgressBar progress;
    private Handler ejecutarProgress;
    private  static  int  contProcess;


    private static  final String[] fruta = new String[]{
            "Manzana","Uva","Sandia","Mango","Pera","Fresa",
            "Melocotones","Frambuesa","Limon","Lima","platano","Ciluelas","Coco"
    };
    private static  final String[] animal = new String[]{
            "Perro","Gato","Hormiga","Leon","Leopardo","Tortugas","Tigres","Peces",
            "Águila","Loro","Mono","Gorilla","Tucán",
            "Gallina","Gallo","Cocodrillo","Serpiente"
    };
    private static  final String[] lenguaje = new String[]{
            "C++","C#","Java","Php","Pyton","JavaScript","C","Matlan",
            "Sql","Ruby","visual Basic .NET","Swift","Objective.C","R","Perl","D",
            "Assembly language","Go","Object Pascal","Visual Basic"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        this.progress = findViewById(R.id.progressBar);
        this.ejecutarProgress = new Handler();
        progress.setMax(100);

        ///______________________________autocomplement______________________
        //fruta
        ArrayAdapter<String> adapterfruta = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,fruta);
        final AutoCompleteTextView txtFruta = findViewById(R.id.txtFruta);
        txtFruta.setAdapter(adapterfruta);
        //animal
        ArrayAdapter<String> adapterAnimal = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,animal);
        final AutoCompleteTextView txtAnimal = findViewById(R.id.txtAnimal);
        txtAnimal.setAdapter(adapterAnimal);
        //lenguaje
        ArrayAdapter<String> adapterleng = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,lenguaje);
        final AutoCompleteTextView txtLeng = findViewById(R.id.txtProg);
        txtLeng.setAdapter(adapterleng);

        Button btnprogreso = findViewById(R.id.btnProcesar);
        btnprogreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new procesosecundario()).start();
                String frutas = txtFruta.getText().toString().trim();
                String animal = txtAnimal.getText().toString().trim();
                String lenguajes = txtLeng.getText().toString().trim();
                boolean valido = true;
                if(frutas.equals("")){
                    txtFruta.setError("Este campo es requerido");
                    valido = false;
                }
                if(animal.equals("")){
                    txtAnimal.setError("Este campo es requerido");
                    valido = false;
                }
                if(lenguajes.equals("")){
                    txtLeng.setError("Este campo es requerido");
                    valido = false;
                }

            }
        });
    }
    final  class  procesosecundario implements  Runnable{
        AutoCompleteTextView fu = findViewById(R.id.txtFruta);
        AutoCompleteTextView an = findViewById(R.id.txtFruta);
        AutoCompleteTextView le = findViewById(R.id.txtFruta);
        @Override
        public void run() {
            while(contProcess< 100){
                metodoEspera();
                ejecutarProgress.post(new Runnable() {
                    @Override
                    public void run() {
                        progress.setProgress(contProcess);
                        if(contProcess==100) {
                            Toast.makeText(Preguntas.this, "Fruta:"+(fu.getText().toString().toLowerCase())+"Animal: "+(an.getText().toString().toLowerCase())+"Lenguaje"+(le.getText().toString().toLowerCase()), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        }
        private void metodoEspera() {
            try {
                Thread.sleep(500);
                contProcess++;
            }catch (Exception e ){

            }
        }
    }



}