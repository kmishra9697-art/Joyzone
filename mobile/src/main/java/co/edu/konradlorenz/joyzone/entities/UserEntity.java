package co.edu.konradlorenz.joyzone.entities;

import java.util.ArrayList;

public class UserEntity {

    private String FirstName;
    private String LastName;
    private int Age;
    private String Description;
    private ArrayList Eventos;

    public UserEntity(String firstName, String lastName, int age, String description, ArrayList eventos) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Description = description;
        Eventos = eventos;
    }
    public UserEntity(){}

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList getEventos() {
        return Eventos;
    }

    public void setEventos(ArrayList eventos) {
        Eventos = eventos;
    }
}
