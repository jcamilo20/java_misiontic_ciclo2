/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClickEventUpdate;
import controller.InitialData;
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


public class UpdatePanel extends JPanel {
    
    
    //ELEMENTOS PARA INSERTAR POCION
    private JLabel                       lblPocCodigo;
    private JTextField                txtPocCodigo;
    private JLabel                       lblPocNombre;
    private JTextField                 txtPocNombre;      
    private JLabel                       lblPocLitros;
    private JTextField                txtPocLitros;      
    private JLabel                       lblPocVecesUsada;
    private JTextField                txtPocVecesUsada;      
    private JButton                    btnModificar;
    private JTable                       tblResults;

    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public UpdatePanel(TablePanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }

    public UpdatePanel() {
    }
    
    
    /**
     * 
     */
    private void initComponents(){        
        GridLayout layout = new GridLayout(1,7,30,40);
        setLayout(layout);
        InitialData initialData = new InitialData();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        this.separarInputs(width);
                

        //***Campos para actualizar una pocion***

        this.setLblPocCodigo(new JLabel("Código"));
        add(this.cambiarTamanioLbl(this.getLblPocCodigo()));
        
        this.setTxtPocCodigo(new JTextField());
        add(this.getTxtPocCodigo());
        
        //*************
                
        this.setLblPocLitros(new JLabel("Litros"));
        add(this.cambiarTamanioLbl(this.getLblPocLitros()));
        
        this.setTxtPocLitros(new JTextField());
        add(this.getTxtPocLitros());
        
        //*************
   
     
        this.setLblPocVecesUsada(new JLabel("Veces Usada"));
        add(this.cambiarTamanioLbl(this.getLblPocVecesUsada()));
        
        this.setTxtPocVecesUsada(new JTextField());
        add(this.getTxtPocVecesUsada());
        
         //*************

         
        // boton de agregar
        
        this.setBtnModificar(new JButton("Modificar"));
        add(this.cambiarTamanioBtn(this.getBtnModificar()));
        
        ClickEventUpdate clickEvent = new ClickEventUpdate(this);
        this.getBtnModificar().addActionListener(clickEvent);
        
        
       



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
     * @return the lblPocNombre
     */
    public JLabel getLblPocNombre() {
        return lblPocNombre;
    }

    /**
     * @param lblPocNombre the lblPocNombre to set
     */
    public void setLblPocNombre(JLabel lblPocNombre) {
        this.lblPocNombre = lblPocNombre;
    }

    /**
     * @return the txtPocNombre
     */
    public JTextField getTxtPocNombre() {
        return txtPocNombre;
    }

    /**
     * @param txtPocNombre the txtPocNombre to set
     */
    public void setTxtPocNombre(JTextField txtPocNombre) {
        this.txtPocNombre = txtPocNombre;
    }

    /**
     * @return the lblPocLitros
     */
    public JLabel getLblPocLitros() {
        return lblPocLitros;
    }

    /**
     * @param lblPocLitros the lblPocLitros to set
     */
    public void setLblPocLitros(JLabel lblPocLitros) {
        this.lblPocLitros = lblPocLitros;
    }

    /**
     * @return the txtPocLitros
     */
    public JTextField getTxtPocLitros() {
        return txtPocLitros;
    }

    /**
     * @param txtPocLitros the txtPocLitros to set
     */
    public void setTxtPocLitros(JTextField txtPocLitros) {
        this.txtPocLitros = txtPocLitros;
    }

    /**
     * @return the lblPocVecesUsada
     */
    public JLabel getLblPocVecesUsada() {
        return lblPocVecesUsada;
    }

    /**
     * @param lblPocVecesUsada the lblPocVecesUsada to set
     */
    public void setLblPocVecesUsada(JLabel lblPocVecesUsada) {
        this.lblPocVecesUsada = lblPocVecesUsada;
    }

    /**
     * @return the txtPocVecesUsada
     */
    public JTextField getTxtPocVecesUsada() {
        return txtPocVecesUsada;
    }

    /**
     * @param txtPocVecesUsada the txtPocVecesUsada to set
     */
    public void setTxtPocVecesUsada(JTextField txtPocVecesUsada) {
        this.txtPocVecesUsada = txtPocVecesUsada;
    }

    /**
     * @return the btnModificar
     */
    public JButton getBtnModificar() {
        return btnModificar;
    }

    /**
     * @param btnModificar the btnModificar to set
     */
    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
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