package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import Modal.*;
import View.*;




public class Controller_of_dashboard
{
    Dashboard_Model model;
    Dashboard view;
    ResultSet rs;
    PreparedStatement pst=null;
        public Controller_of_dashboard(Dashboard view)
                
            
        {
            this.view=view;
            
             view.addDashboardListner(new DashboardListener());
        }
        
        class DashboardListener implements ActionListener
        {

        @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    model=view.getuser();
                        if(checkUser(model))
                        {
                            view.setMessage("Added Successfully");
                        }
                         else
                        {
                            view.setMessage("Invalid reruest");
                    
                        }
                }
                catch(Exception e1)
                {
                
                }

        }
        
        public boolean checkUser(Dashboard_Model user) throws Exception
        {
           
        try
          {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456789");
            

        
            if (user.getMovie_name().isEmpty() || user.getGenre().isEmpty() ||
            user.getDuration().isEmpty() || user.getAge().isEmpty() ||
            user.getDesc().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return false;
        }
            
                       String sql="insert into dashboard(Movie_name,Movie_genre,duration,age_catagory,Plot) values(?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1,user.getMovie_name());
            pst.setString(2,user.getGenre());
            pst.setString(3,user.getDuration());
            pst.setString(4,user.getAge());
            pst.setString(5,user.getDesc());
            
            



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

