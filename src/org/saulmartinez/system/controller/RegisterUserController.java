/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.saulmartinez.system.service.UserService;
import org.saulmartinez.system.service.UserStatus;
import org.saulmartinez.system.utils.AlertInformation;
import org.saulmartinez.system.utils.Validations;
import org.saulmartinez.system.utils.ViewFactory;

/**
 *
 * @author informatica
 */
public class RegisterUserController implements Initializable {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private PasswordField pwdConfirmPass;

    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();
    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onCreateAccount(MouseEvent event) {
        boolean isEmailValid = validate.emailValidation(txtEmail.getText().trim());

        if (isEmailValid == false) {
            alertInfo.viewAlert("ERROR", "ERROR EMAIL", "ERROR DE CAMPO", "HAS INGRESADO UN EMAIL INCORRECTO");
        }
        String user, name, email, lastName, password, confirmPass;
        user = txtUsername.getText().trim();
        name = txtName.getText().trim();
        email = txtEmail.getText().trim();
        lastName = txtLastName.getText().trim();
        password = pwdPassword.getText().trim();
        confirmPass = pwdConfirmPass.getText().trim();

        if (validate.isFieldEmpty(user) == true
                || validate.isFieldEmpty(name) == true
                || validate.isFieldEmpty(lastName) == true
                || validate.isFieldEmpty(email) == true
                || validate.isFieldEmpty(password) == true
                || validate.isFieldEmpty(confirmPass) == true) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS",
                    "ERROR DE CAMPO",
                    "DEJÓ CAMPOS VACIOS DEL FORMULARIO");

            return;
        }

        //Longitud de texto
        String msgField = "";
        if (validate.validateLengthOfText(user, 25) == false) {
            msgField = "El campo usuario es mayor de 25 caracteres";
        }
        if (validate.validateLengthOfText(name, 50) == false) {
            msgField = "El campo name es mayor de 50 caracteres";
        }
        if (validate.validateLengthOfText(lastName, 50) == false) {
            msgField = "El campo lastName es mayor de 50 caracteres";
        }
        if (validate.validateLengthOfText(email, 50) == false) {
            msgField = "El campo email es mayor de 50 caracteres";
        }
        if (validate.validateLengthOfText(password, 35) == false) {
            msgField = "El campo password es mayor de 35 caracteres";
        }
        if (msgField.isEmpty() == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO", "ERROR", msgField);
            return;
        }
        if (validate.equalsText(password, confirmPass) == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CONTRASEÑA", "ERROR", "SUS CONTRASEÑAS NO COINCIDEN");
            return;
        }
        UserStatus status
                = userService.createUser(user, name, lastName, email, password);

        switch (status) {
            case UserStatus.ERROR_USER_CREATE ->
                System.out.println("Error al crear en crtl");
            case UserStatus.USER_CREATED ->
                System.out.println("Si se creo el usuario");
            case UserStatus.EMPTY_FIELDS ->
                System.out.println("Los campos no estan vacios");
            case UserStatus.INVALID_LENGTH_VALUE ->
                System.out.println("Validar longitud del texto");

            default ->
                System.out.println("Uknown error");
        }
    }

}
