import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController{


    @FXML
    private Button btn_cancel;

    @FXML
    private Button btn_login;

    @FXML
    private Label login_message_label;

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    public void btn_loginOnAction(ActionEvent event)
    {

//        String[] id={"0000000001","0000000002","0000000003","0000000004","0000000005","0000000006","0000000007"};
//        for(int d=0;d<7;d++){
//            System.out.println("INSERT INTO `attendence` (`staff_id`, `attd`, `date`, `aid`) VALUES ('"+id[d]+"', '1', '2022-08-1', NULL);");
//        }


        if (tf_username.getText().isBlank() == false && pf_password.getText().isBlank() == false){

           autoCountAtdd();

            //login_message_label.setText("pass");
            validateLogin();
        }else {
            login_message_label.setText("Please Enter Username & Password !!");
        }
    }

    public void btn_cancelOnAction(ActionEvent event){
        Stage stage=(Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }
    public void autoCountAtdd(){
        DatabaseConnection connection=new DatabaseConnection();
        Connection connect = connection.getConnection();
        try{
            Statement statement = connect.createStatement();
            int arryLength=0;
            String time = String.valueOf(java.time.LocalDate.now());
            ResultSet staffCont = statement.executeQuery("SELECT COUNT(1) FROM staff_data;");
            while (staffCont.next()){
                arryLength=staffCont.getInt("COUNT(1)");
            }
            System.out.println("Array Length:"+arryLength);
            staffCont.close();
            ResultSet staffIdData = statement.executeQuery("SELECT staff_id FROM staff_data;");
            int i=0;
            String [] id = new String[arryLength];
            while (staffIdData.next()){
                id[i] = staffIdData.getString("staff_id");
                i++;
            }
            System.out.println("Array:");
                for (int j=0;j<arryLength;j++)
                {
                    System.out.println(id[j]);


                }
            staffCont.close();
            ResultSet checkDay = statement.executeQuery("SELECT COUNT(1) FROM attendence WHERE date='"+time+"';");
            while (checkDay.next()) {
                if (checkDay.getInt("COUNT(1)") == 0) {



                    for (int j = 0; j < arryLength; j++) {
                        System.out.println("Insert"+id[j]);
                        statement.executeUpdate("INSERT INTO `attendence` (`staff_id`, `attd`, `date`, `aid`) VALUES ('" + id[j] + "', '0', '" + time + "', NULL)");

                    }
                }
                else {
                    System.out.println("already inserted");
                }
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE Username = '"+tf_username.getText()+"' AND Password = '"+pf_password.getText()+"'";
        try{

            Statement statement = connectDB.createStatement();


            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()){
                if (queryResult.getInt(1) == 1){
                    login_message_label.setText("Pass!!");
                    Stage dash = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 600, 400);

                    dash.initStyle(StageStyle.UNDECORATED);
                    dash.setScene(scene);
                    dash.show();

                    Stage stage=(Stage) btn_cancel.getScene().getWindow();
                    stage.close();
                }else {
                    login_message_label.setText("Invalid Login, Please try again!!");
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}