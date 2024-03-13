package com.example.ejercicio1.conexiones;

import com.example.ejercicio1.modelos.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {

    @GET("/v2/assets")
    Call<Respuesta> getMonedas();

}
