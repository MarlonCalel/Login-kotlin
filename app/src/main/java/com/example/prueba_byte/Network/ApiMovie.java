package com.example.prueba_byte.Network;

import com.example.prueba_byte.Model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovie {
    @GET("movies/list.php")
    Call<List<Movie>>  getMovies();
}
