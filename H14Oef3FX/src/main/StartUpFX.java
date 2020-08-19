package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import domein.Login;
import gui.RegistratieScherm;

public class StartUpFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {   
        Login login = new Login();
        RegistratieScherm registratiescherm = new RegistratieScherm(login);
        Scene scene = new Scene(registratiescherm,400,150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registratie");
        primaryStage.show();
    }    
    
    public static void main(String[] args) {
        launch(args);
    } 
}
