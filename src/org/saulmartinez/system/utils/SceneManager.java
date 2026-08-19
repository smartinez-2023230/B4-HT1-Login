/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.utils;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage mainStage;

    private SceneManager() {

    }

    public static SceneManager getInstanciaSceneManager() {
        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }
        return instanciaSceneManager;
    }

    /**
     * Este metodo permite recibir un parametro de tipo Scene y 
     * es la escena que se mostrara en el stage.
     * @param scene Escena a mostrar
     */
    
    public void changeScene(Scene scene) {
        try {
            mainStage.setScene(scene);
            mainStage.sizeToScene();
            mainStage.show();
        } catch (NullPointerException objetoNulo) {

        }
    }

    public Stage getMainStage() {
        return mainStage;
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

}
