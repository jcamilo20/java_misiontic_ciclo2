/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import access.PocionDAO;
import javax.swing.JOptionPane;
import view.DeletePanel;


public class ClickEventDelete implements ActionListener {

    private DeletePanel deletePanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    
    public ClickEventDelete(DeletePanel deletePanel){
        this.deletePanel = deletePanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        //Obtener datos de la interfaz para luego eliminar en BD
        
        if(actionEvent.getSource() == this.deletePanel.getBtnEliminar()) {
            //Primero verifica que los campos no esten vacios
            if(this.deletePanel.getTxtPocCodigo().getText().equals("")){
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
            }
            //Luego, obtiene lo que diligenció el usuario
            else{
                int pocCodigo         =  Integer.parseInt(this.deletePanel.getTxtPocCodigo().getText());

                //Elimina todo el registro en bd con el codigo asociado
                PocionDAO valor = new PocionDAO();
                valor.eliminarRegistro(pocCodigo);
                        
                //Limpiar los campos
                this.deletePanel.getTxtPocCodigo().setText("");
                
                //Actualiza toda la tabla que se muestra al usuario
                PocionDAO actualiza = new PocionDAO();
                this.deletePanel.setTblResults(actualiza.obtenerRegistros()); 
            }
        } 
    }
}