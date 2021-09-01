package app.Model;

import java.sql.*;
import java.util.ArrayList;

import app.Helper.DBConnector;
import app.Helper.Helper;

public class Lessons {
    int id, educator_id;
    String name, desc, link, branch;

    int qId;
    String contentString, questionString, selectionsString, rightString;

    public Lessons(int id, int educator_id, String name, String desc, String link, String branch) {
        this.id = id;
        this.educator_id = educator_id;
        this.name = name;
        this.desc = desc;
        this.link = link;
        this.branch = branch;
    }

    public Lessons(int id, String contentName, String question, String selections, String rightAnswer) {
        this.qId = id;
        this.contentString = contentName;
        this.questionString = question;
        this.selectionsString = selections;
        this.rightString = rightAnswer;
    }

    public int getQId() {
        return this.qId;
    }

    public void setQId(int qId) {
        this.qId = qId;
    }

    public String getContentString() {
        return this.contentString;
    }

    public void setContentString(String contentString) {
        this.contentString = contentString;
    }

    public String getQuestionString() {
        return this.questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getSelectionsString() {
        return this.selectionsString;
    }

    public void setSelectionsString(String selectionsString) {
        this.selectionsString = selectionsString;
    }

    public String getRightString() {
        return this.rightString;
    }

    public void setRightString(String rightString) {
        this.rightString = rightString;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEducator_id() {
        return this.educator_id;
    }

    public void setEducator_id(int educator_id) {
        this.educator_id = educator_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBranch() {
        return this.branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public static ArrayList<Lessons> getLessons(int educator_id) {
        ArrayList<Lessons> lArrayList = new ArrayList<>();
        String query = "SELECT * FROM lessons WHERE educator_id = " + educator_id;
        if (educator_id == 0) {
            query = "SELECT * FROM lessons ";
        }

        java.sql.Statement statement;
        Lessons lesson;
        try {
            statement = DBConnector.getInstance().createStatement();
            ResultSet rSet = statement.executeQuery(query);
            while (rSet.next()) {

                int id = rSet.getInt("id");
                int educator = rSet.getInt("educator_id");
                String name = rSet.getString("name");
                String description = rSet.getString("description");
                String link = rSet.getString("youtubelink");
                String branch = rSet.getString("lessbranch");

                lesson = new Lessons(id, educator, name, description, link, branch);
                lArrayList.add(lesson);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lArrayList;
    }

    public static void addLesson(int educator_id, String name, String desc, String link, String branch) {
        String query = "INSERT INTO lessons (educator_id,name,description,youtubelink,lessbranch) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, educator_id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, desc);
            preparedStatement.setString(4, link);
            preparedStatement.setString(5, branch);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteLesson(int id) {
        String query = "DELETE FROM lessons WHERE id = " + id;
        try {
            java.sql.Statement statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addquizquestions(String queString, String aString, String rAString, int alessid) {
        String query = "INSERT INTO quizquestions (question,selections,answer,lessid) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = DBConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, queString);
            preparedStatement.setString(2, aString);
            preparedStatement.setString(3, rAString);
            preparedStatement.setInt(4, alessid);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Lessons> getQuestions(int educator_id) {
        ArrayList<Lessons> list = new ArrayList<>();
        String query = "SELECT * FROM quizquestions ";
        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            ResultSet rSet = statement.executeQuery(query);
            Lessons lessons;
            while (rSet.next()) {
                int id = rSet.getInt("id");
                int lessid = rSet.getInt("lessid");
                String question = rSet.getString("question");
                String selections = rSet.getString("selections");
                String answer = rSet.getString("answer");
                String content = null;

                for (Lessons l : getLessons(educator_id)) {
                    if (l.getId() == lessid) {
                        content = l.getName();
                    }
                }
                if (content != null) {
                    lessons = new Lessons(id, content, question, selections, answer);
                    list.add(lessons);
                } else {
                    return list;
                }

            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return list;
    }

    public static ArrayList<Lessons> filter(String text, String selectedItem) {
        ArrayList<Lessons> lArrayList = new ArrayList<>();
        String query;
        if (selectedItem != null) {
            query = "SELECT * FROM lessons WHERE name LIKE '%{n}'AND lessbranch LIKE '%{b}%'";
            query = query.replace("{n}", text);
            query = query.replace("{b}", selectedItem);
        } else {
            query = "SELECT * FROM lessons WHERE name LIKE '%{n}'";
            query = query.replace("{n}", text);
        }
        Lessons lesson;
        Statement statement;
        try {
            statement = DBConnector.getInstance().createStatement();
            ResultSet rSet = statement.executeQuery(query);
            while (rSet.next()) {
                int id = rSet.getInt("id");
                int educator = rSet.getInt("educator_id");
                String name = rSet.getString("name");
                String description = rSet.getString("description");
                String link = rSet.getString("youtubelink");
                String branch = rSet.getString("lessbranch");

                lesson = new Lessons(id, educator, name, description, link, branch);
                lArrayList.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lArrayList;

    }

    public static void update(int id, String col, String newValue) {
        String query = "UPDATE  lessons SET " + col + " = '" + newValue + "' WHERE id = " + String.valueOf(id) + ";";
        Statement pr;
        try {
            pr = DBConnector.getInstance().createStatement();
            pr.executeUpdate(query);
            pr.close();
            Helper.showMsg("success");
        } catch (SQLException e) {
            Helper.showMsg("invalid");
        }
    }

    public static void updateQuestion(int id, String col, String newValue) {
        String query = "UPDATE  quizquestions SET " + col + " = '" + newValue + "' WHERE id = " + String.valueOf(id)
                + ";";
        if (col == "lessid") {
            query = "UPDATE  lessons SET " + col + " = " + newValue + " WHERE id = " + String.valueOf(id) + ";";
        }
        Statement pr;
        try {
            pr = DBConnector.getInstance().createStatement();
            pr.executeUpdate(query);
            pr.close();
            Helper.showMsg("success");
        } catch (SQLException e) {
            Helper.showMsg("invalid");
        }
    }

}
