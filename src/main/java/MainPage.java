import commands.ShowCommand;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.text.Text;


import java.io.IOException;
import java.sql.SQLException;

public class MainPage extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        System.out.println("test");
        // установка надписи
        Parent root = FXMLLoader.load(getClass().getResource("ShowPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");
        stage.setWidth(697);
        stage.setHeight(495);
        stage.show();
    }
}