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
import java.sql.*;
import javax.swing.JOptionPane;
import Modal.*;
import View.*;


public class controller_of_Registration
{
    Registration_modal model;
    registrationui view;
    ResultSet rs;
    PreparedStatement pst=null;
        public controller_of_Registration(registrationui view)
        {
            this.view=view;
            
             view.addLoginListner(new RegisetrListener());
        }
        
        class RegisetrListener implements ActionListener
        {

        @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    model=view.getUser();
                        if(checkUser(model))
                        {
                            view.setMessage("Registered Successfully");
                        }
                         else
                        {
                            view.setMessage("Invalid registration");
                    
                        }
                }
                catch(Exception e1)
                {
                
                }

        }
        
        public boolean checkUser(Registration_modal user) throws Exception
        {
           
        try
          {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Dellinspiron@1176");
            
           String checkUsernameQuery = "SELECT * FROM register WHERE Username = ?";
           pst = conn.prepareStatement(checkUsernameQuery);
           pst.setString(1, user.getUsername());
           ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            
            JOptionPane.showMessageDialog(null, "Username is already taken");
            return false;
        }
        
            if (user.getFull_Name().isEmpty() || user.getContactno().isEmpty() ||
            user.getUsername().isEmpty() || user.getAddress().isEmpty() ||
            user.getPassword().isEmpty() || user.getRetype_password().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return false;
        }
            
            if (!user.getPassword().equals(user.getRetype_password())) {
            JOptionPane.showMessageDialog(null, "Password and confirm password must match");
            return false;
        }
            String sql="insert into register(Full_Name,Address,Phone_No,Username,Pass,Retype_Pass) values(?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,user.getFull_Name());
            pst.setString(2,user.getAddress());
            pst.setString(3,user.getContactno());
            pst.setString(4,user.getUsername());
            pst.setString(5,user.getPassword());
            pst.setString(6,user.getRetype_password());



            pst.executeUpdate();
              System.out.println("Data inserted");
            JOptionPane.showMessageDialog(null,"Data Registered Successfully");
          
          }
          catch(Exception e2)
          {
              System.out.println(e2.getMessage());
              throw e2;
          }  
        finally {
        if (pst != null) {
            pst.close();
        }
    }
            
            return false;
        }
    }  
}
