/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MainWindow extends JFrame {
    
    public MainWindow(){
        initComponents();
    }
    
    private void initComponents(){
        setTitle("Registro Mágico De Henry Plotter");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        TablePanel resultsPanel = new TablePanel();
        setContentPane(resultsPanel);
        add(new JLabel(new ImageIcon("images/logo.png")));
        add(new AddPanel(resultsPanel));
        add(new UpdatePanel(resultsPanel));
        add(new FilterPanel(resultsPanel));
        add(new DeletePanel(resultsPanel));

                
        this.getContentPane().setBackground(new Color(27,72,92));
        //this.setResizable(false);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        if(width<1920.0){
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        else{
            this.setSize(1600, 720);
            Dimension frameSize  = getSize();
            setLocation((screenSize.width  - frameSize.width)  / 2, 
                    (screenSize.height - frameSize.height) / 2);
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}