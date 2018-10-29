package co.edu.konradlorenz.joyzone.entities;

import java.util.Date;

public class EventEntity {

    private String Name;
    private String Description;
    private String Date;
    private String Spot;
    private String Direccion;
    private String Users;

    public EventEntity(String name, String description, String date, String spot, String direccion, String users) {
        Name = name;
        Description = description;
        Date = date;
        Spot = spot;
        Direccion = direccion;
        Users = users;
    }

    public EventEntity(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSpot() {
        return Spot;
    }

    public void setSpot(String spot) {
        Spot = spot;
    }

    public String getdireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getUsers() {
        return Users;
    }

    public void setUsers(String users) {
        Users = users;
    }
}
