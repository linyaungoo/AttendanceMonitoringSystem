import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;

public class invalidIDController {
    @FXML
    private Button btnOk;



    public void setBtnOk(javafx.event.ActionEvent event) {

            Stage stage=(Stage) btnOk.getScene().getWindow();
            stage.close();

    }
}
