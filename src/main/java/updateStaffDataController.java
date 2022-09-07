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
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class updateStaffDataController implements Initializable {
    @FXML
    private Button btn_logout;
    Stage dash = new Stage();
    FXMLLoader fxmlLoader;
    public void btn_logoutOnAction(ActionEvent event) throws IOException {

        fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
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

        fxmlLoader = new FXMLLoader(Main.class.getResource("newStaff.fxml"));
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

        fxmlLoader = new FXMLLoader(Main.class.getResource("searchStaffData.fxml"));
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
        fxmlLoader = new FXMLLoader(Main.class.getResource("updateStaffData.fxml"));
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
        fxmlLoader = new FXMLLoader(Main.class.getResource("deleteStaff.fxml"));
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

        fxmlLoader = new FXMLLoader(Main.class.getResource("attendence.fxml"));
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
        fxmlLoader = new FXMLLoader(Main.class.getResource("attendenceReport.fxml"));
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
        fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
        stage.close();

    }

    @FXML
    private Button btnSearch;
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
    private ChoiceBox <String> cb_role;
    @FXML
    private DatePicker dateHire;
    @FXML
    private DatePicker dateBirth;

    String id,name,role,hireDate,phone,email,birthDate,address;
    public void setBtnSearch(ActionEvent event) {
        id = tf_id.getText();


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String updateString="SELECT * FROM staff_data WHERE staff_id = '"+id+"';";

        ResultSet queryResult=null;
        Statement statement=null;
        try {
            statement = connectDB.createStatement();
            queryResult = statement.executeQuery(updateString);
            while (queryResult.next()){
                id=queryResult.getString("staff_id");
                name= queryResult.getString("name");
                birthDate =queryResult.getString("date_of_birth");
                phone = queryResult.getString("phone");
                email = queryResult.getString("email");
                hireDate = queryResult.getString("date_of_hire");
                role = queryResult.getString("role");
                address = queryResult.getString("address");
                tf_id.setText(id);
                tf_name.setText(name);
                tf_address.setText(address);
                tf_email.setText(email);
                tf_phone.setText(phone);
//                dateBirth.setValue(LOCAL_DATE(birthDate));
                cb_role.getItems().set(1,role);


            }
            System.out.println(id+name+address+email+phone);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if(queryResult !=null){
                    queryResult.close();
                }
                if (statement !=null)
                {
                    statement.close();
                }
                if (connectDB !=null){
                    connectDB.close();
                }
            }catch (SQLException ex) {
                System.out.println(ex);
            }
        }



    }
//    public static final LocalDate LOCAL_DATE (String dateString){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate localDate = LocalDate.parse(dateString, formatter);
//        return localDate;
//    }

    @FXML
    private Button btnUpdate;
    public void setBtnUpdate(ActionEvent event){
        String id = tf_id.getText();
        String name=tf_name.getText();
        String phone=tf_phone.getText();
        String email= tf_email.getText();
        String address= tf_address.getText();
        String role=cb_role.getValue();
        String hireDate= String.valueOf(dateHire.getValue());
        String birthDate= String.valueOf(dateBirth.getValue());
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String updateQuery="UPDATE staff_data SET name='"+name+"',date_of_birth='"+birthDate+"', phone='"+phone+"',email='"+email+"',date_of_hire='"+hireDate+"',role='"+role+"',address='"+address+"' WHERE staff_id='"+id+"';";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(updateQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] rank={"Rector","Pro-Rector","Professor","Associate Professor","Lecturer","Assistant Lecture","Tutor","Office Staff"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cb_role.getItems().addAll(rank);

    }

}
