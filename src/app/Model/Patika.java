package app.Model;

import java.sql.*;
import java.util.ArrayList;


import app.Helper.DBConnector;

public class Patika {
    private int id;
    private String name;

    public Patika(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public static ArrayList<Patika> listPatikas(){
        ArrayList<Patika> lPatikas = new ArrayList<>();
        String query = "SELECT * FROM patika";
        Patika pat;
        try {
        Statement statement = DBConnector.getInstance().createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            pat = new Patika(rs.getInt("id"), rs.getString("name"));
            lPatikas.add(pat);
        }
        rs.close();
        statement.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return lPatikas;
    }
    public static void addPatika(String text) {
        String query = "INSERT INTO patika (name) VALUES ('"+text+"')";

        try {
            Statement statement = DBConnector.getInstance().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(query);
    }
    public static void update(int id, String name) {
        String query = "UPDATE patika SET name = ? WHERE id = ?";
        PreparedStatement pr; 
        try {
            pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setInt(2, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delete(int id) {
        String query = "DELETE FROM patika WHERE id = ? ";
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
