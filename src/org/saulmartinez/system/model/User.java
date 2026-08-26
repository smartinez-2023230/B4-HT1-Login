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

    private String iduser;
    private String email;
    private String name;
    private String lastname;
    private String password;
    private String user;

    public User(){}
    
    public User(String iduser, String email, String name, String lastname, String password, String user) {
        this.iduser = iduser;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.user = user;
    }

    public User(String password, String email, String name, String lastname, String user) {
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.user = user;
    }

    
    
    public String getId_user() {
        return iduser;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public void setId_user(String id_user) {
        this.iduser = id_user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastname = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
