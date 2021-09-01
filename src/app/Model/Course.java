package app.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.Helper.DBConnector;

public class Course {
    private int id, user_id, patika_id;
    private String name, lang,patika_name,user_name;
    Patika patika;

    public Course(int id, int user_id, int patika_id, String name, String lang,String patika_name,String user_name) {
        this.id = id;
        this.user_id = user_id;
        this.patika_id = patika_id;
        this.name = name;
        this.lang = lang;
        this.patika_name=patika_name;
        this.user_name=user_name;
        
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPatika_id() {
        return this.patika_id;
    }

    public void setPatika_id(int patika_id) {
        this.patika_id = patika_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public String getPatika_name() {
        return this.patika_name;
    }

    public void setPatika_name(String patika_name) {
        this.patika_name = patika_name;
    }

    public String getUser_name() {
        return this.user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

   
    public static ArrayList<Course> getCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";

        Statement statement;
        Course course;
        try {
            statement = DBConnector.getInstance().createStatement();        
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                int user_id = resultSet.getInt("user_id");
                int patika_id = resultSet.getInt("patika_id");
                String name = resultSet.getString("name");
                String lang = resultSet.getString("lang");
                String pn=null;
                String en=null;
                for(Patika p : Patika.listPatikas()){
                    if(p.getId()==patika_id){
                        pn = p.getName();
                    }
                }

                for(User p :User.getList()){
                    if(p.getId()==user_id){
                        en = p.getName();
                    }
                }
                course = new Course(id, user_id, patika_id, name, lang,pn,en);
                courses.add(course);
             
            }
           

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public static void addCourse(String text, String text2, int selectedItem, int selectedItem2) {
        String query = "INSERT INTO courses (name,lang,patika_id,user_id) VALUES (?,?,?,?)";
        PreparedStatement pr;
        try {
        pr = DBConnector.getInstance().prepareStatement(query); 
        pr.setString(1, text);
        pr.setString(2, text2);
        pr.setInt(3, selectedItem);
        pr.setInt(4, selectedItem2);

        pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    public static void delete(int id) {
        String query = "DELETE FROM courses WHERE id = ? ";
        PreparedStatement pr; 
        try {
            pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            pr.executeUpdate();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
}
