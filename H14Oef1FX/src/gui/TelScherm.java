package gui;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextArea;
import domein.EigenString;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class TelScherm extends GridPane
{    
    private TextField txfTekst;
    private TextArea txaResultaat;
    private EigenString eigenString;

    public TelScherm(EigenString eigenString)
    {
        this.eigenString = eigenString;
        buildGui();
    }
    
    private void buildGui()
    {
        setPadding(new Insets(10));
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
        
        add(new Label("Geef een zin in en druk op \"Enter\": "),0,0);
        
        txfTekst = new TextField();
     //   txfTekst.setMinWidth(300);
        add(txfTekst,0,1);

        txaResultaat = new TextArea();
        txaResultaat.setStyle("-fx-font-family: monospace"); 
//font nodig waar elke letter evenveel ruimte inneemt voor correcte formattering 
        add(txaResultaat,0,2);
//laatste rij vergroot/verkleint bij vergroten/verkleinen van het scherm        
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);
        this.getRowConstraints().addAll(row1, row2, row3);
//eerste kolom vergroot/verkleint bij vergroten/verkleinen van het scherm
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(col1);       
        
        txfTekst.setOnAction(this::txfTekstAction);
    }
    private void txfTekstAction(ActionEvent event)
    {
        try
        {
            eigenString.setTekst(txfTekst.getText());
            txaResultaat.appendText(eigenString.telKaraktersVolgensSoort());
        }
        catch (IllegalArgumentException iae)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fout");
            alert.setHeaderText(null);
            alert.setContentText("Tekst moet ingevuld zijn");
            alert.showAndWait();
        }
    }
}