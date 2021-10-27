/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.EscuelaModel;
import utils.ConnectionDB;


public class EscuelaDAO {
    private Connection conn = null;
    /**
    * 
    * @return 
    */
    public ArrayList<EscuelaModel> getAllEscuelas(){
        ArrayList<EscuelaModel> escuelas = new ArrayList();
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql ="SELECT esc_codigo, esc_nombre FROM escuela;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
        
            while(result.next()){
            EscuelaModel escuela = new EscuelaModel(result.getInt(1), result.getString(2));
            escuelas.add(escuela); 
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return escuelas;     
    }    
}
