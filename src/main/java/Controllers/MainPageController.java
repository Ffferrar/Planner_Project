package Controllers;

import commands.CreateCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import utils.TargetType;

import java.io.IOException;
import java.sql.SQLException;

public class MainPageController{
    private Parent root;

    TargetType targetType;

    @FXML
    private Button createSTButton;

    @FXML
    private void click_small(ActionEvent event) throws IOException {
        this.targetType = TargetType.Small;

        //Обращается к CreationPageController
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CreationPage.fxml"));
        root = loader.load();
        CreationPageController creationPageController = loader.getController();
        creationPageController.initType(targetType);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(529);
        stage.setHeight(329);
        stage.show();
    }



    @FXML
    private Button createMTButton;

    @FXML
    private void click_middle(ActionEvent event) throws IOException {
        this.targetType = TargetType.Middle;

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CreationPage.fxml"));
        root = loader.load();
        CreationPageController creationPageController = loader.getController();
        creationPageController.initType(targetType);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(529);
        stage.setHeight(329);
        stage.show();
    }



    @FXML
    private Button createSuperTButton;

    @FXML
    private void click_super(ActionEvent event) throws IOException {
        this.targetType = TargetType.Super;

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CreationPage.fxml"));
        root = loader.load();
        CreationPageController creationPageController = loader.getController();
        creationPageController.initType(targetType);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(529);
        stage.setHeight(329);
        stage.show();
    }

    @FXML
    private Button showButton;

    @FXML
    private void click_show(ActionEvent event) throws IOException, SQLException {

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ShowPage.fxml"));
        root = loader.load();
        DataPageController dataPageController = loader.getController();
        dataPageController.initialize();

        Stage stage = (Stage) showButton.getScene().getWindow();
        stage.setScene(new Scene(root, 529, 329));

    }



}