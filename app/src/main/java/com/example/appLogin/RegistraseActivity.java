package com.example.appLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appLogin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistraseActivity extends AppCompatActivity {


    private FirebaseAuth mAuth;

    private  EditText correo;
    private  EditText contrasena;
    private  EditText contrasenaConfirmation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrase);

        mAuth = FirebaseAuth.getInstance();

        correo = (EditText) findViewById(R.id.editCorreo);
        contrasena = (EditText) findViewById(R.id.editContrasena);
        contrasenaConfirmation =(EditText) findViewById(R.id.editPasswordConfirmation);


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
      //  updateUI(currentUser); si esta registrado

    }

    public  void registrarUsuario(View view){

        //verificamos que sean iguales
        if(contrasena.getText().toString().equals(contrasenaConfirmation.getText().toString())){

            mAuth.createUserWithEmailAndPassword(correo.getText().toString(), contrasena.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                Toast.makeText(getApplicationContext(), "Usuario creado.", Toast.LENGTH_SHORT).show();

                                FirebaseUser user = mAuth.getCurrentUser();

                                //mandar al inicio
                                Intent i = new Intent(getApplicationContext(),MainActivity.class);

                                startActivity(i);

                               //updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                               // updateUI(null);
                            }

                            // ...
                        }
                    });
        }else{
            Toast.makeText(this,"las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }


    }


}