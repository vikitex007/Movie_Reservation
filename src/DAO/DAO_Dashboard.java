/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import connection.*;
import Modal.*;
import Modal.Dashboard_Modal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

 
public class DAO_Dashboard extends DbConnection{
    
     public boolean add(Dashboard_Modal mod) {
        PreparedStatement ps = null;
        Connection conn = dbconnect();

        String sql = "INSERT INTO Dashboard(Movie_Name,Movie_Genre,Duration,Age_category,Plot) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getMovie_name());
            ps.setString(2, mod.getMovie_genre());
            ps.setString(3, mod.getDuration());
            ps.setString(4, mod.getAge());
            ps.setString(5, mod.getPlot());
           
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
            return false;
            
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
         // Added a default return statement outside the try-catch block
    }
     
     public boolean update(Dashboard_Modal mod) {
        PreparedStatement ps = null;
        Connection conn = dbconnect();

        String sql = "UPDATE dashboard Set Movie_name=?,Movie_Genre=?,Duration=?,Age_category=?,Plot=? WHERE Movie_name=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getMovie_name());
            ps.setString(2, mod.getMovie_genre());
            ps.setString(3, mod.getDuration());
            ps.setString(4, mod.getAge());
            ps.setString(5, mod.getPlot());
            ps.setString(6, mod.getMovie_name());
            ps.execute();
            return true;

        } catch (Exception e) { 
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
     
     
     public boolean delete(Dashboard_Modal mod) {
        PreparedStatement ps = null;
        Connection conn = dbconnect();

        String sql = "DELETE FROM dashboard WHERE Movie_name=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,mod.getMovie_name());
            ps.execute();
            return true;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
     
     public boolean search(Dashboard_Modal mod) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = dbconnect();

        String sql = "SELECT * FROM dashboard WHERE Movie_name=?";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, mod.getMovie_name());
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                mod.setMovie_name(rs.getString("Movie_name"));
                mod.setMovie_genre(rs.getString("Movie_genre"));
                mod.setDuration(rs.getString("Duration"));
                mod.setAge(rs.getString("Age_category"));
                mod.setPlot(rs.getString("Plot"));
                
                return true;
                
            }

            return false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        return false; // Added a default return statement outside the try-catch block
    }
    
}
