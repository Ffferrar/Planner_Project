package Controllers;

import commands.ShowCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import targetFactory.SuperTargetFactory;
import targets.SuperTarget;
import targets.Target;
import utils.TargetType;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class DataPageController {
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
        List<Target> list =  new ShowCommand("Super").execute();
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
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MiddlePage.fxml"));
                try {
                    this.root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                MiddlePageController middlePageController = loader.getController();
                middlePageController.initParentID(list.get(finalI).getId());

                Stage stage = (Stage) btn.getScene().getWindow();
                stage.setScene(new Scene(root, 529, 329));
                    });

            usersData.add(btn);
        }

    }

    @FXML
    private Button createButton;

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
    private Button reloadButton;

    @FXML
    private void click_reload(ActionEvent event) throws IOException, SQLException {
        initialize();
    }
}
