package app;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class mainframe  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    private TextField textField2;


    @FXML
    void initialize() {
        System.out.println("hello");

    }

    
    public void handle() {
        System.out.println(textField.getText() + " "+textField2.getText());
        JOptionPane.showMessageDialog(null, "seni nerde ve ne zaman sikebilirim "+textField.getText() , "Hello", JOptionPane.INFORMATION_MESSAGE);
    }
}


