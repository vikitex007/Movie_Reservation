/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author razer
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Connection;
import View.Loginui;
import Modal.Login_Modal;
import View.Dashboard;
import java.sql.DriverManager;
import java.sql.Statement;


public class Controller_of_login {
    Loginui logview;
    Login_Modal logmod;
    ResultSet rs;
    Statement stmt;
    public Controller_of_login(Loginui logview){
        this.logview=logview;
        logview.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener{
        
       
        @Override
        public void actionPerformed(ActionEvent e){
            
            try{
                logmod=logview.getUser();   
                if(checkUser(logmod)){       
                    logview.setMessage("login successfully");
                    Dashboard obj = new Dashboard();
                    obj.setVisible(true);
                    logview.dispose();
                    
                }
                else{
                    logview.setMessage("invalid user");
                    
                }
                           
        
            }
            catch(Exception e1){
                System.out.println(e1.getMessage());
                
            }
        }
        public boolean checkUser(Login_Modal user) throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","12345678");
            String query="select * from register where username='"+user.getUsername()+"' AND Pass='"+user.getPassword()+"'";
            try{
                stmt=conn.createStatement();
                rs=stmt.executeQuery(query);
                if (rs.next()){
                    return true;
                }
                conn.close();
                
            }
            catch(Exception e2){
                System.out.println(e2.getMessage());
                
            }
           return false;
         }


    }
    
    
    
    
    
}
