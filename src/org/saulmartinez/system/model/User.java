/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.model;

/**
 *
 * @author informatica
 */
public class User {
    private String id_user;
    private String email;
    private String name;
    private String lastName;
    private String password;
    private String user;

    public String getId_user() {
        return id_user;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
