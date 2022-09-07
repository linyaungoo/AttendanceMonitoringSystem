import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class deleteStaffController implements Initializable {
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
    private Button btnSearch;

    @FXML
    TextField tf_id;
    String rStaffID,staffID,rName,rRank,rDob,rHireDate,rAddress,rPhone,rEmail;

    ObservableList<SearchStaffData> list;
    public void setBtnSearch(ActionEvent event) {
        staffID=tf_id.getText();
        System.out.println(1111);

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String selectData="SELECT * FROM staff_data WHERE staff_id = '"+staffID+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet result = statement.executeQuery(selectData);
            while (result.next()){
                rStaffID=result.getString("staff_id");
                rName= result.getString("name");
                rDob =result.getString("date_of_birth");
                rPhone = result.getString("phone");
                rEmail = result.getString("email");
                rHireDate = result.getString("date_of_hire");
                rRank = result.getString("role");
                rAddress = result.getString("address");

            }
            System.out.println(staffID+rName+rDob);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        list= FXCollections.observableArrayList(
                new SearchStaffData(staffID,rName,rRank,rDob,rHireDate,rAddress)
        );
        table.setItems(list);

    }

    public void SetBtnDelete(ActionEvent event) {
        String id=tf_id.getText();
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String deleteQuery="DELETE FROM staff_data WHERE staff_id='"+id+"';";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(deleteQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    private TableView<SearchStaffData> table;



    @FXML
    private TableColumn<SearchStaffData, String> id;

    @FXML
    private TableColumn<SearchStaffData, String> name;

    @FXML
    private TableColumn<SearchStaffData, String> rank;

    @FXML
    private TableColumn<SearchStaffData, String> dob;

    @FXML
    private TableColumn<SearchStaffData, String> hireD;

    @FXML
    private TableColumn<SearchStaffData, String> address;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("name"));
        rank.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("rank"));
        dob.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("dob"));
        hireD.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("hireDate"));
        address.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("address"));



    }

}
