import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FillData {
    @FXML
    private Button btnOk;



    public void setBtnOk(javafx.event.ActionEvent event) {

        Stage stage=(Stage) btnOk.getScene().getWindow();
        stage.close();

    }
}
