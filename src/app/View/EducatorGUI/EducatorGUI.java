package app.View.EducatorGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.App;
import app.mainframe;
import app.Helper.Helper;
import app.Model.Course;
import app.Model.Educator;
import app.Model.Lessons;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TabPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class EducatorGUI {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button eduexitbutt;

    @FXML
    private TextField filtitle;

    @FXML
    private ComboBox<String> fillcourse;

    @FXML
    private Button filbutt;

    @FXML
    private TableView<Lessons> tableContent;

    @FXML
    private TableColumn<Lessons, Integer> col_id;

    @FXML
    private TableColumn<Lessons, String> col_title;

    @FXML
    private TableColumn<Lessons, String> col_desc;

    @FXML
    private TableColumn<Lessons, String> col_link;

    @FXML
    private TableColumn<Lessons, String> col_course;

    @FXML
    private TableView<Lessons> tableQesitions;

    @FXML
    private TableColumn<Lessons, Integer> colQuestionId;

    @FXML
    private TableColumn<Lessons, String> colQuestionTitle;

    @FXML
    private TableColumn<Lessons, String> colQuestionQ;

    @FXML
    private TableColumn<Lessons, String> colQuestionAnswer;

    @FXML
    private TableColumn<Lessons, String> colQuestionRight;

    @FXML
    private TabPane addpane;

    @FXML
    private TextField addtitle;

    @FXML
    private TextField addDesc;

    @FXML
    private TextField addLink;

    @FXML
    private ComboBox<String> addCourse;

    @FXML
    private Button addButt;

    @FXML
    private TextArea addQuestion;

    @FXML
    private TextArea addAnswer;

    @FXML
    private ComboBox<String> addRight;

    @FXML
    private ComboBox<String> addQuestionTitle;

    @FXML
    private Button addQuestionButton;

    public int educator_id;
    
  
    public void setId(int id){
        this.educator_id=id;
        listContent(getId());
        listQuestions(getId());
    }   
    public int getId(){
        return this.educator_id;
    }
    @FXML
    void initialize() { 
        assert eduexitbutt != null : "fx:id=\"eduexitbutt\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert filtitle != null : "fx:id=\"filtitle\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert fillcourse != null : "fx:id=\"fillcourse\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert filbutt != null : "fx:id=\"fillcourse\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert tableContent != null : "fx:id=\"tableContent\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert col_id != null : "fx:id=\"col_id\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert col_title != null : "fx:id=\"col_title\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert col_desc != null : "fx:id=\"col_desc\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert col_link != null : "fx:id=\"col_link\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert col_course != null : "fx:id=\"col_course\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert tableQesitions != null : "fx:id=\"tableQesitions\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert colQuestionTitle != null : "fx:id=\"colQuestionTitle\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert colQuestionId != null : "fx:id=\"colQuestionId\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert colQuestionQ != null : "fx:id=\"colQuestionQ\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert colQuestionAnswer != null : "fx:id=\"colQuestionAnswer\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert colQuestionRight != null : "fx:id=\"colQuestionRight\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addpane != null : "fx:id=\"addtitle\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addtitle != null : "fx:id=\"addtitle\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addDesc != null : "fx:id=\"addDesc\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addLink != null : "fx:id=\"addLink\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addCourse != null : "fx:id=\"addCourse\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addButt != null : "fx:id=\"addButt\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addQuestion != null : "fx:id=\"addQuestion\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addAnswer != null : "fx:id=\"addAnswer\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addRight != null : "fx:id=\"addRight\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addQuestionTitle != null : "fx:id=\"addQuestionTitle\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        assert addQuestionButton != null : "fx:id=\"addQuestionButton\" was not injected: check your FXML file 'EducatorGUI.fxml'.";
        handle();
        addContent();
        filter(); 
        
        addQuestion();
       
    }


    public void handle(){
        eduexitbutt.setOnAction(arg0->{ 
            Stage stage = (Stage) eduexitbutt.getScene().getWindow();
            stage.close();
            App app = new App();
            app.start(new Stage());
        });
    }


    public void listContent(int id){
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_title.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_title.setCellFactory(TextFieldTableCell.forTableColumn());
        col_desc.setCellValueFactory(new PropertyValueFactory<>("desc"));
        col_desc.setCellFactory(TextFieldTableCell.forTableColumn());
        col_link.setCellValueFactory(new PropertyValueFactory<>("link"));
        col_link.setCellFactory(TextFieldTableCell.forTableColumn());
        col_course.setCellValueFactory(new PropertyValueFactory<>("branch"));
        col_course.setCellFactory(TextFieldTableCell.forTableColumn());

        tableContent.setOnMouseClicked(e->{
            if(tableContent.getSelectionModel().getSelectedIndex()!=-1){
            ContextMenu contextMenu = new ContextMenu();
            MenuItem deleItem = new MenuItem("Sil");
            MenuItem updateItem = new MenuItem("Güncelle");

            contextMenu.getItems().addAll(deleItem, updateItem);
            deleItem.setOnAction(ee->{
                Lessons.deleteLesson(tableContent.getSelectionModel().getSelectedItem().getId());
                loadContent(educator_id);
            });
            update();
 
           
            tableContent.setContextMenu(contextMenu);   
            }
        }); 
        
        loadContent(id);
    }
    public void update(){

        col_title.setOnEditCommit(e->{
        Lessons.update(e.getRowValue().getId(),"name", e.getNewValue());
        }); 
        col_desc.setOnEditCommit(e->{
        Lessons.update(e.getRowValue().getId(),"description", e.getNewValue());
        });  
        col_link.setOnEditCommit(e->{
        Lessons.update(e.getRowValue().getId(),"youtubelink", e.getNewValue());
        });  
        col_course.setOnEditCommit(e->{
        Lessons.update(e.getRowValue().getId(),"lessbranch", e.getNewValue());
        });
        }


    public void loadContent(int id) {
    tableContent.getItems().clear();
    tableContent.getItems().addAll(Lessons.getLessons(id));
    }


    public void addContent(){
        
        addCourse.setOnMouseClicked(e->{     
            addCourse.getItems().clear();     
            for(Course c: Course.getCourses()){
                if(c.getUser_id()==educator_id){
                    addCourse.getItems().add(c.getName());
                }
            }
            if(addCourse.getItems().size()==0){
            Helper.showMsg("Eğitmen için atanmış ders bulunmamaktadır.");
            }
           
        });
        addButt.setOnAction(e-> {
            if(addtitle.getText().isEmpty()||addLink.getText().isEmpty()||addCourse.getSelectionModel().getSelectedItem().isBlank()){
                Helper.showMsg("fill");
            }else{
                Lessons.addLesson(educator_id, addtitle.getText(), addDesc.getText(), addLink.getText(), addCourse.getSelectionModel().getSelectedItem());
                loadContent(educator_id);
            }
        });
    }

    
    public void filter(){
        fillcourse.setOnMouseClicked(e->{
        fillcourse.getItems().clear();
        for(Course c: Course.getCourses()){
            fillcourse.getItems().add(c.getName());
        }
    });
        filbutt.setOnAction(e-> {
         if(fillcourse.getSelectionModel().getSelectedItem()==null&&filtitle.getText().isEmpty()){
            Helper.showMsg("fill");
        }else{
        tableContent.getItems().clear();
        tableContent.getItems().addAll(Lessons.filter(filtitle.getText(),fillcourse.getSelectionModel().getSelectedItem()));
        }   
        });
    }

    public void addQuestion(){
      
        addQuestionTitle.setOnMouseClicked(e->{
            addQuestionTitle.getItems().clear();
          for(Lessons l : Lessons.getLessons(educator_id)){
            addQuestionTitle.getItems().add(l.getName());
        }  
        });
        
        
        addRight.getItems().addAll("A","B","C","D");
        addQuestionButton.setOnAction(e->{
            addQuestionTitle.getSelectionModel().getSelectedItem();
            if(addQuestion.getText().isEmpty()||addAnswer.getText().isEmpty()||addRight.getSelectionModel().getSelectedItem()==null||addQuestionTitle.getSelectionModel().getSelectedItem()==null){
                Helper.showMsg("Tüm alanları doldurduğunuzdan emin olun.");
            }else{
                Lessons.addquizquestions(addQuestion.getText(),addAnswer.getText(),addRight.getSelectionModel().getSelectedItem(),Lessons.getLessons(educator_id).get(addQuestionTitle.getSelectionModel().getSelectedIndex()).getId());

                tableQesitions.getItems().clear();
                tableQesitions.getItems().addAll(Lessons.getQuestions(educator_id));
            }
        });
    }
    

    public void listQuestions(int educator){
        colQuestionId.setCellValueFactory(new PropertyValueFactory<>("qId"));
        colQuestionTitle.setCellValueFactory(new PropertyValueFactory<>("contentString"));
        colQuestionTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        colQuestionQ.setCellValueFactory(new PropertyValueFactory<>("questionString"));
        colQuestionQ.setCellFactory(TextFieldTableCell.forTableColumn());
        colQuestionAnswer.setCellValueFactory(new PropertyValueFactory<>("selectionsString"));
        colQuestionAnswer.setCellFactory(TextFieldTableCell.forTableColumn());
        colQuestionRight.setCellValueFactory(new PropertyValueFactory<>("rightString"));
        colQuestionRight.setCellFactory(TextFieldTableCell.forTableColumn());
        tableQesitions.getItems().clear();
        tableQesitions.getItems().addAll(Lessons.getQuestions(educator));
        updateQuestion();
    }
    
    public void updateQuestion(){

        colQuestionTitle.setOnEditCommit(e->{
            for(Lessons lessons : Lessons.getQuestions(educator_id)){
                if(lessons.getName()==e.getNewValue()){
                    Lessons.updateQuestion(e.getRowValue().getQId(),"lessid", String.valueOf(lessons.getId()));
                }
            }
        }); 
        colQuestionQ.setOnEditCommit(e->{
        Lessons.updateQuestion(e.getRowValue().getQId(),"question", e.getNewValue());
        });  
        colQuestionAnswer.setOnEditCommit(e->{
        Lessons.updateQuestion(e.getRowValue().getQId(),"selections", e.getNewValue());
        });  
        colQuestionRight.setOnEditCommit(e->{
        Lessons.updateQuestion(e.getRowValue().getQId(),"answer", e.getNewValue());
        });
        }


}
