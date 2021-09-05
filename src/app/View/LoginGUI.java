package app.View;

import java.net.URL;
import java.util.ResourceBundle;
import app.Model.User;
import app.View.EducatorGUI.EducatorGUI;
import app.View.OperatorGUI.OperatorGUI;
import app.View.StudentGUI.StudentGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class LoginGUI {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField logname;

    @FXML
    private TextField logpass;

    @FXML
    private Button lobbutton;

    @FXML
    private Button signupButton;

    
    @FXML
    void initialize() {
        assert logname != null : "fx:id=\"logname\" was not injected: check your FXML file 'Untitled'.";
        assert logpass != null : "fx:id=\"logpass\" was not injected: check your FXML file 'Untitled'.";
        assert lobbutton != null : "fx:id=\"lobbutton\" was not injected: check your FXML file 'Untitled'.";
       login();
    }

    public void login(){
        signupButton.setOnAction(arg0->{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUpGUI.fxml"));
                BorderPane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Hello World!");
                primaryStage.initModality(Modality.APPLICATION_MODAL);
                primaryStage.setScene(scene);
                primaryStage.show();
                }catch(Exception ee){
                System.out.println(ee.getMessage());
                
            }
            Stage stage =(Stage)lobbutton.getScene().getWindow();
            stage.close();
        });
        
        lobbutton.setOnAction(e->{
            if(logname.getText().length()==0||logpass.getText().length()==0){
                System.out.println("Boşlukları Doldurunuz!");
            }else{
                for(User u : User.getList()){
                   if(logname.getText().equals(u.getUname())&&logpass.getText().equals(u.getPass())){
                       switch(u.getType()){
                           case "operator":
                           
                            try{
                                FXMLLoader fxmlLoader = new FXMLLoader(OperatorGUI.class.getResource("OperatorGUI.fxml"));
                                GridPane root = fxmlLoader.load();
                                OperatorGUI operatorGUI = (OperatorGUI)fxmlLoader.getController();
                                operatorGUI.setname(u.getName());
                                Scene scene = new Scene(root);
                                Stage primaryStage = new Stage();
                                primaryStage.setTitle("Hello World!");
                                primaryStage.initModality(Modality.APPLICATION_MODAL);
                                primaryStage.setScene(scene);
                                primaryStage.show();
                                }catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                           break;
                           case "student":
                           try{
                            FXMLLoader fxmlLoader1 = new FXMLLoader(StudentGUI.class.getResource("StudentGUI.fxml"));
                            Pane root1 = fxmlLoader1.load();
                            StudentGUI educatorGUI = (StudentGUI)fxmlLoader1.getController();
                            educatorGUI.setId(u.getId());
                            Scene scene1 = new Scene(root1); 
                            Stage primaryStage1 = new Stage();
                            primaryStage1.setTitle("Student");
                            primaryStage1.initModality(Modality.APPLICATION_MODAL);
                            primaryStage1.setScene(scene1);
                            primaryStage1.show();
                            }catch(Exception ee){
                            System.out.println(ee.getMessage());
                    }
                           break;
                           case "educator":
                           try{
                                FXMLLoader fxmlLoader1 = new FXMLLoader(EducatorGUI.class.getResource("EducatorGUI.fxml"));
                                AnchorPane root1 = fxmlLoader1.load();
                                EducatorGUI educatorGUI = (EducatorGUI)fxmlLoader1.getController();
                                educatorGUI.setId(u.getId());
                                Scene scene1 = new Scene(root1); 
                                Stage primaryStage1 = new Stage();
                                primaryStage1.setTitle("Hello World!");
                                primaryStage1.initModality(Modality.APPLICATION_MODAL);
                                primaryStage1.setScene(scene1);
                                primaryStage1.show();
                                }catch(Exception ee){
                                System.out.println(ee.getMessage());
                        }
                        break;
                       }
                       Stage stage =(Stage)lobbutton.getScene().getWindow();
                       stage.close();
                   }
           }
        }
          
        });
    }


}