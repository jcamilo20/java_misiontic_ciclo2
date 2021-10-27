/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import access.PocionDAO;
import java.util.ArrayList;
import model.EscuelaModel;
import model.PocionModel;
import view.FilterPanel;


public class ClickEventFilter implements ActionListener {

    private FilterPanel filterPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    
    public ClickEventFilter(FilterPanel filterPanel){
        this.filterPanel = filterPanel;
    }
   
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        
        //Obtener datos de la interfaz para luego actualizarlos en BD
        
        if(actionEvent.getSource() == this.filterPanel.getBtnFiltrar()) {
            
            int escFK         = ((EscuelaModel)this.filterPanel.getCbxEscuelasList().getSelectedItem()).getEscCodigo();
            System.out.println(escFK);
                        
            
            PocionDAO valor =  new PocionDAO();
           ArrayList<PocionModel> registrosFiltrados = valor.obtenerRegistrosFiltrados(escFK);
           


            //Actualiza toda la tabla que se muestra al usuario
            this.filterPanel.setTblResults(registrosFiltrados);           


        }
        
    }
    
    public int accederValor(){
        int escFK         = ((EscuelaModel)this.filterPanel.getCbxEscuelasList().getSelectedItem()).getEscCodigo();
        return escFK;
    }
           

}