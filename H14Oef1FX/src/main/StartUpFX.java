package main;

import domein.EigenString;
import gui.TelScherm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUpFX extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {   
        EigenString es = new EigenString("iets");
        TelScherm telscherm = new TelScherm(es);
        Scene scene = new Scene(telscherm,400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tellen");
        primaryStage.show();
    }    
    
    public static void main(String[] args) {
        launch(args);
    } 
}
