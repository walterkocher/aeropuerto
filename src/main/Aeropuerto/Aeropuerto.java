package Aeropuerto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Aeropuerto.Avion;

public class Aeropuerto {
    private ArrayList<Avion> aviones; 
    
    public Aeropuerto(){
        this.aviones = new ArrayList<Avion>();
    }
    
    public Avion agregarAvion(String nombre, int año) {
        Avion avion = new Avion(nombre, año, this);
        this.aviones.add(avion);
        return avion;
    }

    public void visualizarAviones() {
        throw new UnsupportedOperationException();
    }

    public List<Avion> getAviones() {
        return this.aviones;
    }

    public List<Pasajero> buscarPasajerosFecha(Date fecha) {
        List<Pasajero> pasajeros = new ArrayList<Pasajero>();
        //recorre la lista de aviones
        for (Avion avion : this.aviones) {
            //por cada avión, recorre su lista de vuelos
            for (Vuelo vuelo : avion.getVuelos()) {
                if (vuelo.getHoraVuelo().equals(fecha)) {
                    pasajeros.addAll(vuelo.getPasajeros());
                }
            }

        }
        return pasajeros;
    }

    public List<Pasajero> buscarPasajerosVuelo(Vuelo vuelo) {
        List<Pasajero> pasajeros = new ArrayList<Pasajero>();
        //recorre la lista de aviones
        for (Avion avion : this.aviones) {
            //por cada avión, recorre su lista de vuelos
            for (Vuelo vuelos : avion.getVuelos()) {
                if (vuelo.equals(vuelos)) {
                    pasajeros.addAll(vuelos.getPasajeros());
                    break;
                }
            }

        }
        return pasajeros;
    }

    public List<Pasajero> buscarPasajerosCovid() {
        List<Pasajero> pasajeros = new ArrayList<Pasajero>();
        List<Vuelo> vuelos = new ArrayList<Vuelo>();
        //recorre la lista de aviones
        for (Avion avion : this.aviones) {
            //por cada avión recorre la lista de vuelos
            for (Vuelo vuelo : avion.getVuelos()) {
                boolean condicion = true;
                //por cada vuelo recorre la lista de pasajeros
                //se ejecuta periódicamente hasta comprobar si existe un pasajero con covid+
                while(condicion){
                for (Pasajero pasajero : vuelo.getPasajeros()) {
                        {
                            if (pasajero.getPasaporteSanitario()==null || pasajero.getPasaporteSanitario().getResultadoPCR() == true) {
                                condicion = false;
                                pasajeros.addAll(vuelo.getPasajeros());
                                vuelos.add(vuelo);
                            }
                        }
                    }
                }

            }


        }
        // ejecuta la trazabilidad de los vuelos
        pasajeros= this.buscarTrazabilidadCovid(pasajeros,vuelos);
        return pasajeros;
    }

    private List<Pasajero> buscarTrazabilidadCovid(List<Pasajero> pasajeros, List<Vuelo> vuelos) {
        //recorre la lista de aviones
        for (Avion avion : this.aviones) {
            //por cada avión recorre la lista de vuelos
            for (Vuelo vuelo : avion.getVuelos()) {
                //recorre la lista de los vuelos con un caso covid+
                for (Vuelo vuelosCovid : vuelos) {
                    boolean condicion = true;
                    int diferenciaHoraria = vuelo.getHoraVuelo().getHours() - vuelosCovid.getHoraVuelo().getHours();
                    // si el vuelo que no tuvo un pasajero covid positivo pero estuvo en contacto con un vuelo que si lo tuvo
                    // se agregan todos los pasajeros como casos sospechosos
                    if (!vuelos.contains(vuelo) && diferenciaHoraria <= 1) {
                        pasajeros.addAll(vuelo.getPasajeros());

                    }
                }

            }

        }
        return pasajeros;

    }
}
