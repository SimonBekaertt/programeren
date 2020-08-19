package gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import domein.Login;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;

public class RegistratieScherm extends GridPane
{    
    private TextField txfGebruikersnaam, txfWachtwoord, txfWachtwoord2;
    private Login login;

    public RegistratieScherm(Login login)
    {
        this.login = login;
        buildGui();
    }
    
    private void buildGui()
    {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
        
        add(new Label("Gebruikersnaam:"),0,0);     
        txfGebruikersnaam = new TextField();
        add(txfGebruikersnaam,1,0);

        add(new Label("Wachtwoord:"),0,1);     
        txfWachtwoord = new TextField();
        add(txfWachtwoord,1,1);

        add(new Label("Bevestig wachtwoord:"),0,2);     
        txfWachtwoord2 = new TextField();
        add(txfWachtwoord2,1,2);        
 
// We maken constraints aan voor beide kolommen en geven aan dat de tweede kolom mag groeien/krimpen
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(col1, col2);
        
        txfGebruikersnaam.setOnAction(this::txfGebruikersnaamAction);
        txfWachtwoord.setOnAction(this::txfWachtwoordAction);
        txfWachtwoord2.setOnAction(this::txfWachtwoord2Action);
    }
    private void txfGebruikersnaamAction(ActionEvent event)
    {
        try
        {
            login.setGebruikersnaam(txfGebruikersnaam.getText());
            txfWachtwoord.requestFocus();
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfGebruikersnaam.selectAll();
        }
    }
    private void txfWachtwoordAction(ActionEvent event)
    {
        try
        {
            login.setWachtwoord(txfWachtwoord.getText());
            txfWachtwoord2.requestFocus();
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfWachtwoord.selectAll();
        }
    }
    private void txfWachtwoord2Action(ActionEvent event)
    {
        try
        {
            String invoer = txfWachtwoord2.getText();
            if (invoer == null || invoer.isEmpty())
                 throw new IllegalArgumentException("Gelieve het wachtwoord te bevestigen");
            if (!invoer.equals(login.getWachtwoord()))
                  throw new IllegalArgumentException("Gelieve het wachtwoord correct te bevestigen");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("OK");
            alert.setHeaderText(null);
            alert.setContentText("Alle ingevoerde gegevens worden aanvaard");
            alert.showAndWait();   
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText(iae.getMessage());
            alert.showAndWait();
            txfWachtwoord2.selectAll();
        }
    }    
}
