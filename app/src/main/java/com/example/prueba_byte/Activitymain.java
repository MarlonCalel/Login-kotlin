package com.example.prueba_byte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba_byte.Adapter.MovieAdapter;
import com.example.prueba_byte.Model.Movie;
import com.example.prueba_byte.Network.ApiMovie;
import com.example.prueba_byte.Network.Apiclient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Activitymain extends AppCompatActivity {

    private List<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    private FirebaseFirestore mfirestore;
    EditText etIngresar;
    Button btIngresar, btRegistrarse;

    public TextInputEditText txtInputUsuario;
    public TextInputEditText txtInputPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_movies=01);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        showMovies();


        mfirestore = FirebaseFirestore.getInstance();


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

    public void showMovies(){
        Call<List<Movie>> call= Apiclient.getClient().create(ApiMovie.class).getMovies();
        Call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    movies = (List<Movie>) response.body();
                    movieAdapter=new MovieAdapter(movies,getApplicationContext());
                    recyclerView.setAdapter(movieAdapter);
                }

            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Activitymain.this, "error de conexion", Toast.LENGTH_SHORT.show);

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





