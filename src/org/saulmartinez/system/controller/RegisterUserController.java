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

        if (validate.isFieldEmpty(user) == false
                || validate.isFieldEmpty(name) == false
                || validate.isFieldEmpty(lastName) == false
                || validate.isFieldEmpty(email) == false
                || validate.isFieldEmpty(password) == false
                || validate.isFieldEmpty(confirmPass) == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS",
                    "ERROR DE CAMPO",
                    "DEJÓ CAMPOS VACIOS DEL FORMULARIO");

            return;
        }

        //Longitud de texto
        if (validate.validateLengthOfText(user, 25)||
            validate.validateLengthOfText(name, 50) ||
            validate.validateLengthOfText(lastName, 50)||
            validate.validateLengthOfText(email, 50) ||
            validate.validateLengthOfText(password, 50)){
            
        }
    }

}
