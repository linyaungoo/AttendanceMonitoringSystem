import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class searchStaffDataController implements Initializable {
    @FXML
    private Button btn_logout;

    public searchStaffDataController() {
    }

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

//    @FXML
//    private TableView<SearchStaffData> table;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> id;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> name;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> rank;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> dob;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> hireD;
//
//    @FXML
//    private TableColumn<SearchStaffData, String> address;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        id.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("id"));
//        name.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("name"));
//        rank.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("rank"));
//        dob.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("dob"));
//        hireD.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("hireDate"));
//        address.setCellValueFactory(new PropertyValueFactory<SearchStaffData, String>("address"));



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
    TextField tf_id;
    String rStaffID,staffID,rName,rRank,rDob,rHireDate,rAddress,rNrc,rEmail;

    ObservableList<SearchStaffData>list;



    @FXML
    Label label_name;
    @FXML
    Label label_address;
    @FXML
    Label label_id;
    @FXML
    Label label_role;
    @FXML
    Label label_dob;
    @FXML
    Label label_nrc;
    @FXML
    Label label_email;

    @FXML
    Label name;
    @FXML
    Label nrc;
    @FXML
    Label id;
    @FXML
    Label email;
    @FXML
    Label dob;
    @FXML
    Label address;
    @FXML
    Label role;

    @FXML
    ImageView imageView;


    public void setBtnSearch(ActionEvent event) throws FileNotFoundException {
        staffID=tf_id.getText();


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
                rNrc = result.getString("nrc");
                rEmail = result.getString("email");
                rHireDate = result.getString("date_of_hire");
                rRank = result.getString("role");
                rAddress = result.getString("address");

            }



            id.setVisible(true);
            nrc.setVisible(true);
            name.setVisible(true);
            email.setVisible(true);
            role.setVisible(true);
            address.setVisible(true);
            dob.setVisible(true);

            label_id.setVisible(true);
            label_nrc.setVisible(true);
            label_name.setVisible(true);
            label_address.setVisible(true);
            label_role.setVisible(true);
            label_email.setVisible(true);
            label_dob.setVisible(true);

            label_id.setText(rStaffID);
            label_nrc.setText(rNrc);
            label_email.setText(rEmail);
            label_role.setText(rRank);
            label_address.setText(rAddress);
            label_dob.setText(rDob);
            label_name.setText(rName);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        list= FXCollections.observableArrayList(
//                new SearchStaffData(staffID,rName,rRank,rDob,rHireDate,rAddress)
//        );
//        table.setItems(list);

    }
    @FXML
    TextField tf_name;

    public void searchByName(ActionEvent event) {
        staffID=tf_name.getText();


        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String selectData="SELECT * FROM staff_data WHERE name = '"+staffID+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet result = statement.executeQuery(selectData);
            while (result.next()){
                rStaffID=result.getString("staff_id");
                rName= result.getString("name");
                rDob =result.getString("date_of_birth");
                rNrc = result.getString("nrc");
                rEmail = result.getString("email");
                rHireDate = result.getString("date_of_hire");
                rRank = result.getString("role");
                rAddress = result.getString("address");

            }
            label_id.setText(rStaffID);
            label_nrc.setText(rNrc);
            label_email.setText(rEmail);
            label_role.setText(rRank);
            label_address.setText(rAddress);
            label_dob.setText(rDob);
            label_name.setText(rName);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        list= FXCollections.observableArrayList(
//                new SearchStaffData(staffID,rName,rRank,rDob,rHireDate,rAddress)
//        );
//        table.setItems(list);
    }
}
