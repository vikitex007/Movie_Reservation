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
import DAO.DAO_Dashboard;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;




public class Controller_of_dashboard implements ActionListener {
    private Dashboard_Modal mod;
    private DAO_Dashboard modDAO;
    private Dashboard stupage;
    private JTable jTable;
    private JButton btnPrint;
    
    
    public Controller_of_dashboard(Dashboard_Modal mod, DAO_Dashboard modDAO, Dashboard stupage)
    {
        
        this.mod = mod;
        this.modDAO = modDAO;
        this.stupage = stupage;
        this.btnPrint = stupage.HallB_print;
        this.btnPrint = stupage.HallA_Print;
        
        this.btnPrint.addActionListener(this);
        
        
        this.stupage.Add_btn.addActionListener(this);
        
        this.stupage.Delete_btn.addActionListener(this);
        this.stupage.Refresh_btn.addActionListener(this);
        
        this.stupage.Update_btn.addActionListener(this);
        this.stupage.Refresh.addActionListener(this);
       
        this.stupage.Search_btn.addActionListener(this);

        this.jTable = stupage.Deletetable;
        this.jTable = stupage.UpdateTable;
        
    }
    
    public void start()
    {
        stupage.setTitle("Dasboard");
        stupage.setLocationRelativeTo(null);
//        stupage.txtID.setVisible(true);
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == stupage.Add_btn)
        {
            if (validateFields1()) {
                mod.setMovie_name(stupage.MovieName_txt.getText());
                mod.setMovie_genre(stupage.MovieGenre_txt.getText());
                mod.setDuration(stupage.Duration_txt.getText());
                mod.setAge(stupage.Age_txt.getText());
                mod.setPlot(stupage.plot_txt.getText());
                
                
                
                if(modDAO.add(mod))
                {
                    JOptionPane.showMessageDialog(null, "Added Successfully");
                    clear();
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot be Added");
                    
                }   
            }
            
        }
        if(e.getSource() == stupage.Update_btn)
        {
            if (validateFields2()) {
               
                mod.setMovie_name(stupage.jTextField6.getText());
                mod.setMovie_genre(stupage.jTextField7.getText());               
                mod.setDuration(stupage.jTextField8.getText());
                mod.setAge(stupage.jTextField9.getText());
                mod.setPlot(stupage.jTextField10.getText());
                
                
                if(modDAO.update(mod))
                {
                    JOptionPane.showMessageDialog(null, "Updated Successfully");
                    clear2();
                } else {
                    JOptionPane.showMessageDialog(null, "Error in Updating");
                    clear2();
                }   
            }
            
        }
        
        
        if(e.getSource() == stupage.Delete_btn)
        {
            if (validateMovieField2()) {
                mod.setMovie_name(stupage.Remove_txt.getText());
                
                
                if(modDAO.delete(mod))
                {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");

                } else {
                    JOptionPane.showMessageDialog(null, "Error in Deleting");
                   
                    
                }   
            }
            
        }
        
        
        
        
        if(e.getSource() == stupage.Search_btn)
        {
            if (validateMovieField()) {
                mod.setMovie_name(stupage.Search_txt.getText()); 
                
                if(modDAO.search(mod))
                {
                    stupage.jTextField6.setText(mod.getMovie_name());
                    stupage.jTextField7.setText(mod.getMovie_genre());
                    stupage.jTextField8.setText(mod.getDuration());
                    stupage.jTextField9.setText(mod.getAge());
                    stupage.jTextField10.setText(mod.getPlot());
                   
                } else {
                    JOptionPane.showMessageDialog(null, "No Record Found");
                    clear2();
                }   
            }
            
        }
        
        
        
        
      
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private boolean validateFields1() {
        if (stupage.MovieName_txt.getText().isEmpty() || stupage.MovieGenre_txt.getText().isEmpty()
                || stupage.Duration_txt.getText().isEmpty() || stupage.Age_txt.getText().isEmpty()
                || stupage.plot_txt.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        return true;
    }
    
     private boolean validateFields2() {
        if (stupage.jTextField6.getText().isEmpty() || stupage.jTextField7.getText().isEmpty()
                || stupage.jTextField8.getText().isEmpty() || stupage.jTextField9.getText().isEmpty()
                || stupage.jTextField10.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Please fill in all the fields.");
            return false;
        }
        return true;
    }
    
    
    private boolean validateMovieField() {
        if (stupage.Search_txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Movie name.");
            return false;
        }
        
        return true;
    }
    
     private boolean validateMovieField2() {
        if (stupage.Remove_txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a Movie name.");
            return false;
        }
        
        return true;
    }
     
    public void clear()
    {
        stupage.MovieName_txt.setText(null);
        stupage.MovieGenre_txt.setText(null);
        stupage.Duration_txt.setText(null);
        stupage.Age_txt.setText(null);
        stupage.plot_txt.setText(null);
        
    }  
    
    public void clear2()
    {
        stupage.jTextField6.setText(null);
        stupage.jTextField7.setText(null);
        stupage.jTextField8.setText(null);
        stupage.jTextField9.setText(null);
        stupage.jTextField10.setText(null);
        
    } 

        
        
        
        
    
                 
           
}
