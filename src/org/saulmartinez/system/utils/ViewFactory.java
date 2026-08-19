/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.saulmartinez.system.utils;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import org.saulmartinez.system.ClasePrincipal;

/**
 *
 * @author informatica
 */
public class ViewFactory {

    private final String PATH_VIEWS = "/org/saulmartinez/system/view/";

    public Scene loadFileFXML(String nameFXML, int width, int height) {
        String filePath = PATH_VIEWS + nameFXML;
        try {
            FXMLLoader loader = new FXMLLoader();

            URL urlFile = ClasePrincipal.class.getResource(filePath);
            loader.setBuilderFactory(new JavaFXBuilderFactory());
            loader.setLocation(urlFile);

            return new Scene(loader.load(), width, height);

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    public void loadScene(String FXMLname) {
        Scene scene = null;
        try {
            switch (FXMLname) {
                case "login" -> {
                    SceneManager.getInstanciaSceneManager().getMainStage().setTitle("Login");
                    SceneManager.getInstanciaSceneManager().getMainStage().setResizable(false);
                    scene = loadFileFXML("LoginView.fxml", 400, 500);
                }
                default ->
                    
                    scene = loadFileFXML("LoginView.fxml", 300, 400);
            }
            SceneManager.getInstanciaSceneManager().changeScene(scene);
        } catch (NullPointerException objetonulo) {
            System.out.println("error loading the scene");
        }
    }

    public void viewLogin() {
        loadScene("login");
    }
}
