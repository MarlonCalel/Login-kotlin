package com.example.prueba_byte.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
    private static Retrofit retrofit;
    public static Retrofit getClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://mocki.io/v1/eeced007-6b29-4c9d-ab63-c115a990d927")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
