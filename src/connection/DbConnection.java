package connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */





import java.sql.*;

/**
 *
 * @author razer
 */
public class DbConnection {
    public Connection conn;

   
    public static Connection dbconnect(){
        // TODO code application logic here
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Dellinspiron@1176");
            
            System.out.println("connected");
            return conn;
        
        
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Not connected");
                    
        }
        return null;
    }   
}
    
