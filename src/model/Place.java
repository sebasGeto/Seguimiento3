package model;

public class Place {
    private String name;
    private double area;
    private String photoPath;
    private double resources;

    public Place(String name, double area, String photoPath, double resources) {
        this.name = name;
        this.area = area;
        this.photoPath = photoPath;
        this.resources = resources;
    }

    public String toString(){

        String msg = "";

        msg += "Nombre: "+ name;
        msg += "\nArea: "+ area;
        msg += "\nFoto: "+ photoPath;
        msg += "\nRecursos: "+resources;

        return msg;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public double getResources() {
        return resources;
    }

}
