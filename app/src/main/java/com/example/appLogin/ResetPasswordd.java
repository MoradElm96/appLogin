package com.example.appLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordd extends AppCompatActivity {

    private EditText mailBox;
    private Button botonRestablecer;


    private String email= "";
    private FirebaseAuth mAuth;
    //loader
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_passwordd);

        mAuth = FirebaseAuth.getInstance();

        dialog = new ProgressDialog(this);
        mailBox = (EditText) findViewById(R.id.editTextCorreoUsuario);
        botonRestablecer = (Button) findViewById(R.id.btnResetPassword);

        botonRestablecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = mailBox.getText().toString();

                if(!email.isEmpty()){

                    dialog.setMessage("Espere un momento...");
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.show();

                    resetPassword();
                }else{

                    Toast.makeText(getApplicationContext(),"Debe ingresar el email de usuario", Toast.LENGTH_SHORT).show();

                }
                //ocultamos dialog
                dialog.dismiss();



            }
        });

    }

    public void resetPassword(){
//idioma correo

        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                //validar

                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(), "se ha enviado correo para restablecer, revise su buzon", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText( getApplicationContext(),"No se pudo enviar el correo de restablecer contraseña ", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }



}