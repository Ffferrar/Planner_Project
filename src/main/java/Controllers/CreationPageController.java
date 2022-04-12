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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

public class CreationPageController{
    //initType - показывает, какой Target создается
    public void initType(TargetType type) {
        this.targetType = type;
    }
    TargetType targetType;

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
    private DatePicker dateField = new DatePicker();

    @FXML
    private void date(ActionEvent event) throws IOException {
        if (dateField.getValue() != null ){
            LocalDate localDate = dateField.getValue();
            this.date = new GregorianCalendar();
            this.date.setTime( java.sql.Date.valueOf(localDate) );
            System.out.println(this.date);
        }
    }

    @FXML
    private Button confirmButton;

    @FXML
    private void click(ActionEvent event) throws SQLException {

        if (this.name != null && this.date != null){
            switch (this.targetType){
                case Small:
                    new SmallTargetFactory().createTarget(this.name, this.date, 0, 0);
                case Middle:
                    new MiddleTargetFactory().createTarget(this.name, this.date, 0, 0);
                case Super:
                    new SuperTargetFactory().createTarget(this.name, this.date, 0, 0);
            }
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();

        }
    }
}