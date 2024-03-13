package com.example.ejercicio1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio1.R;
import com.example.ejercicio1.modelos.DataItem;

import java.util.List;

public class MonedaAdapter extends RecyclerView.Adapter<MonedaAdapter.MonedaVH> {


    private Context context;
    private int fila;
    private List<DataItem> listaMonedas;

    public MonedaAdapter(Context context, int fila, List<DataItem> listaMonedas) {
        this.context = context;
        this.fila = fila;
        this.listaMonedas = listaMonedas;
    }

    @NonNull
    @Override
    public MonedaVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(context).inflate(fila, null);

        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        vista.setLayoutParams(lp);

        return new MonedaVH(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MonedaVH holder, int position) {

        DataItem moneda = listaMonedas.get(position);
        holder.lbSymbol.setText(moneda.getSymbol());
        holder.lbName.setText(moneda.getName());
        holder.lbPrice.setText(moneda.getPriceUsd());
        holder.lbExplorer.setText(moneda.getExplorer());
        //Picasso.get().load(moneda.getExplorer()).placeholder(R.drawable.ic_launcher_background).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return listaMonedas.size();
    }

    public class MonedaVH extends RecyclerView.ViewHolder{

        ImageView img;
        TextView lbSymbol, lbName, lbPrice, lbExplorer;


        public MonedaVH(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgFila);
            lbSymbol = itemView.findViewById(R.id.lbSymbolFila);
            lbName = itemView.findViewById(R.id.lbNameFila);
            lbPrice = itemView.findViewById(R.id.lbPriceFila);
            lbExplorer = itemView.findViewById(R.id.lbExplorerFila);

        }
    }
}
