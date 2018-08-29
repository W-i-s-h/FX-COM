package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window1 = primaryStage;
        primaryStage.setOnCloseRequest(event -> windowClose());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("COM порт");
        primaryStage.setScene(new Scene(root, 325, 600));
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        primaryStage.setMaximized(false);
        primaryStage.show();

    }

    private void windowClose() {
        window1.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
