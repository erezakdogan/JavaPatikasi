/**
 * Sample Skeleton for 'SignUpGUI.fxml' Controller Class
 */

package app.View;

import java.net.URL;
import java.util.ResourceBundle;

import app.Helper.Helper;
import app.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SignUpGUI {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="signpass"
    private TextField signpass; // Value injected by FXMLLoader

    @FXML // fx:id="signuname"
    private TextField signuname; // Value injected by FXMLLoader

    @FXML // fx:id="signname"
    private TextField signname; // Value injected by FXMLLoader

    @FXML // fx:id="signbutt"
    private Button signbutt; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert signpass != null : "fx:id=\"signpass\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signuname != null : "fx:id=\"signuname\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signname != null : "fx:id=\"signname\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        assert signbutt != null : "fx:id=\"signbutt\" was not injected: check your FXML file 'SignUpGUI.fxml'.";
        signbutt.setOnAction(arg0->{
            if(signname.getText().length()==0||signpass.getText().length()==0||signuname.getText().length()==0){
                Helper.showMsg("fill");
            }else{
                User.add(signname.getText(), signuname.getText(), signpass.getText(), "student");
            }
        });
    }


}
