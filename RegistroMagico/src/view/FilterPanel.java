/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClickEventFilter;
import controller.InitialData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.EscuelaModel;


import model.PocionModel;


public class FilterPanel extends JPanel {
    
    
    //ELEMENTOS PARA INSERTAR POCION
  
    private JLabel                       lblEscuelas;
    private JComboBox<EscuelaModel>       cbxEscuelasList;
    private JButton                     btnFiltrar;
    private JTable                       tblResults;

    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public FilterPanel(TablePanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    public FilterPanel() {
    }
    
    
    /**
     * 
     */
    private void initComponents(){        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        this.separarInputs(width);
        
        InitialData initialData = new InitialData();

        //***Campos para filtrar pociones desarrolladas por escuelas***

        // Escuela selection
        this.setLblEscuelas(new JLabel("Escuela"));
        add(this.cambiarTamanioLbl(this.getLblEscuelas()));
        this.setCbxEscuelasList((JComboBox<EscuelaModel>) new JComboBox());
        this.getCbxEscuelasList().setModel(new DefaultComboBoxModel<>(initialData.getEscuelas().toArray(new EscuelaModel[initialData.getEscuelas().size()])));
        this.getCbxEscuelasList().setSelectedIndex(0);
        add(this.getCbxEscuelasList());
        
        
        
        // boton de agregar
        
        this.setBtnFiltrar(new JButton("Filtrar"));
        add(this.cambiarTamanioBtn(this.getBtnFiltrar()));
        
        ClickEventFilter clickEvent = new ClickEventFilter(this);
        this.getBtnFiltrar().addActionListener(clickEvent);
        
        
       



}

    /**
     * @return the lblEscuelas
     */
    public JLabel getLblEscuelas() {
        return lblEscuelas;
    }

    /**
     * @param lblEscuelas the lblEscuelas to set
     */
    public void setLblEscuelas(JLabel lblEscuelas) {
        this.lblEscuelas = lblEscuelas;
    }

    /**
     * @return the cbxEscuelasList
     */
    public JComboBox<EscuelaModel> getCbxEscuelasList() {
        return cbxEscuelasList;
    }

    /**
     * @param cbxEscuelasList the cbxEscuelasList to set
     */
    public void setCbxEscuelasList(JComboBox<EscuelaModel> cbxEscuelasList) {
        this.cbxEscuelasList = cbxEscuelasList;
    }

    /**
     * @return the btnFiltrar
     */
    public JButton getBtnFiltrar() {
        return btnFiltrar;
    }

    /**
     * @param btnFiltrar the btnFiltrar to set
     */
    public void setBtnFiltrar(JButton btnFiltrar) {
        this.btnFiltrar = btnFiltrar;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    public void setTblResults(ArrayList<PocionModel> pocRegistros) {
        String[] headers = {"Código", "Nombre", "Litros", "Veces Usada", "Escuela"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<pocRegistros.size(); i++){
            tableModel.addRow(pocRegistros.get(i).toArray() );
        }
    }

    public JLabel cambiarTamanioLbl(JLabel lblDatos){ //Cambia el Tamaño de los JLabel, según el ancho de pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();        
        
         if(width<1920.0){ 
             lblDatos.setFont(new Font("Sans_serif", Font.BOLD, 13));
         }
         else{
            lblDatos.setFont(new Font("Sans_serif", Font.BOLD, 17));
         }
        return lblDatos;
    }

    public JButton cambiarTamanioBtn(JButton btnDatos){ //Cambia el Tamaño de los JButton, según el ancho de pantalla
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();        
        
         if(width<1920.0){ 
             btnDatos.setFont(new Font("Sans_serif", Font.BOLD, 13));
         }
         else{
            btnDatos.setFont(new Font("Sans_serif", Font.BOLD, 17));
         }
        return btnDatos;   
    }
    
    public void separarInputs(double valor){
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();        
        
         if(width<1920.0){ 
             GridLayout layout = new GridLayout(1,7,10,40);
             setLayout(layout);
         }
         else{
            GridLayout layout = new GridLayout(1,7,30,40);
            setLayout(layout);
         }
    }

}
