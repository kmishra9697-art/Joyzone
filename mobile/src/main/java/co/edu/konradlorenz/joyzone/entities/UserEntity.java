package co.edu.konradlorenz.joyzone.entities;

import java.util.ArrayList;

public class UserEntity {

    private String FirstName;
    private String LastName;
    private int Age;
    private String Description;
    private ArrayList interests;

    public UserEntity(String firstName, String lastName, int age, String description, ArrayList interests) {
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Description = description;
        this.interests = interests;
    }

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

    public ArrayList getInterests() {
        return interests;
    }

    public void setInterests(ArrayList interests) {
        this.interests = interests;
    }
}
