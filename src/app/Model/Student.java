package app.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

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
            query = query.replace("?5", "/");

        } else {
            if (patika1.contains(patname)) {
                Helper.showMsg("Bu ders alınmıştır.");
            } else {
                patika1 += patname + "/";
                query = "UPDATE students SET patikas = '" + patika1 + "' WHERE id = " + StudentId;

            }
        }
        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException err) {

        }

    }

    public void myCoursesAdd(String coursename, int StudentId) {
        String query1 = "SELECT courses FROM students WHERE id = " + StudentId;
        String course = null;
        try {
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query1);
            while (resultSet.next()) {
                System.out.println("test");
                String name = resultSet.getString("courses");
                course = name;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = null;
        if (course == null) {
            System.out.println("test2");

            query = "INSERT INTO students (id,courses,patikas,contents,quiz) VALUES (?1,'?2/','?3','?4','?5')";
            query = query.replace("?1", String.valueOf(StudentId));
            query = query.replace("?2", coursename);
            query = query.replace("?3", " ");
            query = query.replace("?4", " ");
            query = query.replace("?5", "/");
            System.out.println("test2.1");
            System.out.println(coursename + StudentId);

        } else {
            if (course.contains(coursename)) {
                Helper.showMsg("Bu ders alınmıştır.");
            } else {
                System.out.println("test3");

                course += coursename + "/";
                query = "UPDATE students SET courses = '" + course + "' WHERE id = " + StudentId;

            }
        }
        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException err) {

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
        loadContents();
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

    public void loadContents() {
        String query = "UPDATE students SET contents = '{contents}'";
        String content = null;
        for (Lessons l : Lessons.getLessons(0)) {
            content += l.getName() + "/";
        }
        query = query.replace("{contents}", content);
        query = query.replace("null", "");

        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void takeContent(int id, int StudentId) {

    }

    public void takeQuiz(int rights, int LessonsId, int StudentId) {
        String queryb = "SELECT * FROM quizquestions WHERE lessid = " + LessonsId;
        int num = 0;
        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            ResultSet rSet = statement.executeQuery(queryb);
            while (rSet.next()) {
                num++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String quizes = "";
        for (Lessons l : Lessons.getLessons(0)) {
            if (l.getId() == LessonsId) {
                quizes += l.getName() + " konusunda " + num + " tane sorudan ";
            }
        }
        quizes += rights + " tane doğru.- /";
        String query = "UPDATE students SET quiz = REPLACE(quiz, '/', '{quizes}') WHERE id = " + StudentId;
        query = query.replace("{quizes}", quizes);
        Statement statement2;
        try {
            statement2 = DBConnector.getInstance().createStatement();
            statement2.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> quizresults(int studentId) {
        ArrayList<String> qArrayList = new ArrayList<>();
        String query = "SELECT quiz FROM students WHERE id = " + studentId;

        try {
            String str = " ";
            Statement statement;
            statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                str += resultSet.getString("quiz");
                str = str.replace("/", "");
                qArrayList.addAll(Arrays.asList(str.split("-")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return qArrayList;

    }

}
