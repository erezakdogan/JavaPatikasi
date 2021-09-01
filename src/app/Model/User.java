package app.Model;

import java.sql.*;
import java.util.ArrayList;

import app.Helper.DBConnector;
import app.Helper.Helper;
public class User {
    private int id;
    private String name, uname, pass,type;

    public User(){

    }
    
    public User(int id, String name, String uname, String pass, String type) {
        this.id = id;
        this.name = name;
        this.uname = uname;
        this.pass = pass;
        this.type = type;
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

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ArrayList<User> getList(){
        ArrayList<User> uList = new ArrayList<>();
        User user;
        try {
            String query = "SELECT * FROM public.user";
            Statement statement = DBConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                user = new User();
                user.setId( resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUname(resultSet.getString("uname"));
                user.setPass(resultSet.getString("pass"));
                user.setType(resultSet.getString("type"));
                uList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uList;

    }

    public static boolean getUser(String u){
        for(User user : getList()){
            if(user.getUname().equals(u)){
                return true;
            }
        }
        return false;
    }


        
    public static boolean add(String name, String uname, String pass, String type){
        String query = "INSERT INTO public.user (name,uname,pass,type) VALUES (?,?,?,?::type)";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setString(1, name);
            pr.setString(2, uname);
            pr.setString(3, pass);
            pr.setString(4, type);
            
            return pr.executeUpdate() != -1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void delete(int id){
        String query = "DELETE FROM public.user WHERE id = ?";
        try {
            PreparedStatement pr = DBConnector.getInstance().prepareStatement(query);
            pr.setInt(1, id);
            pr.executeUpdate();     
        } catch (SQLException e){
            e.printStackTrace();
            Helper.showMsg("invalid");

        }
       
    }
    public static void update(int id, String value , String s){
        String query = "UPDATE  public.user SET "+value+" = '"+s+"' WHERE id = "+ String.valueOf(id)+";";
        Statement pr;
        boolean isContain = false;
        if(value=="uname"){
            for(User u : getList()){
                if(u.getUname()==value){
                    isContain = true;
                }
            }
        }

        if(isContain){
            try {
            pr = DBConnector.getInstance().createStatement(); 
            pr.executeUpdate(query);
            pr.close();
            Helper.showMsg("success");
        } catch (SQLException e) {
        }
        }else{
             Helper.showMsg("invalid");
        }       
    }

    public static ArrayList<User> search(String name, String uname, String selectedItem) {
        ArrayList<User> uList = new ArrayList<>();
        String query = "SELECT * FROM public.user WHERE name LIKE '%{name}%' AND uname LIKE '%{uname}%'";
        query = query.replace("{name}", name);
        query = query.replace("{uname}", uname);
        if(selectedItem != null&&selectedItem!="all"){
            query+=" AND type = '{operator}' ";
            query = query.replace("{operator}", selectedItem);
        }

        System.out.println();
    try {
        Statement statement = DBConnector.getInstance().createStatement();
        ResultSet rs = statement.executeQuery(query);
        User user;
        while(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setUname(rs.getString("uname"));
            user.setPass(rs.getString("pass"));
            user.setType(rs.getString("type"));
            uList.add(user);

        }
        rs.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return uList;

}
    
}
