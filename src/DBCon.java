import java.sql.*;


public class DBCon {
    public static void main(String[] args) {
        Connection connection = null;
        String stSql = "UPDATE actor SET first_name='Selma' Where actor_id=234 "; 
        String prSql = "UPDATE actor SET first_name=    ? Where actor_id= ? "; 

        try{
            String url = "jdbc:postgresql://localhost/dvdrental?user=postgres&password=postgresql";
            connection = DriverManager.getConnection(url);
            // Statement statement = connection.createStatement();
            // statement.executeUpdate(stSql);
            PreparedStatement statement2 = connection.prepareStatement(prSql);
            statement2.setString(1, "Telma");
            statement2.setInt(2, 235);
            statement2.executeUpdate();
          
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            
        }
    }
}
