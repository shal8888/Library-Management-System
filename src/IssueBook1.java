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
public class IssueBook1 {
    public void manage(String BId ,String SId,String issueddate,String returneddate){
        Connection conn=MyConnection.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
            try {
                ps=conn.prepareStatement("INSERT INTO `issuebook`(`bookid`, `studentid`, `issueddate`, `returningdate`) VALUES (?,?,?,?) ");
                ps.setString(1, BId);
                ps.setString(2, SId);
                ps.setString(3,issueddate);
                ps.setString(4, returneddate);
               
                
                //ps.execute();
                if (ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "This book issued");
                
                
                }
                        
            
        
        } catch (SQLException ex) {
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }}
    
    public void displayTable(JTable table){
        Connection con=MyConnection.getConnection();
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT * FROM `issuebook`");
            ResultSet rs=ps.executeQuery();
            DefaultTableModel model= (DefaultTableModel)table.getModel();
            Object [] row= new Object[5];
            model.setRowCount(0);
            while(rs.next()){
            row[0] = rs.getString(1);
            row[1] = rs.getString(2);
            row[2] = rs.getString(3);
            row[3] = rs.getString(4);
            
            
            
            model.addRow(row);
            }
    }   catch (SQLException ex) {   
            Logger.getLogger(AddLibrarian.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
