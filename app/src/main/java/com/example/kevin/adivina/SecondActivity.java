package com.example.kevin.adivina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    int min,max,randomNum,ContadorFallos=0;
    EditText Comprova;
    String numGenerado;
    TextView Resultat,Intentos;
    Button BotonComprova;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Intent intent = getIntent();

        min = intent.getIntExtra("minimo",0);
        max = intent.getIntExtra("maximo",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Comprova = findViewById(R.id.edTxtAdiv);
        Random rand = new Random();
        randomNum = rand.nextInt((max - min) + 1) + min;
        Resultat = findViewById(R.id.lblResultat);
        Intentos = findViewById(R.id.lblIntentos);
        BotonComprova = findViewById(R.id.btnComprova);


    }
    public void onClickComprova(View view) {
        try {
            int Compro;
            Compro = Integer.parseInt(Comprova.getText().toString());
            if (Compro > min-1 && Compro < max+1) {
                if (Compro == randomNum) {
                    Resultat.setText("Has Acertado  :)");
                    ContadorFallos++;
                    Intentos.setText("Lo has conseguido con " + ContadorFallos + " intentos.");
                    BotonComprova.setEnabled(false);
                    Comprova.setEnabled(false);
                }else{
                    ContadorFallos++;
                    Resultat.setText("Has fallado :(     Vuelve a probar ");
                    Intentos.setText("Intentos : " + ContadorFallos);}
                    Comprova.setText("");
            }else{
                Toast.makeText(this, "Valor fuera de rango", Toast.LENGTH_SHORT).show();
            }
        }catch(Exception e){
            Toast.makeText(this, "Esta vacío", Toast.LENGTH_SHORT).show();
        }
    }




public void onClickPatras(View view){
        finish();
    }




}