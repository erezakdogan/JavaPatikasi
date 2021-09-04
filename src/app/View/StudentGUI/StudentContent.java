package app.View.StudentGUI;

import java.net.URL;
import java.util.ResourceBundle;
import app.Helper.Helper;
import app.Model.Lessons;
import app.Model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import javafx.scene.control.ComboBox;

public class StudentContent {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label contentanswers;

    @FXML
    private Label contenttitle;

    @FXML
    private Label contentcourse;

    @FXML
    private Label contentlink;

    @FXML
    private Label contentquiz;

    @FXML
    private Button contetback;

    @FXML
    private Button contetforward;

    @FXML
    private Button questionprev;

    @FXML
    private Button questionNext;

    @FXML
    private Label numlabel;

    @FXML
    private Button contetexit;

    @FXML
    private ComboBox<String> comboSelect;

    @FXML
    private Label contentnumright;


    @FXML
    void initialize() {
        assert contenttitle != null
                : "fx:id=\"contenttitle\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contentcourse != null
                : "fx:id=\"contentcourse\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contentlink != null
                : "fx:id=\"contentlink\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contentquiz != null
                : "fx:id=\"contentquiz\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contentanswers != null
                : "fx:id=\"contentquiz\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert comboSelect != null
                : "fx:id=\"contentquiz\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contetback != null
                : "fx:id=\"contetback\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contetforward != null
                : "fx:id=\"contetforward\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert questionprev != null
                : "fx:id=\"questionprev\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert questionNext != null
                : "fx:id=\"questionNext\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert numlabel != null : "fx:id=\"numlabel\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contetexit != null
                : "fx:id=\"contetexit\" was not injected: check your FXML file 'StudentContent.fxml'.";
        assert contentnumright != null
                : "fx:id=\"contetexit\" was not injected: check your FXML file 'StudentContent.fxml'.";
     

        comboSelect.getItems().setAll("A", "B", "C", "D");

    }

    int in;
    Boolean[] aa;
    int i = 0;
    int p = 0;
    String b;

    public void setLabels(String contentname, int studentId) {
        contetexit.setOnAction(e -> {
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(StudentGUI.class.getResource("StudentGUI.fxml"));
                Pane root1 = fxmlLoader1.load();
                StudentGUI educatorGUI = (StudentGUI) fxmlLoader1.getController();
                educatorGUI.setId(studentId);
                Scene scene = contetforward.getScene();
                scene.setRoot(root1);
                Stage primaryStage1 = (Stage) contetforward.getScene().getWindow();
                primaryStage1.setScene(scene);
                primaryStage1.show();
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        });

        Lessons.getLessons(0).stream().forEach(e -> {
            if (e.getId() == getId(contentname)) {
                contenttitle.setText(e.getName());
                contentcourse.setText(e.getBranch());
                contentlink.setText(e.getLink());
                loadQuestion(contentname);
            }
        });

        ArrayList<String> branch = new ArrayList<>();
        for (Lessons l : Lessons.getLessons(0)) {

            if (l.getName().equals(contentname)) {
                for (Lessons wl : Lessons.getLessons(0)) {
                    if (wl.getBranch().equals(l.getBranch())) {
                        branch.add(wl.getName());
                    }
                }
                in = branch.indexOf(l.getName());
            }
        }
        contetforward.setOnAction(ev -> {
            
                Student student = new Student();
                student.takeQuiz(p, getId(contentname), studentId);
            try {
                setLabels(branch.get(in + 1), studentId);
                p = 0;
                if (in == branch.size() - 1) {
                    contetforward.setText("Dersi Bitir.");
                }
            } catch (IndexOutOfBoundsException error) {
                try {
                    FXMLLoader fxmlLoader1 = new FXMLLoader(StudentGUI.class.getResource("StudentGUI.fxml"));
                    Pane root1 = fxmlLoader1.load();
                    StudentGUI educatorGUI = (StudentGUI) fxmlLoader1.getController();
                    educatorGUI.setId(studentId);
                    Scene scene = contetforward.getScene();
                    scene.setRoot(root1);
                    Stage primaryStage1 = (Stage) contetforward.getScene().getWindow();
                    primaryStage1.setScene(scene);
                    primaryStage1.show();
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }

            }
        });
    }

    public int getId(String contentname) {
        for (Lessons e : Lessons.getLessons(0)) {
            if (e.getName().equals(contentname)) {
                return e.getId();
            }
        }
        return 0;
    }

    public void loadQuestion(String contentname) {
        ArrayList<String> queStrings = new ArrayList<>();
        ArrayList<String> queAnswers = new ArrayList<>();
        ArrayList<String> rightAnswers = new ArrayList<>();

        System.out.println(Lessons.getQuestions(0).size());
        Lessons.getQuestions(0).stream().forEach(e -> {
            if (e.getContentString().equals(contentname)) {
                queStrings.add(e.getQuestionString());
                queAnswers.add(e.getSelectionsString());
                rightAnswers.add(e.getRightString());
            }
        });
        aa = new Boolean[rightAnswers.size()];

        contentquiz.setText(queStrings.get(0));
        contentanswers.setText(queAnswers.get(0));

        int j = queStrings.size();

        numlabel.setText((i + 1) + "/" + j);
        questionprev.setOnAction(e -> {
            if (i > 0) {
                i--;
                contentquiz.setText(queStrings.get(i));
                contentanswers.setText(queAnswers.get(i));
                numlabel.setText((i + 1) + "/" + j);
            }
        });
        questionNext.setOnAction(e -> {
            try {
                if (comboSelect.getSelectionModel().getSelectedItem().equals(rightAnswers.get(i))) {
                    aa[i] = true;
                } else {
                    aa[i] = false;
                }
            } catch (NullPointerException err) {
                if (aa[i] == null) {
                    aa[i] = null;
                }
            } catch (IndexOutOfBoundsException iob) {
                Helper.showMsg("index out of bound");
            }
            comboSelect.getSelectionModel().clearSelection();

            if (i < j - 1) {

                i++;
                contentquiz.setText(queStrings.get(i));
                contentanswers.setText(queAnswers.get(i));
                numlabel.setText((i + 1) + "/" + j);
                if (i+1 == queAnswers.size()) {
                    questionNext.setText("Bitir");
                }

            } else {
                if (Arrays.toString(aa).contains("null")) {
                    Helper.showMsg("TÜM SORULARI CEVAPLANDIRIN");
                } else {
                    for (Boolean bool : aa) {
                        if (bool == true) {
                            p++;
                        }
                    }
                    contentnumright.setText("Dogru cevap sayısı : " + p);
                }
            }
        });
    }
}
