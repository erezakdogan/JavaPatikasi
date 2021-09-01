package app.View.OperatorGUI;

import java.net.URL;
import java.util.ResourceBundle;

import app.App;
import app.Helper.Helper;
import app.Model.Patika;
import app.Model.User;
import app.View.LoginGUI;
import app.Model.Operator;
import app.Model.Course;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class OperatorGUI {
    Operator operator;

    @FXML
    private Button button;
    @FXML
    private Label userlabel;

    @FXML 
    private TableView<User> tableview;
    @FXML
    private TableColumn<User,Integer> idofid;
    @FXML
    private TableColumn<User,String> nameColumn;
    @FXML
    private TableColumn<User, String> uColumn;
    @FXML
    private TableColumn<User,String> pColumn;
    @FXML
    private TableColumn<User,String> utColumn;
    
    @FXML
    private Button addButton;
    @FXML
    private TextField addname;
    @FXML
    private TextField adduname;   
    @FXML
    private TextField addpass;
    @FXML
    private ComboBox<String> addtype;
    @FXML
    private TextField deleteId;
    @FXML
    private Button deleteButton;
   
   
    @FXML
    private Button sbutton;
    @FXML
    private TextField sname;   
    @FXML
    private TextField suname;
    @FXML
    private ComboBox<String> stype;


    @FXML 
    private TableView<Patika> pTableView;
    @FXML
    private TableColumn<Patika,Integer> patid;
    @FXML
    private TableColumn<Patika,String> patname;
    @FXML
    private Tab patTabid;
    @FXML
    private TabPane tabpane;


    @FXML
    private Button addpatbutt;
    @FXML
    private TextField addpattext ;   

  
    @FXML 
    private TableView<Course> tabders;

    @FXML
    private TableColumn<Course, Integer> idofders;

    @FXML
    private TableColumn<Course, String> nameders;

    @FXML
    private TableColumn<Course, String> language;

    @FXML
    private TableColumn<Course, String> patcol;

    @FXML
    private TableColumn<Course, String> egitcol;

    @FXML
    private TextField dan;

    @FXML
    private TextField dal;

    @FXML
    private ComboBox<String> dap;

    @FXML
    private ComboBox<String> dae;

    @FXML
    private Button dab;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    void initialize() { 
    assert button != null : "fx:id=\"button\" was not injected: check your FXML file 'OperatorGUI.fxml'.";    
    assert userlabel != null : "fx:id=\"button\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert tabpane != null : "fx:id=\"tabpane\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert sname != null : "fx:id=\"sname\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert suname != null : "fx:id=\"suname\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert stype != null : "fx:id=\"stype\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert sbutton != null : "fx:id=\"sbutton\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert tableview != null : "fx:id=\"tableview\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert idofid != null : "fx:id=\"idofid\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert nameColumn != null : "fx:id=\"nameColumn\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert uColumn != null : "fx:id=\"uColumn\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert pColumn != null : "fx:id=\"pColumn\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert utColumn != null : "fx:id=\"utColumn\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addname != null : "fx:id=\"addname\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert adduname != null : "fx:id=\"adduname\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addpass != null : "fx:id=\"addpass\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addtype != null : "fx:id=\"addtype\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert deleteId != null : "fx:id=\"deleteId\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert patTabid != null : "fx:id=\"patTabid\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addpattext != null : "fx:id=\"addpattext\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert addpatbutt != null : "fx:id=\"addpatbutt\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert pTableView != null : "fx:id=\"pTableView\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert patid != null : "fx:id=\"patid\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert patname != null : "fx:id=\"patname\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert tabders != null : "fx:id=\"tabders\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert idofders != null : "fx:id=\"idofders\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert nameders != null : "fx:id=\"nameders\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert language != null : "fx:id=\"language\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert patcol != null : "fx:id=\"patcol\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert egitcol != null : "fx:id=\"egitcol\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert dan != null : "fx:id=\"dan\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert dal != null : "fx:id=\"dal\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert dap != null : "fx:id=\"dap\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert dae != null : "fx:id=\"dae\" was not injected: check your FXML file 'OperatorGUI.fxml'.";
    assert dab != null : "fx:id=\"dab\" was not injected: check your FXML file 'OperatorGUI.fxml'.";

        button.setOnAction(e->{
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
            App app = new App();
            app.start(new Stage());
        });
        listUser();
        addUser();
        deleteUser();
        update();
        search();
        listPatikas();
        listCourses();
    }
    String username;
    public void setname(String name){
        this.username=name;
        userlabel.setText("Hoşgeldiniz : "+username);
    }
 
    private void loadusers() {
        tableview.getItems().clear();
        tableview.getItems().addAll(User.getList());
    }
    public void listUser(){
        idofid.setCellValueFactory(new PropertyValueFactory<>("id"));    
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        uColumn.setCellValueFactory(new PropertyValueFactory<>("uname"));
        uColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        pColumn.setCellValueFactory(new PropertyValueFactory<>("pass"));
        pColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        utColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        utColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        loadusers();
    }
    
    public void addUser(){
        addtype.getItems().removeAll();
        addtype.setValue("operator");
        addtype.getItems().addAll("operator","educator","student");
        addButton.setOnAction(e -> {
            if(addname.getText().length()==0||adduname.getText().length()==0||addpass.getText().length()==0){
                Helper.showMsg("fill");
               
            }else if(!User.getUser(adduname.getText())){
                
                User.add(addname.getText(), adduname.getText(), addpass.getText(), addtype.getSelectionModel().getSelectedItem());
                addname.clear();
                adduname.clear();
                addpass.clear(); 
                loadusers();
                Helper.showMsg("success");


            }else{
               Helper.showMsg("reuname");
            }
        });
        
    }

    public void deleteUser(){
      
        tableview.setOnMouseClicked(e-> {
        int str = tableview.getSelectionModel().getSelectedIndex();
        if(str!=-1){
        deleteId.setText(String.valueOf(tableview.getItems().get(str).getId()));
        } });  
            deleteButton.setOnAction(e -> {
            User.delete(Integer.parseInt(deleteId.getText()));
           
            addname.clear();
            adduname.clear();
            addpass.clear();
            loadusers();
        });
       
    }
    public void update(){

    nameColumn.setOnEditCommit(e->{
        User.update(e.getRowValue().getId(),"name", e.getNewValue());
    });
    uColumn.setOnEditCommit(e->{
        User.update(e.getRowValue().getId(),"uname", e.getNewValue());
    });  
    pColumn.setOnEditCommit(e->{
        User.update(e.getRowValue().getId(),"pass", e.getNewValue());
    });  
    utColumn.setOnEditCommit(e->{
        User.update(e.getRowValue().getId(),"type", e.getNewValue());
    });
    }

    public void search(){
        stype.getItems().addAll("all","operator","educator","student");
        sbutton.setOnAction(e-> {
            if(sname.getText()==""&&suname.getText()==""&&stype.getSelectionModel().getSelectedItem()==""){
                Helper.showMsg("fill");
            }else{
            
            tableview.getItems().clear();
            tableview.getItems().addAll(User.search(sname.getText(),suname.getText(),stype.getSelectionModel().getSelectedItem()));
            sname.clear();
            suname.clear();
    
            }
                
        });
    }
    private void loadpatikas() {
        pTableView.getItems().clear();
        pTableView.getItems().addAll(Patika.listPatikas());
    }

    public void listPatikas(){
    patid.setCellValueFactory(new PropertyValueFactory<>("id"));    
    patname.setCellValueFactory(new PropertyValueFactory<>("name"));
    patname.setCellFactory(TextFieldTableCell.forTableColumn());
    loadpatikas();
    
    pTableView.setContextMenu(popup());
    addPatika();
    }

    public void addPatika(){
        addpatbutt.setOnAction(e->{
            if(addpattext!=null&&addpattext.getText()!=""){
            Patika.addPatika(addpattext.getText());
            loadpatikas();
            addpattext.clear();
        }else{
            Helper.showMsg("fill");
        }
        });
       
    }
    public ContextMenu popup(){
        
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem update = new MenuItem("Güncelle");
        MenuItem dele = new MenuItem("Sil");
        contextMenu.getItems().addAll(update,dele);
        update.setOnAction(ev->{
          
           
    //    new UpdateGUI(pTableView.getSelectionModel().getSelectedItem().getId(),pTableView.getSelectionModel().getSelectedItem().getName());
        
        });
        dele.setOnAction(e-> {
        System.out.println(pTableView.getSelectionModel().getSelectedItem().getId()+" silindi");
        Patika.delete(pTableView.getSelectionModel().getSelectedItem().getId());
        loadpatikas();
        tabders.refresh();
    });
        return contextMenu;
    }

    private void loadcourses() {
        for(Course c : Course.getCourses()){
           if(c.getPatika_name()==null){
               Course.delete(c.getId());
           }
        }
        tabders.getItems().clear();
        tabders.getItems().addAll(Course.getCourses());
    }

    public void listCourses(){
        idofders.setCellValueFactory(new PropertyValueFactory<>("id"));    
        nameders.setCellValueFactory(new PropertyValueFactory<>("name")); 
        language.setCellValueFactory(new PropertyValueFactory<>("lang"));    
        patcol.setCellValueFactory(new PropertyValueFactory<>("patika_name")); 
        egitcol.setCellValueFactory(new PropertyValueFactory<>("user_name"));    

        loadcourses();
        final ContextMenu pop = new ContextMenu();
        MenuItem update = new MenuItem("Güncelle");
        MenuItem dele = new MenuItem("Sil"); 
        pop.getItems().addAll(update,dele);
        update.setOnAction(eu->{
            System.out.println("updated");
        });
        dele.setOnAction(ed->{
            if(tabders.getSelectionModel().getSelectedIndex()!=-1){
                Course.delete(tabders.getSelectionModel().getSelectedItem().getId());
                loadcourses();
            }
        });
        tabders.setContextMenu(pop);

        dap.setOnMouseClicked(ec->{
            dap.getItems().clear();
             for(Patika p:Patika.listPatikas()){
            dap.getItems().add(p.getName());
        }
        });
       dae.setOnMouseClicked(ev->{
           dae.getItems().clear();
           for(User p:User.getList()){
               if(p.getType().equals("educator")){
                   dae.getItems().add(p.getName());
               }
        }
       });
       addCourse();
        }


  



    public void addCourse() {
        dab.setOnAction(e-> {
            if(dan.getText().length()==0|| dal.getText().length()==0||dap.getSelectionModel().getSelectedItem()==null||dae.getSelectionModel().getSelectedItem()==null){
                Helper.showMsg("fill");               
            }else{
               Course.addCourse(dan.getText(),dal.getText(),Patika.listPatikas().get(dap.getSelectionModel().getSelectedIndex()).getId(),User.getList().get(dae.getSelectionModel().getSelectedIndex()).getId()); 
               loadcourses();     
            } 
        // dan.clear();
        // dal.clear();
        // dap.getSelectionModel().clearSelection();
        // dae.getSelectionModel().clearSelection();
    });
        
    }
    

    
    
}

