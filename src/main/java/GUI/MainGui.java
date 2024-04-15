package GUI;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainGui extends Application {

  public void startapplication() {
    launch("luis");
  }

  @Override
  public void start(Stage stage) {
    Parent root;
    FXMLLoader laoder = new FXMLLoader(getClass().getResource("resources/login.fxml"));
    try {
      root = laoder.load();
    } catch (IOException e) {
      System.out.println(e.getLocalizedMessage() + " " + e.getMessage());
      e.printStackTrace();
      throw new RuntimeException();
    }
    Scene scene = new Scene(root, Color.DEEPPINK);
    stage = new Stage();
    stage.setTitle("ANELLE BOBA");
    stage.setScene(scene);
    stage.show();
  }
}
