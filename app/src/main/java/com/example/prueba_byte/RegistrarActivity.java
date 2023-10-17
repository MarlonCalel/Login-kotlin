package com.example.prueba_byte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegistrarActivity extends AppCompatActivity {

    Button btnregistrar;
    EditText name, password, email;

    FirebaseFirestore mFirestore;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);


        name = findViewById(R.id.nombre);
        password = findViewById(R.id.contraseña);
        email = findViewById(R.id.correo);


        //Registrar usuario
        Button btnregistrar = findViewById(R.id.btnregistrar);
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logica de registro con Firebase



            }
        });


        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        this.setTitle("Crear usuario");
        mFirestore = FirebaseFirestore.getInstance();




    }








    }



