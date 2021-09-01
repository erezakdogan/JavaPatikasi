package app.View.StudentGUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Model.Course;
import app.Model.Lessons;
import app.Model.Patika;
import app.Model.Student;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.Tab;

public class StudentGUI {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TreeView<String> pattree;

    @FXML
    private TreeView<String> coursetree;

    @FXML
    private AnchorPane coursepane;

    @FXML
    private Label namelabel;

    Student student;

    int StudentId;

    public void setId(int id) {
        this.StudentId = id;
        loadPatikas();
        listCourses();

    }

    ArrayList<Patika> patikas = Patika.listPatikas();

    @FXML
    void initialize() {
        assert pattree != null : "fx:id=\"pattree\" was not injected: check your FXML file 'Untitled'.";
        assert coursetree != null : "fx:id=\"coursetree\" was not injected: check your FXML file 'Untitled'.";
        assert namelabel != null : "fx:id=\"namelabel\" was not injected: check your FXML file 'Untitled'.";
        assert coursepane != null : "fx:id=\"namelabel\" was not injected: check your FXML file 'Untitled'.";

    }

    public void loadPatikas() {
        TreeItem<String> base = new TreeItem<>("Patikalar");
        TreeItem<String> roots;
        pattree.setRoot(base);
        pattree.setShowRoot(false);

        pattree.setOnMouseClicked(e -> {
            pattree.setContextMenu(contextMenu());
        });

        for (int i = 0; i < Patika.listPatikas().size(); i++) {
            roots = new TreeItem<>(patikas.get(i).getName());
            ArrayList<TreeItem<String>> treeItems = new ArrayList<>();
            int a = patikas.get(i).getId();
            Course.getCourses().stream().forEach(e -> {
                if (e.getPatika_id() == a)
                    treeItems.add(new TreeItem<>(e.getName()));
            });
            roots.getChildren().addAll(treeItems);
            roots.setExpanded(true);
            base.getChildren().add(roots);
        }
    }

    public boolean isPatika(String name) {
        for (int i = 0; i < patikas.size(); i++) {
            if (patikas.get(i).getName().contains(name)) {
                return true;
            }
        }
        return false;
    }

    public ContextMenu contextMenu() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem pEkle = new MenuItem("Patikaya Kaydol");
        MenuItem dEkle = new MenuItem("Dersi Ekle");
        contextMenu.getItems().addAll(pEkle, dEkle);

        pEkle.setOnAction(arg0 -> {
            String select = pattree.getSelectionModel().getSelectedItem().getValue();
            if (isPatika(select)) {
                student.myPatikasAdd(select, StudentId);
                listCourses();
            }
        });

        dEkle.setOnAction(arg0 -> {
            String select = pattree.getSelectionModel().getSelectedItem().getValue();
            if (!isPatika(select)) {
                student.myCoursesAdd(select, StudentId);
                listCourses();
            }
        });
        return contextMenu;
    }

    public void listCourses() {
        student = new Student();
        TreeItem<String> root = new TreeItem<>();
        TreeItem<String> courseBase = new TreeItem<>();
        TreeItem<String> courses;
        TreeItem<String> lessons;
        TreeItem<String> patika;

        ArrayList<Lessons> mycontent = student.myLessonsList(StudentId);
        ArrayList<Course> mycourses = student.myCoursesList(StudentId);

        coursetree.setRoot(root);
        coursetree.setShowRoot(false);
        courseBase.setExpanded(true);

        ArrayList<TreeItem<String>> patikaList = new ArrayList<>();
        for (int k = 0; k < patikas.size(); k++) {
            patika = new TreeItem<>(patikas.get(k).getName());

            ArrayList<TreeItem<String>> courselist = new ArrayList<>();
            for (int i = 0; i < mycourses.size(); i++) {
                if (patikas.get(k).getName().equals(mycourses.get(i).getPatika_name())) {
                    courses = new TreeItem<>(mycourses.get(i).getName());

                    ArrayList<TreeItem<String>> contentlist = new ArrayList<>();
                    for (int j = 0; j < mycontent.size(); j++) {
                        if (mycourses.get(i).getName().equals(mycontent.get(j).getBranch())) {
                            lessons = new TreeItem<>(mycontent.get(j).getName());
                            contentlist.add(lessons);
                        }
                    }
                    courses.getChildren().addAll(contentlist);
                    courses.setExpanded(true);

                    courselist.add(courses);
                }
            }
            patika.getChildren().addAll(courselist);
            patika.setExpanded(true);
            patikaList.add(patika);
        }
        root.getChildren().addAll(patikaList);
    }

}

