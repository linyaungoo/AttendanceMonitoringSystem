import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;

public class attendenceReportController  {
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
    private Button btn_newStaff;

    public void setBtn_newStaff(ActionEvent event) throws IOException {

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

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_back.getScene().getWindow();
        stage.close();

    }

//    @FXML
//    private TableView<attdReport> table;
//    @FXML
//    private TableColumn<attdReport,String> name;
//    @FXML
//    private TableColumn<attdReport,String> id;
//    @FXML
//    private TableColumn<attdReport, String> attd;
//    @FXML
//    private TableColumn<attdReport, String> date;
//
//
//    @FXML
//    private TextField tf_id;
//    @FXML
//    private DatePicker date_field;
//
//
//    String query;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        name.setCellValueFactory(new PropertyValueFactory<attdReport, String>("name"));
//        id.setCellValueFactory(new PropertyValueFactory<attdReport, String>("id"));
//        attd.setCellValueFactory(new PropertyValueFactory<attdReport, String>("attd"));
//        date.setCellValueFactory(new PropertyValueFactory<attdReport, String>("date"));
//
//
//
//    }
//    String gId,gDate;
//    DatabaseConnection connectNow = new DatabaseConnection();
//    Connection connectDB;
//    public void searchByDate(ActionEvent event) {
//
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//        gId=tf_id.getText();
//        gDate=String.valueOf(date_field.getValue());
//
//
//        ObservableList<attdReport> reports = FXCollections.observableArrayList();
//        ObservableList<attdReport> row= FXCollections.observableArrayList();
//
//        System.out.println(gDate);
//        String query="SELECT staff_data.name,attendence.staff_id,attendence.attd,attendence.date FROM staff_data, attendence WHERE attendence.date='"+gDate+"' AND staff_data.staff_id=attendence.staff_id ORDER BY attendence.aid ASC ;";
//        try{
//            Statement statement = connectDB.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            int i=0;
//            while (resultSet.next()) {
//
//                attdReport attdReports=new attdReport();
//
//                attdReports.setName(resultSet.getString("name"));
//                attdReports.setId(resultSet.getString("staff_id"));
//                attdReports.setAttd(String.valueOf(resultSet.getInt("attd")));
//                attdReports.setDate(resultSet.getString("date"));
//                reports.add(i,attdReports);
//
//
//
////                    System.out.println(reports.size());
//                System.out.println(reports.get(i).getName());
//                System.out.println(reports.get(i).getId());
//                System.out.println(reports.get(i).getAttd());
//                System.out.println(reports.get(i).getDate());
//                i++;
//
//            }
//
////            for (int j=0;j<reports.size();j++)
////            {
////                System.out.println(reports.get(j).getName());
////                System.out.println(reports.get(j).getId());
////                System.out.println(reports.get(j).getAttd());
////                System.out.println(reports.get(j).getDate());
////            }
//            table.setItems(reports);
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    String rName,rId,rAttd,rDate;
//
//    public void searchById(ActionEvent event) {
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
//        gId=tf_id.getText();
//        gDate=String.valueOf(date_field.getValue());
//        attdReport attdReports=new attdReport();
//        ObservableList<attdReport> reports = FXCollections.observableArrayList();
//
//        String query="SELECT staff_data.name,attendence.staff_id,attendence.attd,attendence.date FROM staff_data, attendence WHERE staff_data.staff_id='"+gId+"'AND attendence.staff_id='"+gId+"'ORDER BY attendence.aid ASC ;";
//        try {
//            Statement statement = connectDB.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            int i=0;
//            System.out.println(resultSet);
//            while (resultSet.next()) {
//
//
//                    attdReports.setName(resultSet.getString("name"));
//                    attdReports.setId(resultSet.getString("staff_id"));
//                    attdReports.setAttd(String.valueOf(resultSet.getInt("attd")));
//                    attdReports.setDate(resultSet.getString("date"));
//                    reports.add(attdReports);
//
//
//            }
//
//
//            for (int j=0;j<reports.size();j++)
//            {
//                System.out.println(reports.get(j).getName());
//                System.out.println(reports.get(j).getId());
//                System.out.println(reports.get(j).getAttd());
//                System.out.println(reports.get(j).getDate());
//            }
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @FXML
    Button mReport;
    public void setMonthlyReport(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MonthlyReport.fxml"));
        Scene scene = new Scene(((FXMLLoader) fxmlLoader).load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) mReport.getScene().getWindow();
        stage.close();
    }
    @FXML
    Button yReport;
    public void setYearlyReport(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("YearlyReportOnTable.fxml"));
        Scene scene = new Scene(((FXMLLoader) fxmlLoader).load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) yReport.getScene().getWindow();
        stage.close();
    }
}
