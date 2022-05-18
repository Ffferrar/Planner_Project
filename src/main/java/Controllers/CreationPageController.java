package Controllers;

import commands.CreateCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import targetFactory.MiddleTargetFactory;
import targetFactory.SmallTargetFactory;
import targetFactory.SuperTargetFactory;
import utils.TargetType;


import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.GregorianCalendar;

public class CreationPageController{
    //initType - показывает, какой Target создается
    public void initType(TargetType type) {
        this.targetType = type;
    }
    public void initParentID(String parentID) {
        this.parentID = parentID;
    }

    TargetType targetType;
    String parentID;


    String name = null;
    GregorianCalendar date;

    @FXML
    private TextField textField = new TextField();

    @FXML
    private void text(ActionEvent event) throws IOException {
        if ((textField.getText() != null && !textField.getText().isEmpty())) {
            this.name = textField.getText();
        }
    }

    @FXML
    private DatePicker dataField = new DatePicker();

    @FXML
    private void data(ActionEvent event) throws IOException {
        if ((dataField.getValue() != null)) {
            this.date = GregorianCalendar.from(dataField.getValue().atStartOfDay(ZoneId.systemDefault()));
        }
    }

    @FXML
    private Button confirmButton;

    @FXML
    private void click(ActionEvent event) throws SQLException {

        if (this.name != null){

            new CreateCommand(targetType, this.name, 0, this.date, parentID).execute();

            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();

        }
    }
}