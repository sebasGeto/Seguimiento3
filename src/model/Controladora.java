package model;

import java.util.Arrays;

public class Controladora {

    private final int MAX_PLACES = 200;
    private Place[] places = new Place[MAX_PLACES];
    private int placeCounter = 0;

    private Place[] almacenamiento;

    public Controladora(){

        almacenamiento = new Place[1000];
        crearCasosDePrueba();
    }

    public String listarPlaces(){

        String lista = "";

        for(int i = 0; i<almacenamiento.length; i++){

            if (almacenamiento[i]!=null) {
                
            lista +="\n"+almacenamiento[i].getName()+"-"+almacenamiento[i].getArea();
            }

        }
        return lista;
        
    }

    public boolean almacenarPlace(String name, double area, String photoPath, double resources){

        Place nuevoPlace = new Place(name,area, "", 0.0);

        for (int i =0; i<almacenamiento.length;i++){

            if (almacenamiento[i] == null){

                almacenamiento[i] = nuevoPlace;
                return true;
            }else if (almacenamiento[i] != null && almacenamiento[i].getName().equals(name)) {
                return false;
            }

        }

        return false;
    }

    public Place buscarPlace(String codigo){

        for (int i = 0; i<almacenamiento.length; i++){

            Place temporal = almacenamiento[i];

            if (temporal!=null) {
            
                if (codigo.equals(temporal.getName())) {
                return temporal;
                }
            }
        }

        return null;
    }

    public String mostrarPlace(String codigo){

        Place temporal = buscarPlace(codigo);

        if (temporal == null){
            return "El Place no existe";
        }
        
        return temporal.toString();
    }

    public void crearCasosDePrueba(){

    }

    public int getMaxPlaces() {
        return MAX_PLACES;
    }

    public int getPlaceCounter() {
        return placeCounter;
    }


public boolean addPlace(Place place) {
    if (placeCounter < MAX_PLACES) {
        places[placeCounter] = place;
        placeCounter++;
        return true; 
    }
    return false; 
}

public boolean removePlace(Place place) {
    for (int i = 0; i < placeCounter; i++) {
        if (places[i].equals(place)) {
            System.arraycopy(places, i + 1, places, i, placeCounter - i - 1);
            places[placeCounter - 1] = null;
            placeCounter--;
            return true; 
        }
    }
    return false; 
}

public Place[] getPlaces() {
    return Arrays.copyOf(places, placeCounter); 
}

    public void incrementPlaceCounter() {
        placeCounter+=1;
    }

}