/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author informatica
 */
public class AlertInformation {

    public AlertInformation() {
    }     

    public void viewAlert(String alertType, String title, String header, String message) {
        AlertType type;

        // Switch to determine the AlertType from the received String
        switch (alertType.toUpperCase()) {
            case "INFORMATION":
                type = AlertType.INFORMATION;
                
            case "WARNING":
                type = AlertType.WARNING;
                
            case "ERROR":
                type = AlertType.ERROR;
                
            case "CONFIRMATION":
                type = AlertType.CONFIRMATION;
                
            case "NONE":
                type = AlertType.NONE;
                
            default:
                // If the type is not recognized, default to an information alert
                type = AlertType.INFORMATION;
                break;
        }

        // Creation and configuration of the alert
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);

        // Show the alert and wait for the user's response
        alert.showAndWait();
    }
}
