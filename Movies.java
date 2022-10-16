import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.css.ParsedValue; 
   
public class Movies { 
    static Connection conn = null;  
    public static void connect() {  
        try {  
            String url = "jdbc:sqlite:C:/SQLite/Movies.db";  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    public static void createNewDatabase(String fileName) {    
   
        try {  
            if (conn != null) {  
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("The driver name is " + meta.getDriverName());  
                System.out.println("A new database has been created."); 
            }
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
    public static void main(String[] args) 
    {  
        createNewDatabase("Movies.db");
        connect();
        createNewTable();
    }  
    public static void createNewTable() {  
        String sql = "CREATE TABLE Movies ( Name TEXT (50) PRIMARY KEY, Actor TEXT (50), Actress TEXT (50), Director TEXT (50), [Year of release] INTEGER (4)  );";  
          
        try{  
            Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } 
    }
    public static void selectAll()
    {    
            String sql = "SELECT * FROM MOVIES";  
              
            try{  
                Statement stmt = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(rs.getString("Name") +  "\t" +   
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getString("Director") + "\t" +    
                                   rs.getInt("[Year of release]"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }  

    
    public static void getByDirectorAndName(String Name,String director )
    {
        String sql = "SELECT * FROM Movies WHERE Director = '"+Name+"' AND  Name = '"+director+"' ";  
              
            try{  
                Statement stmt = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(rs.getString("Name") +  "\t" +   
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getString("Director") + "\t" +    
                                   rs.getInt("[Year of release]"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
   
    
    public static void getByActor(String Name1,String Name2 )
    {
        String sql = "SELECT * FROM Movies WHERE Actor = '"+Name1+"' AND  Actress = '"+Name2+"' ";  
              
            try{  
                Statement stmt = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(rs.getString("Name") +  "\t" +   
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getString("Director") + "\t" +    
                                   rs.getInt("[Year of release]"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
    public static void getByDirector(String Name1)
    {
        String sql = "SELECT * FROM Movies WHERE Director = '"+Name1+"'";  
              
            try{  
                Statement stmt = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(rs.getString("Name") +  "\t" +   
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" +
                                   rs.getString("Director") + "\t" +    
                                   rs.getInt("[Year of release]"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
    public static void getByActorandActress(String Name1,String Name2 )
    {
        String sql = "SELECT * FROM Movies WHERE DIRECTOR = '"+Name1+"' AND  [Year_of_release] = '"+Name2+"' ";  
              
            try{  
                Statement stmt = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);   
            while (rs.next()) {  
                System.out.println(   
                                   rs.getString("Actor") + "\t" +
                                   rs.getString("Actress") + "\t" );
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
    }
    

}  
