package com.example.preguntitas.object;

public class Users {
    String Id;
    String Name;
    String Email;
    String Password;
    Boolean Type;

    public Users(String id, String name, String email, String password, Boolean type) {
        Id = id;
        Name = name;
        Email = email;
        Password = password;
        Type = type;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getType() {
        return Type;
    }

    public void setType(Boolean type) {
        Type = type;
    }
}
