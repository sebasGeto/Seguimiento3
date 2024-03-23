package ui;

import java.util.Scanner;
import model.Place;
import model.Controladora;

public class Ejecutable {
    private static Controladora controller;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    controller = new Controladora();
    
    int choice = 0;
    do {
        System.out.println("\nCop 16 place App Menu:");
        System.out.println("1. Registrar un lugar");
        System.out.println("2. Mostrar la lista de lugares registrados");
        System.out.println("3. Consultar la informacion de un lugar");
        System.out.println("4. Exit");
        System.out.print("Ingresa el numero de tu eleccion: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                registerPlace(scanner);
                break;
            case 2:
                showListOfPlaces();
                break;
            case 3:
                consultPlaceInformation(scanner);
                break;
            case 4:
                System.out.println("Saliendo del programa. Adios!");
                break;
            default:
                System.out.println("Opcion invalida. Intenta de nuevo.");
        }
    } while (choice != 4);
    scanner.close();
}
    private static void registerPlace(Scanner scanner) {
        if (controller.getPlaceCounter() < controller.getMaxPlaces()) {
            System.out.println("Registrar un lugar:");
            System.out.print("Ingresa el nombre del lugar: ");
            String name = scanner.next();
            System.out.print("Ingresa el area (en kilometros cuadrados) del lugar: ");
            double area = scanner.nextDouble();
            System.out.print("Ingresa el enlace de la foto de la imagen: ");
            String photoPath = scanner.next();
            System.out.print("Ingrese los recursos económicos necesarios para el mantenimiento en dólares: ");
            double resources = scanner.nextDouble();
            Place newPlace = new Place(name, area, photoPath, resources);
            controller.addPlace(newPlace);
            System.out.println("Lugar registrado exitosamente.");
        } else {
            System.out.println("Capacidad máxima alcanzada. No se pueden registrar más lugares.");
        }
    }
    private static void showListOfPlaces() {
        System.out.println("\nLista de lugares registrados:");
        Place[] equis = controller.getPlaces(); 
    
        if (equis != null && equis.length > 0) {
            int placeCounter = controller.getPlaceCounter(); 
    
            for (int i = 0; i < placeCounter; i++) {
                if (equis[i] != null) { 
                    System.out.println((i + 1) + ". " + equis[i].getName() + " - Área: " + equis[i].getArea() + " km^2");
                }
            }
        } else {
            System.out.println("No hay lugares registrados para mostrar.");
        }
    }
    private static void consultPlaceInformation(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Ingresa el nombre del lugar registrado: ");
        String placeName = scanner.nextLine().trim(); 
    
        if (placeName == null) {
            System.out.println("No has ingresado un nombre. Por favor, intenta de nuevo.");
            return;  
        }
    
        Place[] places = controller.getPlaces();
        if (places == null || places.length == 0) {
            System.out.println("No hay lugares registrados para consultar.");
            return;            
        }        

        boolean placeFound = false;
            for (Place place : places) {
                if (place != null && place.getName().equalsIgnoreCase(placeName)) {  // Asegúrate de que 'place' no sea null antes de llamar a getName()
                    System.out.println("\nInformación del lugar " + placeName + ":");
                    System.out.println("Nombre: " + place.getName());
                    System.out.println("Área: " + place.getArea() + " km^2");
                    System.out.println("Foto: " + place.getPhotoPath());
                    System.out.println("Recursos necesarios: $" + place.getResources());
                    placeFound = true;
                    break;
                }
            }
        
    
        if (!placeFound) {
            System.out.println("Lugar no encontrado. Por favor, verifica el nombre e intenta de nuevo.");
        }
    }

    
}
