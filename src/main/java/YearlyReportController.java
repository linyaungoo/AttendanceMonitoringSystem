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
import java.sql.Statement;


public class YearlyReportController {
    Stage dash = new Stage();
    @FXML
    Button btn_logout;
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
        System.out.println("work");

        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();
        stage.close();

    }





    @FXML
    TextField tfID;
    @FXML
    TextField tf_year;

    @FXML
    Button btn_view;
    @FXML
    Label lName;
    @FXML
    Label lId;
    @FXML
    Label lDate;
    @FXML
    Label lTotalLeave;

    @FXML
    Label lTotalDay;

    @FXML
    Label sName,sId,sDate,sTotalLeave,sTotalDay;



    String sentID;
    public void setBtnViewOnTable(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(Main.class.getResource("YearlyReportOnTable.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        dash.initStyle(StageStyle.UNDECORATED);
        dash.setScene(scene);
        dash.show();

        Stage stage=(Stage) btn_newStaff.getScene().getWindow();


        stage.close();


    }

    public YearlyReportController(String sentID) {
        this.sentID = sentID;
    }

    public  String getIDData(){
        sentID=tfID.getText();
        return sentID;
    }


    public void setBtnSearchReport(ActionEvent event) {
        String id=tfID.getText();
        String year=tf_year.getText();
        btn_view.setVisible(true);

        lDate.setVisible(true);
        lName.setVisible(true);
        lId.setVisible(true);
        lTotalDay.setVisible(true);
        lTotalLeave.setVisible(true);


        sDate.setVisible(true);
        sName.setVisible(true);
        sId.setVisible(true);
        sTotalDay.setVisible(true);
        sTotalLeave.setVisible(true);

        String queryForDayCountNameID="SELECT COUNT(1),attendence.staff_id,staff_data.name FROM attendence,staff_data WHERE attendence.staff_id=staff_data.staff_id AND attendence.staff_id='"+id+"' AND date BETWEEN '"+year+"-01-01' AND '"+year+"-12-31';";
        String queryForLeaveCont="SELECT COUNT(1) FROM attendence WHERE attendence.attd=0 AND attendence.staff_id='"+id+"' AND attendence.date BETWEEN '"+year+"-01-01' AND '"+year+"-12-31';";
        String queryForLeaveDays="SELECT attendence.date FROM attendence WHERE attendence.staff_id='"+id+"' AND attendence.attd=0 AND attendence.date BETWEEN '"+year+"-01-01' AND '"+year+"-12-31';";

        String resultName = null,resultID = null,resultDayCount = null,rLeaveCount=null;

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(queryForDayCountNameID);

            while (queryResult.next()){
                resultName=queryResult.getString("name");
                resultDayCount=queryResult.getString(1);
                resultID=queryResult.getString(2);
            }
            queryResult.close();
            queryResult=statement.executeQuery(queryForLeaveCont);
            while (queryResult.next()){
                rLeaveCount=queryResult.getString(1);
            }
            sTotalLeave.setText(rLeaveCount);
            queryResult.close();


        }catch (Exception e){
            System.out.println(e);
        }

        sName.setText(resultName);
        sId.setText(resultID);
        sTotalDay.setText(resultDayCount);
    }

    public void setPrintReport(ActionEvent event) {
    }
}
