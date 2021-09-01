package app.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import app.Helper.DBConnector;
import app.Helper.Helper;

public class Student extends User {
    public void myPatikasAdd(String patname, int StudentId) {
        String query1 = "SELECT patikas FROM students WHERE id = " + StudentId;
        String patika1 = null;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                String name = resultSet.getString("patikas");
                patika1 = name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(patika1);

        String query = null;
        if (patika1 == null) {
            query = "INSERT INTO students (id,courses,patikas,contents,quiz) VALUES (?1,'?2','?3/','?4','?5')";
            query = query.replace("?1", String.valueOf(StudentId));
            query = query.replace("?2", " ");
            query = query.replace("?3", patname);
            query = query.replace("?4", " ");
            query = query.replace("?5", " ");

        } else {
            if (patika1.contains(patname)) {
                Helper.showMsg("Bu ders alınmıştır.");
            } else {
                patika1 += patname + "/";
                query = "UPDATE students SET patikas = '" + patika1 + "' WHERE id = " + StudentId;

                Statement statement;
                try {
                    statement = DBConnector.getInstance().createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void myCoursesAdd(String coursename, int StudentId) {
        String query1 = "SELECT courses FROM students WHERE id = " + StudentId;
        String course = null;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                String name = resultSet.getString("courses");
                course = name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query;
        if (course == null) {
            query = "INSERT INTO students (id,courses,patikas,contents,quiz) VALUES (?1,'?2/','?3','?4','?5')";
            query = query.replace("?1", String.valueOf(StudentId));
            query = query.replace("?2", coursename);
            query = query.replace("?3", "");
            query = query.replace("?4", "");
            query = query.replace("?5", "");

        } else {
            if (course.contains(coursename)) {
                Helper.showMsg("Bu ders alınmıştır.");
            } else {
                course += coursename + "/";
                query = "UPDATE students SET courses = '" + course + "' WHERE id = " + StudentId;
                Statement statement;
                try {
                    statement = DBConnector.getInstance().createStatement();
                    statement.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Course> myCoursesList(int StudentId) {
        ArrayList<Course> courses = new ArrayList<>();
        String query = "SELECT courses FROM students WHERE id = " + StudentId;

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("courses");
                for (Course c : Course.getCourses()) {
                    if (name.contains(c.getName())) {
                        courses.add(c);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public ArrayList<Lessons> myLessonsList(int StudentId) {
        ArrayList<Lessons> lessons = new ArrayList<>();
        String query = "SELECT contents FROM students WHERE id = " + StudentId;
        Lessons lessons2;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("contents");
                for (Lessons l : Lessons.getLessons(0)) {
                    if (name.contains(l.getName())) {
                        lessons2 = new Lessons(l.getId(), l.getEducator_id(), l.getName(), l.getDesc(), l.getLink(),
                                l.getBranch());
                        lessons.add(lessons2);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lessons;
    }

    public void takeContent(int id, int StudentId) {

    }

    public void takeQuiz(int LessonsId, int StudentId) {

    }

}
