package com.example.appLogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appLogin.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void irIniciar(View view){

        Intent i = new Intent(this, IniciarSesionActivity.class);
        startActivity(i);


    }

    public void irRegistro(View view){

        Intent i = new Intent(this, RegistraseActivity.class);
        startActivity(i);
    }
}