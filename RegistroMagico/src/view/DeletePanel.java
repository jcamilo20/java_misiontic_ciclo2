/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClickEventDelete;
import java.awt.Dimension;
import java.awt.Font;


import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import model.PocionModel;


public class DeletePanel extends JPanel {
    
    
    //ELEMENTOS PARA INSERTAR POCION
    private JLabel                       lblPocCodigo;
    private JTextField                txtPocCodigo;
    private JButton                      btnEliminar;
    private JTable                       tblResults;

    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public DeletePanel(TablePanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    public DeletePanel() {
    }
    
    
    /**
     * 
     */
    private void initComponents(){        
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        this.separarInputs(width);
        

        //***Campos para eliminar una pocion***

        // Codigo selection
        this.setLblPocCodigo(new JLabel("Código"));
        add(this.cambiarTamanioLbl(this.getLblPocCodigo()));
        
        this.setTxtPocCodigo(new JTextField());
        add(this.getTxtPocCodigo());
        
        // boton de agregar
        
        this.setBtnEliminar(new JButton("Eliminar"));
        add(this.cambiarTamanioBtn(this.getBtnEliminar()));
        
        ClickEventDelete clickEvent = new ClickEventDelete(this);
        this.getBtnEliminar().addActionListener(clickEvent);

}

    /**
     * @return the lblPocCodigo
     */
    public JLabel getLblPocCodigo() {
        return lblPocCodigo;
    }

    /**
     * @param lblPocCodigo the lblPocCodigo to set
     */
    public void setLblPocCodigo(JLabel lblPocCodigo) {
        this.lblPocCodigo = lblPocCodigo;
    }

    /**
     * @return the txtPocCodigo
     */
    public JTextField getTxtPocCodigo() {
        return txtPocCodigo;
    }

    /**
     * @param txtPocCodigo the txtPocCodigo to set
     */
    public void setTxtPocCodigo(JTextField txtPocCodigo) {
        this.txtPocCodigo = txtPocCodigo;
    }

    /**
     * @return the btnEliminar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @param btnEliminar the btnEliminar to set
     */
    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param tblResults the tblResults to set
     */
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