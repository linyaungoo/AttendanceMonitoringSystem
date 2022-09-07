import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class YearlyReportOnTableController implements Initializable {


    public void setPrintReport(ActionEvent event) {
        System.out.println("result:");
        System.out.println(yearlyReportController.getIDData());
    }
    @FXML
    Label setID;
    String id="99";
    YearlyReportController yearlyReportController= new YearlyReportController(id);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setID.setText(yearlyReportController.getIDData());

    }


    Stage dash = new Stage();
    @FXML
    private Button btn_logout;
    public void btn_logoutOnAction(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();
        Stage stage=(Stage) btn_logout.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_back;
    public void setBtn_back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MonthlyReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_back.getScene().getWindow();
        stage.close();

    }
}