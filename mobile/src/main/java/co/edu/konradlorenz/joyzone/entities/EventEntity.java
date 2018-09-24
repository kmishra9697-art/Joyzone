package co.edu.konradlorenz.joyzone.entities;

import java.util.Date;

public class EventEntity {

    private String Name;
    private String Description;
    private Date Date;
    private String Spot;
    private String direccion;
    private int Users;

    public EventEntity(String name, String description, java.util.Date date, String spot, String direccion, int users) {
        Name = name;
        Description = description;
        Date = date;
        Spot = spot;
        this.direccion = direccion;
        Users = users;
    }

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

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public String getSpot() {
        return Spot;
    }

    public void setSpot(String spot) {
        Spot = spot;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getUsers() {
        return Users;
    }

    public void setUsers(int users) {
        Users = users;
    }
}
