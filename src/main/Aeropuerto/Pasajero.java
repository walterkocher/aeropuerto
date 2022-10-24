package Aeropuerto;

public class Pasajero extends Persona {
	private String run;
	private PasaporteSanitario pasaporteSanitario;

	public PasaporteSanitario getPasaporteSanitario() {
		return pasaporteSanitario;
	}

	public String getRun() {
		return this.run;
	}
}