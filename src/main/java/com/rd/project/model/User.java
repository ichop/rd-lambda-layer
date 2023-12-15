package com.rd.project.model;

public class User {
    private Integer id;
    private String email;
    private String name;
    private String surname;
    private String role;

    public User() {
    }

    public User( String email, String name, String surname, String role) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
