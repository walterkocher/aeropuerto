package Aeropuerto;

import java.util.ArrayList;
import Aeropuerto.Vuelo;

public class Piloto extends Persona {
	private String rut;
	private String idPiloto;
	private ArrayList<Vuelo> vuelosInscritos = new ArrayList<Vuelo>();

	public String getRut() {
		return this.rut;
	}

	public String getIdPiloto() {
		return this.idPiloto;
	}
}