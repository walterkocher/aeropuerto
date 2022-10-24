package Aeropuerto;

import java.util.ArrayList;
import Aeropuerto.Vuelo;

public class Avion {
	private String nombre;
	private int año;
	private double kmRecorridos;
	private Aeropuerto aeropuerto;
	private ArrayList<Vuelo> vuelos;

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}

	public Avion(String nombre, int año, Aeropuerto aeropuerto){
	 this.nombre= nombre;
	 this.año=año;
	 this.kmRecorridos=0.0;
	 this.aeropuerto= aeropuerto;
	 this.vuelos= new ArrayList<Vuelo>();
 }
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return this.año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getKmRecorridos() {
		return this.kmRecorridos;
	}

	public void setKmRecorridos(double kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}
}