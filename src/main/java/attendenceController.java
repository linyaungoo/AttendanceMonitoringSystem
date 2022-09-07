import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class attendenceController {
    @FXML
    private Button btn_logout;

    public void btn_logoutOnAction(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();
        Stage stage = (Stage) btn_logout.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_newStaff;

    public void setBtn_newStaff(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newStaff.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_searchStaff;

    public void setBtn_SearchStaffOnAction(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("searchStaffData.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage = (Stage) btn_searchStaff.getScene().getWindow();
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

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_attendence;

    public void setBtn_Attendence(ActionEvent a) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("attendence.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_attdReport;

    public void setBtn_reportData(ActionEvent a) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("attendenceReport.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button btn_back;

    public void setBtn_back(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage = (Stage) btn_newStaff.getScene().getWindow();
        stage.close();

    }


    @FXML
    TextField tf_id;


    String id;
    String query = "";
    String verify = "";

    @FXML
    Label label;

    public void setBtn_attend(ActionEvent event) {
        id = tf_id.getText();



        String time = String.valueOf(java.time.LocalDate.now());
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        verify = "SELECT COUNT(1) FROM attendence WHERE staff_id='" + id + "' AND date='" + time + "';";
        query = "INSERT INTO `attendence` (`staff_id`, `attd`, `date`) VALUES ('" + id + "', '1', '" + time + "');";
        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verify);
            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    label.setText("Already Attend");
                    System.out.println("already attend");
                }
                else {
                    statement = connectDB.createStatement();
                    statement.executeUpdate(query);
                    label.setText("Attend");
                    System.out.println("Attend");
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}