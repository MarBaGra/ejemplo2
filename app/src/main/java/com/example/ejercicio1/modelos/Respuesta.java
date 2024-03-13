package com.example.ejercicio1.modelos;

import java.util.List;

public class Respuesta{
	private List<DataItem> data;
	private long timestamp;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setTimestamp(long timestamp){
		this.timestamp = timestamp;
	}

	public long getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"Respuesta{" + 
			"data = '" + data + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}