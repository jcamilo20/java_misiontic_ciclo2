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
import model.PocionModel;
import view.UpdatePanel;


public class ClickEventUpdate implements ActionListener {

    private UpdatePanel updatePanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    
    public ClickEventUpdate(UpdatePanel updatePanel){
        this.updatePanel = updatePanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        //Obtener datos de la interfaz para luego actualizarlos en BD
        
        if(actionEvent.getSource() == this.updatePanel.getBtnModificar()) {
            //Primero verifica que los campos no esten vacios
            if(this.updatePanel.getTxtPocCodigo().getText().equals("")||this.updatePanel.getTxtPocLitros().getText().equals("") || this.updatePanel.getTxtPocVecesUsada().getText().equals("")){
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
            }
            else{                
                //Luego, obtiene lo que diligenció el usuario
                int pocCodigo         =  Integer.parseInt(this.updatePanel.getTxtPocCodigo().getText());
                float pocLitros = Float.parseFloat(this.updatePanel.getTxtPocLitros().getText());
                int pocUsada= Integer.parseInt(this.updatePanel.getTxtPocVecesUsada().getText());
                //System.out.println(pocLitros + " " + pocUsada + " " + pocCodigo);
 
            
                //Luego va al DAO y le pasamos los datos de la interfaz
                PocionDAO modificar = new PocionDAO();
                PocionModel valores = new PocionModel(pocLitros, pocUsada, pocCodigo);
                modificar.modificarRegistro(valores);
        
                //Limpiar campos
                this.updatePanel.getTxtPocCodigo().setText("");
                this.updatePanel.getTxtPocLitros().setText("");
                this.updatePanel.getTxtPocVecesUsada().setText("");

            
                //Actualiza toda la tabla que se muestra al usuario
                PocionDAO actualiza = new PocionDAO();
                this.updatePanel.setTblResults(actualiza.obtenerRegistros());               
            }
         }       
    }
           

}