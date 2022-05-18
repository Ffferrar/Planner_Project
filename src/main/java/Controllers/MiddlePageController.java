package Controllers;

import commands.ShowCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import targets.Target;
import utils.TargetType;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class MiddlePageController {
    String parentID;

    public void initParentID(String parentID){
        this.parentID = parentID;
    }

    private ObservableList<Button> usersData = FXCollections.observableArrayList();
    private Parent root;
    TargetType targetType;

    @FXML
    private ListView<Button> tableTargets;

    // инициализируем форму данными
    @FXML
    public void initialize() throws SQLException {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        // заполняем таблицу данными
        tableTargets.setItems(usersData);
    }

    private void initData() throws SQLException {
        usersData = FXCollections.observableArrayList();
        List<Target> list =  new ShowCommand(this.parentID).execute();
        for (int i = 0; i < list.size(); i++){
            final Button btn = new Button();

            SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMM-yyyy");
            String stringData = formattedDate.format(list.get(i).endData.getTime());

            GregorianCalendar actualData = new GregorianCalendar();
            int dateResult = actualData.compareTo(list.get(i).endData);

            if (dateResult < 0){
                btn.setStyle("-fx-background-color: green");
            }
            else{btn.setStyle("-fx-background-color: orange");}

            btn.setText(list.get(i).name + " " + stringData);

            int finalI = i;
            btn.setOnAction((ActionEvent event) -> {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("LittlePage.fxml"));
                try {
                    this.root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SmallPageController smallPageController = loader.getController();
                smallPageController.initParentID(list.get(finalI).getId());

                Stage stage = (Stage) btn.getScene().getWindow();
                stage.setScene(new Scene(root, 529, 329));
            });

            usersData.add(btn);
        }


    }

    @FXML
    private Button createButton;

    @FXML
    private void click_middle(ActionEvent event) throws IOException {
        this.targetType = TargetType.Middle;

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("CreationPage.fxml"));
        root = loader.load();
        CreationPageController creationPageController = loader.getController();
        creationPageController.initType(targetType);
        creationPageController.initParentID(parentID);

        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(529);
        stage.setHeight(329);
        stage.show();

    }

    @FXML
    private Button reloadButton;

    @FXML
    private void click_reload(ActionEvent event) throws IOException, SQLException {
        initialize();
    }

    @FXML
    private Button returnButton;

    @FXML
    private void click_return(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("ShowPage.fxml"));
        root = loader.load();

        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();

        DataPageController dataPageController = loader.getController();

        Stage stage1 = new Stage();
        Scene scene = new Scene(root);
        stage1.setScene(scene);
        stage1.setWidth(529);
        stage1.setHeight(329);
        stage1.show();
    }

}
