package com.example.kevin.adivina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText From;
    EditText To;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        From = findViewById(R.id.edTxtFrom);
        To = findViewById(R.id.edTxtTo);
    }

    public void onClickBtnStop(View view){
        From.setText("");
        To.setText("");
    }


    public void onClickBtnPlay(View view) {
        int min, max;

        try{
            min = Integer.parseInt(From.getText().toString()) ;
            max = Integer.parseInt(To.getText().toString());
            if (min < max){
                try {
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("minimo", min);
                    intent.putExtra("maximo", max);

                    startActivity(intent);
                }catch (Exception e){

                }


            }else {
                Toast.makeText(this, "El primer valor ha de ser menor al segundo.", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, "Los campos han de ser llenados con numeros enteros.", Toast.LENGTH_SHORT).show();
        }




    }




}

