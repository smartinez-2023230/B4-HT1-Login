/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.service;

import org.saulmartinez.system.model.User;
import org.saulmartinez.system.repository.UserRepository;
import org.saulmartinez.system.utils.AlertInformation;
import org.saulmartinez.system.utils.Validations;

/**
 *
 * @author informatica
 */
public class UserService {

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserRepository userRepo = new UserRepository();

    public UserStatus createUser(String user, String name, String lastName, String email, String password) {
        if (validate.isFieldEmpty(user) == true
                || validate.isFieldEmpty(name) == true
                || validate.isFieldEmpty(lastName) == true
                || validate.isFieldEmpty(email) == true
                || validate.isFieldEmpty(password) == true) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS",
                    "ERROR DE CAMPO",
                    "DEJÓ CAMPOS VACIOS DEL FORMULARIO");
            return UserStatus.EMPTY_FIELDS;
        }
        try {
            User newUser = new User(password, email, name, lastName, user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATED;
        } catch (Exception e) {
            return UserStatus.ERROR_USER_CREATE;
        }
    }
}
