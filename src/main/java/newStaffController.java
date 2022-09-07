import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class newStaffController implements Initializable {
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
    private Button btn_newStaff;

    public void setBtn_newStaff(ActionEvent event) throws IOException {
        Stage dash = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("newStaff.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_searchStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
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

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
        stage.close();

    }

    @FXML
    private Button btn_addData;

    String id,name,role,hireDate,phone,email,birthDate,address;

    @FXML
    private ChoiceBox<String> select_role;
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_name;
    @FXML
    private TextField tf_phone;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_address;

    @FXML
    private DatePicker hire_date;

    @FXML
    private DatePicker birth_date;
    public void setBtn_addData(ActionEvent event) throws IOException {
        id=tf_id.getText();
        name=tf_name.getText();
        phone=tf_phone.getText();
        email=tf_email.getText();
        address=tf_address.getText();
        role=select_role.getValue();
        hireDate= String.valueOf(hire_date.getValue());
        birthDate=String.valueOf(birth_date.getValue());
        if(id.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(name.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(phone.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(email.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(address.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(role.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(hireDate.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }else if(birthDate.isBlank()!=false){
            Stage dash = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fillData.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 200, 85);

            dash.initStyle(StageStyle.UNDECORATED);
            dash.setScene(scene);
            dash.show();
        }

        else validateId();
//        else validateId();




//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//        String insertData="INSERT INTO `staffdata` (`staff_id`, `name`, `date_of_birth`, `gender`, `address`) VALUES ('"+id+"', '"+name+"', '2002-07-03', '1', '"+address+"');";
//        Statement statement = null;
//
//        try {
//            statement = connectDB.createStatement();
//            statement.executeUpdate(insertData);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }

    public void validateId(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verify = "SELECT count(1) FROM staff_data WHERE staff_id = '"+id+"'";

        try{


            Statement statement = connectDB.createStatement();
                ResultSet queryResult = statement.executeQuery(verify);
            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){

                    Stage dash = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("invalidID.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 200, 85);

                    dash.initStyle(StageStyle.UNDECORATED);
                    dash.setScene(scene);
                    dash.show();


                }


                else {
                    String insertData="INSERT INTO `staff_data` (`staff_id`, `name`, `date_of_birth`, `phone`, `email`, `date_of_hire`, `role`, `address`) VALUES ('"+id+"', '"+name+"', '"+birthDate+"', '"+phone+"', '"+email+"', '"+hireDate+"', '"+role+"', '"+address+"');";
//                    statement = connectDB.createStatement();
                    statement.executeUpdate(insertData);
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private String[] rank={"Rector","Pro-Rector","Professor","Associate Professor","Lecturer","Assistant Lecture","Tutor","Office Staff"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select_role.getItems().addAll(rank);

    }
}
