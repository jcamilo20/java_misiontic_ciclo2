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
import model.PocionModel;
import utils.ConnectionDB;



public class PocionDAO {
    private Connection conn = null;
    /**
    * 
    * @return 
    */

    public void insertPocion(int codigo, String nombre, float litros, int usada, int escFK) { //Método para insertar una nueva pocion a la BD
         try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO pocion(poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_codigo_fk) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigo);
            statement.setString(2, nombre);
            statement.setFloat(3, litros);
            statement.setInt(4, usada);
            statement.setInt(5, escFK);
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    public ArrayList<PocionModel> obtenerRegistros() { // Método que obtiene todos los registros de la tabla pocion
        ArrayList<PocionModel> guardaRegistros = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_nombre\n"+
                   "FROM pocion\n"+
                    "JOIN escuela ON pocion.esc_codigo_fk = esc_codigo\n"+
                    "ORDER BY poc_codigo ASC;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                PocionModel registro = new PocionModel(result.getInt(1), result.getString(2), result.getFloat(3), result.getInt(4), result.getString(5)); //Crea un objeto y llama al constructor de la tabla modelo e inicializa los atributos
                guardaRegistros.add(registro);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return guardaRegistros; //Retorna una lista con todos los registros de la bd
    }
   
    public void modificarRegistro(PocionModel pocionmodel) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE pocion SET poc_litros = ?,  poc_veces_usada = ? WHERE poc_codigo = ?;"; //Método para actualizar un registro en BD segun el codigo seleccionado
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setFloat(1, pocionmodel.getPocLitros());
            statement.setInt(2, pocionmodel.getPocVecesUsada());
            statement.setInt(3, pocionmodel.getPocCodigo());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    public void eliminarRegistro(int codigo) {  //Método para eliminar un registro en BD segun el codigo seleccionado
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM pocion WHERE poc_codigo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigo);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
    
    public ArrayList<PocionModel> obtenerRegistrosFiltrados(int valor) { // Método que obtiene todos los registros filtrados de la tabla pocion
        ArrayList<PocionModel> guardaRegistros = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT poc_codigo, poc_nombre, poc_litros, poc_veces_usada, esc_nombre\n"+
                   "FROM pocion\n"+
                    "JOIN escuela ON esc_codigo_fk = esc_codigo\n"+
                    "WHERE esc_codigo_fk = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, valor);
            ResultSet result    = statement.executeQuery();
            
            while (result.next()) {
                PocionModel registro = new PocionModel(result.getInt(1), result.getString(2), result.getFloat(3), result.getInt(4), result.getString(5)); //Crea un objeto y llama al constructor de la tabla modelo e inicializa los atributos
                guardaRegistros.add(registro);
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return guardaRegistros; //Retorna una lista con todos los registros filtrados de la bd
    }

}
