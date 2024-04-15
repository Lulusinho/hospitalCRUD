package GUI;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControler {
  private Stage loginstage;
  private Parent loginroot;
  private Scene loginscene;
  @FXML
  TextField inputlogin;

  @FXML
  PasswordField passwordlogin;

  @FXML
  Button buttonid;

  @FXML
  public void getinfo(ActionEvent e) {

    FXMLLoader laoder = new FXMLLoader(getClass().getResource("resources/main.fxml"));
    try {
      loginroot = laoder.load();

    } catch (IOException exception) {
      System.out.println("couldn't load the main scene");
      exception.printStackTrace();
      System.exit(-1);
    }
    MainController controller = laoder.getController();
    controller.wellcomelb.setText("Wellcome: " + inputlogin.getText());

    loginstage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    loginscene = new Scene(loginroot);
    loginstage.setScene(loginscene);
    loginstage.show();
  }

}
