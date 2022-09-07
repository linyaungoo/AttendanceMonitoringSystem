import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class dashboardController {
    @FXML
    private Button btn_logout;
    public void btn_logoutOnAction(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();
        Stage stage=(Stage) btn_logout.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_AddStaff;

    public void btn_AddStaffOnAction(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newStaff.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_SearchStaff;

    public void setBtn_SearchStaffOnAction(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("searchStaffData.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_updateStaff;


    public void setBtn_updateStaff(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("updateStaffData.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_deleteStaff;
    public void setBtn_deleteStaff(ActionEvent a) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("deleteStaff.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_Attendence;
    public void setBtn_Attendence(ActionEvent a) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("attendence.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_reportData;
    public void setBtn_reportData(ActionEvent a) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("attendenceReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_AddStaff.getScene().getWindow();
        stage.close();
    }
}
