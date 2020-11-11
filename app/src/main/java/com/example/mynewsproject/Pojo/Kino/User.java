package com.example.mynewsproject.Pojo.Kino;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private String pol;

    public User(String firstName, String lastName, int age, String pol) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pol = pol;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }
}
