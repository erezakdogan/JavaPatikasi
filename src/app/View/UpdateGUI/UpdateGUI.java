package app.View.UpdateGUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UpdateGUI{
    int id;
    String name;
    public UpdateGUI(int id, String name){
        this.id=id;
        this.name=name;
        // try{
        //     FXMLLoader fxmlLoader = new FXMLLoader(UpdateGUI.class.getResource("UpdateGUI.fxml"));
        //     Parent root = fxmlLoader.load();
        //     Scene scene = new Scene(root);
        //     Stage primaryStage =new Stage();
        //     primaryStage.setTitle("Hello World!");
    
        //     primaryStage.setScene(scene);
        //     primaryStage.show();
        //     }catch(Exception e){
        //         System.out.println(e.getMessage());
        // }
        ubutt.setOnAction(e->{
            System.out.println(utext.getText());
        });
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button ubutt;

    @FXML
    private TextField utext;

    @FXML
    void initialize() {
        System.out.println("utext.getText()");
        assert ubutt != null : "fx:id=\"ubutt\" was not injected: check your FXML file 'UpdateGUI..fxml'.";
        assert utext != null : "fx:id=\"utext\" was not injected: check your FXML file 'UpdateGUI..fxml'.";
    }

    @FXML
    private void handleConnectButtonAction(ActionEvent event){
   System.out.println("df");          
}

    private void up(String text) {
        System.out.println(text);
    }
    
}