/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class AddBookclass {
    public void manage(String bookid,String name,String author,String returningdate,String availability){
        Connection conn=MyConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
            try {
                ps=conn.prepareStatement("INSERT INTO `addbook`(`bookid`, `name`, `author`, `returningdate`,  `availability`) VALUES  (?,?,?,?,?) ");
                ps.setString(1,bookid);
                ps.setString(2,name);
                ps.setString(3,author);
                ps.setString(4,returningdate);
              
                ps.setString(5,availability);
              
                //ps.execute();
                if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "New Book Added");
                
                }
                        
            
        
        } catch (SQLException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }}
    public void displayTable(JTable table){
        Connection con=MyConnection.getConnection();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT * FROM `addbook`");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model= (DefaultTableModel)table.getModel();
            Object [] row= new Object[5];
            model.setRowCount(0);
            while(rs.next()){
            row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            row[4] = rs.getString(5);
            
            
            model.addRow(row);
            }
    }   catch (SQLException ex) {   
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    

    
}
