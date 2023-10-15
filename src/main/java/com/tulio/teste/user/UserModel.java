package com.tulio.teste.user;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity(name = "TB_User")
public class UserModel {
   
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
     
    String name;
    String password;
    String occupation;

    public UUID getId() {
        return this.id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    public String getOccupation() {
        return this.occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
