package com.example.ejercicio1.conexiones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    public static final String BASE_URL = "https://api.coincap.io";

    public static Retrofit getConexion(){
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

}
