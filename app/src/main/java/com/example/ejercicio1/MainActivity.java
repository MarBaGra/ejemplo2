package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ejercicio1.adapter.MonedaAdapter;
import com.example.ejercicio1.conexiones.ApiConexiones;
import com.example.ejercicio1.conexiones.RetrofitObject;
import com.example.ejercicio1.databinding.ActivityMainBinding;
import com.example.ejercicio1.modelos.DataItem;
import com.example.ejercicio1.modelos.Respuesta;

import java.net.HttpURLConnection;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<DataItem> listaMonedas;

    private MonedaAdapter adapter;

    private RecyclerView.LayoutManager lm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaMonedas = new ArrayList<>();

        adapter = new MonedaAdapter(this, R.layout.fila, listaMonedas);
        binding.contenido.setAdapter(adapter);
        lm = new LinearLayoutManager(MainActivity.this);
        binding.contenido.setLayoutManager(lm);

        getMonedas();

    }

    private void getMonedas() {

        Retrofit retrofit = RetrofitObject.getConexion();
        ApiConexiones api = retrofit.create(ApiConexiones.class);

        Call<Respuesta> getMonedas = api.getMonedas();

        getMonedas.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (response.code() == HttpURLConnection.HTTP_OK){
                    Respuesta respuesta = response.body();
                    listaMonedas.addAll(respuesta.getData());
                    adapter.notifyItemRangeInserted(0, listaMonedas.size());
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });

    }
}





