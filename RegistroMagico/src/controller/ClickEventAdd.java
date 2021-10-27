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
import model.EscuelaModel;
import view.AddPanel;




public class ClickEventAdd implements ActionListener {

    private AddPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEventAdd(AddPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        //Obtener datos de la interfaz para luego insertarlos en bd
        
        if(actionEvent.getSource() == this.controlsPanel.getBtnAgregar()) {
            //Primero verifica que los campos no esten vacios
            if(this.controlsPanel.getTxtPocCodigo().getText().equals("") || this.controlsPanel.getTxtPocNombre().getText().equals("") || this.controlsPanel.getTxtPocLitros().getText().equals("")|| this.controlsPanel.getTxtPocVecesUsada().getText().equals("")){
                JOptionPane.showMessageDialog(null,"No puede haber campos vacíos");  
            }
            else{
                 //Luego, obtiene lo que diligenció el usuario
                int pocCodigo = Integer.parseInt(this.controlsPanel.getTxtPocCodigo().getText());
                String pocNombre     = (String)this.controlsPanel.getTxtPocNombre().getText();
                float pocLitros = Float.parseFloat(this.controlsPanel.getTxtPocLitros().getText());
                int pocUsada= Integer.parseInt(this.controlsPanel.getTxtPocVecesUsada().getText());
                int escFK         = ((EscuelaModel)this.controlsPanel.getCbxEscuelasList().getSelectedItem()).getEscCodigo();
                
                //Inserta en la base de datos los valores recibidos desde  la interfaz del programa
                PocionDAO valores = new PocionDAO();
                valores.insertPocion(pocCodigo, pocNombre, pocLitros, pocUsada, escFK);
            
                //Limpiar los campos
                this.controlsPanel.getTxtPocCodigo().setText("");
                this.controlsPanel.getTxtPocNombre().setText("");
                this.controlsPanel.getTxtPocLitros().setText("");
                this.controlsPanel.getTxtPocVecesUsada().setText("");
           
                 // System.out.println(pocCodigo + " " + pocNombre + " " + pocLitros + " " + pocUsada+" "+escFK);
            

                //Actualiza toda la tabla que se muestra al usuario
                PocionDAO actualiza = new PocionDAO();
                this.controlsPanel.setTblResults(actualiza.obtenerRegistros());
            }         
        }
    }  
}