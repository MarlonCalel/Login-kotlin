package com.example.prueba_byte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class Activitymain extends AppCompatActivity {
    EditText etIngresar;
    Button btIngresar, btRegistrarse;

    public TextInputEditText txtInputUsuario;
    public TextInputEditText txtInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etIngresar = findViewById(R.id.txtUsuaLogin);
        btIngresar = findViewById(R.id.btnIngresar);
        btRegistrarse = (Button)findViewById(R.id.btnRegistrarse);



        txtInputUsuario = findViewById(R.id.txtUsuaLogin);

        btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activitymain.this, RegistrarActivity.class);
                startActivity(intent);

            }


        });

        btIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle enviaDatos = new Bundle();
                enviaDatos.putString("keyDatos", etIngresar.getText().toString());

                Intent intent = new Intent(Activitymain.this, HomeActivity.class);
                intent.putExtras(enviaDatos);
                startActivity(intent);


            }
        });


    }


    public void irIniciar(View view) {
        Intent PackageContext;
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void irRegistrarse(View view) {
        Intent PackageContext;
        Intent i = new Intent(this, RegistrarActivity.class);
        startActivity(i);
    }
}





